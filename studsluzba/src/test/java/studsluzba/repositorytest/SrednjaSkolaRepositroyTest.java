package studsluzba.repositorytest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import studsluzba.model.SrednjaSkola;
import studsluzba.repositories.SrednjaSkolaRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SrednjaSkolaRepositroyTest {
	
	@Autowired
	SrednjaSkolaRepository srednjaSkolaRepo;
	
	@Test
	public void saveSrednjaSkolaTest() {
		
	}
}
