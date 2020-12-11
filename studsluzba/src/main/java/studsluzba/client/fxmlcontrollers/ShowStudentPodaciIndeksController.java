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
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import studsluzba.client.MainViewManager;
import studsluzba.model.Indeks;
import studsluzba.model.SrednjaSkola;
import studsluzba.model.StudProgram;
import studsluzba.model.Student;
import studsluzba.model.VisokoskolskaUstanova;
import studsluzba.repositories.StudProgramRepository;
import studsluzba.services.IndeksService;
import studsluzba.services.SifarniciService;
import studsluzba.services.StudentService;

@Component
public class ShowStudentPodaciIndeksController {

	@Autowired
	MainViewManager mainViewManager;
	
	@Autowired
	SifarniciService sifarniciService;
	
	@Autowired
	IndeksService indeksService;
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	StudProgramRepository studProgramRepo;
	
	@Autowired
	SortStudentaByIndeksController selektovanStudent;

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
	
	@FXML private ComboBox<String> pol;
	
	//Indeks FXML
	
	@FXML private TextField brIndeksaTf;
	
	@FXML private TextField godinaUpisaIndeksaTf;
	
	@FXML private ComboBox<StudProgram> smerCb;
	
	//istorija indeksa 
	@FXML private TableView<Indeks> indeksTable;
		
	private ObservableList<Indeks> istorijaIndeksa;
		
	@FXML
    public void initialize() {
		
		List<StudProgram> stProgram = sifarniciService.getStProgram();
		smerCb.setItems(FXCollections.observableArrayList(stProgram));
		
		List<String> polCodes = List.of("Muski", "Zenski");
		pol.setItems(FXCollections.observableArrayList(polCodes));
		
		List<String> drzavaCodes = List.of("Republika Srbija", "Crna Gora", "Hrvatska");
		drzavaRodjenjaCb.setItems(FXCollections.observableArrayList(drzavaCodes));
		drzavljanstvoCb.setItems(FXCollections.observableArrayList(drzavaCodes));
		
		List<String> mestaCodes = List.of("Beograd", "Leskovac", "Vranje");
		ObservableList<String> mestaCodesObservableList = FXCollections.observableArrayList(mestaCodes);
		mestoRodjenjaCb.setItems(mestaCodesObservableList);
		List<SrednjaSkola> srednjeSkole = sifarniciService.getSrednjeSkole();
		srednjeSkolaCb.setItems(FXCollections.observableArrayList(srednjeSkole));
		List<VisokoskolskaUstanova> vsUstanova = sifarniciService.getVisokoskolskaUstanova();
		prelazSaVisokoskolskeUstanoveCb.setItems(FXCollections.observableArrayList(vsUstanova));
		
		//Postavljanje podataka studenta
		
		Indeks indeks = selektovanStudent.getSelectedIndeksToUpdate();
		Student student = indeks.getStudent();
		
		imeTf.setText(student.getIme());
		prezimeTf.setText(student.getPrezime());
		srednjeImeTf.setText(student.getSrednjeIme());
		jmbgTf.setText(student.getJmbg());
		datumRodjenjaDp.setValue(student.getDatumRodjenja());
		emailFakultetaTf.setText(student.getEmailFakultet());
		emailPrivatniTf.setText(student.getEmailPrivatan());
		brojTelefonaTf.setText(student.getBrTelefona());
		adresaPrebivalistaTf.setText(student.getAdresaPrebivalista());
		mestoRodjenjaCb.setValue(student.getMestoRodjenja());
		drzavaRodjenjaCb.setValue(student.getDrzavaRodjenja());
		drzavljanstvoCb.setValue(student.getDrzavljanstvo());
		nacionalnostTf.setText(student.getNacionalnost());
		brojLicneKarteTf.setText(student.getBrojLicneKarte());
		licnuKartuIzdaoTf.setText(student.getIzdavacLicneKarte());
		srednjeSkolaCb.setValue(student.getSrSkola());
		prelazSaVisokoskolskeUstanoveCb.setValue(student.getVisokoskolskaUstanova());
		uspehSrednjaSkolaTf.setText(String.valueOf(student.getUspehSrednjaSkola()));
		uspehPrijemniTf.setText(String.valueOf(student.getUspehPrijemni()));
		pol.setValue(student.getPol());
		
		brIndeksaTf.setText(String.valueOf(indeks.getBrojIndexa()));
		godinaUpisaIndeksaTf.setText(String.valueOf(indeks.getGodinaUpisa()));
		smerCb.setValue(indeks.getStudProgram());
		
		//popunjena istorijaIndeksa table
		istorijaIndeksa = FXCollections.observableArrayList(indeksService.selectIstorijaIndeksa(student.getBrojLicneKarte()));
		indeksTable.setItems(istorijaIndeksa);
		
	}
	
	public void handleOpenModalSrednjeSkole(ActionEvent ae) {
		mainViewManager.openModal("addSrednjaSkolaUpdateIndeks");		
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
		mainViewManager.openModal("addVisokoskolskaUstanovaUpdateIndeks");
	}
	
	//Update studenta
	public void onActionUpdateStudenta(ActionEvent event) {
		boolean flag = false;
		Indeks indeks = selektovanStudent.getSelectedIndeksToUpdate();
		
		Indeks indeksNovi = indeks;
		
		Student student = indeks.getStudent();
		
		int brojIndeksa = Integer.parseInt(brIndeksaTf.getText());
		int godinaUpisa = Integer.parseInt(godinaUpisaIndeksaTf.getText());
		StudProgram sp = smerCb.getValue();
		
		//Proveravam da li je doslo do promene indeksa i menja indeks, tako sto stari setujem na false (ako je bio aktivan), a trenutni setujem na true (ako je potrebno)
		if(indeks.getBrojIndexa() != brojIndeksa || indeks.getGodinaUpisa() != godinaUpisa || indeks.getStudProgram() != sp) {
			Indeks proveriDaLiPostoji = indeksService.checkForIndeks(brojIndeksa, sp, godinaUpisa);
			if(proveriDaLiPostoji != null) {
				System.out.println("Indeks postoji");
				actionTarget.setText("Ovakav indeks postoji!");
				return;
			}
			
			if(indeks.isAktivan()) {
				flag = true;
				indeks = studentService.promeniAktivanIndeksNaNeaktivan(indeks);
			}
			
			if(flag == true) {
				System.out.println("Flag je: " + flag);
				studentService.saveIndeksNov(student, brojIndeksa, godinaUpisa, sp, indeksNovi.getObnovaGodine(), indeksNovi.getUpisGodine(), true);
			}
			else {
				studentService.saveIndeksNov(student, brojIndeksa, godinaUpisa, sp, indeksNovi.getObnovaGodine(), indeksNovi.getUpisGodine(), false);
			}
			istorijaIndeksa.add(indeks);
		}
		flag = false;
		
		float uspehSrSkole = Float.parseFloat(uspehSrednjaSkolaTf.getText());
		float uspehPrijemni = Float.parseFloat(uspehPrijemniTf.getText());
		
		studentService.updateStudent(student, imeTf.getText(), prezimeTf.getText(), srednjeImeTf.getText(), jmbgTf.getText(),
				datumRodjenjaDp.getValue(), emailFakultetaTf.getText(), emailPrivatniTf.getText(), brojTelefonaTf.getText(),
				adresaPrebivalistaTf.getText(), mestoRodjenjaCb.getValue(), drzavaRodjenjaCb.getValue(), drzavljanstvoCb.getValue(),
				nacionalnostTf.getText(), brojLicneKarteTf.getText(), licnuKartuIzdaoTf.getText(), srednjeSkolaCb.getValue(),
				uspehSrSkole, uspehPrijemni, prelazSaVisokoskolskeUstanoveCb.getValue(), pol.getValue());
		
		actionTarget.setText("Student je update-ovan!");
	}
}
