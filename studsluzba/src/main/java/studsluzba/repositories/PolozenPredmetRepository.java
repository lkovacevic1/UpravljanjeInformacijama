package studsluzba.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import studsluzba.model.Indeks;
import studsluzba.model.Ispit;
import studsluzba.model.PolozenPredmet;

public interface PolozenPredmetRepository extends CrudRepository<PolozenPredmet, Integer> {
	
	//Prosecna ocena studenta na predemtu za odredjeni raspon godina
	@Query("select avg(pp.ocena) from PolozenPredmet pp join pp.indeks i where i.godinaUpisa >= :pocGodina and i.godinaUpisa <= :krajGodina")
	double avgOcenaURasponuGodina(int pocGodina,int krajGodina);
	
	//Prosecna ocena na ispitu
	@Query("select avg(pp.ocena) from PolozenPredmet pp join pp.ispit i where i.idIspit like :ispit")
	double avgOcenaNaIspitu(int ispit);
	
	// selekcija svih polozenih ispita za id indeksa
	@Query("select p from PolozenPredmet p join fetch p.indeks i where i.idIndeks like :id") 
	List<PolozenPredmet> findPolozenIspitByID(int id);
	
	// selekcija svih polozenih ispita za id indeksa
	@Query("select p from PolozenPredmet p where p.indeks like :indeks and p.polozen = 1") 
	List<PolozenPredmet> findPolozenIspitByIndeks(Indeks indeks);
	
	//Proverava da li je indeks polozio predmet
	@Query("select p.polozen from PolozenPredmet p where p.indeks like :indeks and p.ispit like :ispit")
	boolean isPolozen(Indeks indeks, Ispit ispit);
}
