package studsluzba.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import studsluzba.model.Ispit;

public interface IspitRepository extends CrudRepository<Ispit, Integer> {
	
	
	//studenti kojima su prijavljeni na neki ispit
	@Query("select i from Ispit i")
	List<Ispit> ispitiZaPrijavu();
	
	//rezultati za ispit
	@Query("select i from Ispit i where i.zakljucenIspit = 1")
	List<Ispit> rezultatiIspita();
	
}
