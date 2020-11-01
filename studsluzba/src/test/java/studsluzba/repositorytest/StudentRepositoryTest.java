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
		
		///Visokoskolska ustanova
		VisokoskolskaUstanova vsu = new VisokoskolskaUstanova();
		vsu.setNazivVisokoskolskeUstanove("Matematicki fakultet");
		visokoskolskaUstanovaRepo.save(vsu);
		
		///Srednja Skola
		SrednjaSkola sk = new SrednjaSkola();
		sk.setNazivSrednjeSkole("Racunarska gimnazija");
		sk.setMestoSrednjeSkole("Knez Mihajlova 6");
		sk.setVrstaSrednjeSkole("Gimnazija");
		srednjaSkolaRepo.save(sk);
		
		///Indeks
		Indeks i = new Indeks();
		i.setAktivan(true);
		i.setBrojIndexa(68);
		
		DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
		Date date = df.parse("01-10-2018");
		
		i.setDatumAktivacijeIndexa(date);
		i.setGodinaUpisa(2020);
		indeksRepo.save(i);
		
		
		///Student
		Student s = new Student();
		s.setAdresaPrebivalista("Beogradska 85a");
		s.setBrojLicneKarte("1423153153E0000B123");
		s.setBrTelefona("0694267412");
		
		date = df.parse("26-07-1999");
		
		s.setDatumRodjenja(date);
		s.setDrzavaRodjenja("Srbija");
		s.setDrzavljanstvo("Srpsko");
		s.setEmailFakultet("aradonjic6819rn@raf.rs");
		s.setEmailPrivatan("anastasijaradonjic@gmail.com");
		s.setIme("Anastasija");
		s.getIndeks().add(i);
		s.setIzdavacLicneKarte("PS NOVI BEOGRAD");
		s.setJmbg("1052014789134");
		s.setMestoRodjenja("Beograd");
		s.setNacionalnost("Srpkinja");
		s.setPol("z");
		s.setPrezime("Radonjic");
		s.setSrSkola(sk);
		s.setUspehPrijemni(89);
		s.setUspehSrednjaSkola(93);
		s.setVisokoskolskaUstanova(vsu);
	}
}
