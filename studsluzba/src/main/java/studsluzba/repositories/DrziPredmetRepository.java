package studsluzba.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import studsluzba.model.DrziPredmet;
import studsluzba.model.SkolskaGodina;

public interface DrziPredmetRepository extends CrudRepository<DrziPredmet, Integer> {

	//Selektuj sve predmete u odredjenoj skolskoj godini
	@Query("select dp from DrziPredmet dp where dp.skolskaGodina like :skolskaGodina")
	List<DrziPredmet> getPredmetiPoSkolskojGodini(SkolskaGodina skolskaGodina);
}
