package Issue;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import Register.MySqlConnector;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class issueViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> bloodGrp;

    @FXML
    private DatePicker issueDate;

    @FXML
    private Label lblStatus;

    @FXML
    private TextField txtAmount;

    @FXML
    private TextField txtCause;

    @FXML
    private TextField txtHospital;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtUnits;
    
    Connection con;
    PreparedStatement pst;

    @FXML
    void doIssue(ActionEvent event) {
    	String name=txtName.getText();
    	String cause=txtCause.getText();
    	String bgrp=bloodGrp.getSelectionModel().getSelectedItem();
    	String hospital=txtHospital.getText();
    	String units=txtUnits.getText();
    	int unit=Integer.parseInt(units);
    	String amt=txtAmount.getText();
    	LocalDate d=issueDate.getValue();
    	java.sql.Date date=java.sql.Date.valueOf(d);
    	String grp="";
    	if(bgrp.equals("B+"))
    		grp="Bp";
    	if(bgrp.equals("A+"))
    		grp="Ap";
    	if(bgrp.equals("AB+"))
    		grp="ABp";
    	if(bgrp.equals("O+"))
    		grp="Op";
    	if(bgrp.equals("B-"))
    		grp="Bn";
    	if(bgrp.equals("A-"))
    		grp="An";
    	if(bgrp.equals("AB-"))
    		grp="ABn";
    	if(bgrp.equals("O-"))
    		grp="Onn";
    
    	try {
    		pst=con.prepareStatement("select * from units ");
    		ResultSet table=pst.executeQuery();
    		while(table.next())
    		{
    			int count=table.getInt(grp);
    			if(count>=unit)
    			{
    				pst=con.prepareStatement("update units set "+grp+"="+grp+"-"+unit+"");
    				pst.executeUpdate();
    				try {
    					pst=con.prepareStatement("insert into issued values(?,?,?,?,?,?,?)");
    					pst.setString(1, name);
    					pst.setString(3,bgrp);
    					pst.setInt(4, unit);
    					pst.setString(5, hospital);
    					pst.setDate(2, date);
    					pst.setString(6, cause);
    					pst.setString(7,amt);
    					pst.executeUpdate();
    					lblStatus.setText("record saved..");
    				} catch (SQLException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
    			}
    			else
    			{
    				lblStatus.setText("This blood group is currently not available");
    			}
    		}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }

    @FXML
    void initialize() {
    	con=MySqlConnector.doConnect();
    	if(con==null)
    		System.out.println("Connection problemm..");
    	else
    		System.out.println("connected");
    	ArrayList<String> items=new ArrayList<String>(Arrays.asList("A+","B+","AB+","O+","A-","B-","AB-","O-"));
    	bloodGrp.getItems().addAll(items);
    }

}

