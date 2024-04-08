package ReceiverDetails;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import Register.MySqlConnector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class receiveViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> idGroup;

    @FXML
    private TableView<ReceiveBean> tableview;
    
    Connection con;
    PreparedStatement pst;

    @FXML
    void doFilter(ActionEvent event) {
    	tableview.getColumns().clear();
    	TableColumn<ReceiveBean,String> name=new TableColumn<ReceiveBean,String>("Receiver name");
    	name.setCellValueFactory(new PropertyValueFactory<>("rname"));
    	name.setMinWidth(100);
    	tableview.getColumns().add(name);
    	
    	TableColumn<ReceiveBean,String> doi=new TableColumn<ReceiveBean,String>("Date of Issue");
    	doi.setCellValueFactory(new PropertyValueFactory<>("doi"));
    	doi.setMinWidth(120);
    	tableview.getColumns().add(doi);
    	
    	TableColumn<ReceiveBean,String> grp=new TableColumn<ReceiveBean,String>("Blood Group");
    	grp.setCellValueFactory(new PropertyValueFactory<>("bgroup"));
    	grp.setMinWidth(100);
    	tableview.getColumns().add(grp);
    	
    	TableColumn<ReceiveBean,String> units=new TableColumn<ReceiveBean,String>("Blood Units");
    	units.setCellValueFactory(new PropertyValueFactory<>("units"));
    	units.setMinWidth(100);
    	tableview.getColumns().add(units);
    	
    	TableColumn<ReceiveBean,String> h=new TableColumn<ReceiveBean,String>("Hospital");
    	h.setCellValueFactory(new PropertyValueFactory<>("hospital"));
    	h.setMinWidth(120);
    	tableview.getColumns().add(h);
    	
    	tableview.setItems(Fetch());
    }
    ObservableList<ReceiveBean> Fetch() 
    {
    	String grp=idGroup.getSelectionModel().getSelectedItem();
    	ObservableList<ReceiveBean>ary=FXCollections.observableArrayList();
    	try {
    		pst = con.prepareStatement("select * from issued where bgroup=?");
    		pst.setString(1,grp);
    		ResultSet table=pst.executeQuery();
    		while(table.next()) {
	    		String bgrp=table.getString("bgroup");
	    		String name = table.getString("rname");
	    		String DOI = String.valueOf(table.getDate("doi").toLocalDate());
	    		String units=table.getString("units");
	    		String h=table.getString("hospital");
	    		System.out.println(name);
	    		ReceiveBean ref=new ReceiveBean(name,DOI,bgrp,units,h);
	    		//System.out.println(ref.getHname());
	    		ary.add(ref);	
    		}
    	}
    	catch(Exception ex) { ex.printStackTrace(); }
    		return ary;
    }

    @FXML
    void initialize() {
    	con=MySqlConnector.doConnect();
    	ArrayList<String> items=new ArrayList<String>(Arrays.asList("A+","B+","AB+","O+","A-","B-","AB-","O-"));
    	idGroup.getItems().addAll(items);
    }

}
