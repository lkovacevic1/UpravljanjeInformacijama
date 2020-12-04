package studsluzba.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studsluzba.model.ObnovaGodine;
import studsluzba.model.Predmet;
import studsluzba.repositories.ObnovaGodineRepository;


@Service
public class ObnovaGodineService {

	@Autowired 
	ObnovaGodineRepository obnovaGodineRepo;
	
	public ObnovaGodine saveObnovaGodine(List<Predmet> predmeti, String datum, String napomena) {
		ObnovaGodine obnovaGodine = new ObnovaGodine();
		obnovaGodine.setPredmeti(predmeti);
		obnovaGodine.setNapomena(napomena);
		int date = Integer.parseInt(datum);
		obnovaGodine.setGodinaObnove(date);
		obnovaGodineRepo.save(obnovaGodine);
		return null;
	}
}
