package studsluzba.client.fxmlcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import studsluzba.model.Indeks;
import studsluzba.model.Ispit;
import studsluzba.repositories.IndeksRepository;
import studsluzba.repositories.IspitRepository;
import studsluzba.repositories.StudentRepository;
import studsluzba.services.IndeksService;
import studsluzba.services.StudentService;

@Component
public class RezultatiIspitaController {
	
	@Autowired
	IspitRepository ispitRepo;
	
	@Autowired
	IndeksRepository indeksRepo;
	
	@Autowired
	StudentRepository studentRepo;
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	IndeksService indeksService;
	

	@FXML private ComboBox<Ispit> prijavljeniIspiti;
	
	@FXML TableView<Indeks> prijavljeniStudentiIspitTable;
	
	private ObservableList<Indeks> sviStudent;
	
	@FXML 
	public void initialize() {
		List<Ispit> sviIspiti = ispitRepo.rezultatiIspita();
		prijavljeniIspiti.setItems(FXCollections.observableArrayList(sviIspiti));
		
		sviStudent = FXCollections.observableArrayList(indeksService.loadAll());
		prijavljeniStudentiIspitTable.setItems(sviStudent);
	}
	
	public void rezultatiIspita() {
		Ispit ispit = prijavljeniIspiti.getValue();
		int id = ispit.getIdIspit();
		List<Indeks> indeksi = indeksRepo.getSortedIndeks(id);
		
		prijavljeniStudentiIspitTable.getItems().clear();
		prijavljeniStudentiIspitTable.getItems().addAll(indeksi);
	}
}
