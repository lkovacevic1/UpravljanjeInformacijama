package studsluzba.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import studsluzba.model.PolozenPredmet;

public interface PolozenPredmetRepository extends CrudRepository<PolozenPredmet, Integer> {
	
	//Prosecna ocana studenta na predemtu za odredjeni raspon godina
	@Query("select avg(pp.ocena) from PolozenPredmet pp join pp.indeks i where i.godinaUpisa like :pocGodina")
	double avgOcenaURasponuGodina(int pocGodina);
}
