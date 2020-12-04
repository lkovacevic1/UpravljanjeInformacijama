package studsluzba.client.fxmlcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import studsluzba.model.Indeks;
import studsluzba.model.StudProgram;
import studsluzba.model.Student;
import studsluzba.model.VisokoskolskaUstanova;
import studsluzba.repositories.StudentRepository;
import studsluzba.services.IndeksService;
import studsluzba.services.SifarniciService;
import studsluzba.services.StudentService;

@Component
public class PromenaIndeksStudentuController {
	
	@Autowired
	SifarniciService sifarniciService;

	@Autowired
	StudentRepository studentRepo;
	 
	@Autowired
	IndeksService indeksService;
		
		
	@FXML private ComboBox<Student> student;
	 
	@FXML private TextField indeks;
	 
	@FXML
	public void initialize() {		
		 
		List<Student> studenti = sifarniciService.getStudent();
		student.setItems(FXCollections.observableArrayList(studenti));
	}
		
	public void promeniIndeks(ActionEvent event) {
		/*Student stud = student.getValue();
	
		String index = indeks.getText();
		String parts[] = index.split("/");
		
		int indeks = Integer.parseInt(parts[0]);
		int godina = Integer.parseInt(parts[1]);
		String studProgram = parts[2];
		StudProgram sp = new StudProgram(studProgram);
		 
		Indeks i = indeksService.changeIndeks(stud, indeks, godina, sp);*/
	}
}
