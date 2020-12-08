package studsluzba.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studsluzba.model.Nastavnik;
import studsluzba.model.Zvanje;
import studsluzba.repositories.NastavnikRepository;

@Service
public class NastavnikService {

	@Autowired
	NastavnikRepository nastavnikRepo;
	
	public List<Nastavnik> loadAll(){
		Iterable<Nastavnik> iter = nastavnikRepo.findAll();
		List<Nastavnik> rez = new ArrayList<Nastavnik>();		
		iter.forEach(rez::add);
		return rez;
	}
	
	public Nastavnik setAktivanNaNeaktivan(Nastavnik nastavnik) {
		nastavnik.setAktivan(false);
		
		return nastavnikRepo.save(nastavnik);
	}
	
	public Nastavnik saveNovoZvanje(Nastavnik nastavnik, Zvanje zvanje) {
		Nastavnik ns = new Nastavnik();
		ns.setIme(nastavnik.getIme());
		ns.setPrezime(nastavnik.getPrezime());
		ns.setSrednjeIme(nastavnik.getSrednjeIme());
		ns.setEmail(nastavnik.getEmail());
		ns.setZavrsenaVisokoskolskaUstanova(nastavnik.getZavrsenaVisokoskolskaUstanova());
		ns.setZvanje(zvanje);
		ns.setAktivan(true);
		
		return nastavnikRepo.save(ns);
	}
}
