package studsluzba.client.fxmlcontrollers;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import studsluzba.client.MainViewManager;
import studsluzba.client.importer.CSVPoeniImporter;

@Component
public class ImportController {
	
	@FXML Label nazivFajlaLabel;
	
	@FXML Label izvestajImportLabel;
	
	@Autowired
	MainViewManager mainViewManager;
	
	@Autowired
	CSVPoeniImporter csvPoeniImporter;
	
	private File fajl;
	
	public void izaberiFajl(ActionEvent ecent) {	
		fajl = mainViewManager.openFileChooser();
		if(fajl != null) {
			nazivFajlaLabel.setText(fajl.getName());
		}
		else
		{
			nazivFajlaLabel.setText("Odaberite fajl za import !");
		}
	}
	
	
	public void zapocniImport(ActionEvent ecent) {		
		if(fajl != null) {
			String poruka = csvPoeniImporter.importCSV(fajl);
			izvestajImportLabel.setText(poruka);
		}
		else
		{
			izvestajImportLabel.setText("Odaberite fajl za import !");
		}
	}
}

