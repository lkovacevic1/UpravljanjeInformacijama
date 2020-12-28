package studsluzba.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import studsluzba.model.StudProgram;

public interface StudProgramRepository extends CrudRepository<StudProgram, Integer>{
	
	//Selekcija stud programa na kojima selektovani student nije
	@Query("select sp from StudProgram sp where sp.oznaka not like :oznaka")
	List<StudProgram> selectAllStudPrograma(String oznaka);
	
	//Selekcija studPrograma po skracenom nazivu
	@Query("select sp from StudProgram sp where sp.oznaka like :skraceniNaziv")
	StudProgram getStudProgramBySkraceniNaziv(String skraceniNaziv);
}
