package studsluzba.client.fxmlcontrollers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import studsluzba.client.MainViewManager;
import studsluzba.model.DrziPredmet;
import studsluzba.model.Indeks;
import studsluzba.model.Nastavnik;
import studsluzba.model.ObnovaGodine;
import studsluzba.model.PolozenPredmet;
import studsluzba.model.Predmet;
import studsluzba.model.SkolskaGodina;
import studsluzba.model.StudProgram;
import studsluzba.model.Student;
import studsluzba.model.UpisGodine;
import studsluzba.repositories.IndeksRepository;
import studsluzba.repositories.PredmetRepository;
import studsluzba.repositories.StudProgramRepository;
import studsluzba.repositories.UpisGodineRepository;
import studsluzba.services.IndeksService;
import studsluzba.services.ObnovaGodineService;
import studsluzba.services.SifarniciService;
import studsluzba.services.StudProgramService;
import studsluzba.services.StudentService;
import studsluzba.services.UpisGodineService;

@Component
public class DosijeController {
	
	@Autowired
	MainViewManager mainViewManager;
	
	@Autowired
	IndeksRepository indeksRepo;
	
	@Autowired
	PredmetRepository predmetRepo;
	
	@Autowired 
	StudProgramRepository studProgramRepo;
	
	
	@Autowired
	IndeksService indeksService;
	
	@Autowired
	UpisGodineService upisGodineService;
	
	@Autowired 
	ObnovaGodineService obnovaGodineService;
	
	@Autowired
	SifarniciService sifaraniciService;
	
	@Autowired
	StudentService studentService;
	
	@Autowired 
	StudProgramService studProgramService;
	
	@Autowired
	PretraziStudentePoImenuPrezimenuController pretraziStud;
	
	//TableView Aktivnosti studenta
	
	@FXML private TableView<UpisGodine> upisGodineTable;
	
	private ObservableList<UpisGodine> sviUpisi;
	
	@FXML private TableView<ObnovaGodine> obnovaGodineTable;
	
	private ObservableList<ObnovaGodine> sveObnove;
	
	//Aktivnost Studenta FXML

	@FXML private ComboBox<String> upis_obnova;
	
	@FXML private ComboBox<Predmet> predmeti;
	
	@FXML private TextField datum;
	
	private ObservableList<Indeks> sviIndeksi;
	
	@FXML private TextField napomena;
	
	@FXML private TableView<Indeks> stTable;
	
	private List<Predmet> selektovaniPredmeti = new ArrayList<Predmet>();
	
	//Promena Indeksa FXML
	
	@FXML private TextField indeks;
	
	@FXML private ComboBox<StudProgram> studProgramCb;
	
	@FXML private TableView<Indeks> indeksTable;
	
	@FXML private Label actionTarget;
	
	//Polozeni predmeti
	
	@FXML private TableView<PolozenPredmet> polozeniPredmetiTable;
	
	private ObservableList<PolozenPredmet> sviPolozeniPredmeti;
	
	
	private ObservableList<Predmet> sviPredmeti;
	
	//Dodaj studenta na predmet
	
	@FXML private ComboBox<DrziPredmet> predmetCb;
	
	@FXML private TableView<Predmet> sviPredmeteTable;
	
	private ObservableList<Predmet> sviPredmetiKojeSlusaStud;
	
	private ObservableList<DrziPredmet> drziPredmet;
	
	//---------------------------
	
	@FXML
    protected void initialize() {	
		Indeks index = pretraziStud.selektovanIndeks;
		
		//TableView Aktivnosti studenta
		sviUpisi = FXCollections.observableArrayList(upisGodineService.findAllUpisForIndeks(index));
		upisGodineTable.setItems(sviUpisi);
		
		sveObnove = FXCollections.observableArrayList(obnovaGodineService.findAllObnoveForIndeks(index));
		obnovaGodineTable.setItems(sveObnove);
		
		//Aktivnosti Studenta
		List<String> obn_upis = List.of("Obnova Godine", "Upis Godine");
		upis_obnova.setItems(FXCollections.observableArrayList(obn_upis));
		
		
		sviIndeksi = FXCollections.observableArrayList(indeksRepo.selectIndekxById(index.getIdIndeks()));
		stTable.setItems(sviIndeksi);
		
		
		
		StudProgram studProgram = index.getStudProgram();
		String oznaka = studProgram.getOznaka();
		
		
		List<Predmet> predmet = sifaraniciService.getPredmeti(studProgram);
		predmeti.setItems(FXCollections.observableArrayList(predmet));
		
		//Promena Indeksa Studenta
		
		List<StudProgram> stProgram = studProgramRepo.selectAllStudPrograma(oznaka);
		studProgramCb.setItems(FXCollections.observableArrayList(stProgram));
		
		indeksTable.setItems(sviIndeksi);
		
		//Polozeni Predmeti
		sviPolozeniPredmeti = FXCollections.observableArrayList(sifaraniciService.getPolozeniPredmeti(index));
		polozeniPredmetiTable.setItems(sviPolozeniPredmeti);
		
		
		//Dodaj predmet studentu
		drziPredmet = FXCollections.observableList(sifaraniciService.getAllDrziPredmet());
		predmetCb.setItems(FXCollections.observableArrayList(drziPredmet));
		
		
		sviPredmetiKojeSlusaStud = FXCollections.observableArrayList(sifaraniciService.getPredmetiKojeSlusaStudent(index.getIdIndeks()));
		sviPredmeteTable.setItems(sviPredmetiKojeSlusaStud);
	}
	
	public void dodajDrziPredmet(DrziPredmet drPredmet) {
		predmetCb.getItems().add(drPredmet);
	}
	
	//Akcije za Aktivnosti studenta
	public void dodajUListuPredmeta(ActionEvent event) {
		Predmet p = predmeti.getSelectionModel().getSelectedItem();
		selektovaniPredmeti.add(p);
	}
	
	public void napraviAktivnost(ActionEvent event) {
		
		Indeks index = pretraziStud.selektovanIndeks;
		Student s = index.getStudent();
		Indeks indeks = indeksRepo.findAktivanIndeks(s.getIdstudent());
		
		if(upis_obnova.getValue().equals("Obnova Godine")) {
			ObnovaGodine ob = obnovaGodineService.saveObnovaGodine(selektovaniPredmeti, datum.getText(), napomena.getText(), indeks);
			sveObnove.add(ob);
			obnovaGodineTable.setItems(sveObnove);
		}else if(upis_obnova.getValue().equals("Upis Godine")) {
			UpisGodine up = upisGodineService.saveUpisGodine(selektovaniPredmeti, datum.getText(), napomena.getText(), indeks);
			sviUpisi.add(up);
			upisGodineTable.setItems(sviUpisi);
		}
		selektovaniPredmeti.clear();
	}
	
	//Akcija za Dodelu novog Indeksa
	public void dodeliNoviIndeks(ActionEvent event) {
		Indeks _indeks = pretraziStud.selektovanIndeks;
		Student s = _indeks.getStudent();
		
		int year = Calendar.getInstance().get(Calendar.YEAR);
		int i = Integer.parseInt(indeks.getText());
		StudProgram sp = studProgramCb.getValue();
		
		Indeks proveriDaLiPostoji = indeksService.checkForIndeks(i, sp, year);
		
		if(proveriDaLiPostoji != null) {
			System.out.println("Indeks postoji");
			actionTarget.setText("Ovakav indeks vec postoji!");
			return;
		}
		
		studentService.promeniAktivanIndeksNaNeaktivan(_indeks);
		
		pretraziStud.updateTabeluSaIndeksima(_indeks);
		
		ObnovaGodine obnova = _indeks.getObnovaGodine();
		UpisGodine upis = _indeks.getUpisGodine();
		
		Indeks index = studentService.saveIndeks(s, i, sp, obnova, upis);
		sviIndeksi.add(index);
		pretraziStud.addNoviIndeks(index);
		
		//Brisem stari indeks iz druge tabele
		
		sviIndeksi.clear();
		sviIndeksi.add(index);
		indeksTable.setItems(sviIndeksi);
	}
	
	//Otvaranje forme za dodavanje novogPredmeta
	public void openFormForNewDrziPredmet(ActionEvent event) {
		mainViewManager.openModal("addNewDrziPredmet");
	}
	
	//Dodavanje novog predmeta studentu
	public void dodajNoviPredmetStudentu(ActionEvent event) {
		List<Indeks> indeksi = new ArrayList<Indeks>();
		indeksi.add(pretraziStud.selektovanIndeks);
		DrziPredmet drPredmet = sifaraniciService.addSlusaPredmet(indeksi, predmetCb.getValue());
		Predmet pr = drPredmet.getPredmet();
		sviPredmetiKojeSlusaStud.add(pr);
		indeksi.clear();
	}
}
