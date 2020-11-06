package studsluzba.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import studsluzba.model.OsvojeniPredispitniPoeni;


public interface OsvojeniPredispitniPoeniRepository extends CrudRepository<OsvojeniPredispitniPoeni, Integer> {
	
	//Selekcija ostvarenih poena na predispitnim obavezama za studenta na odredjenom predmetu u skolskoj godini
	  @Query("select opp.osvojeniPredispitniPoeni from OsvojeniPredispitniPoeni opp where opp.indeks.idIndeks like :indeks and opp.predispitneObaveze.predmet.nazivPredmeta like :predmet")
	  int selectOsvojeniPredPoeni(int indeks, String predmet);
	  
	//Selekcija ostvarenih poena na predispitnim obavezama za studenta na odredjenom predmetu u skolskoj godini
	  @Query("select opp.osvojeniPredispitniPoeni from OsvojeniPredispitniPoeni opp where opp.indeks.idIndeks like :indeks and opp.predispitneObaveze.predmet.nazivPredmeta like :predmet and opp.predispitneObaveze.skolskaGodina.skolskaGodina like :godina")
	  int selectOsvojeniPredPoeniSaGodinom(int indeks, String predmet, int godina);
}
