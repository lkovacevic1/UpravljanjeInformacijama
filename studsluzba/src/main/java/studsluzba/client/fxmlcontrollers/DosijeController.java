package studsluzba.client.fxmlcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import studsluzba.model.Indeks;
import studsluzba.model.Predmet;
import studsluzba.model.Student;
import studsluzba.model.VisokoskolskaUstanova;
import studsluzba.repositories.PredmetRepository;
import studsluzba.services.SifarniciService;

@Component
public class DosijeController {
	
	@Autowired
	SifarniciService sifraniciService;

	@FXML private ComboBox<String> upis_obnova;
	
	@FXML private ComboBox<Predmet> predmeti;
	
	@FXML private DatePicker datum;
	
	@FXML private TextField napomena;
	
	@FXML private TableView stTable;
	
	@FXML
    public void initialize() {	
		List<String> obn_upis = List.of("Obnova Godine", "Upis Godine");
		upis_obnova.setItems(FXCollections.observableArrayList(obn_upis));
		
		List<Predmet> predmet = sifraniciService.getPredmeti();
		predmeti.setItems(FXCollections.observableArrayList(predmet));
		
	}
}
