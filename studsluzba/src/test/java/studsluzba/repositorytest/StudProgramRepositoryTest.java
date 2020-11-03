package studsluzba.repositorytest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import studsluzba.repositories.StudProgramRepository;
import studsluzba.repositories.VisokoskolskaUstanovaRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudProgramRepositoryTest {

	@Autowired
	StudProgramRepository studijskiProgramRepo;

	@Test
	public void saveStudentskiProgramTest() {

	}

}
