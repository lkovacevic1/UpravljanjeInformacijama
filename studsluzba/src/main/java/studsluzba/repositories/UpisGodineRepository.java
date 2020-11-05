package studsluzba.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import studsluzba.model.UpisGodine;

public interface UpisGodineRepository  extends CrudRepository<UpisGodine, Integer> {
	// selekcija svih upisanih godina za id indeksa
	@Query("select u from UpisGodine u join fetch u.indeks i where i.idIndeks like :id") 
	List<UpisGodine> findUpisGodineByID(int id);
}
