package studsluzba.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import studsluzba.model.PredispitneObaveze;

public interface PredispitneObavezeRepository extends CrudRepository<PredispitneObaveze, Integer> {

	//Lista oznaka za predispitne obaveze studenta
	@Query("select po from PredispitneObaveze po join po.osvojeniPredispitniPoeni obaveze where obaveze.indeks.idIndeks like :idIndeks")
	List<PredispitneObaveze> findVrstaObaveze(int idIndeks);
}
