package studsluzba.client.fxmlcontrollers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import studsluzba.model.Indeks;
import studsluzba.model.Predmet;
import studsluzba.model.StudProgram;
import studsluzba.model.Student;
import studsluzba.repositories.IndeksRepository;
import studsluzba.repositories.PredmetRepository;
import studsluzba.services.SifarniciService;
import studsluzba.services.StudentService;

@Component
public class DosijeController {
	
	@Autowired
	IndeksRepository indeksRepo;
	
	@Autowired
	SifarniciService sifraniciService;
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	PredmetRepository predmetRepo;
	
	@Autowired
	PretraziStudentePoImenuPrezimenuController pretraziStud;

	@FXML private ComboBox<String> upis_obnova;
	
	@FXML private ComboBox<Predmet> predmeti;
	
	@FXML private DatePicker datum;
	
	private ObservableList<Student> sviStidenti;
	
	@FXML private TextField napomena;
	
	@FXML private TableView<Student> stTable;
	
	@FXML private TableView<Student> studentiTable;
	
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
}
