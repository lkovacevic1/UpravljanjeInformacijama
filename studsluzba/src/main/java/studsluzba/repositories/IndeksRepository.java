package studsluzba.repositories;

import org.springframework.data.repository.CrudRepository;

import studsluzba.model.Indeks;
import studsluzba.model.Student;

public interface IndeksRepository extends CrudRepository<Indeks, Integer> {

}
