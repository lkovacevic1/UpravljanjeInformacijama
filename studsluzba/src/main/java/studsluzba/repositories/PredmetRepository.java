package studsluzba.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import studsluzba.model.Predmet;

public interface PredmetRepository extends CrudRepository<Predmet, Integer>{

	//spisak oredmeta na studijskom programu
	@Query("select p from Predmet p join fetch p.studProgram sp where sp.nazivStudPrograma like :nazivStudProg")
	List<Predmet> findPredmetByStudProgram(String nazivStudProg);
}
