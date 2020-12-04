package studsluzba.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studsluzba.model.IspitniRok;
import studsluzba.repositories.IspitniRokRepository;

@Service
public class IspitniRokoviService {
	
	@Autowired
	IspitniRokRepository ispitniRokRepo;
	
	public List<IspitniRok> loadAll(){
		
		Iterable<IspitniRok> iter = ispitniRokRepo.findAll();
		List<IspitniRok> rez = new ArrayList<IspitniRok>();
		iter.forEach(rez::add);
		
		return rez;
	}

}
