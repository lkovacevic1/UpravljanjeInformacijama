package studsluzba.services;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studsluzba.client.fxmlcontrollers.ShowStudentPodaciController;
import studsluzba.client.fxmlcontrollers.ShowStudentPodaciIndeksController;
import studsluzba.client.fxmlcontrollers.StudentController;
import studsluzba.model.DrziPredmet;
import studsluzba.model.Indeks;
import studsluzba.model.Ispit;
import studsluzba.model.IspitniRok;
import studsluzba.model.Nastavnik;
import studsluzba.model.PolozenPredmet;
import studsluzba.model.Predmet;
import studsluzba.model.SkolskaGodina;
import studsluzba.model.SrednjaSkola;
import studsluzba.model.StudProgram;
import studsluzba.model.Student;
import studsluzba.model.VisokoskolskaUstanova;
import studsluzba.repositories.DrziPredmetRepository;
import studsluzba.repositories.IndeksRepository;
import studsluzba.repositories.IspitRepository;
import studsluzba.repositories.IspitniRokRepository;
import studsluzba.repositories.NastavnikRepository;
import studsluzba.repositories.PolozenPredmetRepository;
import studsluzba.repositories.PredmetRepository;
import studsluzba.repositories.SkolskaGodinaRepository;
import studsluzba.repositories.SrednjaSkolaRepository;
import studsluzba.repositories.StudProgramRepository;
import studsluzba.repositories.StudentRepository;
import studsluzba.repositories.VisokoskolskaUstanovaRepository;

@Service
public class SifarniciService {

	@Autowired
	StudentRepository studRepo;
	
	@Autowired
	IspitRepository ispitRepo;
	
	@Autowired
	NastavnikRepository nastavnikRepo;
	
	@Autowired
	IndeksRepository indeksRepo;
	
	@Autowired
	StudProgramRepository stProgramRepo;
	
	@Autowired
	IspitniRokRepository ispitniRokRepo;
	
	@Autowired
	DrziPredmetRepository drziPredmetRepo;
	
	@Autowired
	PredmetRepository predmetRepo;
	
	@Autowired
	SrednjaSkolaRepository srednjeSkolaRepo;
	
	@Autowired
	PolozenPredmetRepository polozenPredmetRepo;
	
	@Autowired
	SkolskaGodinaRepository skolskaGodinaRepo;
	
	@Autowired
	VisokoskolskaUstanovaRepository vsRepo;
	
	@Autowired 
	StudentController studentController;
	
	@Autowired
	ShowStudentPodaciController showStudentPodaciController;
	
	@Autowired
	ShowStudentPodaciIndeksController showStudentPodaciIndeksController;
	
	//Srednje skole
	
	public List<SrednjaSkola> getSrednjeSkole(){		
		Iterable<SrednjaSkola> iter = srednjeSkolaRepo.findAll();
		List<SrednjaSkola> rez = new ArrayList<SrednjaSkola>();		
		iter.forEach(rez::add);
		return rez;		
	}
	
	public void updateSrednjaSk() {
		studentController.updateSrednjeSkole();
	}
	
	public void updateSrednjaKadUpdateStudentaSk() {
		showStudentPodaciController.updateSrednjeSkole();
	}
	
	public void updateSrednjaKadUpdateIndekSk() {
		showStudentPodaciIndeksController.updateSrednjeSkole();
	}
	
	public SrednjaSkola saveSrednjaSkola(SrednjaSkola ss) {
		return srednjeSkolaRepo.save(ss);
	}
	
	//Visokoskolske ustanove
	
	public void updateVisokoskUstanova() {
		studentController.updateVisokoskolskaUstanova();
	}
	
	public void updateVisokoskUstanovaUpdate() {
		showStudentPodaciController.updateVisokoskolskaUstanova();
	}
	
	public void updateVisokoskUstanovaUpdateIndeks() {
		showStudentPodaciIndeksController.updateVisokoskolskaUstanova();
	}
	
	public List<VisokoskolskaUstanova> getVisokoskolskaUstanova(){		
		Iterable<VisokoskolskaUstanova> iter = vsRepo.findAll();
		List<VisokoskolskaUstanova> rez = new ArrayList<VisokoskolskaUstanova>();		
		iter.forEach(rez::add);
		return rez;		
	}
	
	public VisokoskolskaUstanova saveVisokoskolskaUstanova(VisokoskolskaUstanova vs) {
		return vsRepo.save(vs);
	}
	
	//Student
	
	public List<Student> getStudent(){		
		Iterable<Student> iter = studRepo.findAll();
		List<Student> rez = new ArrayList<Student>();		
		iter.forEach(rez::add);
		return rez;		
	}
	
	//Predmet
	
	public List<Predmet> getPredmeti(){
		Iterable<Predmet> iter = predmetRepo.findAll();
		List<Predmet> rez = new ArrayList<Predmet>();		
		iter.forEach(rez::add);
		return rez;	
	}
	
	public List<Predmet> getPredmetiForStudent(int indeks){
		return predmetRepo.findPredmetForIndeks(indeks);
	}
	
	public List<Predmet> getPredmetiKojeSlusaStudent(int indeks){
		return predmetRepo.findPredmetiKojeSlusaIndeks(indeks);
	}
	
	public List<Predmet> getPredmeti(StudProgram stProgram){
		return predmetRepo.findPredmetByOznaka(stProgram.getOznaka());
	}
	
	//Ispitni rok
	
	public List<IspitniRok> getIspitniRok(){		
		Iterable<IspitniRok> iter = ispitniRokRepo.findAll();
		List<IspitniRok> rez = new ArrayList<IspitniRok>();		
		iter.forEach(rez::add);
		return rez;		
	}
	
	//Nastavnik
	
	public List<Nastavnik> getNastavnici(){		
		Iterable<Nastavnik> iter = nastavnikRepo.findAll();
		List<Nastavnik> rez = new ArrayList<Nastavnik>();		
		iter.forEach(rez::add);
		return rez;		
	}
	
	//Ispit
	
	public List<Ispit> getIspiti(){
		Iterable<Ispit> iter = ispitRepo.findAll();
		List<Ispit> rez = new ArrayList<Ispit>();		
		iter.forEach(rez::add);
		return rez;	
	}
	
	//StudProgram
	
	public List<StudProgram> getStProgram(){
		Iterable<StudProgram> iter = stProgramRepo.findAll();
		List<StudProgram> rez = new ArrayList<StudProgram>();		
		iter.forEach(rez::add);
		return rez;	
	}
	
	public List<StudProgram> selectAllStudProgram(String oznaka){
		return stProgramRepo.selectAllStudPrograma(oznaka);
	}
	
	//Polozen predmet
	
	public List<PolozenPredmet> getPolozeniPredmeti(Indeks indeks){
		return polozenPredmetRepo.findPolozenIspitByIndeks(indeks);
	}
	
	//Indeks
	
	public List<Indeks> getAllIndeks(){
		Iterable<Indeks> iter = indeksRepo.findAll();
		List<Indeks> rez = new ArrayList<Indeks>();		
		iter.forEach(rez::add);
		return rez;	
	}
	
	public List<Indeks> selectIndeksById(int indeks){
		return indeksRepo.selectIndekxById(indeks);
	}
	
	public Indeks findAktivanIndeks(int idStudenta) {
		return indeksRepo.findAktivanIndeks(idStudenta);
	}
	
	//Skolska godina
	
	public List<SkolskaGodina> getAllSkolskeGodine(){
		Iterable<SkolskaGodina> iter = skolskaGodinaRepo.findAll();
		List<SkolskaGodina> rez = new ArrayList<SkolskaGodina>();		
		iter.forEach(rez::add);
		return rez;	
	}
	
	public SkolskaGodina saveSkolskaGodina(int godina) {
		SkolskaGodina staraGodina = skolskaGodinaRepo.findAktivnaSkGod();
		staraGodina.setAktivna(false);
		
		SkolskaGodina sk = new SkolskaGodina();
		sk.setAktivna(true);
		sk.setSkolskaGodina(godina);
		
		skolskaGodinaRepo.save(staraGodina);
		return skolskaGodinaRepo.save(sk);
	}
	
	public SkolskaGodina getAktivnaSkolskaGodina() {
		return skolskaGodinaRepo.findAktivnaSkGod();
	}
	
	//Drzi predmet
	
	public List<DrziPredmet> getAllDrziPredmet(){
		Iterable<DrziPredmet> iter = drziPredmetRepo.findAll();
		List<DrziPredmet> rez = new ArrayList<DrziPredmet>();		
		iter.forEach(rez::add);
		return rez;	
	}
	
	public DrziPredmet saveDrziPredmet(Nastavnik nastavnik, Predmet predmet, SkolskaGodina skGodina) {
		DrziPredmet drziPredmet = new DrziPredmet();
		drziPredmet.setNastavnik(nastavnik);
		drziPredmet.setPredmet(predmet);
		drziPredmet.setSkolskaGodina(skGodina);
		return drziPredmetRepo.save(drziPredmet);
	}
	
	public DrziPredmet addSlusaPredmet(List<Indeks> indeks, DrziPredmet drziPredmet) {
		drziPredmet.setIndeksi(indeks);
		
		return drziPredmetRepo.save(drziPredmet);
	}
	
	public List<DrziPredmet> findPredmetUGodini(SkolskaGodina skolskaGodina){
		return drziPredmetRepo.getPredmetiPoSkolskojGodini(skolskaGodina);
	}
	
	
}
