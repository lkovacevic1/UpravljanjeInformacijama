package studsluzba.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import studsluzba.model.Ispit;

public interface IspitRepository extends CrudRepository<Ispit, Integer> {

	//studenti kojima je zakljucen = false
	@Query("select i from Ispit i where i.zakljucenIspit = 0")
	List<Ispit> ispitiZaPrijavu();
	
	//rezultati za ispit
	@Query("select i from Ispit i where i.zakljucenIspit = 1")
	List<Ispit> rezultatiIspita();
	
}
