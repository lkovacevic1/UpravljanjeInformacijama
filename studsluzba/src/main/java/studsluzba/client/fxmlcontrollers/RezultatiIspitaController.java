package studsluzba.client.fxmlcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import studsluzba.model.Ispit;
import studsluzba.model.Student;
import studsluzba.repositories.IspitRepository;
import studsluzba.repositories.StudentRepository;
import studsluzba.services.StudentService;

@Component
public class RezultatiIspitaController {
	
	@Autowired
	IspitRepository ispitRepo;
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	StudentRepository studentRepo;

	@FXML private ComboBox<Ispit> prijavljeniIspiti;
	
	@FXML TableView<Student> prijavljeniStudentiIspitTable;
	
	private ObservableList<Student> sviStudent;
	
	@FXML 
	public void initialize() {
		List<Ispit> sviIspiti = ispitRepo.rezultatiIspita();
		prijavljeniIspiti.setItems(FXCollections.observableArrayList(sviIspiti));
		
		sviStudent = FXCollections.observableArrayList(studentService.loadAll());
		prijavljeniStudentiIspitTable.setItems(sviStudent);
	}
	
	public void rezultatiIspita() {
		Ispit ispit = prijavljeniIspiti.getValue();
		int id = ispit.getIdIspit();
		List<Student> studenti = studentRepo.sortedStudents(id);
		
		prijavljeniStudentiIspitTable.getItems().clear();
		prijavljeniStudentiIspitTable.getItems().addAll(studenti);
	}
}
