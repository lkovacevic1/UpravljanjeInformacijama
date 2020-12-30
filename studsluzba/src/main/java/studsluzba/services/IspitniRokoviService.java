package studsluzba.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studsluzba.model.Ispit;
import studsluzba.model.IspitniRok;
import studsluzba.model.Nastavnik;
import studsluzba.model.Predmet;
import studsluzba.model.SkolskaGodina;
import studsluzba.repositories.IspitRepository;
import studsluzba.repositories.IspitniRokRepository;

@Service
public class IspitniRokoviService {
	
	@Autowired
	IspitniRokRepository ispitniRokRepo;
	
	@Autowired
	IspitRepository ispitRepo;
	
	public List<IspitniRok> loadAll(){
		
		Iterable<IspitniRok> iter = ispitniRokRepo.findAll();
		List<IspitniRok> rez = new ArrayList<IspitniRok>();
		iter.forEach(rez::add);
		
		return rez;
	}
	
	public IspitniRok saveIspitniRok(LocalDate datumPocetka, LocalDate datumZavrsetka, SkolskaGodina sk, String imeRoka) {
		
		IspitniRok ispRok = new IspitniRok();
		ispRok.setDatumPocetkaIspitnogRoka(datumPocetka);
		ispRok.setDatumZavrsetkaIspitnogRoka(datumZavrsetka);
		ispRok.setSkolskaGodina(sk);
		ispRok.setImeRoka(imeRoka);
		return ispitniRokRepo.save(ispRok);
		
	}
	
	public List<Ispit> loadAllIspiti(){
		
		Iterable<Ispit> iter = ispitRepo.findAll();
		List<Ispit> rez = new ArrayList<Ispit>();
		iter.forEach(rez::add);
		
		return rez;
	}
	
	public Ispit saveIspit(LocalDate datumOdrzavanjaIspita, int vremeOdrzavanjaIspita, boolean zakljucenIspit, Predmet p, Nastavnik n, IspitniRok i) {

        Ispit ispit = new Ispit();
        ispit.setDatumOdrzavanjaIspita(datumOdrzavanjaIspita);
        ispit.setVremeOdrzavanjaIspita(vremeOdrzavanjaIspita);
        ispit.setZakljucenIspit(zakljucenIspit);
        ispit.setPredmet(p);
        ispit.setNastavnik(n);
        ispit.setIspitniRok(i);
        return ispitRepo.save(ispit);
    }
}
