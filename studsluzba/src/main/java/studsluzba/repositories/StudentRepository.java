package studsluzba.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import studsluzba.model.ObnovaGodine;
import studsluzba.model.PolozenPredmet;
import studsluzba.model.SrednjaSkola;
import studsluzba.model.Student;
import studsluzba.model.UpisGodine;

public interface StudentRepository extends CrudRepository<Student, Integer> {

	/// selekcija studenta preko id
	 @Query("select s from Student s join fetch s.indeks i where i.idIndeks like :id")
	 Student findStudentByID(int id);

	
	 // selekcija svih polozenih ispita za id indeksa
	 @Query("select p from PolozenPredmet p join fetch p.indeks i where i.idIndeks like :id") 
	 List<PolozenPredmet> findPolozenIspitByID(int id);
	 
	 // selekcija svih upisanih godina za id indeksa
	 @Query("select u from UpisGodine u join fetch u.indeks i where i.idIndeks like :id") 
	 List<UpisGodine> findUpisGodineByID(int id);
	  
	  // selekcija svih obnovljenih godina za id indeksa
	  @Query("select o from ObnovaGodine o join fetch  o.indeks i where i.idIndeks like :id") 
	  List<ObnovaGodine> findObnovaGodineByID(int id);
	  
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
	  @Query("select s from Student s join fetch s.srSkola sk where sk.nazivSrednjeSkole like :naziv")
	  List<Student> findStudentBySrednjaSkola(String naziv);
	  
	  
}
