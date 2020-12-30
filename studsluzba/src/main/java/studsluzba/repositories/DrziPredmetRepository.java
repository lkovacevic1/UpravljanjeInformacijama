package studsluzba.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import studsluzba.model.DrziPredmet;
import studsluzba.model.Nastavnik;
import studsluzba.model.Predmet;
import studsluzba.model.SkolskaGodina;

public interface DrziPredmetRepository extends CrudRepository<DrziPredmet, Integer> {

	//Selektuj sve predmete u odredjenoj skolskoj godini
	@Query("select dp from DrziPredmet dp where dp.skolskaGodina like :skolskaGodina")
	List<DrziPredmet> getPredmetiPoSkolskojGodini(SkolskaGodina skolskaGodina);
	
	//Selekcija nastavnika za odredjeni predmet u odredjenoj skolskoj godini
	@Query("select dp from DrziPredmet dp where dp.predmet like :predmet and dp.skolskaGodina like :skGodine")
	DrziPredmet selectNastavnik(Predmet predmet, SkolskaGodina skGodine);
	
	//Selekcija nastavnika za odredjeni predmet i ispitni rok
	@Query("select dp.nastavnik from DrziPredmet dp where dp.skolskaGodina like :sk and dp.predmet like :predmet")
	Nastavnik findNastavnikForPredmet(SkolskaGodina sk, Predmet predmet);
}
