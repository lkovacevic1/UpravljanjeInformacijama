package studsluzba.repositorytest;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import studsluzba.model.DrziPredmet;
import studsluzba.model.Indeks;
import studsluzba.model.Ispit;
import studsluzba.model.IspitniRok;
import studsluzba.model.IstorijaZvanja;
import studsluzba.model.IzlazakNaIspit;
import studsluzba.model.Nastavnik;
import studsluzba.model.ObnovaGodine;
import studsluzba.model.OsvojeniPredispitniPoeni;
import studsluzba.model.PolozenPredmet;
import studsluzba.model.PredispitneObaveze;
import studsluzba.model.Predmet;
import studsluzba.model.PrijavaIspita;
import studsluzba.model.SkolskaGodina;
import studsluzba.model.SrednjaSkola;
import studsluzba.model.StudProgram;
import studsluzba.model.Student;
import studsluzba.model.UpisGodine;
import studsluzba.model.VisokoskolskaUstanova;
import studsluzba.model.VrstaStudija;
import studsluzba.model.Zvanje;
import studsluzba.repositories.AktivnostStudentaRepository;
import studsluzba.repositories.DrziPredmetRepository;
import studsluzba.repositories.IndeksRepository;
import studsluzba.repositories.IspitRepository;
import studsluzba.repositories.IspitniRokRepository;
import studsluzba.repositories.IstorijaZvanjaRepository;
import studsluzba.repositories.IzlazakNaIspitRepository;
import studsluzba.repositories.NastavnikRepository;
import studsluzba.repositories.ObnovaGodineRepository;
import studsluzba.repositories.OsvojeniPredispitniPoeniRepository;
import studsluzba.repositories.PolozenPredmetRepository;
import studsluzba.repositories.PredispitneObavezeRepository;
import studsluzba.repositories.PredmetRepository;
import studsluzba.repositories.PrijavaIspitaRepository;
import studsluzba.repositories.SkolskaGodinaRepository;
import studsluzba.repositories.SrednjaSkolaRepository;
import studsluzba.repositories.StudProgramRepository;
import studsluzba.repositories.StudentRepository;
import studsluzba.repositories.UpisGodineRepository;
import studsluzba.repositories.VisokoskolskaUstanovaRepository;
import studsluzba.repositories.VrstaStudijaRepository;
import studsluzba.repositories.ZvanjeRepository;

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

	@Autowired
	AktivnostStudentaRepository aktivnostiStudRepo;

	@Autowired
	DrziPredmetRepository drziPredmetRepo;

	@Autowired
	IspitniRokRepository ispitniRokRepo;

	@Autowired
	IspitRepository ispitRepo;

	@Autowired
	IstorijaZvanjaRepository istorijaZvanjaRepo;

	@Autowired
	IzlazakNaIspitRepository izlazakNaIspitRepo;

	@Autowired
	NastavnikRepository nastavnikRepo;

	@Autowired
	ObnovaGodineRepository obnovaGodineRepo;

	@Autowired
	OsvojeniPredispitniPoeniRepository osvojeniPredispitniPoeniRepo;

	@Autowired
	PolozenPredmetRepository polozeniPredmetRepo;

	@Autowired
	PredispitneObavezeRepository predispitneObavezeRepo;

	@Autowired
	PredmetRepository predmetRepository;

	@Autowired
	PrijavaIspitaRepository prijavaIspitaRepository;

	@Autowired
	StudProgramRepository studProgramRepository;

	@Autowired
	UpisGodineRepository upisGodineRepository;

	@Autowired
	VrstaStudijaRepository vrsteStudijaRepository;

	@Autowired
	ZvanjeRepository zvanjeRepository;

	@Autowired
	SkolskaGodinaRepository skolskaGodinaRepository;

	@Test
	public void saveStudentTest() throws ParseException {
		
		
		////////////////////////////Studijski program i predmet////////////////////////////
		
		
		//Selekcija predmeta na studProgramu
		/*List<Predmet> predmeti = predmetRepository.findPredmetByStudProgram("Racunarske nauke");
		for(Predmet p : predmeti)
			System.out.println(p.toString());*/
		
		////////////////////////////Student////////////////////////////
		
		
		//selekcija studenta sa odredjenom srednjom skolom
		/*List<Student> studenti = studentRepo.findStudentBySrednjaSkola("Racunarska gimnazija");
		for(Student s : studenti)
			System.out.println(s.toString());*/
		
		//selekcija studenta na osnovu imena
		/*List<Student> studenti = studentRepo.findStudentByName("Anastasija");
		for(Student stud : studenti)
			System.out.println(stud.toString());*/
		
		//selekcija studenta na osnovu prezimena
		/*List<Student> studenti1 = studentRepo.findStudentByLastName("Radonjic");
		for (Student stud : studenti1)
			System.out.println(stud.toString());*/
		
		// selekcija studenta na osnovu prezimena
		/*List<Student> studenti2 = studentRepo.findStudentByNameAndLastName("Anastasija", "Radonjic");
		for (Student stud : studenti2)
			System.out.println(stud.toString());*/
		
		//selekcija obnove godine za id indeksa
		/*List<ObnovaGodine> obnovaGodine = studentRepo.findObnovaGodineByID(1);
			for(ObnovaGodine og : obnovaGodine)
				System.out.println(og.toString());*/
		
		//selekcija upisanihGodina za id indeksa
		/*List<UpisGodine> upisGodine = studentRepo.findUpisGodineByID(1);
		for(UpisGodine up : upisGodine)
			System.out.println(up.toString());*/
		
		
		
		//selekcija polozenihPredmeta po id-u
		/*List<PolozenPredmet> polozeniPredmeti = studentRepo.findPolozenIspitByID(1);
		for(PolozenPredmet pp : polozeniPredmeti)
			System.out.println(pp.toString());*/
		
		//selektovanje studenta po id-u
		/*Student student = studentRepo.findStudentByID(1);
		System.out.println(student.toString());*/
		
		
		//////////////////////////////////////////////////////////////////////////
		
		
		/*SrednjaSkola sk = new SrednjaSkola();
		sk.setNazivSrednjeSkole("Matematicka gimnazija");
		sk.setMestoSrednjeSkole("Kraljice Natalije 37");
		sk.setVrstaSrednjeSkole("gimnazija");
		srednjaSkolaRepo.save(sk);*/
		
		Student s = new Student();
		SrednjaSkola sk = new SrednjaSkola();
		VisokoskolskaUstanova vsu = new VisokoskolskaUstanova();
		DrziPredmet drziPredmet = new DrziPredmet();
		Indeks indeks = new Indeks();
		Ispit ispit = new Ispit();
		IspitniRok ispitniRok = new IspitniRok();
		IstorijaZvanja istorijaZvanja = new IstorijaZvanja();
		IzlazakNaIspit izlazakNaIspit = new IzlazakNaIspit();
		Nastavnik nastavnik = new Nastavnik();
		OsvojeniPredispitniPoeni osvojeniPredispitniPoeni = new OsvojeniPredispitniPoeni();
		PolozenPredmet polozeniPredmet = new PolozenPredmet();
		PredispitneObaveze predispitneObaveze = new PredispitneObaveze();
		UpisGodine upisGodine = new UpisGodine();
		ObnovaGodine obnovaGod = new ObnovaGodine();
		Predmet predmet = new Predmet();
		PrijavaIspita prijavaIspita = new PrijavaIspita();
		SkolskaGodina skolskaGodina = new SkolskaGodina();
		StudProgram studProgram = new StudProgram();
		VrstaStudija vrstaStud = new VrstaStudija();
		Zvanje zvanje = new Zvanje();
		
		
		
		/// Visokoskolska ustanova
		vsu.setNazivVisokoskolskeUstanove("Poljoprivredni fakultet");

		visokoskolskaUstanovaRepo.save(vsu);

		/// Srednja Skola
		sk.setNazivSrednjeSkole("Osma gimnazija");
		sk.setMestoSrednjeSkole("Kraljica Natalije 5");
		sk.setVrstaSrednjeSkole("Gimnazija");

		srednjaSkolaRepo.save(sk);

		/// Student
		s.setAdresaPrebivalista("Zute dunje 6");
		s.setBrojLicneKarte("452RTFD5W752R");
		s.setBrTelefona("0617483465");
		s.setDatumRodjenja(LocalDate.of(1999, 05, 25));
		s.setDrzavaRodjenja("Srbija");
		s.setDrzavljanstvo("Srpsko");
		s.setEmailFakultet("mpaunovic1518rn@raf.rs");
		s.setEmailPrivatan("majapaunovic@gmail.com");
		s.setIme("Maja");
		s.setIzdavacLicneKarte("PS NOVI BEOGRAD");
		s.setJmbg("1570234812034");
		s.setMestoRodjenja("Beograd");
		s.setNacionalnost("Srbin");
		s.setPol("z");
		s.setPrezime("Paunovic");
		s.setSrSkola(sk);
		s.setUspehPrijemni(67);
		s.setUspehSrednjaSkola(87);
		s.setVisokoskolskaUstanova(vsu);

		studentRepo.save(s);

		// Zvanje
		zvanje.setZvanje("asistent");

		zvanjeRepository.save(zvanje);

		// Nastavnik
		nastavnik.setIme("Dejana");
		nastavnik.setPrezime("Mandic");
		nastavnik.setSrednjeIme("Dexy");
		nastavnik.setEmail("ddejana@raf.rs");
		nastavnik.setZavrsenaVisokoskolskaUstanova("RAF");
		nastavnik.setZvanje(zvanje);
		
		nastavnikRepo.save(nastavnik);
		
		
		// IstorijaZvanja
		istorijaZvanja.setDatumIzboraZvanja(LocalDate.of(2018, 03, 6));
		istorijaZvanja.setUzaNaucnaOblast("algoritmi");
		istorijaZvanja.setZvanje(zvanje);
		istorijaZvanja.setNastavnik(nastavnik);
		
		istorijaZvanjaRepo.save(istorijaZvanja);
		
		// VrstaStudija
		vrstaStud.setPunNazivStudija("osnovne akademske studije");
		vrstaStud.setSkraceniNazivStudija("OAS");
		
		vrsteStudijaRepository.save(vrstaStud);
		
		
		// StudProgram
		studProgram.setBrojSemestara(8);
		studProgram.setGodinaAkreditacije(2003);
		studProgram.setNazivStudPrograma("Racunarske nauke");
		studProgram.setNazivZvanjaPoZavrsetkuStudija("inzenjer racunarskih nauka");
		studProgram.setOznaka("RN");
		studProgram.setVrstaStudija(vrstaStud);
		
		studProgramRepository.save(studProgram);
		
		
		// SkolskaGodina
		skolskaGodina.setSkolskaGodina(2020);
		skolskaGodina.setAktivna(true);

		skolskaGodinaRepository.save(skolskaGodina);		
		
				
		// IspitniRok
		ispitniRok.setDatumPocetkaIspitnogRoka(LocalDate.of(2020, 06, 7));
		ispitniRok.setDatumZavrsetkaIspitnogRoka(LocalDate.of(2020, 06, 1));
		ispitniRok.setSkolskaGodina(skolskaGodina);
		
		ispitniRokRepo.save(ispitniRok);
		
		
		// Indeks
		indeks.setAktivan(true);
		indeks.setBrojIndexa(15);
		indeks.setDatumAktivacijeIndexa(LocalDate.of(2018, 9, 17));
		indeks.setGodinaUpisa(2020);
		indeks.setStudent(s);
		indeks.setStudProgram(studProgram);
		
		indeksRepo.save(indeks);
		
		
		// UpisGodine
		upisGodine.setGodinaUpisa(4);
		upisGodine.setDatum(LocalDate.of(2020, 8, 16));
		upisGodine.setNapomena("Ucite jace!");
		upisGodine.setIndeks(indeks);
		
		upisGodineRepository.save(upisGodine);
		
		
		// Predmet
		predmet.setBrojESPBpoena(8);
		predmet.setSifra("EW7567");
		predmet.setNazivPredmeta("Dizajn i analiza algoritama");
		predmet.setOpisPredmeta("Pisanje algoritama");
		predmet.setSemestar(4);
		predmet.setFondCasovaPredavanja(12);
		predmet.setFondCasovaVezbi(12);
		predmet.setStudProgram(studProgram);
		predmet.setUpisGodine(upisGodine);
		
		
		predmetRepository.save(predmet);
		
		
		// Ispit
		ispit.setDatumOdrzavanjaIspita(LocalDate.of(2020, 07, 20));
		ispit.setVremeOdrzavanjaIspita(9);
		ispit.setZakljucenIspit(false);
		ispit.setPredmet(predmet);
		ispit.setNastavnik(nastavnik);
		ispit.setIspitniRok(ispitniRok);
				
		ispitRepo.save(ispit);
		
				
		// PolozenPredmet
		polozeniPredmet.setPolozen(true);
		polozeniPredmet.setOcena(8);
		polozeniPredmet.setIndeks(indeks);
		polozeniPredmet.setPredmet(predmet);
		polozeniPredmet.setIspit(ispit);		
				
		polozeniPredmetRepo.save(polozeniPredmet);
				
		
		// PrijavaIspita
		prijavaIspita.setDatumPrijaveIspita(LocalDate.of(2020, 07, 8));
		prijavaIspita.setIspit(ispit);
		prijavaIspita.setIndeks(indeks);
				
		prijavaIspitaRepository.save(prijavaIspita);
		
		
		// IzlazakNaIspit
		izlazakNaIspit.setPrijavaIspita(prijavaIspita);
		izlazakNaIspit.setPonistavaIspit(false);
		izlazakNaIspit.setNapomena("obavezan razmak");
		
		izlazakNaIspitRepo.save(izlazakNaIspit);
		
		
		// DrziPredmet
		drziPredmet.setNastavnik(nastavnik);
		drziPredmet.setPredmet(predmet);
		drziPredmet.setSkolskaGodina(skolskaGodina);
		drziPredmet.getIndeksi().add(indeks);
		
		drziPredmetRepo.save(drziPredmet);
		
		
		// PredispitneObaveze
		predispitneObaveze.setVrstaPredispitnihObaveza("kolokvijum");
		predispitneObaveze.setMaxBrPredispitnihPoena(50);
		predispitneObaveze.setPredmet(predmet);
		predispitneObaveze.setSkolskaGodina(skolskaGodina);
		predispitneObaveze.setNastavnik(nastavnik);
		
		predispitneObavezeRepo.save(predispitneObaveze);
		
		
		
		// OsvojeniPredispitniPoeni
		osvojeniPredispitniPoeni.setOsvojeniPredispitniPoeni(27);
		osvojeniPredispitniPoeni.setPredispitneObaveze(predispitneObaveze);
		osvojeniPredispitniPoeni.setIndeks(indeks);
		
		osvojeniPredispitniPoeniRepo.save(osvojeniPredispitniPoeni);
	}
}
