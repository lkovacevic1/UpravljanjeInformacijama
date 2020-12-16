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
import javafx.scene.control.TextField;
import studsluzba.model.DrziPredmet;
import studsluzba.model.Nastavnik;
import studsluzba.model.Predmet;
import studsluzba.model.SkolskaGodina;
import studsluzba.repositories.NastavnikRepository;
import studsluzba.services.SifarniciService;

@Component
public class SkolskeGodineController {
	
	@Autowired
	SifarniciService sifarniciService;
	
	

	
	@FXML private TextField skolskaGodinaTf;
	
	@FXML private TableView<SkolskaGodina> skolskeGodineTable;
	
	private ObservableList<SkolskaGodina> sveSkolskeGodine;
	
	//pregled nastavnika za predmet
	
	@FXML private ComboBox<Predmet> noviPredmetCb;
	
	@FXML private ComboBox<Nastavnik> noviNastavnikCb;
	
	@FXML private TableView<DrziPredmet> nastavniciPoPredmetimaTable;
	
	private ObservableList<DrziPredmet> sviNastavniciPoPredmetima;
	
	
	@FXML
	protected void initialize() {
		sveSkolskeGodine = FXCollections.observableArrayList(sifarniciService.getAllSkolskeGodine());
		skolskeGodineTable.setItems(sveSkolskeGodine);
		
		List<Predmet> sviPredmeti = sifarniciService.getPredmeti();
		System.out.println(sviPredmeti.size());
		noviPredmetCb.setItems(FXCollections.observableArrayList(sviPredmeti));
		
		
		List<Nastavnik> sviNastavnici = sifarniciService.getNastavnici();
		noviNastavnikCb.setItems(FXCollections.observableArrayList(sviNastavnici));
		
		sviNastavniciPoPredmetima = FXCollections.observableArrayList(sifarniciService.getAllDrziPredmet());
		nastavniciPoPredmetimaTable.setItems(sviNastavniciPoPredmetima);
	}
	
	public void dodajNovuGodinu(ActionEvent event) {
		SkolskaGodina skolskaGodina = sifarniciService.saveSkolskaGodina(Integer.parseInt(skolskaGodinaTf.getText()));
		sveSkolskeGodine.add(skolskaGodina);
		sveSkolskeGodine = FXCollections.observableArrayList(sifarniciService.getAllSkolskeGodine());
		skolskeGodineTable.setItems(sveSkolskeGodine);
	}
	
	public void dodajNastavnika(ActionEvent event) {
		
		Nastavnik nastavnik = noviNastavnikCb.getValue();
		Predmet predmet = noviPredmetCb.getValue();
		SkolskaGodina sk = sifarniciService.getAktivnaSkolskaGodina();
		DrziPredmet dp = sifarniciService.saveDrziPredmet(nastavnik, predmet, sk);
		sviNastavniciPoPredmetima.add(dp);
		
	}
	
}
