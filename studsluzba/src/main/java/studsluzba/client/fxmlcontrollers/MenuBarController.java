package studsluzba.client.fxmlcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;
import studsluzba.client.MainViewManager;

@Component
public class MenuBarController { 
	
	 
	@Autowired
	MainViewManager mainViewManager;
	
		
	@FXML
	private MenuBar menuBar;
	
	
	public void openStudProgrami(ActionEvent event) {
		mainViewManager.changeRoot("studProgrami");
	}
	
	
	public void openNewStudent(ActionEvent event) {
		mainViewManager.changeRoot("newStudent");
	}
	
	public void openSortirajStudentaPoIneksu(ActionEvent event) {
		mainViewManager.changeRoot("sortStudentiPoIndeksu");
	}

	public void openPretraziStudentaPoImenuPrezimenu(ActionEvent event) {
		mainViewManager.changeRoot("pretraziStudentePoImenuPrezimenu");
	}
	
	public void unosIspitaRoka(ActionEvent event) {
		mainViewManager.changeRoot("UnosIspitaRoka");
	}
	
	public void openStudentiPoIspitu(ActionEvent event) {
		mainViewManager.changeRoot("newStudentiPoIspitu");
	}
	
	public void openRezultatiIspita(ActionEvent event) {
		mainViewManager.changeRoot("RezultatiIspita");
	}
	
	public void openPrijavaIspita(ActionEvent event) {
		mainViewManager.changeRoot("prijavaIspita");
	}
	
	public void spisakNastavnika(ActionEvent event) {
		mainViewManager.changeRoot("aktivniNastavnici");
	}
	
	public void predmetiNaProgramu(ActionEvent event) {
		mainViewManager.changeRoot("predmetiNaProgramu");
	}
	
	public void openNewAktivnaSkolskaGodina(ActionEvent event) {
		mainViewManager.changeRoot("addNewAktivnaGodina");
	}
	
	public void openSortBySkolskaGodina(ActionEvent event) {
		mainViewManager.changeRoot("sortBySkolskaGodina");
	}
}