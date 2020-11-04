package studsluzba.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import studsluzba.model.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {
	
	/*//selekcija studenta preko id
	@Query("select s form Student s join fetch s.indeks i where i.idIndeks like :id")
	Student findStudentByID(int id);*/
	
}
