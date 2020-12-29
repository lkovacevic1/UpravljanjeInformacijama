package studsluzba.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studsluzba.model.Indeks;
import studsluzba.model.ObnovaGodine;
import studsluzba.model.Predmet;
import studsluzba.model.UpisGodine;
import studsluzba.repositories.IndeksRepository;
import studsluzba.repositories.ObnovaGodineRepository;


@Service
public class ObnovaGodineService {

	@Autowired 
	ObnovaGodineRepository obnovaGodineRepo;
	
	@Autowired
	IndeksRepository indeksRepo;
	
	public ObnovaGodine saveObnovaGodine(List<Predmet> predmeti, String datum, String napomena, Indeks indeks) {
		LocalDate today = LocalDate.now();
		ObnovaGodine obnovaGodine = new ObnovaGodine();
		obnovaGodine.setPredmeti(predmeti);
		obnovaGodine.setNapomena(napomena);
		int date = Integer.parseInt(datum);
		obnovaGodine.setGodinaObnove(date);
		obnovaGodine.setDatum(today);
		obnovaGodine.setIndeks(indeks);
		obnovaGodineRepo.save(obnovaGodine);
		
		indeks.setObnovaGodine(obnovaGodine);
		indeksRepo.save(indeks);
		
		return obnovaGodineRepo.save(obnovaGodine);
	}
	
	public List<ObnovaGodine> findAllObnoveForIndeks(Indeks indeks){
		int id = indeks.getIdIndeks();
		return obnovaGodineRepo.findObnovaGodineByID(id);
	}
}
