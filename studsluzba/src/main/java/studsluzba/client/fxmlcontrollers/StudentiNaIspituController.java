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
import studsluzba.model.Indeks;
import studsluzba.model.Ispit;
import studsluzba.model.Student;
import studsluzba.repositories.IndeksRepository;
import studsluzba.repositories.IspitRepository;
import studsluzba.repositories.StudentRepository;
import studsluzba.services.IndeksService;
import studsluzba.services.SifarniciService;
import studsluzba.services.StudentiNaIspituService;

@Component
public class StudentiNaIspituController {
	
	@Autowired
	StudentiNaIspituService studentiNaIspituService;
	
	@Autowired
	IndeksService indeksService;
	
	@Autowired
	IndeksRepository indeksRepo;
	
	@Autowired
	IspitRepository ispitRepo;
	
	@Autowired
	StudentRepository studentRepo;
	
	@Autowired
	SifarniciService sifarniciService;
	
	@FXML private ComboBox<Ispit> datumOdrzavanjaIspita;
	
	@FXML private TableView<Indeks> studentiNaIspituTable;
	
	private ObservableList<Indeks> sviIndeksi;
	
	
	@FXML
    public void initialize() {
		
		sviIndeksi = FXCollections.observableList(indeksService.loadAll());
		studentiNaIspituTable.setItems(sviIndeksi);
		
		List<Ispit> ispiti = ispitRepo.ispitiZaPrijavu();
		datumOdrzavanjaIspita.setItems(FXCollections.observableArrayList(ispiti));
	}
	
	public void pretraziStudentePoIspitu(ActionEvent event) {
		Ispit podaci = datumOdrzavanjaIspita.getValue();
		int id = podaci.getIdIspit();
		List<Indeks> indeksi = indeksRepo.findAllIndeksForIspit(id);
		//List<Student> studenti = studentRepo.findAllStudentsForIspit(id);
		
		studentiNaIspituTable.getItems().clear();
		studentiNaIspituTable.getItems().addAll(indeksi);
	}
}
