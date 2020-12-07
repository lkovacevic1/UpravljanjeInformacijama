package studsluzba.client.fxmlcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import studsluzba.model.Ispit;
import studsluzba.model.IspitniRok;
import studsluzba.model.Nastavnik;
import studsluzba.model.Predmet;
import studsluzba.model.SkolskaGodina;
import studsluzba.model.StudProgram;
import studsluzba.model.VisokoskolskaUstanova;
import studsluzba.repositories.NastavnikRepository;
import studsluzba.repositories.SkolskaGodinaRepository;
import studsluzba.services.IspitniRokoviService;
import studsluzba.services.SifarniciService;

@Component
public class UnosIspitRokController {
	
	@Autowired
	IspitniRokoviService ispitniRokoviService;
	
	@Autowired
	SifarniciService sifarniciService;
	
	@Autowired
	NastavnikRepository nastavnikRepo;
	
	@Autowired
	SkolskaGodinaRepository skolskaGodinaRepo;
	
	private ObservableList<IspitniRok> sviRokovi;
	
	private ObservableList<Ispit> sviIspiti;
	
	@FXML private TableView<IspitniRok> rokoviTable;
	
	@FXML private TableView<Ispit> ispitiTable;
	
	@FXML private DatePicker datumPocetkaIspitnogRoka;
	
	@FXML private DatePicker datumZavrsetkaIspitnogRoka;
	
	@FXML private ComboBox<IspitniRok> cbIspitniRok;
	
	//Ispit
	
	@FXML private DatePicker datumPocetkaIspita;
	
	@FXML private TextField vremeOdrzavanjaIspita;
	
	@FXML private CheckBox zakljucen;
	
	@FXML private ComboBox<IspitniRok> cbIspit;
	
	@FXML private ComboBox<Nastavnik> cbNastavnik2;
	
	@FXML private ComboBox<Predmet> cbPredmet2;
	
	 @FXML
	 protected void initialize() {
		 sviRokovi = FXCollections.observableList(ispitniRokoviService.loadAll());
		 rokoviTable.setItems(sviRokovi);
		 
		 sviIspiti = FXCollections.observableList(ispitniRokoviService.loadAllIspiti());
		 ispitiTable.setItems(sviIspiti);
		 
		 List<IspitniRok> ispitniRok = sifarniciService.getIspitniRok();
		 cbIspit.setItems(FXCollections.observableArrayList(ispitniRok));
		 
		 List<Nastavnik> nastavnik = nastavnikRepo.selekcijaAktivnihNastavnika();
		 cbNastavnik2.setItems(FXCollections.observableArrayList(nastavnik));
		 
		 List<Predmet> predmet = sifarniciService.getPredmeti();
		 cbPredmet2.setItems(FXCollections.observableArrayList(predmet));
	 }
	
	 
	 public void handleSacuvajIspitniRok(ActionEvent event) {
		 
		 SkolskaGodina skolskaGodina = skolskaGodinaRepo.findAktivnaSkGod();
		 IspitniRok rok = ispitniRokoviService.saveIspitniRok(datumPocetkaIspitnogRoka.getValue(),datumZavrsetkaIspitnogRoka.getValue(), skolskaGodina);
		 sviRokovi.add(rok);
	 }
	 
	 public void handleSacuvajIspit(ActionEvent event) {
		 
		 boolean flag = false;
		 if(zakljucen.isSelected()) {
			 flag = true;
		 }
		 Nastavnik ns = cbNastavnik2.getValue();
		 System.out.println("Nastavnik " + ns.getIdNastavnik());
		 Ispit ispit = ispitniRokoviService.saveIspit(datumPocetkaIspita.getValue(), Integer.parseInt(vremeOdrzavanjaIspita.getText()), flag, cbPredmet2.getValue(), cbNastavnik2.getValue(), cbIspit.getValue());
		 sviIspiti.add(ispit);
	 }
}
