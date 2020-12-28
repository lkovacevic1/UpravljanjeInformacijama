package studsluzba.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import studsluzba.model.IspitniRok;
import studsluzba.model.SkolskaGodina;

public interface IspitniRokRepository extends CrudRepository<IspitniRok, Integer> {

	//Proveravamo da li ispitni rok vec postoji
	@Query("select rok from IspitniRok rok where rok.imeRoka like :imeRoka and rok.skolskaGodina like :skGodina")
	IspitniRok rokDoesExist(String imeRoka, SkolskaGodina skGodina);
}
