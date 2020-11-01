package studsluzba.repositorytest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import studsluzba.model.Indeks;
import studsluzba.repositories.IndeksRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IndeksRepositoryTest {
	
	@Autowired
	IndeksRepository indeksRepo;
	
	@Test
	public void saveIndeksTest() throws ParseException {
		
	}

}
