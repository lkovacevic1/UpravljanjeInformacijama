package studsluzba.repositorytest;

import java.text.ParseException;
import java.time.LocalDate;

import javax.imageio.spi.ServiceRegistry;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import studsluzba.model.Indeks;
import studsluzba.model.SrednjaSkola;
import studsluzba.model.Student;
import studsluzba.model.VisokoskolskaUstanova;
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

		
		
	}
}
