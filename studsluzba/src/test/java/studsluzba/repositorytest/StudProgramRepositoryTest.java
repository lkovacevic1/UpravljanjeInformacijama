package studsluzba.repositorytest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import studsluzba.model.StudProgram;
import studsluzba.model.VrstaStudija;
import studsluzba.repositories.StudProgramRepository;
import studsluzba.repositories.VrstaStudijaRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudProgramRepositoryTest {

	@Autowired
	StudProgramRepository studijskiProgramRepo;

	@Autowired
	VrstaStudijaRepository vrstaStudijaRepo;

	@Test
	public void saveStudentskiProgramTest() {

		StudProgram studprogram = new StudProgram();
		VrstaStudija vrstaStud = new VrstaStudija();

		// VrstaStudija
		vrstaStud.setPunNazivStudija("osnovne akademske studije");
		vrstaStud.setSkraceniNazivStudija("OAS");
		vrstaStudijaRepo.save(vrstaStud);

		// StudProgram
		studprogram.setBrojSemestara(8);
		studprogram.setGodinaAkreditacije(2003);
		studprogram.setNazivStudPrograma("Racunarske nauke");
		studprogram.setNazivZvanjaPoZavrsetkuStudija("inzenjer racunarskih nauka");
		studprogram.setOznaka("RN");
		studprogram.setVrstaStudija(vrstaStud);
		studijskiProgramRepo.save(studprogram);

	}

}
