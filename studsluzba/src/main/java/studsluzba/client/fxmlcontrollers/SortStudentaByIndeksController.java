package studsluzba.client.fxmlcontrollers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import studsluzba.model.Student;
import studsluzba.repositories.StudentRepository;
import studsluzba.services.StudentService;

@Component
public class SortStudentaByIndeksController {
	 @Autowired
	 StudentService studentService;
	 
	 @Autowired
	 StudentRepository studentRepo;
		
		
	 @FXML private TextField brIndeksa;
	 @FXML private TextField godinaUpisa;
	 @FXML private TextField smer;
	 
	 private ObservableList<Student> sviStidenti;
	 
	 @FXML private TableView<Student> studentiTable;
	 
	 @FXML
	 protected void initialize() {
		 sviStidenti = FXCollections.observableList(studentService.loadAll());
		 studentiTable.setItems(sviStidenti);
	 }
		
	 public void pretraziStudentaPoIndeksu(ActionEvent event) {
		 Student student = studentRepo.findStudentByID(Integer.parseInt(brIndeksa.getText()), Integer.parseInt(godinaUpisa.getText()), smer.getText());
		 studentiTable.getItems().clear();
		 studentiTable.getItems().add(student);
	 }
}
