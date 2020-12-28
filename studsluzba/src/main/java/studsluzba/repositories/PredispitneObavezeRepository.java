package studsluzba.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import studsluzba.model.Nastavnik;
import studsluzba.model.PredispitneObaveze;
import studsluzba.model.Predmet;
import studsluzba.model.SkolskaGodina;

public interface PredispitneObavezeRepository extends CrudRepository<PredispitneObaveze, Integer> {

	//Lista oznaka za predispitne obaveze studenta
	@Query("select po from PredispitneObaveze po join po.osvojeniPredispitniPoeni obaveze where obaveze.indeks.idIndeks like :idIndeks")
	List<PredispitneObaveze> findVrstaObaveze(int idIndeks);
	
	//Proveravamo da li ovakva obaveza vec postoji
	@Query("select po from PredispitneObaveze po where po.nastavnik like :nastavnik and po.predmet like :predmet and po.skolskaGodina like :skolskaGodina and po.vrstaPredispitnihObaveza like :vrsta")
	PredispitneObaveze predispitnaObavezaDoesExist(String vrsta, Nastavnik nastavnik, Predmet predmet, SkolskaGodina skolskaGodina);
}
