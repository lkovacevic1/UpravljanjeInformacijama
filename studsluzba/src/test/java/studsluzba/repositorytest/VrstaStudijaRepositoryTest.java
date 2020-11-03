package studsluzba.repositorytest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import studsluzba.repositories.VrstaStudijaRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VrstaStudijaRepositoryTest {
	
	@Autowired
	VrstaStudijaRepository vrstaStudijaRepo;
	
	@Test
	public void saveVrstaStudijaTest() {
		
		
		
	}

}
