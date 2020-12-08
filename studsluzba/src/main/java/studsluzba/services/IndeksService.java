package studsluzba.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studsluzba.model.Indeks;
import studsluzba.repositories.IndeksRepository;

@Service
public class IndeksService {

	@Autowired
	IndeksRepository indeksRepo;
	
	public List<Indeks> loadAll(){
		Iterable<Indeks> iter = indeksRepo.findAll();
		List<Indeks> rez = new ArrayList<Indeks>();		
		iter.forEach(rez::add);
		return rez;
	}
}
