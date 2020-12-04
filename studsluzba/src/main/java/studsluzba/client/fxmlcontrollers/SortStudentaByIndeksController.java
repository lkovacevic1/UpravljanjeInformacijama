package studsluzba.client.fxmlcontrollers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import studsluzba.model.Student;
import studsluzba.repositories.StudentRepository;
import studsluzba.services.StudentService;

@Component
public class SortStudentaByIndeksController {
	 @Autowired
	 StudentService studentService;
	 
	 @Autowired
	 StudentRepository studentRepo;
		
		
	 @FXML private TextField indeks;
	 
	 private ObservableList<Student> sviStidenti;
	 
	 @FXML private TableView<Student> studentiTable;
	 
	 @FXML
	 protected void initialize() {
		 sviStidenti = FXCollections.observableList(studentService.loadAll());
		 studentiTable.setItems(sviStidenti);
	 }
		
	 public void pretraziStudentaPoIndeksu(ActionEvent event) {
		 String index = indeks.getText();
		 String parts[] = index.split("/");
		
		 Student student = studentRepo.findStudentByID(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), parts[2]);
		 studentiTable.getItems().clear();
		 studentiTable.getItems().add(student);
	 }
}