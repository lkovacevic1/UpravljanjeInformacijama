package studsluzba.repositorytest;

import java.text.ParseException;
import java.time.LocalDate;

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
		
		Student s = new Student();
		Indeks i = new Indeks();
		SrednjaSkola sk = new SrednjaSkola();
		VisokoskolskaUstanova vsu = new VisokoskolskaUstanova();
		
		///Visokoskolska ustanova
		vsu.setNazivVisokoskolskeUstanove("Matematicki fakultet");
		visokoskolskaUstanovaRepo.save(vsu);
		
		///Srednja Skola
		sk.setNazivSrednjeSkole("Racunarska gimnazija");
		sk.setMestoSrednjeSkole("Knez Mihajlova 6");
		sk.setVrstaSrednjeSkole("Gimnazija");
		srednjaSkolaRepo.save(sk);
		
		///Indeks
		i.setAktivan(true);
		i.setBrojIndexa(68);
		i.setDatumAktivacijeIndexa(LocalDate.of(2018, 10, 1));
		i.setGodinaUpisa(2020);
		i.setStudent(s);
		
		///Student
		s.setAdresaPrebivalista("Beogradska 85a");
		s.setBrojLicneKarte("1423153153E0000B123");
		s.setBrTelefona("0694267412");
		s.setDatumRodjenja(LocalDate.of(1999, 07, 26));
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
		studentRepo.save(s);
		
		indeksRepo.save(i);
	}
}
