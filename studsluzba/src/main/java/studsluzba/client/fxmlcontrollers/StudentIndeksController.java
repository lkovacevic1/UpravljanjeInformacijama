package studsluzba.client.fxmlcontrollers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import studsluzba.client.MainViewManager;
import studsluzba.model.DrziPredmet;
import studsluzba.model.Indeks;
import studsluzba.model.ObnovaGodine;
import studsluzba.model.OsvojeniPredispitniPoeni;
import studsluzba.model.PolozenPredmet;
import studsluzba.model.PredispitneObaveze;
import studsluzba.model.Predmet;
import studsluzba.model.StudProgram;
import studsluzba.model.Student;
import studsluzba.model.UpisGodine;
import studsluzba.repositories.IndeksRepository;
import studsluzba.repositories.PredispitneObavezeRepository;
import studsluzba.repositories.PredmetRepository;
import studsluzba.repositories.StudProgramRepository;
import studsluzba.services.IndeksService;
import studsluzba.services.ObnovaGodineService;
import studsluzba.services.SifarniciService;
import studsluzba.services.StudProgramService;
import studsluzba.services.StudentService;
import studsluzba.services.UpisGodineService;

@Component
public class StudentIndeksController {
	
	@Autowired
	MainViewManager mainViewManager;
	
	@Autowired
	IndeksRepository indeksRepo;
	
	@Autowired
	PredmetRepository predmetRepo;
	
	@Autowired 
	StudProgramRepository studProgramRepo;
	
	@Autowired
	PredispitneObavezeRepository predispitneObavezeRepo;
	
	
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
	SifarniciService sifarniciService;
	
	@Autowired
	SortStudentaByIndeksController promeniIndeksStud;
	
	//TableView Aktivnosti studenta
	
	@FXML private TableView<UpisGodine> upisGodineTable;
		
	private ObservableList<UpisGodine> sviUpisi;
		
	@FXML private TableView<ObnovaGodine> obnovaGodineTable;
		
	private ObservableList<ObnovaGodine> sveObnove;
	
	//Aktivnost Studenta FXML

	@FXML private ComboBox<String> upis_obnova;
	
	@FXML private ComboBox<Predmet> predmeti;
	
	@FXML private TextField datum;
	
	private ObservableList<Indeks> sviIndexi;
	
	@FXML private TextField napomena;
	
	@FXML private TableView<Indeks> indeksAktivnostTable;
	
	private List<Predmet> selektovaniPredmeti = new ArrayList<Predmet>();
	
	//Promena Indeksa FXML
		
	@FXML private TextField indeks;
	
	@FXML private ComboBox<StudProgram> studProgramCb;
		
	@FXML private TableView<Indeks> indeksTable;
	
	//Polozeni predmeti
	
	@FXML private TableView<PolozenPredmet> polozeniPredmetiTable;
		
	private ObservableList<PolozenPredmet> sviPolozeniPredmeti;
	
		
	//Dodaj studenta na predmet
	
	@FXML private ComboBox<DrziPredmet> predmetCb;
		
	@FXML private TableView<Predmet> sviPredmeteTable;
		
	private ObservableList<Predmet> sviPredmetiKojeSlusaStud;
		
	private ObservableList<DrziPredmet> drziPredmet;
	
	//---------------------------
	
	@FXML
    public void initialize() {	
		Indeks index = promeniIndeksStud.selektovanIndeksZaZamenu;
		
		//TableView Aktivnosti studenta
		sviUpisi = FXCollections.observableArrayList(upisGodineService.findAllUpisForIndeks(index));
		upisGodineTable.setItems(sviUpisi);
		
		sveObnove = FXCollections.observableArrayList(obnovaGodineService.findAllObnoveForIndeks(index));
		obnovaGodineTable.setItems(sveObnove);
		
		//Aktivnost Studenta
		List<String> obn_upis = List.of("Obnova Godine", "Upis Godine");
		upis_obnova.setItems(FXCollections.observableArrayList(obn_upis));
	
		
		sviIndexi = FXCollections.observableArrayList(indeksRepo.selectIndekxById(index.getIdIndeks()));
		indeksAktivnostTable.setItems(sviIndexi);
		
		
		
		StudProgram studProgram = index.getStudProgram();
		String oznaka = studProgram.getOznaka();
		
		
		
		List<Predmet> predmet = sifaraniciService.getPredmeti(studProgram);
		predmeti.setItems(FXCollections.observableArrayList(predmet));
		
		//Promena indeksa
		
		List<StudProgram> stProgram = studProgramRepo.selectAllStudPrograma(oznaka);
		studProgramCb.setItems(FXCollections.observableArrayList(stProgram));
		
		indeksTable.setItems(sviIndexi);
		
		
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
		Indeks index = promeniIndeksStud.selektovanIndeksZaZamenu;
		Student stud = index.getStudent();
		Indeks ind = indeksRepo.findAktivanIndeks(stud.getIdstudent());
		
		if(upis_obnova.getValue().equals("Obnova Godine")) {
			obnovaGodineService.saveObnovaGodine(selektovaniPredmeti, datum.getText(), napomena.getText(), ind);
		}else if(upis_obnova.getValue().equals("Upis Godine")) {
			upisGodineService.saveUpisGodine(selektovaniPredmeti, datum.getText(), napomena.getText(), ind);
		}
		selektovaniPredmeti.clear();
		
		sviUpisi = FXCollections.observableArrayList(upisGodineService.findAllUpisForIndeks(index));
		upisGodineTable.setItems(sviUpisi);
		
		sveObnove = FXCollections.observableArrayList(obnovaGodineService.findAllObnoveForIndeks(index));
		obnovaGodineTable.setItems(sveObnove);
	}
	
	//Akcija za dodelu novog Indeksa
	public void promeniIndeks(ActionEvent event) {
		Indeks _indeks = promeniIndeksStud.selektovanIndeksZaZamenu;
		Student s = _indeks.getStudent();
		
		studentService.promeniAktivanIndeksNaNeaktivan(_indeks);
		
		promeniIndeksStud.updateTabeluSaIndeksima(_indeks);
		
		ObnovaGodine obnova = _indeks.getObnovaGodine();
		UpisGodine upis = _indeks.getUpisGodine();
		
		int i = Integer.parseInt(indeks.getText());
		
		StudProgram sp = studProgramCb.getValue();
		
		Indeks index = studentService.saveIndeks(s, i, sp, obnova, upis);
		sviIndexi.add(index);
		
		//Dodam promenjeni indeks u prvu tabelu
		promeniIndeksStud.addNoviIndeks(index);
		
		
		//Brisem stari indeks iz druge tabele
		sviIndexi.clear();
		sviIndexi.add(index);
		indeksTable.setItems(sviIndexi);
	}
	
	//Otvaranje forme za dodavanje novogPredmeta
	public void openFormForNewDrziPredmet(ActionEvent event) {
		mainViewManager.openModal("addNewDrziPredmetIndeks");
	}
		
	//Dodavanje novog predmeta studentu
	public void dodajNoviPredmetKojiSlusaStudent(ActionEvent event) {
		List<Indeks> indeksi = new ArrayList<Indeks>();
		indeksi.add(promeniIndeksStud.selektovanIndeksZaZamenu);
		DrziPredmet drPredmet = sifaraniciService.addSlusaPredmet(indeksi, predmetCb.getValue());
		Predmet pr = drPredmet.getPredmet();
		sviPredmetiKojeSlusaStud.add(pr);
		indeksi.clear();
	}
}
