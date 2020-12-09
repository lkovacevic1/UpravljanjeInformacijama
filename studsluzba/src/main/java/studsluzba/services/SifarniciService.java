package studsluzba.services;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public List<SrednjaSkola> getSrednjeSkole(){		
		Iterable<SrednjaSkola> iter = srednjeSkolaRepo.findAll();
		List<SrednjaSkola> rez = new ArrayList<SrednjaSkola>();		
		iter.forEach(rez::add);
		return rez;		
	}
	
	public SrednjaSkola saveSrednjaSkola(SrednjaSkola ss) {
		return srednjeSkolaRepo.save(ss);
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
	
	public List<Student> getStudent(){		
		Iterable<Student> iter = studRepo.findAll();
		List<Student> rez = new ArrayList<Student>();		
		iter.forEach(rez::add);
		return rez;		
	}
	
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
	
	public List<IspitniRok> getIspitniRok(){		
		Iterable<IspitniRok> iter = ispitniRokRepo.findAll();
		List<IspitniRok> rez = new ArrayList<IspitniRok>();		
		iter.forEach(rez::add);
		return rez;		
	}
	
	public List<Nastavnik> getNastavnici(){		
		Iterable<Nastavnik> iter = nastavnikRepo.findAll();
		List<Nastavnik> rez = new ArrayList<Nastavnik>();		
		iter.forEach(rez::add);
		return rez;		
	}
	
	public List<Ispit> getIspiti(){
		Iterable<Ispit> iter = ispitRepo.findAll();
		List<Ispit> rez = new ArrayList<Ispit>();		
		iter.forEach(rez::add);
		return rez;	
	}
	
	public List<StudProgram> getStProgram(){
		Iterable<StudProgram> iter = stProgramRepo.findAll();
		List<StudProgram> rez = new ArrayList<StudProgram>();		
		iter.forEach(rez::add);
		return rez;	
	}
	
	public List<PolozenPredmet> getPolozeniPredmeti(Indeks indeks){
		return polozenPredmetRepo.findPolozenIspitByIndeks(indeks);
	}
	
	public List<Indeks> getAllIndeks(){
		Iterable<Indeks> iter = indeksRepo.findAll();
		List<Indeks> rez = new ArrayList<Indeks>();		
		iter.forEach(rez::add);
		return rez;	
	}
	
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
