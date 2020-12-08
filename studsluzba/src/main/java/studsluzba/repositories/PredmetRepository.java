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
	
	
}
