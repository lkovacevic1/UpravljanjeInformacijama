package studsluzba.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studsluzba.model.Indeks;
import studsluzba.model.Predmet;
import studsluzba.model.UpisGodine;
import studsluzba.repositories.IndeksRepository;
import studsluzba.repositories.UpisGodineRepository;

@Service
public class UpisGodineService {

	@Autowired 
	UpisGodineRepository upisGodineRepo;
	
	@Autowired
	IndeksRepository indeksRepo;
	
	public UpisGodine saveUpisGodine(List<Predmet> predmeti, String datum, String napomena, Indeks indeks) {
		LocalDate today = LocalDate.now();
		UpisGodine upisGodine = new UpisGodine();
		upisGodine.setPredmeti(predmeti);
		upisGodine.setNapomena(napomena);
		int date = Integer.parseInt(datum);
		upisGodine.setGodinaUpisa(date);
		upisGodine.setDatum(today);
		upisGodine.setIndeks(indeks);
		
		upisGodineRepo.save(upisGodine);
		
		indeks.setUpisGodine(upisGodine);
		indeksRepo.save(indeks);
		
		return upisGodineRepo.save(upisGodine);
	}
}
