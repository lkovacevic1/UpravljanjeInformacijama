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
import studsluzba.model.Indeks;
import studsluzba.model.Student;
import studsluzba.repositories.IndeksRepository;
import studsluzba.repositories.StudentRepository;
import studsluzba.services.IndeksService;
import studsluzba.services.StudentService;

@Component
public class PretraziStudentePoImenuPrezimenuController {
	 @Autowired
	 IndeksService indeksService;
	 
	 @Autowired
	 IndeksRepository indeksRepo;
	 
	 @Autowired  
	 MainViewManager mainViewManager;
	 
	 Indeks selektovanIndeks;
		
	 @FXML private TextField ime;
	 @FXML private TextField prezime;
	 
	 private ObservableList<Indeks> sviIndeksi;
	 
	 @FXML private TableView<Indeks> indeksTable;
	 
	 @FXML
	 protected void initialize() {
		 sviIndeksi = FXCollections.observableList(indeksService.loadAllActiveIndeks());
		 
		 
		 indeksTable.setRowFactory( tv -> {
			    TableRow<Indeks> row = new TableRow<>();
			    row.setOnMouseClicked(event -> {
			        if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
			        	Indeks rowData = row.getItem();
			           
			        	selektovanIndeks = rowData;
			            
			            mainViewManager.openModal("TabAktivnostIndeksStudenta", 750, 500);
			        }
			    });
			    return row ;
			});
		 
		 indeksTable.setItems(sviIndeksi);
	 }
	 
	 public void addNoviIndeks(Indeks i) {
		 indeksTable.getItems().add(i);
	 }
	
	 public void updateTabeluSaIndeksima(Indeks i) {
		 indeksTable.getItems().remove(selektovanIndeks);
		 indeksTable.getItems().add(i);
	 }
	 
	 public void pretraziStudentePoImenuPrezimenu(ActionEvent event) {
		 List<Indeks> indeks = indeksRepo.findIndeksByNameAndLastName(ime.getText(), prezime.getText());
		 indeksTable.getItems().clear();
		 indeksTable.getItems().addAll(indeks);
	 }
	 
	 public Indeks getSelectedStudentToUpdate() {
		 Indeks i = indeksTable.getSelectionModel().getSelectedItem();
		 return i;
	 }
	 
	 public void updateStudenta(ActionEvent event) {
		 Indeks i = indeksTable.getSelectionModel().getSelectedItem();
		 System.out.println("Selektovan idensk je: " + i);
		 
		 mainViewManager.changeRoot("updateStudenta");
	 }
}
