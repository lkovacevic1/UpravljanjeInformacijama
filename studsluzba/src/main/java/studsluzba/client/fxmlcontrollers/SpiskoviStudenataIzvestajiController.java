package studsluzba.client.fxmlcontrollers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import studsluzba.client.reports.IndeksNaIspituEntity;
import studsluzba.client.reports.ReportsManager;
import studsluzba.model.Indeks;
import studsluzba.model.Ispit;
import studsluzba.model.IspitniRok;
import studsluzba.model.Nastavnik;
import studsluzba.model.Predmet;
import studsluzba.model.SkolskaGodina;
import studsluzba.model.StudProgram;
import studsluzba.model.Student;
import studsluzba.services.IndeksService;
import studsluzba.services.IspitniRokoviService;
import studsluzba.services.SifarniciService;
import studsluzba.services.StudProgramService;

@Component
public class SpiskoviStudenataIzvestajiController {

	@Autowired
	ReportsManager reportsManager;
	
	
	@FXML ComboBox<Predmet> predmetCb;
	
	@FXML ComboBox<IspitniRok> rokCb;
	
	@Autowired
	SifarniciService sifarniciService;
	
	@Autowired
	IspitniRokoviService ispitniRokService;
	
	@Autowired
	IndeksService indeksService;
	
	@FXML
    public void initialize() {	
		predmetCb.setItems(FXCollections.observableArrayList(sifarniciService.loadAllPredmeti()));
		rokCb.setItems(FXCollections.observableArrayList(ispitniRokService.loadAll()));
	}
	
	public void handleGenerisiSpisakPoStudProgramu(ActionEvent ecent) {	
		IspitniRok isRok = rokCb.getValue();
		Predmet predmet = predmetCb.getValue();
		SkolskaGodina sk = sifarniciService.selectSkolskaGodinaForIspitRok(isRok.getIdIspitnogRoka());
		Nastavnik nastavnik = sifarniciService.selectNastavnik(sk, predmet);
		
		Ispit ispit = sifarniciService.selectIspitByRokAndPredmet(isRok, predmet);
		
		StringBuilder imePrezime = new StringBuilder();
		imePrezime.append(nastavnik.getIme());
		imePrezime.append(" ");
		imePrezime.append(nastavnik.getPrezime());
		System.out.println("Ime nastavnika je: " + imePrezime);
		
		List<IndeksNaIspituEntity> indeksi = indeksService.selectpolozenIndeks(ispit, nastavnik, predmet, sk);	//(Data source) Pravimo glavne podatke koji nam se pojavljuju u glavnoj tabeli izvestaja
		Map<String,Object> params = new HashMap<String, Object>(); //Map<NazivParametra (isto kao parametar u jasperu), VrednostParametra>
		params.put("predmet", predmetCb.getValue().getNazivPredmeta());//Ubacujemo parametre
		params.put("sifraPredmeta", predmetCb.getValue().getSifra());
		params.put("imePrezimeProfesora", imePrezime.toString());
		params.put("imeRoka", isRok.getImeRoka());
		reportsManager.openReport(indeksi, params, "IzvestajIspita");
	}

}
