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
import studsluzba.model.Predmet;
import studsluzba.model.StudProgram;
import studsluzba.model.Student;
import studsluzba.repositories.IndeksRepository;
import studsluzba.repositories.PredmetRepository;
import studsluzba.services.ObnovaGodineService;
import studsluzba.services.SifarniciService;
import studsluzba.services.StudentService;

@Component
public class DosijeController {
	
	@Autowired
	IndeksRepository indeksRepo;
	
	@Autowired
	SifarniciService sifraniciService;
	
	@Autowired 
	ObnovaGodineService obnovaGodineService;
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	PredmetRepository predmetRepo;
	
	@Autowired
	PretraziStudentePoImenuPrezimenuController pretraziStud;

	@FXML private ComboBox<String> upis_obnova;
	
	@FXML private ComboBox<Predmet> predmeti;
	
	@FXML private TextField datum;
	
	private ObservableList<Student> sviStidenti;
	
	@FXML private TextField napomena;
	
	@FXML private TableView<Student> stTable;
	
	@FXML private TableView<Student> studentiTable;
	
	private List<Predmet> selektovaniPredmeti = new ArrayList<Predmet>();
	
	@FXML
    public void initialize() {	
		List<String> obn_upis = List.of("Obnova Godine", "Upis Godine");
		upis_obnova.setItems(FXCollections.observableArrayList(obn_upis));
		
		List<Student> stud = new ArrayList<Student>();
		Student s = pretraziStud.selektovanStudent;
		stud.add(s);
		System.out.println(s.getIdstudent());
		sviStidenti = FXCollections.observableList(stud);
		stTable.setItems(sviStidenti);
		
		
		List<Indeks> ind = indeksRepo.findIndeksOfStudent(s);
		StudProgram sp = null;
		System.out.println("\n");
		for(Indeks in : ind) {
			System.out.println(in.getBrojIndexa());
			 //if(s.getIndeks().equals(in.getIndeks())){
			 	sp = in.getStudProgram();
			 //}
		}
		
		List<Predmet> predmet = sifraniciService.getPredmeti(sp);
		predmeti.setItems(FXCollections.observableArrayList(predmet));
	}
	
	public void dodajUListuPredmeta(ActionEvent event) {
		//Predmet p = predmeti.getValue();
		Predmet p = predmeti.getSelectionModel().getSelectedItem();
		selektovaniPredmeti.add(p);
	}
	
	public void napraviAktivnost(ActionEvent event) {
		Student s = pretraziStud.selektovanStudent;
		Indeks indeks = indeksRepo.findAktivanIndeks(s.getIdstudent());
		if(upis_obnova.getValue().equals("Obnova Godine")) {
			ObnovaGodine obnovaGodine = obnovaGodineService.saveObnovaGodine(selektovaniPredmeti, datum.getText(), napomena.getText(), indeks);
		}
		selektovaniPredmeti.clear();
	}
}
