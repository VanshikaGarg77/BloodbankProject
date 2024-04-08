package AdminDesk;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class adminViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void developer(ActionEvent event) {
    	try{
    		Parent root=FXMLLoader.load(getClass().getResource("/Developers/meetView.fxml")); 
			Scene scene = new Scene(root);
			Stage stage=new Stage();
			stage.setScene(scene);
			stage.show();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }

    @FXML
    void donorRecord(ActionEvent event) {
    	try{
    		Parent root=FXMLLoader.load(getClass().getResource("/DonorRecord2/donorView.fxml")); 
			Scene scene = new Scene(root);
			Stage stage=new Stage();
			stage.setScene(scene);
			stage.show();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }

    @FXML
    void entry(ActionEvent event) {
    	try{
    		Parent root=FXMLLoader.load(getClass().getResource("/Entry/entryView.fxml")); 
			Scene scene = new Scene(root);
			Stage stage=new Stage();
			stage.setScene(scene);
			stage.show();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }

    @FXML
    void issue(ActionEvent event) {
    	try{
    		Parent root=FXMLLoader.load(getClass().getResource("/Issue/issueView.fxml")); 
			Scene scene = new Scene(root);
			Stage stage=new Stage();
			stage.setScene(scene);
			stage.show();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }

    @FXML
    void receiverDetails(ActionEvent event) {
    	try{
    		Parent root=FXMLLoader.load(getClass().getResource("/ReceiverDetails/receiveView.fxml")); 
			Scene scene = new Scene(root);
			Stage stage=new Stage();
			stage.setScene(scene);
			stage.show();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }

    @FXML
    void register(ActionEvent event) {
    	try{
    		Parent root=FXMLLoader.load(getClass().getResource("/Register/registerView.fxml")); 
			Scene scene = new Scene(root);
			Stage stage=new Stage();
			stage.setScene(scene);
			stage.show();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }

    @FXML
    void units(ActionEvent event) {
    	try{
    		Parent root=FXMLLoader.load(getClass().getResource("/BloodUnits/UnitsView.fxml")); 
			Scene scene = new Scene(root);
			Stage stage=new Stage();
			stage.setScene(scene);
			stage.show();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }

    @FXML
    void initialize() {

    }

}
