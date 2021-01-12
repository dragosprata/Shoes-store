package presentation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Stream;
import model.ClientsData;

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

public class ClientLoginController {
	
	@FXML
	private TextField user;
	
	@FXML
	private TextField pass;
	
	@FXML
	private Label lblStatus;
	
	public static List<ClientsData> citireFisier(){
		List<ClientsData> list = new ArrayList<ClientsData>();
		String numeFisier = "src/Data.txt";
		//citim fisierul intr-un stream
		try(Stream<String> stream = Files.lines(Paths.get(numeFisier))){
			stream.forEach(e -> {
				StringTokenizer st = new StringTokenizer(e,"		");
				while(st.hasMoreElements()){
					String username = st.nextElement().toString();
					String password = st.nextElement().toString();
					list.add(new ClientsData(username,password));
				}
			});
		} catch(IOException e){
			e.printStackTrace();
		}
		return list;
	}
	
	public void loginClient(ActionEvent event) throws IOException{
		
		List<ClientsData> list = ClientLoginController.citireFisier();
		
		//if(user.getText().equals("client") && pass.getText().equals("1234"))
		for(ClientsData element:list){
			if (user.getText().equals(element.getUsername()) && pass.getText().equals(element.getPassword())){
				lblStatus.setText("Succes!");
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/presentation/ClientLayout.fxml"));
	            Parent root2 = (Parent) fxmlLoader.load();
	            Stage stage = new Stage();
	            stage.setScene(new Scene(root2));  
	            stage.show();
		} else {
			lblStatus.setText("Failed!");
		}
		}
	}
}
