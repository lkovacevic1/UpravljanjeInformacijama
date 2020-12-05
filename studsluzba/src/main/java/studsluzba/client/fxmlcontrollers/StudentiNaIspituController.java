package studsluzba.client.fxmlcontrollers;

import java.time.LocalDate;
import java.util.List;
import java.util.Observable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import studsluzba.client.MainViewManager;
import studsluzba.model.Ispit;
import studsluzba.model.Student;
import studsluzba.repositories.StudentRepository;
import studsluzba.services.SifarniciService;
import studsluzba.services.StudentiNaIspituService;

@Component
public class StudentiNaIspituController {
	
	@Autowired
	StudentiNaIspituService studentiNaIspituService;
	
	@Autowired
	StudentRepository studentRepo;
	
	@Autowired
	SifarniciService sifarniciService;
	
	@FXML private ComboBox<Ispit> datumOdrzavanjaIspita;
	
	@FXML private TableView<Student> studentiNaIspituTable;
	
	private ObservableList<Student> sviStudenti;
	
	
	@FXML
    public void initialize() {
		
		sviStudenti = FXCollections.observableList(studentiNaIspituService.loadAll());
		studentiNaIspituTable.setItems(sviStudenti);
		
		List<Ispit> ispiti = sifarniciService.getIspiti();
		datumOdrzavanjaIspita.setItems(FXCollections.observableArrayList(ispiti));
	}
	
	public void pretraziStudentePoIspitu(ActionEvent event) {
		Ispit podaci = datumOdrzavanjaIspita.getValue();
		int id = podaci.getIdIspit();
		List<Student> studenti = studentRepo.sortedStudents(id);
		for (Student st : studenti) {
			System.out.println(st);
		}
		studentiNaIspituTable.getItems().clear();
		studentiNaIspituTable.getItems().addAll(studenti);
	}
}
