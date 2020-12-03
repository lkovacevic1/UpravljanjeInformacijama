package studsluzba.services;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studsluzba.model.SrednjaSkola;
import studsluzba.model.VisokoskolskaUstanova;
import studsluzba.repositories.SrednjaSkolaRepository;
import studsluzba.repositories.VisokoskolskaUstanovaRepository;

@Service
public class SifarniciService {

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
	
	
}
