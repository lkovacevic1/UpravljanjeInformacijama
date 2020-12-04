package studsluzba.client.fxmlcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import studsluzba.model.IspitniRok;
import studsluzba.model.StudProgram;
import studsluzba.services.IspitniRokoviService;

@Component
public class UnosIspitRokController {
	
	@Autowired
	IspitniRokoviService ispitniRokoviService;
	
	private ObservableList<IspitniRok> sviRokovi;
	
	@FXML private TableView<IspitniRok> rokoviTable;
	
	
	 @FXML
	 protected void initialize() {
		 sviRokovi = FXCollections.observableList(ispitniRokoviService.loadAll());
		 rokoviTable.setItems(sviRokovi);
	 }
	
}
