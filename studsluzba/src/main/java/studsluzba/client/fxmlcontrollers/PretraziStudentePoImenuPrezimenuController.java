package studsluzba.client.fxmlcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import studsluzba.client.MainViewManager;
import studsluzba.model.Student;
import studsluzba.repositories.StudentRepository;
import studsluzba.services.StudentService;

@Component
public class PretraziStudentePoImenuPrezimenuController {
	 @Autowired
	 StudentService studentService;
	 
	 @Autowired
	 StudentRepository studentRepo;
	 
	 @Autowired  
	 MainViewManager mainViewManager;
	 
	 Student selektovanStudent;
		
	 @FXML private TextField ime;
	 @FXML private TextField prezime;
	 
	 private ObservableList<Student> sviStidenti;
	 
	 @FXML private TableView<Student> studentiTable;
	 
	 @FXML
	 protected void initialize() {
		 sviStidenti = FXCollections.observableList(studentService.loadAll());
		 
		 
		 studentiTable.setRowFactory( tv -> {
			    TableRow<Student> row = new TableRow<>();
			    row.setOnMouseClicked(event -> {
			        if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
			            Student rowData = row.getItem();
			            /*System.out.println(rowData);
			            
			            Student st = row.getItem();
			            System.out.println(st.getIdstudent());*/
			            selektovanStudent = rowData;
			            
			            mainViewManager.openModal("TabAktivnostIndeksStudenta", 750, 500);
			        }
			    });
			    return row ;
			});
		 
		 studentiTable.setItems(sviStidenti);
	 }
		
	 public void pretraziStudentePoImenuPrezimenu(ActionEvent event) {
		 List<Student> student = studentRepo.findStudentByNameAndLastName(ime.getText(), prezime.getText());
		 studentiTable.getItems().clear();
		 studentiTable.getItems().addAll(student);
	 }
}
