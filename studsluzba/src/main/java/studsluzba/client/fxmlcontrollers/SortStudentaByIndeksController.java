package studsluzba.client.fxmlcontrollers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import studsluzba.client.MainViewManager;
import studsluzba.model.Indeks;
import studsluzba.model.StudProgram;
import studsluzba.model.Student;
import studsluzba.model.VisokoskolskaUstanova;
import studsluzba.repositories.IndeksRepository;
import studsluzba.repositories.StudentRepository;
import studsluzba.services.IndeksService;
import studsluzba.services.StudProgramService;
import studsluzba.services.StudentService;

@Component
public class SortStudentaByIndeksController {
	
	 @Autowired
	 IndeksRepository indeksRepo;
	 
	 @Autowired  
	 MainViewManager mainViewManager;
	 
	 @Autowired
	 StudProgramService studProgramService;
	 
	 @Autowired
	 IndeksService indeksService;
		
	 Indeks selektovanIndeksZaZamenu;
		
	 @FXML private TextField indeks;
	 
	 private ObservableList<Indeks> sviIndeksi;
	 
	 @FXML private TableView<Indeks> indexTable;
	 
	 @FXML private ComboBox<StudProgram> studProgramCb;
	 
	 @FXML
	 protected void initialize() {
		 sviIndeksi = FXCollections.observableList(indeksService.loadAll());
		 
		 indexTable.setRowFactory( tv -> {
			    TableRow<Indeks> row = new TableRow<>();
			    row.setOnMouseClicked(event -> {
			        if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
			        	Indeks rowData = row.getItem();
			            /*System.out.println(rowData);
			            //12
			            Student st = row.getItem();
			            System.out.println(st.getIdstudent());*/
			        	selektovanIndeksZaZamenu = rowData;
			            
			            mainViewManager.openModal("KopijaTaba", 750, 500);
			        }
			    });
			    return row ;
			});
		 
		 indexTable.setItems(sviIndeksi);
		 
		 List<StudProgram> studProgram = studProgramService.loadAll();
		 studProgramCb.setItems(FXCollections.observableArrayList(studProgram));
	 }
	 
	 public void addNoviIndeks(Indeks i) {
		 indexTable.getItems().add(i);
	 }
	 
	 public void updateTabeluSaIndeksima(Indeks i) {
		 indexTable.getItems().remove(selektovanIndeksZaZamenu);
		 indexTable.getItems().add(i);
	 }
		
	 public void pretraziStudentaPoIndeksu(ActionEvent event) {
		 String index = indeks.getText();
		 String parts[] = index.split("/");
		 StudProgram stProgramOznaka = studProgramCb.getValue();
		 String oznaka = stProgramOznaka.getOznaka();
		
		 Indeks indeks = indeksRepo.findIndeksByID(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), oznaka);
		 indexTable.getItems().clear();
		 indexTable.getItems().add(indeks);
	 }

	public TableView<Indeks> getIndexTable() {
		return indexTable;
	}

	public void setIndexTable(TableView<Indeks> indexTable) {
		this.indexTable = indexTable;
	}
	 
}
