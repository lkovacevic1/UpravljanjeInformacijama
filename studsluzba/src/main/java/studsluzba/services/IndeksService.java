package studsluzba.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studsluzba.model.Indeks;
import studsluzba.model.OsvojeniPredispitniPoeni;
import studsluzba.model.PolozenPredmet;
import studsluzba.model.StudProgram;
import studsluzba.model.Student;
import studsluzba.repositories.IndeksRepository;
import studsluzba.repositories.OsvojeniPredispitniPoeniRepository;
import studsluzba.repositories.PolozenPredmetRepository;

@Service
public class IndeksService {

	@Autowired
	IndeksRepository indeksRepo;
	
	@Autowired
	PolozenPredmetRepository polozenPredmetRepo;
	
	@Autowired
	OsvojeniPredispitniPoeniRepository osvojeniPredispitniPoeniRepo;
	
	public List<Indeks> loadAll(){
		Iterable<Indeks> iter = indeksRepo.findAll();
		List<Indeks> rez = new ArrayList<Indeks>();		
		iter.forEach(rez::add);
		return rez;
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
	
	public OsvojeniPredispitniPoeni dodajePredispitnePoene(OsvojeniPredispitniPoeni opp, int poeni) {
		opp.setOsvojeniPredispitniPoeni(poeni);
		
		return osvojeniPredispitniPoeniRepo.save(opp);
	}
	
	public PolozenPredmet dodajePoeneNaIspitu(PolozenPredmet pp, int poeni, int obaveze) {
		pp.setOsvojeniPoeniNaIspitu(poeni);
		if(poeni + obaveze < 50)
			pp.setOcena(5);
		else if(51 <= poeni + obaveze && poeni + obaveze < 61)
			pp.setOcena(6);
		else if(61 <= poeni + obaveze && poeni + obaveze < 71)
			pp.setOcena(7);
		else if(71 <= poeni + obaveze && poeni + obaveze < 81)
			pp.setOcena(8);
		else if(81 <= poeni + obaveze && poeni + obaveze < 91)
			pp.setOcena(9);
		else
			pp.setOcena(10);
		
		return polozenPredmetRepo.save(pp);
	}
}
