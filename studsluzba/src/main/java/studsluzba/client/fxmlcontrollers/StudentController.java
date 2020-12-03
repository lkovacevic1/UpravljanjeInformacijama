package studsluzba.client.fxmlcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import studsluzba.client.MainViewManager;
import studsluzba.model.SrednjaSkola;
import studsluzba.model.Student;
import studsluzba.model.VisokoskolskaUstanova;
import studsluzba.services.SifarniciService;
import studsluzba.services.StudentService;

@Component
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@Autowired
	SifarniciService sifarniciService;
	
	
	@Autowired  
	MainViewManager mainViewManager;
	
	// forma ce se koristiti za unos novog i za azuriranje postojeceg studenta
	private Student student;
	
	@FXML private TextField imeTf;
	@FXML private TextField prezimeTf;
	@FXML private TextField srednjeImeTf;
	@FXML private TextField jmbgTf;
	@FXML private DatePicker datumRodjenjaDp;
	@FXML private Text actionTarget;
	
	@FXML private TextField emailFakultetaTf;
	
	@FXML private TextField emailPrivatniTf;
	
	
	@FXML private TextField brojTelefonaTf;
	@FXML private TextField adresaPrebivalistaTf;
	@FXML private ComboBox<String> mestoRodjenjaCb;

	@FXML private ComboBox<String> drzavaRodjenjaCb;

	@FXML private ComboBox<String> drzavljanstvoCb;

	@FXML private TextField nacionalnostTf;

	@FXML private TextField brojLicneKarteTf;

	@FXML private TextField licnuKartuIzdaoTf;
	
	// prvi upis

	@FXML private ComboBox<SrednjaSkola> srednjeSkolaCb;
	
	@FXML private ComboBox<VisokoskolskaUstanova> prelazSaVisokoskolskeUstanoveCb;

	@FXML private TextField uspehSrednjaSkolaTf;

	@FXML private TextField uspehPrijemniTf;
	
	@FXML private TextField pol;
	
	@FXML
    public void initialize() {		
		List<String> drzavaCodes = List.of("Republika Srbija", "Crna Gora", "Hrvatska");
		drzavaRodjenjaCb.setItems(FXCollections.observableArrayList(drzavaCodes));
		drzavaRodjenjaCb.setValue(new String("Repoublika Srbija"));
		drzavljanstvoCb.setItems(FXCollections.observableArrayList(drzavaCodes));
		drzavljanstvoCb.setValue(new String("Republika Srbija"));
		List<String> mestaCodes = List.of("Beograd", "Leskovac", "Vranje");
		ObservableList<String> mestaCodesObservableList = FXCollections.observableArrayList(mestaCodes);
		mestoRodjenjaCb.setItems(mestaCodesObservableList);
		List<SrednjaSkola> srednjeSkole = sifarniciService.getSrednjeSkole();
		srednjeSkolaCb.setItems(FXCollections.observableArrayList(srednjeSkole));
		List<VisokoskolskaUstanova> vsUstanova = sifarniciService.getVisokoskolskaUstanova();
		prelazSaVisokoskolskeUstanoveCb.setItems(FXCollections.observableArrayList(vsUstanova));
    }
	
	public void handleOpenModalSrednjeSkole(ActionEvent ae) {
		// TODO kreira modal window za dodavanje nove srednje skole, mozda i brisanje i promena postojeÄ‡ih ?? strani kljuÄ�
		mainViewManager.openModal("addSrednjaSkola");		
	}
	
	public void updateSrednjeSkole() {
		List<SrednjaSkola> srednjeSkole = sifarniciService.getSrednjeSkole();
		srednjeSkolaCb.setItems(FXCollections.observableArrayList(srednjeSkole));
	}
	
	public void updateVisokoskolskaUstanova() {
		List<VisokoskolskaUstanova> vsUstanove = sifarniciService.getVisokoskolskaUstanova();
		prelazSaVisokoskolskeUstanoveCb.setItems(FXCollections.observableArrayList(vsUstanove));
	}
	
	public void handleOpenModalVisokoskolskeUstanove(ActionEvent event) {
		mainViewManager.openModal("addVisokoskolskaUstanova");
	}
	
	public void handleSaveStudent(ActionEvent event) {
		Student st = studentService.saveStudent(imeTf.getText(), prezimeTf.getText(), srednjeImeTf.getText(), jmbgTf.getText(),
				datumRodjenjaDp.getValue(), emailFakultetaTf.getText(), emailPrivatniTf.getText(), brojTelefonaTf.getText(),
				adresaPrebivalistaTf.getText(), mestoRodjenjaCb.getValue(), drzavaRodjenjaCb.getValue(), drzavljanstvoCb.getValue(),
				nacionalnostTf.getText(), brojLicneKarteTf.getText(), licnuKartuIzdaoTf.getText(), srednjeSkolaCb.getValue(),
				uspehSrednjaSkolaTf.getText(), uspehPrijemniTf.getText(), prelazSaVisokoskolskeUstanoveCb.getValue(), pol.getText());
		
	}
	
}
