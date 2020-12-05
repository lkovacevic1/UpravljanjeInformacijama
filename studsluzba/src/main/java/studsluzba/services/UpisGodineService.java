package studsluzba.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studsluzba.model.Indeks;
import studsluzba.model.Predmet;
import studsluzba.model.UpisGodine;
import studsluzba.repositories.UpisGodineRepository;

@Service
public class UpisGodineService {

	@Autowired 
	UpisGodineRepository upisGodineRepo;
	
	public UpisGodine saveUpisGodine(List<Predmet> predmeti, String datum, String napomena, Indeks indeks) {
		UpisGodine upisGodine = new UpisGodine();
		upisGodine.setPredmeti(predmeti);
		upisGodine.setNapomena(napomena);
		int date = Integer.parseInt(datum);
		upisGodine.setGodinaUpisa(date);
		upisGodine.setIndeks(indeks);
		return upisGodineRepo.save(upisGodine);
	}
}