package studsluzba.client.fxmlcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import studsluzba.model.VisokoskolskaUstanova;
import studsluzba.services.SifarniciService;

@Component
public class AddVisokoskolskaUstanovaUpdateIndeksController {

	@Autowired
	SifarniciService sifarniciService;

	@FXML TextField nazivNoveVisokoskolskeUstanoveTf;
	
	
	@FXML public void addVisokoskolskuUstanovu(ActionEvent event) {		
		VisokoskolskaUstanova vs = new VisokoskolskaUstanova();
		vs.setNazivVisokoskolskeUstanove(nazivNoveVisokoskolskeUstanoveTf.getText());
		sifarniciService.saveVisokoskolskaUstanova(vs);		
		sifarniciService.updateVisokoskUstanovaUpdateIndeks();
		closeStage(event);
	}
	
	private void closeStage(ActionEvent event) {
        Node  source = (Node)  event.getSource(); 
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
    }
}
