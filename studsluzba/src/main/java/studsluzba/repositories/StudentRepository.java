package studsluzba.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import studsluzba.model.ObnovaGodine;
import studsluzba.model.PolozenPredmet;
import studsluzba.model.Student;
import studsluzba.model.UpisGodine;

public interface StudentRepository extends CrudRepository<Student, Integer> {

	

}
