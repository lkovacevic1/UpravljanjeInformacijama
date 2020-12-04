package studsluzba.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import studsluzba.model.Indeks;
import studsluzba.model.StudProgram;
import studsluzba.model.Student;
import studsluzba.repositories.IndeksRepository;

@Service
public class IndeksService {

	@Autowired 
	IndeksRepository indeksRepo;
	
	public Indeks changeIndeks(Student stud, int indeks, int godina, StudProgram studProgram) {
		/*Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		
		Transaction tx = session.beginTransaction();
		
		Indeks i = new Indeks();
		i.setAktivan(true);
		i.setStudent(stud);
		i.setBrojIndexa(indeks);
		i.setGodinaUpisa(godina);
		i.setStudProgram(studProgram);
		session.update(i);
		
		tx.commit();
		session.close();*/
		
		return null;
	}	
	
	public List<Indeks> loadAll(){
		Iterable<Indeks> iter = indeksRepo.findAll();
		List<Indeks> rez = new ArrayList<Indeks>();		
		iter.forEach(rez::add);
		return rez;
	}
}
