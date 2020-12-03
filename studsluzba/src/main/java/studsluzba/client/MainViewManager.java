package studsluzba.client;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import studsluzba.client.fxmlcontrollers.MainWindowController;

@Component
public class MainViewManager {
	
		
		@Autowired
		ContextFXMLLoader appFXMLLoader; 
		
		private Scene scene;
		
		public Scene createScene() {	  
		  try {		  
			  FXMLLoader loader = appFXMLLoader.getLoader(MainViewManager.class.getResource("/fxml/main.fxml"));
			  BorderPane borderPane = loader.load();
			  this.scene = new Scene(borderPane);			  
		  } catch (IOException e) {
			  e.printStackTrace();
		  }
		  return this.scene;
		 }			
		
		public void changeRoot(String fxml) {
			FXMLLoader loader = appFXMLLoader.getLoader(MainViewManager.class.getResource("/fxml/"+fxml+".fxml"));
			try {
				scene.setRoot(loader.load());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public void openModal(String fxml) {
			FXMLLoader loader = appFXMLLoader.getLoader(MainViewManager.class.getResource("/fxml/"+fxml+".fxml"));
			try {
				Parent parent = loader.load();
				Scene scene = new Scene(parent, 400, 300);
				Stage stage = new Stage();
				stage.initModality(Modality.APPLICATION_MODAL);
				stage.setScene(scene);
				stage.showAndWait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}

