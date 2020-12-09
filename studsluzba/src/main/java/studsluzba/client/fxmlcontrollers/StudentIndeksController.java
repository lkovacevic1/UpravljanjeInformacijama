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
	SifarniciService sifraniciService;
	
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
		
	
	//Dodavanje poena studentu FXML
	
	@FXML private ComboBox<Predmet> predmetCb;
	
	@FXML private ComboBox<PredispitneObaveze> obavezaCb;
	
	@FXML private TextField predispitniPoeniTF;
	
	@FXML private TextField ispitPoeniTF;
	
	//Polozeni predmeti
	
	@FXML private TableView<PolozenPredmet> polozeniPredmetiTable;
		
	private ObservableList<PolozenPredmet> sviPolozeniPredmeti;
	
	//Slusa predmete
	
	@FXML private TableView<Predmet> slusaPredmeteTable;
		
	private ObservableList<Predmet> sviPredmeti;
		
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
		
		
		
		List<Predmet> predmet = sifraniciService.getPredmeti(studProgram);
		predmeti.setItems(FXCollections.observableArrayList(predmet));
		
		//Promena indeksa
		
		List<StudProgram> stProgram = studProgramRepo.selectAllStudPrograma(oznaka);
		studProgramCb.setItems(FXCollections.observableArrayList(stProgram));
		
		indeksTable.setItems(sviIndexi);
		
		//Poeni indeksa
		predmetCb.setItems(FXCollections.observableArrayList(predmet));
		
		List<PredispitneObaveze> predispitneObaveze = predispitneObavezeRepo.findVrstaObaveze(index.getIdIndeks());
		obavezaCb.setItems(FXCollections.observableArrayList(predispitneObaveze));
		
		//Polozeni Predmeti
		sviPolozeniPredmeti = FXCollections.observableArrayList(sifraniciService.getPolozeniPredmeti(index));
		polozeniPredmetiTable.setItems(sviPolozeniPredmeti);
		
		//Slusa predmet
		sviPredmeti = FXCollections.observableArrayList(sifarniciService.getPredmetiForStudent(index.getIdIndeks()));
		slusaPredmeteTable.setItems(sviPredmeti);
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
	
	//Akcija za dodavanje poena studentu
	public void dodajPoena(ActionEvent event) {
		Indeks indeks = promeniIndeksStud.selektovanIndeksZaZamenu;
		
		int obaveze = Integer.parseInt(predispitniPoeniTF.getText());
		int ispitPoeni = Integer.parseInt(ispitPoeniTF.getText());
		
		
		List<OsvojeniPredispitniPoeni> opp = indeks.getOsvojeniPredispitniPOeni();
		OsvojeniPredispitniPoeni _opp = opp.get(0);
		
		indeksService.dodajePredispitnePoene(_opp, obaveze);
		
		List<PolozenPredmet> pp = indeks.getPolozeniPredmeti();
		PolozenPredmet _pp = pp.get(0);
		
		indeksService.dodajePoeneNaIspitu(_pp, ispitPoeni, obaveze);
		
		indeksService.dodajOsvojenePoene(indeks, obaveze, ispitPoeni);
		
		opp.clear();
	}
}
