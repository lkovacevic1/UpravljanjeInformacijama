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
import studsluzba.model.Predmet;
import studsluzba.model.StudProgram;
import studsluzba.repositories.PredmetRepository;
import studsluzba.services.SifarniciService;

@Component
public class PredmetiNaProgramuController {

	@Autowired
	PredmetRepository predmetiRepo;
	
	@Autowired
	SifarniciService sifarniciService;
	
	@FXML private ComboBox<StudProgram> stProgramCb;
	
	@FXML private TableView<Predmet> predmetiTable;
	
	 private ObservableList<Predmet> sviPredmeti;
	 
	 @FXML
	 protected void initialize() {
		 List<StudProgram> sviStProgrami = sifarniciService.getStProgram();
		 stProgramCb.setItems(FXCollections.observableArrayList(sviStProgrami));
		 
		 sviPredmeti = FXCollections.observableList(sifarniciService.getPredmeti());
		 predmetiTable.setItems(sviPredmeti);
	 }
	 
	 public void izvadiPredmeteNaProgramu(ActionEvent event) {
		 StudProgram stProgram = stProgramCb.getValue();
		 sviPredmeti.clear();
		 sviPredmeti = FXCollections.observableList(predmetiRepo.findPredmetByOznaka(stProgram.getOznaka()));
		 predmetiTable.setItems(sviPredmeti);
	 }
}
