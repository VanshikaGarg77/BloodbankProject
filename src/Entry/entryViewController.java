package Entry;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import Register.*;

public class entryViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private DatePicker date;

    @FXML
    private TextField idGroup;

    @FXML
    private TextField idLast;

    @FXML
    private Label lblStatus;

    @FXML
    private TextField txtMobile;
    
    Connection con;
    PreparedStatement pst;

    @FXML
    void doFind(ActionEvent event) {
    	String m=txtMobile.getText();
    	try {
			pst=con.prepareStatement("select * from register where mobile=?");
			pst.setString(1, m);
			ResultSet table=pst.executeQuery();
			while(table.next())
			{
				String grp=table.getString("bgroup");
				java.sql.Date date= table.getDate("doj");
				idGroup.setText(grp);
				idLast.setText(String.valueOf(date));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }

    @FXML
    void doSave(ActionEvent event) {
    	String m=txtMobile.getText();
    	String grp=idGroup.getText();
    	LocalDate ld=date.getValue();
    	java.sql.Date date=java.sql.Date.valueOf(ld);
    	
    	try {
			pst=con.prepareStatement("insert into entry values(?,?,?)");
			pst.setString(1, m);
			pst.setString(3, grp);
			pst.setDate(2,date);
			pst.executeUpdate();
			lblStatus.setText("record saved..");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	if(grp.equals("B+"))
    		grp="Bp";
    	if(grp.equals("A+"))
    		grp="Ap";
    	if(grp.equals("AB+"))
    		grp="ABp";
    	if(grp.equals("O+"))
    		grp="Op";
    	if(grp.equals("B-"))
    		grp="Bn";
    	if(grp.equals("A-"))
    		grp="An";
    	if(grp.equals("AB-"))
    		grp="ABn";
    	if(grp.equals("O-"))
    		grp="Onn";
    	try {
			pst=con.prepareStatement("update units set "+grp+"="+grp+"+1");
			//pst.setString(1, grp);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }

    @FXML
    void initialize() {
    	con=MySqlConnector.doConnect();
    	
    }

}
