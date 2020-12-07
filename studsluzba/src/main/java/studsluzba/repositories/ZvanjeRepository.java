package studsluzba.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import studsluzba.model.Zvanje;

public interface ZvanjeRepository  extends CrudRepository<Zvanje, Integer> {
	
	//Selekcija svih zvanja koje trenutni nastavnik nije
	@Query("select z from Zvanje z where z.zvanje NOT LIKE :zvanje")
	List<Zvanje> zvanjaProfesora(String zvanje);
}
