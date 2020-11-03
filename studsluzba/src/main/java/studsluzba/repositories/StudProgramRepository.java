package studsluzba.repositories;

import org.springframework.data.repository.CrudRepository;

import studsluzba.model.StudProgram;
import studsluzba.model.Student;

public interface StudProgramRepository extends CrudRepository<StudProgram, Integer>{

}
