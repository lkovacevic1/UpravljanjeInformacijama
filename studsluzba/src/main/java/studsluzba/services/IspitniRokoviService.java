package studsluzba.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studsluzba.model.IspitniRok;
import studsluzba.model.SkolskaGodina;
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
	
	public IspitniRok saveIspitniRok(LocalDate datumPocetka, LocalDate datumZavrsetka, SkolskaGodina sk) {
		
		IspitniRok ispRok = new IspitniRok();
		ispRok.setDatumPocetkaIspitnogRoka(datumPocetka);
		ispRok.setDatumZavrsetkaIspitnogRoka(datumZavrsetka);
		ispRok.setSkolskaGodina(sk);
		return ispitniRokRepo.save(ispRok);
		
	}

}
