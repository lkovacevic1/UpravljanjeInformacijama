package studsluzba.client.fxmlcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import studsluzba.client.MainViewManager;
import studsluzba.model.Nastavnik;
import studsluzba.services.NastavnikService;

@Component
public class NastavnikController {
	
	@Autowired
	NastavnikService nastavnikService;
	
	@Autowired  
	MainViewManager mainViewManager;

	@FXML private TableView<Nastavnik> aktivniNastavniciTable;
	
	private ObservableList<Nastavnik> sviNastavnici;
	
	Nastavnik selektovanNastavnik;
	
	@FXML
	protected void initialize() {
		sviNastavnici = FXCollections.observableArrayList(nastavnikService.loadAll());
		
		aktivniNastavniciTable.setRowFactory( tv -> {
		    TableRow<Nastavnik> row = new TableRow<>();
		    row.setOnMouseClicked(event -> {
		        if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
		        	Nastavnik rowData = row.getItem();
		        	selektovanNastavnik = rowData;
		            
		            mainViewManager.openModal("istorijaZvanjaNastavnika", 750, 500);
		        }
		    });
		    return row ;
		});
		
		aktivniNastavniciTable.setItems(sviNastavnici);
	}
}
