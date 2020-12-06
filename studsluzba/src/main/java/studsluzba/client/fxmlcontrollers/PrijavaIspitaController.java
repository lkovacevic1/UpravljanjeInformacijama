package studsluzba.client.fxmlcontrollers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import studsluzba.model.Indeks;
import studsluzba.model.Ispit;
import studsluzba.model.IspitniRok;
import studsluzba.model.PrijavaIspita;
import studsluzba.model.Student;
import studsluzba.repositories.IspitRepository;
import studsluzba.repositories.StudentRepository;
import studsluzba.services.PrijavaIspitaService;
import studsluzba.services.StudentService;

@Component
public class PrijavaIspitaController {
	
	@Autowired
	IspitRepository ispitRepo;
	
	@Autowired
	StudentRepository studentRepo;
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	PrijavaIspitaService prijavaIspitaService;
	
	@FXML private ComboBox<Ispit> neprijavljeniIspiti;
	
	@FXML private ComboBox<Student> studenti;
	
	private ObservableList<Student> sviStudenti;
	
	@FXML
	protected void initialize() {
		
		List<Ispit> sviIspiti = ispitRepo.ispitiZaPrijavu();
		neprijavljeniIspiti.setItems(FXCollections.observableArrayList(sviIspiti));
		
		sviStudenti = FXCollections.observableArrayList(studentService.loadAll());
		studenti.setItems(sviStudenti);
		
	}
	
	public void prijaviStudenta() {
		
		Ispit ispit = neprijavljeniIspiti.getValue();
		Student student = studenti.getValue();
		
		List<Indeks> indeksi = student.getIndeks();
		Indeks indeks = null;
		for (Indeks i : indeksi) {
			if(i.isAktivan()) {
				indeks = i;
				break;
			}
		}
		
		prijavaIspitaService.savePrijavaIspita(ispit, indeks);
	}
	
}
