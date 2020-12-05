package studsluzba.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studsluzba.model.Indeks;
import studsluzba.model.ObnovaGodine;
import studsluzba.model.Predmet;
import studsluzba.repositories.IndeksRepository;
import studsluzba.repositories.ObnovaGodineRepository;


@Service
public class ObnovaGodineService {

	@Autowired 
	ObnovaGodineRepository obnovaGodineRepo;
	
	@Autowired
	IndeksRepository indeksRepo;
	
	public ObnovaGodine saveObnovaGodine(List<Predmet> predmeti, String datum, String napomena, Indeks indeks) {
		ObnovaGodine obnovaGodine = new ObnovaGodine();
		obnovaGodine.setPredmeti(predmeti);
		obnovaGodine.setNapomena(napomena);
		int date = Integer.parseInt(datum);
		obnovaGodine.setGodinaObnove(date);
		obnovaGodine.setIndeks(indeks);
		
		Indeks i = new Indeks();
		i.setObnovaGodine(obnovaGodine);
		indeksRepo.save(i);
		
		return obnovaGodineRepo.save(obnovaGodine);
	}
}
