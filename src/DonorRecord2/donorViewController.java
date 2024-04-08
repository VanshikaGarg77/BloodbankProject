package DonorRecord2;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.scene.control.ComboBox;
import ReceiverDetails.ReceiveBean;
import Register.MySqlConnector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class donorViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private ComboBox<String> idGroup;


    @FXML
    private TableView<DonorBean> tableView;
    
    Connection con;
    PreparedStatement pst;

    @FXML
    void doFetch(ActionEvent event) {
    	tableView.getColumns().clear();
    	TableColumn<DonorBean,String> m=new TableColumn<DonorBean,String>("Mobile no");
    	m.setCellValueFactory(new PropertyValueFactory<>("mobile"));
    	m.setMinWidth(170);
    	tableView.getColumns().add(m);
    	
    	TableColumn<DonorBean,String> dod=new TableColumn<DonorBean,String>("Date of Donation");
    	dod.setCellValueFactory(new PropertyValueFactory<>("dod"));
    	dod.setMinWidth(180);
    	tableView.getColumns().add(dod);
    	
    	TableColumn<DonorBean,String> bgrp=new TableColumn<DonorBean,String>("Blood Group");
    	bgrp.setCellValueFactory(new PropertyValueFactory<>("bgroup"));
    	bgrp.setMinWidth(150);
    	tableView.getColumns().add(bgrp);
    	
    	tableView.setItems(Fetch());
    }

    ObservableList<DonorBean> Fetch() 
    {
    	String grp=idGroup.getSelectionModel().getSelectedItem();
    	ObservableList<DonorBean>ary=FXCollections.observableArrayList();
    	try {
    		pst = con.prepareStatement("select * from entry where bgroup=?");
    		pst.setString(1,grp);
    		ResultSet table=pst.executeQuery();
    		while(table.next()) {
	    		String bgrp=table.getString("bgroup");
	    		String m = table.getString("mobile");
	    		String DOI = String.valueOf(table.getDate("dod").toLocalDate());
	    		DonorBean ref=new DonorBean(m,DOI,bgrp);
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
        assert tableView != null : "fx:id=\"tableView\" was not injected: check your FXML file 'donorView.fxml'.";

    }

}
