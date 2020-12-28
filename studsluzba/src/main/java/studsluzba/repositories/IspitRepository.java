package studsluzba.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import studsluzba.model.Ispit;
import studsluzba.model.IspitniRok;
import studsluzba.model.Nastavnik;
import studsluzba.model.Predmet;

public interface IspitRepository extends CrudRepository<Ispit, Integer> {
	
	
	//studenti kojima su prijavljeni na neki ispit
	@Query("select i from Ispit i")
	List<Ispit> ispitiZaPrijavu();
	
	//rezultati za ispit
	@Query("select i from Ispit i where i.zakljucenIspit = 1")
	List<Ispit> rezultatiIspita();

	//Proveravamo da li ispit vec postoji
	@Query("select i from Ispit i where i.ispitniRok like :ispitniRok and i.nastavnik like :nastavnik and i.predmet like :predmet and i.imeRoka like :imeRoka")
	Ispit doesIspitExist(IspitniRok ispitniRok, Nastavnik nastavnik, Predmet predmet, String imeRoka);
}
