package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

//Main class which extends from Application Class
public class Main extends Application {

    //This is our PrimaryStage (It contains everything)
    private Stage primaryStage;

    //This is the BorderPane of RootLayout
    private BorderPane rootLayout;
    
    //private AnchorPane login;
   
       @Override
    public void start(Stage primaryStage) {
        
    	//1) Declare a primary stage (Everything will be on this stage)
        this.primaryStage = primaryStage;

        //Optional: Set a title for primary stage
        this.primaryStage.setTitle("Shoes Store");

        //2) Initialize RootLayout
        initRootLayout();

    }

    //Initializes the root layout.
    public void initRootLayout() {
    	try {
          //First, load root layout from RootLayout.fxml
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/presentation/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            
            //Second, show the scene containing the root layout.
            //Scene scene = new Scene(rootLayout); //We are sending rootLayout to the Scene.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene); //Set the scene in primary stage.

            //Third, show the primary stage
            primaryStage.show(); //Display the primary stage
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}
