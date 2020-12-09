package studsluzba.client.fxmlcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import studsluzba.model.DrziPredmet;
import studsluzba.model.SkolskaGodina;
import studsluzba.services.SifarniciService;

@Component
public class SviPredmetiZaSkolskuGodinuController {
	
	@Autowired
	SifarniciService sifarniciService;

	@FXML private ComboBox<SkolskaGodina> skolskaGodinaCb;
	
	@FXML private TableView<DrziPredmet> predmetiPoGodiniTable;
	
	private ObservableList<DrziPredmet> sviPredmeti;
	
	@FXML
    public void initialize() {	
		List<SkolskaGodina> sveSkolskeGodine = sifarniciService.getAllSkolskeGodine();
		skolskaGodinaCb.setItems(FXCollections.observableArrayList(sveSkolskeGodine));
		
		sviPredmeti = FXCollections.observableArrayList(sifarniciService.getAllDrziPredmet());
		predmetiPoGodiniTable.setItems(sviPredmeti);
	}
	
	public void selektPredmetiUGodini(ActionEvent event) {
		sviPredmeti.clear();
		List<DrziPredmet> predmeti = sifarniciService.findPredmetUGodini(skolskaGodinaCb.getValue());
		predmetiPoGodiniTable.setItems(FXCollections.observableArrayList(predmeti));
	}
}
