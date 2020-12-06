package studsluzba.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studsluzba.model.Nastavnik;
import studsluzba.repositories.NastavnikRepository;

@Service
public class NastavnikService {

	@Autowired
	NastavnikRepository nastavnikrepo;
	
	public List<Nastavnik> loadAll(){
		Iterable<Nastavnik> iter = nastavnikrepo.findAll();
		List<Nastavnik> rez = new ArrayList<Nastavnik>();		
		iter.forEach(rez::add);
		return rez;
	}
}
