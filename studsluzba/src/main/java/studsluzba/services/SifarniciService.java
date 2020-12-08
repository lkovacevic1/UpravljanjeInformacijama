package studsluzba.services;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studsluzba.model.Ispit;
import studsluzba.model.IspitniRok;
import studsluzba.model.Nastavnik;
import studsluzba.model.Predmet;
import studsluzba.model.SrednjaSkola;
import studsluzba.model.StudProgram;
import studsluzba.model.Student;
import studsluzba.model.VisokoskolskaUstanova;
import studsluzba.repositories.IspitRepository;
import studsluzba.repositories.IspitniRokRepository;
import studsluzba.repositories.NastavnikRepository;
import studsluzba.repositories.PredmetRepository;
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
	StudProgramRepository stProgramRepo;
	
	@Autowired
	IspitniRokRepository ispitniRokRepo;
	
	@Autowired
	PredmetRepository predmetRepo;
	
	@Autowired
	SrednjaSkolaRepository srednjeSkolaRepo;
	
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
}
