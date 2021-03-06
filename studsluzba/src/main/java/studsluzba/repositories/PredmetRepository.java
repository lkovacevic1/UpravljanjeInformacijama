package studsluzba.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import studsluzba.model.Predmet;
import studsluzba.model.StudProgram;

public interface PredmetRepository extends CrudRepository<Predmet, Integer>{
	
	//spisak predmeta na studijskom programu
	@Query("select p from Predmet p join fetch p.studProgram sp where sp.nazivStudPrograma like :nazivStudProg")
	List<Predmet> findPredmetByStudProgram(StudProgram nazivStudProg);
	
	//spisak predmeta po oznaci(RN/RI/RM)
	@Query("select p from Predmet p join fetch p.studProgram sp where sp.oznaka like :oznaka")
	List<Predmet> findPredmetByOznaka(String oznaka);
	
	//spisak predmeta koje slusa student
	@Query("select p from Predmet p join fetch p.studProgram sp join sp.indeksi ind where ind.idIndeks like :idIndeksa")
	List<Predmet> findPredmetForIndeks(int idIndeksa);
	
	//spisak predmeta koje slusa indeks
	@Query("select p from Predmet p join p.drziPredmete dp join dp.indeksi i where i.idIndeks like :idIndeksa")
	List<Predmet> findPredmetiKojeSlusaIndeks(int idIndeksa);
	
	//Selekcija predmeta po nazivu
	@Query("select p from Predmet p where p.nazivPredmeta like :nazivPredmeta")
	Predmet selectPredmetByName(String nazivPredmeta);
}
