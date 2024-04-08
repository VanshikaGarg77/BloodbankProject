package Login;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class loginViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lblStatus;

    @FXML
    private Button login;

    @FXML
    private PasswordField password;

    @FXML
    private TextField userid;

    @FXML
    void doLogin(ActionEvent event) {
    	if(password.getText().equals("11223344") && userid.getText().equals("bloodbank"))
    	{lblStatus.setText("Login successfull..");
    		try{
    		Parent root=FXMLLoader.load(getClass().getResource("/AdminDesk/adminView.fxml")); 
			Scene scene = new Scene(root);
			Stage stage=new Stage();
			stage.setScene(scene);
			stage.show();
    		
			//to hide the opened window
			//Scene scene1=(Scene)login.getScene();
			  // scene1.getWindow().hide();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    	}
    	else
    	{
    		lblStatus.setText("Incorrect Details..");
    	}
    }

    @FXML
    void initialize() {
        assert lblStatus != null : "fx:id=\"lblStatus\" was not injected: check your FXML file 'loginView.fxml'.";
        assert password != null : "fx:id=\"password\" was not injected: check your FXML file 'loginView.fxml'.";
        assert userid != null : "fx:id=\"userid\" was not injected: check your FXML file 'loginView.fxml'.";

    }

}
