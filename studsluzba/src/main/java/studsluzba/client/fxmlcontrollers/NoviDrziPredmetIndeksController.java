package studsluzba.client.fxmlcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import studsluzba.model.DrziPredmet;
import studsluzba.model.Nastavnik;
import studsluzba.model.Predmet;
import studsluzba.model.SkolskaGodina;
import studsluzba.services.SifarniciService;

@Component
public class NoviDrziPredmetIndeksController {

	@Autowired
	SifarniciService sifarniciService;
	
	@Autowired
	StudentIndeksController sviNastavniIndeks;
	
	@FXML private ComboBox<Predmet> noviPredmetCb;
	
	@FXML private ComboBox<Nastavnik> noviNastavnikCb;
	
	@FXML private ComboBox<SkolskaGodina> novaSkolskaGodinaCb;
	

	@FXML
    public void initialize() {	
		List<Predmet> sviPredmeti = sifarniciService.getPredmeti();
		noviPredmetCb.setItems(FXCollections.observableArrayList(sviPredmeti));
		
		List<Nastavnik> sviNastavnici = sifarniciService.getNastavnici();
		noviNastavnikCb.setItems(FXCollections.observableArrayList(sviNastavnici));
		
		List<SkolskaGodina> sveSkolskeGodine = sifarniciService.getAllSkolskeGodine();
		novaSkolskaGodinaCb.setItems(FXCollections.observableArrayList(sveSkolskeGodine));
	}
	
	public void dodajNoviDrziPredmetZaIndeks(ActionEvent event) {
		DrziPredmet drziPredmet = sifarniciService.saveDrziPredmet(noviNastavnikCb.getValue(), noviPredmetCb.getValue(), novaSkolskaGodinaCb.getValue());
		sviNastavniIndeks.dodajDrziPredmet(drziPredmet);
	}
}
