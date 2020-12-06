package studsluzba.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studsluzba.model.Indeks;
import studsluzba.model.Ispit;
import studsluzba.model.PrijavaIspita;
import studsluzba.repositories.PrijavaIspitaRepository;

@Service
public class PrijavaIspitaService {
	
	@Autowired
	PrijavaIspitaRepository prijavaIspitaRepo;
	
	public PrijavaIspita savePrijavaIspita(Ispit ispit, Indeks indeks) {
		
		LocalDate today = LocalDate.now();
		PrijavaIspita prIspita = new PrijavaIspita();
		prIspita.setDatumPrijaveIspita(today);
		prIspita.setIndeks(indeks);
		prIspita.setIspit(ispit);
		return prijavaIspitaRepo.save(prIspita);
	}

}
