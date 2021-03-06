package studsluzba.client.fxmlcontrollers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
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
	 
	 @FXML private Label actionTarget;
	 
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
		 List<Indeks> indeks = new ArrayList<Indeks>();
		 String imeStudenta = ime.getText();
		 String prezimeStudenta = prezime.getText();
		 actionTarget.setText("");
		 
		 if(!imeStudenta.equals("") && prezimeStudenta.equals("")) {
			 indeks = indeksRepo.findStudentByName(imeStudenta);
			 System.out.println("Usao u if");
			 System.out.println(indeks);
			 System.out.println(indeks.size());
			 System.out.println(prezime.getText());
		 }else if(imeStudenta.equals("") && !prezimeStudenta.equals("")) {
			 indeks = indeksRepo.findStudentByLastName(prezimeStudenta);
			 System.out.println(indeks.size());
			 System.out.println(ime.getText());
		 }else if(!imeStudenta.equals("") && !prezimeStudenta.equals("")) {
			 indeks = indeksRepo.findIndeksByNameAndLastName(imeStudenta, prezimeStudenta);
			 System.out.println(indeks.size());
			 System.out.println(ime.getText() + " " + prezime.getText());
		 }else {
			 actionTarget.setText("Ime/prezime moraju biti uneti !");
		 }
		 
		 indeksTable.getItems().clear();
		 indeksTable.getItems().addAll(indeks);
		 ime.setText("");
		 prezime.setText("");
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
