package presentation;

import java.io.IOException;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class RootLayoutController {
	
	@FXML
	private Label lblStatus;
	
	@FXML
	private TextField usernameTextField;
	
	@FXML
	private TextField passwordTextField;
	
	private Stage primaryStage;
	private BorderPane rootLayout;
	
	
	//Exit the program
	public void handleExit(ActionEvent actionEvent){
		System.exit(0);
	}
	
	//Help Menu button behavior
	public void handleHelp(ActionEvent actionEvent){
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Program Information");
		alert.setHeaderText("Aplicatie IS Dragos!");
		alert.setContentText("You can search,delete,update,insert some data with this program.");
		alert.show();
	}
	
	public void handleClient(ActionEvent actionEvent) throws IOException{
		Stage stage1 = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/presentation/ClientView.fxml"));
		Scene scene = new Scene(root,685,348);
		scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
		stage1.setScene(scene);
		stage1.setTitle("Client");
		stage1.show();
	}
	
	public void handleOrder(ActionEvent actionEvent) throws IOException{
		Stage stage2 = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/presentation/OrderView.fxml"));
		Scene scene = new Scene(root,685,348);
		scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
		stage2.setScene(scene);
		stage2.setTitle("Order");
		stage2.show();
	}
	
	public void handleProduct(ActionEvent actionEvent) throws IOException{
		Stage stage3 = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/presentation/ProductView.fxml"));
		Scene scene = new Scene(root,685,348);
		scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
		stage3.setScene(scene);
		stage3.setTitle("Product");
		stage3.show();
	}
	
	public void handleManager(ActionEvent actionEvent) throws IOException{
		Stage stage4 = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/presentation/Login.fxml"));
		Scene scene = new Scene(root,685,348);
		scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
		stage4.setScene(scene);
		stage4.setTitle("Manager login");
		stage4.show();
	}
	
	public void handleGuest(ActionEvent actionEvent) throws IOException{
		Stage stage5 = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/presentation/GuestLayout.fxml"));
		Scene scene = new Scene(root,685,348);
		scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
		stage5.setScene(scene);
		stage5.setTitle("Shoes Store");
		stage5.show();
	}
	
	public void handleGuestProduct(ActionEvent actionEvent) throws IOException{
		Stage stage6 = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/presentation/GuestProductView.fxml"));
		Scene scene = new Scene(root,685,348);
		scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
		stage6.setScene(scene);
		stage6.setTitle("Product");
		stage6.show();
	}
	
	public void handleDeals(ActionEvent actionEvent) throws IOException{
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Deals Informations");
		alert.setHeaderText("Sorry,in this moment the deals are not available!");
		alert.setContentText("You will can see the deals of our store soon!");
		alert.show();
	}
	
	public void handleClientProduct(ActionEvent actionEvent) throws IOException{
		Stage stage7 = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/presentation/ClientProductView.fxml"));
		Scene scene = new Scene(root,685,348);
		scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
		stage7.setScene(scene);
		stage7.setTitle("Product");
		stage7.show();
	}
	
	public void handleClientLogin(ActionEvent actionEvent) throws IOException{
		Stage stage8 = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/presentation/ClientLogin.fxml"));
		Scene scene = new Scene(root,685,348);
		scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
		stage8.setScene(scene);
		stage8.setTitle("Login");
		stage8.show();
	}
	
	public void handleClientOrder(ActionEvent actionEvent) throws IOException{
		Stage stage8 = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/presentation/ClientOrderView.fxml"));
		Scene scene = new Scene(root,710,348);
		scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
		stage8.setScene(scene);
		stage8.setTitle("Order");
		stage8.show();
	}
	
}
