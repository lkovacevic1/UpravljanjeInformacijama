package studsluzba.repositorytest;

import java.text.ParseException;
import java.time.LocalDate;

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
		vsu.setNazivVisokoskolskeUstanove("Matematicki fakultet");

		visokoskolskaUstanovaRepo.save(vsu);

		/// Srednja Skola
		sk.setNazivSrednjeSkole("Racunarska gimnazija");
		sk.setMestoSrednjeSkole("Knez Mihajlova 6");
		sk.setVrstaSrednjeSkole("Gimnazija");

		srednjaSkolaRepo.save(sk);

		/// Student
		s.setAdresaPrebivalista("Beogradska 85a");
		s.setBrojLicneKarte("1423153153E0000B123");
		s.setBrTelefona("0694267412");
		s.setDatumRodjenja(LocalDate.of(1999, 07, 26));
		s.setDrzavaRodjenja("Srbija");
		s.setDrzavljanstvo("Srpsko");
		s.setEmailFakultet("aradonjic6819rn@raf.rs");
		s.setEmailPrivatan("anastasijaradonjic@gmail.com");
		s.setIme("Anastasija");
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

		// Zvanje
		zvanje.setZvanje("profesor");

		zvanjeRepository.save(zvanje);

		// Nastavnik
		nastavnik.setIme("Milos");
		nastavnik.setPrezime("Radenkovic");
		nastavnik.setSrednjeIme("Miki");
		nastavnik.setEmail("milosradenkovic@raf.rs");
		nastavnik.setZavrsenaVisokoskolskaUstanova("FTN");
		nastavnik.setZvanje(zvanje);
		
		nastavnikRepo.save(nastavnik);
		
		
		// IstorijaZvanja
		istorijaZvanja.setDatumIzboraZvanja(LocalDate.of(2019, 03, 20));
		istorijaZvanja.setUzaNaucnaOblast("upravljanje bazama podataka");
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
		ispitniRok.setDatumPocetkaIspitnogRoka(LocalDate.of(2020, 01, 15));
		ispitniRok.setDatumZavrsetkaIspitnogRoka(LocalDate.of(2020, 02, 15));
		ispitniRok.setSkolskaGodina(skolskaGodina);
		
		ispitniRokRepo.save(ispitniRok);
		
		
		// Predmet
		predmet.setBrojESPBpoena(64);
		predmet.setSifra("133DSK");
		predmet.setNazivPredmeta("Upravljanje informacijama");
		predmet.setOpisPredmeta("rad sa bazama");
		predmet.setSemestar(5);
		predmet.setFondCasovaPredavanja(12);
		predmet.setFondCasovaVezbi(12);
		
		predmetRepository.save(predmet);
		
		
		// Ispit
		ispit.setDatumOdrzavanjaIspita(LocalDate.of(2020, 11, 14));
		ispit.setVremeOdrzavanjaIspita(16);
		ispit.setZakljucenIspit(false);
		ispit.setPredmet(predmet);
		ispit.setNastavnik(nastavnik);
		ispit.setIspitniRok(ispitniRok);
				
		ispitRepo.save(ispit);
		
		
		/// Indeks
		indeks.setAktivan(true);
		indeks.setBrojIndexa(68);
		indeks.setDatumAktivacijeIndexa(LocalDate.of(2018, 10, 1));
		indeks.setGodinaUpisa(2020);
		indeks.setStudent(s);
		indeks.setStudProgram(studProgram);
		
		indeksRepo.save(indeks);
		
				
		// PolozenPredmet
		polozeniPredmet.setPolozen(false);
		polozeniPredmet.setOcena(5);
		polozeniPredmet.setIndeks(indeks);
		polozeniPredmet.setPredmet(predmet);
		polozeniPredmet.setIspit(ispit);		
				
		polozeniPredmetRepo.save(polozeniPredmet);
				
		
		// PrijavaIspita
		prijavaIspita.setDatumPrijaveIspita(LocalDate.of(2020, 01, 10));
		prijavaIspita.setIspit(ispit);
		prijavaIspita.setIndeks(indeks);
				
		prijavaIspitaRepository.save(prijavaIspita);
		
		
		// IzlazakNaIspit
		izlazakNaIspit.setPrijavaIspita(prijavaIspita);
		izlazakNaIspit.setPonistavaIspit(false);
		izlazakNaIspit.setNapomena("obavezne maske");
		
		izlazakNaIspitRepo.save(izlazakNaIspit);
		
		
		// DrziPredmet
		drziPredmet.setNastavnik(nastavnik);
		drziPredmet.setPredmet(predmet);
		drziPredmet.setSkolskaGodina(skolskaGodina);
		drziPredmet.getIndeksi().add(indeks);
		
		drziPredmetRepo.save(drziPredmet);
		
		
		// ObnovaGodine
		obnovaGod.setGodinaObnove(2);
		obnovaGod.setDatum(LocalDate.of(2019, 07, 10));
		obnovaGod.setNapomena("Ima rokova !");
		obnovaGod.setIndeks(indeks);
		
		obnovaGodineRepo.save(obnovaGod);
		
		
		// PredispitneObaveze
		predispitneObaveze.setVrstaPredispitnihObaveza("kolokvijum");
		predispitneObaveze.setMaxBrPredispitnihPoena(50);
		predispitneObaveze.setPredmet(predmet);
		predispitneObaveze.setSkolskaGodina(skolskaGodina);
		predispitneObaveze.setNastavnik(nastavnik);
		
		predispitneObavezeRepo.save(predispitneObaveze);
		
		
		
		// OsvojeniPredispitniPoeni
		osvojeniPredispitniPoeni.setOsvojeniPredispitniPoeni(23);
		osvojeniPredispitniPoeni.setPredispitneObaveze(predispitneObaveze);
		osvojeniPredispitniPoeni.setIndeks(indeks);
		
		osvojeniPredispitniPoeniRepo.save(osvojeniPredispitniPoeni);
	}
}
