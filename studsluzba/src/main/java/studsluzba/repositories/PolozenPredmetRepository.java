package studsluzba.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import studsluzba.model.PolozenPredmet;

public interface PolozenPredmetRepository extends CrudRepository<PolozenPredmet, Integer> {
	
	//Prosecna ocana studenta na predemtu za odredjeni raspon godina
	@Query("select avg(pp.ocena) from PolozenPredmet pp join pp.indeks i where i.godinaUpisa >= :pocGodina and i.godinaUpisa <= :krajGodina")
	double avgOcenaURasponuGodina(int pocGodina,int krajGodina);
	
	//Prosecna ocena na ispitu
	@Query("select avg(pp.ocena) from PolozenPredmet pp join pp.ispit i where i.idIspit like :ispit")
	double avgOcenaNaIspitu(int ispit);
}
