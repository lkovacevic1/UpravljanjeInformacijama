package studsluzba.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import studsluzba.model.Nastavnik;

public interface NastavnikRepository extends CrudRepository<Nastavnik, Integer> {
	
	//Selekcija aktivnih nastavnika
	@Query("select n from Nastavnik n where n.aktivan = 1")
	List<Nastavnik> selekcijaAktivnihNastavnika();
	
	//Selekcija istorije zvanja nastavnika
	@Query("select n from Nastavnik n where n.email like :email and n.aktivan = 0")
	List<Nastavnik> selekcijaIstorijeZvanja(String email);
}
