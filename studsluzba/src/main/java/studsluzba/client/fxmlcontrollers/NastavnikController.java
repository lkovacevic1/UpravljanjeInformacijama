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
import studsluzba.repositories.NastavnikRepository;
import studsluzba.services.NastavnikService;

@Component
public class NastavnikController {
	
	@Autowired
	NastavnikService nastavnikService;
	
	@Autowired
	NastavnikRepository nastavnikRepo;
	
	@Autowired  
	MainViewManager mainViewManager;

	@FXML private TableView<Nastavnik> aktivniNastavniciTable;
	
	private ObservableList<Nastavnik> sviNastavnici;
	
	Nastavnik selektovanNastavnik;
	
	@FXML
	protected void initialize() {
		
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
		
		refreshNastavnici();
	}
	
	public void refreshNastavnici() {
		sviNastavnici = FXCollections.observableArrayList(nastavnikRepo.selekcijaAktivnihNastavnika());
		aktivniNastavniciTable.setItems(sviNastavnici);
	}
	
	public void removeNastavnikaZaPromenu() {
		aktivniNastavniciTable.getItems().remove(selektovanNastavnik);
	}

	public TableView<Nastavnik> getAktivniNastavniciTable() {
		return aktivniNastavniciTable;
	}

	public void setAktivniNastavniciTable(TableView<Nastavnik> aktivniNastavniciTable) {
		this.aktivniNastavniciTable = aktivniNastavniciTable;
	}

	public ObservableList<Nastavnik> getSviNastavnici() {
		return sviNastavnici;
	}

	public void setSviNastavnici(ObservableList<Nastavnik> sviNastavnici) {
		this.sviNastavnici = sviNastavnici;
	}
}
