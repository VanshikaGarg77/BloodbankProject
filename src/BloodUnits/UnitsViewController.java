package BloodUnits;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import Register.MySqlConnector;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class UnitsViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField abn;

    @FXML
    private TextField abp;

    @FXML
    private TextField an;

    @FXML
    private TextField ap;

    @FXML
    private TextField bn;

    @FXML
    private TextField bp;

    @FXML
    private TextField on;

    @FXML
    private TextField op;
    
    Connection con;
    PreparedStatement pst;

    @FXML
    void initialize() {
    	con=MySqlConnector.doConnect();
    	try {
			pst=con.prepareStatement("select * from units");
			ResultSet table=pst.executeQuery();
			while(table.next())
			{
				String Ap=table.getString("Ap");
				ap.setText(Ap);
				String Bp=table.getString("Bp");
				bp.setText(Bp);
				String Op=table.getString("Op");
				op.setText(Op);
				String ABp=table.getString("ABp");
				abp.setText(ABp);
				String An=table.getString("An");
				an.setText(An);
				String Bn=table.getString("Bn");
				bn.setText(Bn);
				String On=table.getString("Onn");
				on.setText(On);
				String ABn=table.getString("ABn");
				abn.setText(ABn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
