package studsluzba.client.fxmlcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import studsluzba.model.SkolskaGodina;
import studsluzba.services.SifarniciService;

@Component
public class SkolskeGodineController {
	
	@Autowired
	SifarniciService sifarniciService;

	
	@FXML private TextField skolskaGodinaTf;
	
	@FXML private TableView<SkolskaGodina> skolskeGodineTable;
	
	private ObservableList<SkolskaGodina> sveSkolskeGodine;
	
	@FXML
	protected void initialize() {
		sveSkolskeGodine = FXCollections.observableArrayList(sifarniciService.getAllSkolskeGodine());
		skolskeGodineTable.setItems(sveSkolskeGodine);
	}
	
	public void dodajNovuGodinu(ActionEvent event) {
		SkolskaGodina skolskaGodina = sifarniciService.saveSkolskaGodina(Integer.parseInt(skolskaGodinaTf.getText()));
		sveSkolskeGodine.add(skolskaGodina);
		sveSkolskeGodine = FXCollections.observableArrayList(sifarniciService.getAllSkolskeGodine());
		skolskeGodineTable.setItems(sveSkolskeGodine);
	}
}
