package studsluzba.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import studsluzba.model.SkolskaGodina;

public interface SkolskaGodinaRepository  extends CrudRepository<SkolskaGodina, Integer> {
	
	//aktivna skolska godina
	@Query("select sk from SkolskaGodina sk where sk.aktivna = 1")
	SkolskaGodina findAktivnaSkGod();

}
