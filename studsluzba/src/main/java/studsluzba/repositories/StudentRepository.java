package studsluzba.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import studsluzba.model.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {

	/// selekcija studenta preko indeksu
	 @Query("select s from Student s join fetch s.indeks i where i.brojIndexa like :brojIndeksa and i.godinaUpisa like :godinaUpisa and i.studProgram.oznaka like :oznaka")
	 Student findStudentByID(int brojIndeksa, int godinaUpisa, String oznaka);
	  
	  //selekcija studenta na osnovu imena 
	  @Query("select s from Student s where s.ime like :ime") 
	  List<Student> findStudentByName(String ime);
	  
	//selekcija studenta na osnovu prezimena 
	  @Query("select s from Student s where s.prezime like :prezime") 
	  List<Student> findStudentByLastName(String prezime);
	  
	//selekcija studenta na osnovu imena i prezimena 
	  @Query("select s from Student s where s.ime like :ime and s.prezime like :prezime") 
	  List<Student> findStudentByNameAndLastName(String ime, String prezime);
	  
	  //selekcija studenata iz odredjene srednje skole
	  @Query("select s from Student s where s.srSkola.nazivSrednjeSkole like :naziv")
	  List<Student> findStudentBySrednjaSkola(String naziv);
	  
	  //svi prijavljeni studenti na ispit
	  @Query("select s from Student s join s.indeks i join i.prijavaIspita pi where pi.ispit.predmet.nazivPredmeta like :nazivPredmeta")
	  List<Student> findStudentByPrijavljenIspit(String nazivPredmeta);
	  
	  //sortiran spisak po godini studPrograma, po godini upisa i broju indexa
	  @Query("select s from Student s join s.indeks i order by i.studProgram.nazivStudPrograma, i.upisGodine, i.idIndeks")
	  List<Student> sortByElements();
	  
	  //Koliko puta je student izlazio na ispit
	  @Query("select COUNT(iz) from IzlazakNaIspit iz join iz.polozenPredmet pop join pop.indeks i where i.brojIndexa like :brojIndeksa and i.godinaUpisa like :godinaUpisa and i.studProgram.oznaka like :oznaka and pop.ispit.predmet.nazivPredmeta like :predmet")                                  
	  int countBrojIzlazakaNaIspit(int brojIndeksa, int godinaUpisa, String oznaka, String predmet);
	  
}
