package studsluzba.client.fxmlcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import studsluzba.model.IspitniRok;
import studsluzba.model.Nastavnik;
import studsluzba.model.Zvanje;
import studsluzba.repositories.NastavnikRepository;
import studsluzba.repositories.ZvanjeRepository;
import studsluzba.services.NastavnikService;

@Component
public class ZvanjeController {

	@Autowired
	NastavnikController pretraziNastavnika;
	
	@Autowired
	NastavnikRepository nastavnikRepo;
	
	@Autowired
	NastavnikService nastavnikService;
	
	@Autowired
	ZvanjeRepository zvanjeRepo;
	
	@FXML private TableView<Nastavnik> zvanjeTable;
	
	@FXML private ComboBox<Zvanje> zvanjeCb;
	
	private ObservableList<Nastavnik> sveIstorijeZvanja;
	
	@FXML
	protected void initialize() {
		Nastavnik nastavnik = pretraziNastavnika.selektovanNastavnik;
		Zvanje zvanje = nastavnik.getZvanje();
		
		List<Zvanje> ispitniRok = zvanjeRepo.zvanjaProfesora(zvanje.getZvanje());
		zvanjeCb.setItems(FXCollections.observableArrayList(ispitniRok));
		
		sveIstorijeZvanja = FXCollections.observableArrayList(nastavnikRepo.selekcijaIstorijeZvanja(nastavnik.getEmail()));
		zvanjeTable.setItems(sveIstorijeZvanja);
	}
	
	public void handleNovoZvanje() {
		Nastavnik nastavnik = pretraziNastavnika.selektovanNastavnik;
		nastavnik = nastavnikService.setAktivanNaNeaktivan(nastavnik);
		sveIstorijeZvanja.add(nastavnik);
		System.out.println("-------------------------");
		Zvanje zvanje = zvanjeCb.getValue();
		
		TableView<Nastavnik> tbNastavnik = pretraziNastavnika.getAktivniNastavniciTable();
		
		Nastavnik noviNastavnik = nastavnikService.saveNovoZvanje(nastavnik, zvanje);
		System.out.println("-------------------------");
		//Brisem nastavnika kojeg menjam iz prve tabele
		pretraziNastavnika.removeNastavnikaZaPromenu();
		
		//Dodajem novog nastavnika u prvu tabelu, iz druge forme
		ObservableList<Nastavnik> listaNastavnika = pretraziNastavnika.getSviNastavnici();
		listaNastavnika.add(noviNastavnik);
	}
}
