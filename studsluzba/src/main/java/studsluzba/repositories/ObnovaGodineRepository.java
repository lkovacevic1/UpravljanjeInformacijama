package studsluzba.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import studsluzba.model.ObnovaGodine;

public interface ObnovaGodineRepository extends CrudRepository<ObnovaGodine, Integer> {
	// selekcija svih obnovljenih godina za id indeksa
	@Query("select o from ObnovaGodine o join fetch  o.indeks i where i.idIndeks like :id") 
	List<ObnovaGodine> findObnovaGodineByID(int id);
}
