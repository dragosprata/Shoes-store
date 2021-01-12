package presentation;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LoginController {
	
	@FXML
	private TextField user;
	
	@FXML
	private TextField pass;
	
	@FXML
	private Label lblStatus;
	
	public void login(ActionEvent event) throws IOException{
		
		if(user.getText().equals("admin") && pass.getText().equals("pass")){
			lblStatus.setText("Succes!");
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/presentation/ManagerLayout.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
           // stage.initModality(Modality.APPLICATION_MODAL);
           // stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(new Scene(root1));  
            stage.show();
		} else {
			lblStatus.setText("Failed!");
		}
	}

}
