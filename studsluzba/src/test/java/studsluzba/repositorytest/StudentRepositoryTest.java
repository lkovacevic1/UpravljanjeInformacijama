package studsluzba.repositorytest;

import java.text.ParseException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import studsluzba.model.Indeks;
import studsluzba.repositories.IndeksRepository;
import studsluzba.repositories.SrednjaSkolaRepository;
import studsluzba.repositories.StudentRepository;
import studsluzba.repositories.VisokoskolskaUstanovaRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentRepositoryTest {

	@Autowired
	VisokoskolskaUstanovaRepository visokoskolskaUstanovaRepo;

	@Autowired
	SrednjaSkolaRepository srednjaSkolaRepo;

	@Autowired
	StudentRepository studentRepo;

	@Autowired
	IndeksRepository indeksRepo;

	@Test
	public void saveStudentTest() throws ParseException {
		
		/*Indeks i = new Indeks();
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("upinf");
		EntityManager em = emf.createEntityManager();
		
		try {
			em.getTransaction().begin();
			
			i = em.find(Indeks.class, 1);
			System.out.println(i.getBrojIndexa());
			i.setAktivan(false);
			
			em.persist(i);
			
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
		}*/
	}
}
