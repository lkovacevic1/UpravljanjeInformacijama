package studsluzba.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studsluzba.client.reports.IndeksNaIspituEntity;
import studsluzba.model.Indeks;
import studsluzba.model.Ispit;
import studsluzba.model.IzlazakNaIspit;
import studsluzba.model.Nastavnik;
import studsluzba.model.OsvojeniPredispitniPoeni;
import studsluzba.model.PolozenPredmet;
import studsluzba.model.PredispitneObaveze;
import studsluzba.model.Predmet;
import studsluzba.model.SkolskaGodina;
import studsluzba.model.StudProgram;
import studsluzba.model.Student;
import studsluzba.repositories.IndeksRepository;
import studsluzba.repositories.IzlazakNaIspitRepository;
import studsluzba.repositories.OsvojeniPredispitniPoeniRepository;
import studsluzba.repositories.PolozenPredmetRepository;
import studsluzba.repositories.StudProgramRepository;
import studsluzba.repositories.StudentRepository;

@Service
public class IndeksService {

	@Autowired
	IndeksRepository indeksRepo;
	
	@Autowired
	StudentRepository studentRepo;
	
	@Autowired
	StudProgramRepository studProgramRepo;
	
	@Autowired
	SifarniciService sifarniciService;
	
	@Autowired
	PolozenPredmetRepository polozenPredmetRepo;
	
	@Autowired
	OsvojeniPredispitniPoeniRepository osvojeniPredispitniPoeniRepo;
	
	public List<Indeks> selectIstorijaIndeksa(String brLicne){
		
		return indeksRepo.selectIstorijaIndeksa(brLicne);
	}
	
	public List<Indeks> loadAll(){
		Iterable<Indeks> iter = indeksRepo.findAll();
		List<Indeks> rez = new ArrayList<Indeks>();		
		iter.forEach(rez::add);
		return rez;
	}
	
	public List<Indeks> loadAllActiveIndeks(){
		return indeksRepo.selectActiveIndeks();
	}
	
	public Indeks saveIndeks(Student student, StudProgram studProgram, int brojIndeksa) {
		int year = Calendar.getInstance().get(Calendar.YEAR);
		LocalDate today = LocalDate.now();
		
		Indeks ind = null;
		ind = indeksRepo.doesIndeksExist(year, brojIndeksa, studProgram.getOznaka());
		
		if(ind != null) {
			System.out.println("-----------------------------");
			System.out.println("Ovakav indeks vec postoji!!!");
			System.out.println("-----------------------------");
			
		}else {
			Indeks indeks = new Indeks();
			
			indeks.setStudent(student);
			indeks.setGodinaUpisa(year);
			indeks.setBrojIndexa(brojIndeksa);
			indeks.setAktivan(true);
			indeks.setDatumAktivacijeIndexa(today);
			indeks.setStudProgram(studProgram);
			
			return indeksRepo.save(indeks);
		}
		
		return null;
	}
	
	public Indeks dodajOsvojenePoene(Indeks indeks, int obaveze, int ispit) {
		indeks.setOsvojeniPoeni(obaveze + ispit);
		
		
		return indeksRepo.save(indeks);
	}
	
	public Indeks updateIndeks(Student student, Indeks indeks, int brojIndeksa, int godinaUpisa, StudProgram sp) {
		indeks.setStudent(student);
		indeks.setBrojIndexa(brojIndeksa);
		indeks.setGodinaUpisa(godinaUpisa);
		indeks.setStudProgram(sp);
		return indeksRepo.save(indeks);
	}
	
	public Indeks updateIndeksNov(Student student, Indeks indeks, int brojIndeksa, int godinaUpisa, StudProgram sp, boolean aktivan) {
		indeks.setStudent(student);
		indeks.setBrojIndexa(brojIndeksa);
		indeks.setGodinaUpisa(godinaUpisa);
		indeks.setStudProgram(sp);
		indeks.setAktivan(aktivan);
		return indeksRepo.save(indeks);
	}
	
	public Indeks checkForIndeks(int brIndeksa, StudProgram studPrograma, int godina) {
		return indeksRepo.checkForIndeks(brIndeksa, godina, studPrograma);
	}
	

	public Indeks saveStudentAndIndex(String ime, String prezime, String studProgram, int broj, int godinaUpisa) {
			
		Student s = new Student(ime,prezime);
		s = studentRepo.save(s);
		StudProgram sp = studProgramRepo.getStudProgramBySkraceniNaziv(studProgram);
		Indeks si = new Indeks(broj, godinaUpisa,sp);
		si.setStudent(s);
		return indeksRepo.save(si);
		
		
	}
	
	public Indeks dodajPoene(Indeks si, float ukupnoPredispitni) {
		si.setOsvojeniPoeni(ukupnoPredispitni);
		return indeksRepo.save(si);
	}
	
	public Indeks getIndeks(String studProgram, int broj, int godinaUpisa) {
		List<Indeks> indeksi = indeksRepo.getIndeksi(studProgram, broj, godinaUpisa);
		if(indeksi.isEmpty()) return null;
		return indeksi.get(0);
	}
	
	public List<Indeks> getStudentiNaProgramu(StudProgram sp){
		return indeksRepo.selectStudentNaStudProgramu(sp);
	}
	
	public List<IndeksNaIspituEntity> selectpolozenIndeks(Ispit ispit, Nastavnik nastavnik, Predmet predmet, SkolskaGodina sk){
		
		List<Object[]> rez = indeksRepo.getIndeksForIspit(ispit);
		List<PredispitneObaveze> predispitneObaveze = sifarniciService.getPredispitneObaveze(nastavnik, predmet, sk);
		
		List<IndeksNaIspituEntity> retVal = new ArrayList<IndeksNaIspituEntity>();
		OsvojeniPredispitniPoeni osp = new OsvojeniPredispitniPoeni();
		for(Object[] obj:rez) {
			Indeks indeks = indeksRepo.findIdIndeks((String)obj[0], Integer.parseInt(obj[1].toString()), Integer.parseInt(obj[2].toString()));
			float predispitniPoeni = 0;
			
			for (PredispitneObaveze po : predispitneObaveze) {
				if(sifarniciService.getPredispitniPoeni(po, indeks) != null) {
					osp = sifarniciService.getPredispitniPoeni(po, indeks);
					predispitniPoeni += osp.getOsvojeniPredispitniPoeni();
				}
			}
			
			String indeksStudenta = (String)obj[0] + " " + obj[1].toString() + "/" + obj[2].toString();
			String punoIme = (String)obj[3] + " " + (String)obj[4];
			float poeni = Float.parseFloat(obj[5].toString());
			int ocena = Integer.parseInt(obj[6].toString());
			float ukupnoPoeni = predispitniPoeni + poeni;
			
			String ponistio = "";
			if(ocena == 5) {
				ponistio = "Pao";
			}
			else if(!sifarniciService.isPolozenPredmet(indeks, ispit) && ocena > 5) {
				ponistio = "Ponisten";
			}
			
 			IndeksNaIspituEntity sp = 
					new IndeksNaIspituEntity(indeksStudenta, punoIme, ukupnoPoeni, ocena, ponistio);
			retVal.add(sp);
		}
		return retVal;
	}
}
