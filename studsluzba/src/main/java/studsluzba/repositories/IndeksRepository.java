package studsluzba.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import studsluzba.client.reports.IndeksNaIspituEntity;
import studsluzba.model.Indeks;
import studsluzba.model.Ispit;
import studsluzba.model.Predmet;
import studsluzba.model.StudProgram;
import studsluzba.model.Student;
import studsluzba.model.UpisGodine;

public interface IndeksRepository extends CrudRepository<Indeks, Integer> {
	
	//Selekcija indeks po studentu
	@Query("select i from Indeks i where i.student like :student")
	List<Indeks> findIndeksOfStudent(Student student);
	
	//Selekcija aktivnog indeks studenta
	@Query("select i from Indeks i where i.aktivan = 1 and i.student.idstudent like :idStudenta")
	Indeks findAktivanIndeks(int idStudenta);
	
	//Find indeks by student name or last name
	@Query("select i from Indeks i where i.student.ime like :ime and i.student.prezime like :prezime")
	List<Indeks> findIndeksByNameAndLastName(String ime, String prezime);
	
	//selekcija studenta na osnovu imena 
	@Query("select i from Indeks i where i.student.ime like :ime") 
	List<Indeks> findStudentByName(String ime);
		  
	//selekcija studenta na osnovu prezimena 
	@Query("select i from Indeks i where i.student.prezime like :prezime") 
	List<Indeks> findStudentByLastName(String prezime);
	
	//Finde indeks by student indeks
	@Query("select i from Indeks i where i.brojIndexa like :brIndeks and i.godinaUpisa like :godineUisa and i.studProgram.oznaka like :oznaka")
	Indeks findIndeksByID(int brIndeks, int godineUisa, String oznaka);
	
	//Find index by id
	@Query("select i from Indeks i where i.idIndeks like :id")
	List<Indeks> selectIndekxById(int id);
	
	//Sortirani indeksi, sa ukupnim brojen poena
	@Query("select i from Indeks i join i.prijavaIspita pri where pri.ispit.idIspit like :idIspita order by i.studProgram.oznaka DESC, i.godinaUpisa DESC, i.brojIndexa DESC")
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
	
	//selekcija svih aktivnih indeksa
	@Query("select i from Indeks i where i.aktivan = 1")
	List<Indeks> selectActiveIndeks();
	
	//selekcija svih neaktivnih indeksa za studenta
	@Query("select i from Indeks i where i.student.brojLicneKarte like :brLicne and i.aktivan = 0")
	List<Indeks> selectIstorijaIndeksa(String brLicne);
	
	
	//Da li indeks postoji
	@Query("select i from Indeks i where i.brojIndexa like :brIndeksa and i.godinaUpisa like :godinaUpisa and i.studProgram like :sp")
	Indeks checkForIndeks(int brIndeksa, int godinaUpisa, StudProgram sp);
	
	//Selekcija svih indeksa nekog studenta
	@Query("select i from Indeks i where i.studProgram.oznaka like :skraceniNazivStudPrograma and "
			+ "i.brojIndexa = :broj and i.godinaUpisa = :godinaUpisa")
	List<Indeks> getIndeksi(String skraceniNazivStudPrograma, int broj, int godinaUpisa);
	
	//Spisak svih indeksa po smeru
	@Query("select i from Indeks i where i.studProgram like :sp and i.aktivan = true")
	List<Indeks> selectStudentNaStudProgramu(StudProgram sp);
	
	//Spisak svih indeksa koji su izasli na rok
	@Query("select pp.indeks from PolozenPredmet pp where pp.ispit like :ispit order by pp.indeks.godinaUpisa desc")
	List<Indeks> selectIndeksNaIspitu(Ispit ispit);
	
	
	//Pravimo entitet za izvestaj
	@Query("select i.studProgram.oznaka, i.brojIndexa, i.godinaUpisa, i.student.ime, i.student.prezime, pp.osvojeniPoeniNaIspitu, pp.ocena from Indeks i join i.polozeniPredmeti pp where pp.ispit like :ispit and i.aktivan = true order by i.godinaUpisa desc")
	List<Object[]> getIndeksForIspit(Ispit ispit);
	
	//Selektujemo id indeksa
	@Query("select i from Indeks i where i.studProgram.oznaka like :oznaka and i.brojIndexa like :broj and i.godinaUpisa like :godina and i.aktivan = true")
	Indeks findIdIndeks(String oznaka, int broj, int godina);
}
