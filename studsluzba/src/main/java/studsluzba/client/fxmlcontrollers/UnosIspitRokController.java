package studsluzba.client.fxmlcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import studsluzba.model.IspitniRok;
import studsluzba.model.SkolskaGodina;
import studsluzba.model.StudProgram;
import studsluzba.repositories.SkolskaGodinaRepository;
import studsluzba.services.IspitniRokoviService;

@Component
public class UnosIspitRokController {
	
	@Autowired
	IspitniRokoviService ispitniRokoviService;
	
	@Autowired
	SkolskaGodinaRepository skolskaGodinaRepo;
	
	private ObservableList<IspitniRok> sviRokovi;
	
	@FXML private TableView<IspitniRok> rokoviTable;
	
	@FXML private DatePicker datumPocetkaIspitnogRoka;
	
	@FXML private DatePicker datumZavrsetkaIspitnogRoka;
	
	
	 @FXML
	 protected void initialize() {
		 sviRokovi = FXCollections.observableList(ispitniRokoviService.loadAll());
		 rokoviTable.setItems(sviRokovi);
	 }
	
	 
	 public void handleSacuvajIspitniRok(ActionEvent event) {
		 
		 SkolskaGodina skolskaGodina = skolskaGodinaRepo.findAktivnaSkGod();
		 System.out.println(skolskaGodina);
		 int sk = skolskaGodina.getIdSkolskeGodine();
		 IspitniRok rok = ispitniRokoviService.saveIspitniRok(datumPocetkaIspitnogRoka.getValue(),datumZavrsetkaIspitnogRoka.getValue(), skolskaGodina);
		 sviRokovi.add(rok);
	 }
}
