package Register;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

public class registerViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView AadharPic;

    @FXML
    private TextField Email;

    @FXML
    private ComboBox<String> bloodGrp;

    @FXML
    private DatePicker dob;

    @FXML
    private ComboBox<String> idMobile;

    @FXML
    private TextField idName;

    @FXML
    private DatePicker joiningDate;
    
    @FXML
    private Label lblStatus;

    @FXML
    private Label picPath;
    
    Connection con;
    PreparedStatement pst;

    @FXML
    void doRemove(ActionEvent event) {
    	String m=idMobile.getSelectionModel().getSelectedItem();
    	try {
			pst=con.prepareStatement("delete from register where mobile=?");
			pst.setString(1, m);
			int count=pst.executeUpdate();
			if(count==0)
				lblStatus.setText("Invalid name");
			else
				lblStatus.setText("record deleted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void doSave(ActionEvent event) {
    	String m=idMobile.getSelectionModel().getSelectedItem();
    	String name=idName.getText();
    	String email=Email.getText();
    	String group=bloodGrp.getSelectionModel().getSelectedItem();
    	String path=picPath.getText();
    	LocalDate d=dob.getValue();
    	java.sql.Date date=java.sql.Date.valueOf(d);
    	try {
			pst=con.prepareStatement("insert into register values(?,?,?,?,?,current_date(),?)");
			pst.setString(1, m);
			pst.setString(2, name);
			pst.setString(3, email);
			pst.setString(4, group);
			pst.setDate(5, date);
			pst.setString(6, path);
			pst.executeUpdate();
			lblStatus.setText("record saved..");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

    @FXML
    void doSearch(ActionEvent event) throws FileNotFoundException {
    	String s=idMobile.getSelectionModel().getSelectedItem();
    	try {
			pst=con.prepareStatement("select * from register where mobile=?");
			pst.setString(1, s);
			ResultSet table=pst.executeQuery();
			while(table.next())
			{
				String name=table.getString("name");
				String mail=table.getString("email");
				String grp=table.getString("bgroup");
				String path=table.getString("picpath");
				java.sql.Date dobb= table.getDate("dob");
				java.sql.Date doj= table.getDate("doj");
				idName.setText(name);
				Email.setText(mail);
				bloodGrp.setPromptText(grp);
				picPath.setText(path);
				dob.setValue(dobb.toLocalDate());
				joiningDate.setValue(doj.toLocalDate());
				AadharPic.setImage(new Image(new FileInputStream(path)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void doUpdate(ActionEvent event) {
    	String m=idMobile.getSelectionModel().getSelectedItem();
    	String name=idName.getText();
    	String email=Email.getText();
    	String group=bloodGrp.getSelectionModel().getSelectedItem();
    	String path=picPath.getText();
    	LocalDate d=dob.getValue();
    	java.sql.Date date=java.sql.Date.valueOf(d);
    	try {
			pst=con.prepareStatement("update register set name=?,email=?,bgroup=?,dob=?,doj=current_date(),picpath=? where mobile=?");
			pst.setString(6, m);
			pst.setString(1, name);
			pst.setString(2, email);
			pst.setString(3, group);
			pst.setDate(4, date);
			pst.setString(5, path);
			int count=pst.executeUpdate();
			if(count!=0)
				lblStatus.setText("record updated..");
				else
				lblStatus.setText("Invalid name");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
   
    @FXML
    void doUpload(ActionEvent event) throws FileNotFoundException {
    	FileChooser fc=new FileChooser();
    	File file=fc.showOpenDialog(null);
    	if(file!=null)
    	{
    		AadharPic.setImage(new Image(new FileInputStream(file)));
    		 picPath.setText(file.getPath());
    	}else
    		picPath.setText("nopic.jpg");
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
    	try {
			pst=con.prepareStatement("select * from register");
			ResultSet table=pst.executeQuery();
			while(table.next())
			{
				String m=table.getString("mobile");
				idMobile.getItems().add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
