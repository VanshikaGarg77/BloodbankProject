module BloodBank {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires java.sql;
	requires javafx.base;
	
	opens application to javafx.graphics, javafx.fxml;
	opens Register to javafx.graphics, javafx.fxml;
	opens Entry to javafx.graphics, javafx.fxml;
	opens Issue to javafx.graphics, javafx.fxml;
	opens BloodUnits to javafx.graphics, javafx.fxml,javafx.base;
	opens ReceiverDetails to javafx.graphics, javafx.fxml,javafx.base;
	opens DonorRecord2 to javafx.graphics, javafx.fxml,javafx.base;
	opens Login to javafx.graphics, javafx.fxml;
	opens AdminDesk to javafx.graphics, javafx.fxml;
	opens Developers to javafx.graphics, javafx.fxml;
}
