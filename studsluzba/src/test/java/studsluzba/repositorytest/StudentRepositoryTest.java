package studsluzba.repositorytest;

import java.text.ParseException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
