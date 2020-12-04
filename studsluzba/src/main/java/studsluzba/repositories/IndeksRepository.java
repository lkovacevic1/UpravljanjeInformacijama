package studsluzba.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import studsluzba.model.Indeks;
import studsluzba.model.Student;

public interface IndeksRepository extends CrudRepository<Indeks, Integer> {
/*
	///Sacuvaj stari indeks
	@Query("insert into Indeks values(:student, :godinaUpisa, :brojIndexa, :aktivan, :datumAktivacijeIndexa, :studProgram)")
	Indeks saveOldIndeks(Student student, int godinaUpisa, int brojIndexa, boolean aktivan, LocalDate datumAktivacijeIndexa, StudProgram studProgram);
	
	///Promena indeksa
	@Query("update Indeks set brojIndexa = :indeks, godinaUpisa = :godina, studProgram = :studProgram where student = :studentID")
	Indeks changeIndeks(int indeks, int godina, StudProgram studProgram, Student studentID);*/
	
	@Query("select i form Indeks i where i.student like :student")
	List<Indeks> findIndeksOfStudent(Student student);
}
