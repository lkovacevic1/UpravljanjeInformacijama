package studsluzba.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import studsluzba.model.Indeks;
import studsluzba.model.Student;
import studsluzba.model.UpisGodine;

public interface IndeksRepository extends CrudRepository<Indeks, Integer> {
/*
	///Sacuvaj stari indeks
	@Query("insert into Indeks values(:student, :godinaUpisa, :brojIndexa, :aktivan, :datumAktivacijeIndexa, :studProgram)")
	Indeks saveOldIndeks(Student student, int godinaUpisa, int brojIndexa, boolean aktivan, LocalDate datumAktivacijeIndexa, StudProgram studProgram);
	
	///Promena indeksa
	@Query("update Indeks set brojIndexa = :indeks, godinaUpisa = :godina, studProgram = :studProgram where student = :studentID")
	Indeks changeIndeks(int indeks, int godina, StudProgram studProgram, Student studentID);*/
	
	@Query("select i from Indeks i where i.student like :student")
	List<Indeks> findIndeksOfStudent(Student student);
	
	//Selekcija aktivnog indeks studenta
	@Query("select i from Indeks i where i.aktivan = 1 and i.student.idstudent like :idStudenta")
	Indeks findAktivanIndeks(int idStudenta);
	
	//Find indeks by student name or last name
	@Query("select i from Indeks i where i.student.ime like :ime or i.student.prezime like :prezime")
	List<Indeks> findIndeksByNameAndLastName(String ime, String prezime);
	
	//Finde indeks by student indeks
	@Query("select i from Indeks i where i.brojIndexa like :brIndeks and i.godinaUpisa like :godineUisa and i.studProgram.oznaka like :oznaka")
	Indeks findIndeksByID(int brIndeks, int godineUisa, String oznaka);
	
	//Find index by id
	@Query("select i from Indeks i where i.idIndeks like :id")
	List<Indeks> selectIndekxById(int id);
	
	//Sortirani indeksi, sa ukupnim brojen poena
	@Query("select i from Indeks i join i.prijavaIspita pri where pri.ispit.idIspit like :idIspita order by i.studProgram.nazivStudPrograma DESC, i.upisGodine.godinaUpisa, i.brojIndexa")
	List<Indeks> getSortedIndeks(int idIspita);
	
	//Da li vec postoji dati indeks
	@Query("select i from Indeks i where i.godinaUpisa like :godinaUpisa and i.brojIndexa like :brIndeksa and i.studProgram.oznaka like :oznaka")
	Indeks doesIndeksExist(int godinaUpisa, int brIndeksa, String oznaka);
	
	//Indeksi koji polazi na odredjenom ispitu
	@Query("select i from Indeks i join i.prijavaIspita pi where pi.ispit.idIspit like :idIspit")
	List<Indeks> findAllIndeksForIspit(int idIspit);
	
	// selekcija svih upisanih godina za id indeksa
	@Query("select i from Indeks i  where i.upisGodine.indeks.idIndeks like :id") 
	List<Indeks> selectIndexById(int id);
}
