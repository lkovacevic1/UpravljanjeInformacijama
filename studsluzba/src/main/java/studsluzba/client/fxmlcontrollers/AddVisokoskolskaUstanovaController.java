package studsluzba.client.fxmlcontrollers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import studsluzba.model.VisokoskolskaUstanova;
import studsluzba.services.SifarniciService;
import javafx.scene.Node;

@Component
public class AddVisokoskolskaUstanovaController {
	@Autowired
	SifarniciService sifarniciService;

	@FXML TextField nazivNoveVisokoskolskeUstanoveTf;
	
	
	@FXML public void addVisokoskolskuUstanovu(ActionEvent event) {		
		VisokoskolskaUstanova vs = new VisokoskolskaUstanova();
		vs.setNazivVisokoskolskeUstanove(nazivNoveVisokoskolskeUstanoveTf.getText());
		sifarniciService.saveVisokoskolskaUstanova(vs);		
		sifarniciService.updateVisokoskUstanova();
		closeStage(event);
	}
	
	private void closeStage(ActionEvent event) {
        Node  source = (Node)  event.getSource(); 
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
    }
}
