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
		
		/////////////////////////////////////////Ispit//////////////////////////////////////////////////
		
		//Koliko puta je student izlazio na ispit
		int brojac = studentRepo.countBrojIzlazakaNaIspit(4, 2018, "RN", "Verovatnoca i statistika");
		System.out.println("\n");
		System.out.println(brojac);
		System.out.println("\n");
		
		//Selekcija ostvarenih poena na predispitnim obavezama za studenta na odredjenom predmetu u skolskoj godini (Bez godine)
		/*int i =	osvojeniPredispitniPoeniRepo.selectOsvojeniPredPoeni(1, "Upravljanje informacijama");
		System.out.println("\n" + i + "\n");*/
		
		//Selekcija ostvarenih poena na predispitnim obavezama za studenta na odredjenom predmetu u skolskoj godini (Sa godinom)
		/*int i =	osvojeniPredispitniPoeniRepo.selectOsvojeniPredPoeniSaGodinom(1, "Upravljanje informacijama", 2020);
		System.out.println("\n" + i + "\n");*/
		
		//svi prijavljeni studenti za ispit
		/*List<Student> studenti = studentRepo.findStudentByPrijavljenIspit("Verovatnoca i statistika");
		System.out.println("\n");
		for (Student s : studenti)
			System.out.println(s.toString());
		System.out.println("\n");*/
		
		//prosecna ocena na ispitu
		/*double ocena = polozeniPredmetRepo.avgOcenaNaIspitu(1);
		System.out.println("\n" + ocena + "\n");*/
		
		//sortiran spisak po godini studPrograma, po godini upisa i ukupan broj poena na ispitu
		/*List<Student> studenti = studentRepo.sortByElements();
		System.out.println("\n");
		for(Student s : studenti)
			System.out.println(s.toString());
		System.out.println("\n");*/
		
		////////////////////////////Studijski program i predmet////////////////////////////
		
		
		//Selekcija predmeta na studProgramu
		/*List<Predmet> predmeti = predmetRepository.findPredmetByStudProgram("Racunarske nauke");
		for(Predmet p : predmeti)
			System.out.println(p.toString());*/
		
		//avgOcenaURasponuGodina
		/*double ocena = polozeniPredmetRepo.avgOcenaURasponuGodina(2018,2020);
		System.out.println("\n" + ocena + "\n");*/
		
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
		/*List<ObnovaGodine> obnovaGodine = obnovaGodineRepo.findObnovaGodineByID(1);
			for(ObnovaGodine og : obnovaGodine)
				System.out.println(og.toString());*/
		
		//selekcija upisanihGodina za id indeksa
		/*List<UpisGodine> upisGodine = upisGodineRepository.findUpisGodineByID(3);
		for(UpisGodine up : upisGodine)
			System.out.println(up.toString());*/
		
		//selekcija polozenihPredmeta po id-u
		/*List<PolozenPredmet> polozeniPredmeti = polozeniPredmetRepo.findPolozenIspitByID(1);
		for(PolozenPredmet pp : polozeniPredmeti)
			System.out.println(pp.toString());*/
		
		//selektovanje studenta po indeksu
		/*Student student = studentRepo.findStudentByID(4, 2018, "RN");
		System.out.println("\n");
		System.out.println(student.toString());
		System.out.println("\n");*/
		
		//////////////////////////////////////////////////////////////////////////
		
		
		/*SrednjaSkola sk = new SrednjaSkola();
		sk.setNazivSrednjeSkole("Matematicka gimnazija");
		sk.setMestoSrednjeSkole("Kraljice Natalije 37");
		sk.setVrstaSrednjeSkole("gimnazija");
		srednjaSkolaRepo.save(sk);*/
		
		/*Student s = new Student(); 
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
		Predmet predmet1 = new Predmet();
		
		PrijavaIspita prijavaIspita = new PrijavaIspita();
		SkolskaGodina skolskaGodina = new SkolskaGodina();
		StudProgram studProgram = new StudProgram();
		VrstaStudija vrstaStud = new VrstaStudija();
		Zvanje zvanje = new Zvanje();
		Zvanje zvanje1 = new Zvanje();
		
		
		
		/// Visokoskolska ustanova
		vsu.setNazivVisokoskolskeUstanove("Gradjevinski fakultet");

		visokoskolskaUstanovaRepo.save(vsu);

		/// Srednja Skola
		sk.setNazivSrednjeSkole("Racunarska gimnazija");
		sk.setMestoSrednjeSkole("Kenz Mihajlova 6");
		sk.setVrstaSrednjeSkole("Gimnazija");

		srednjaSkolaRepo.save(sk);

		/// Student
		s.setAdresaPrebivalista("Jurija Gagarina 269");
		s.setBrojLicneKarte("105848607");
		s.setBrTelefona("0691394112");
		s.setDatumRodjenja(LocalDate.of(1998, 11, 16));
		s.setDrzavaRodjenja("Srbija");
		s.setDrzavljanstvo("Srpsko");
		s.setEmailFakultet("lkovacevicr418rn@raf.rs");
		s.setEmailPrivatan("lkovacevic@gmail.com");
		s.setIme("Luka");
		s.setIzdavacLicneKarte("PS BEOGRAD");
		s.setJmbg("1705234812034");
		s.setMestoRodjenja("Beograd");
		s.setNacionalnost("Srbin");
		s.setPol("m");
		s.setPrezime("Kovacevic");
		s.setSrSkola(sk);
		s.setUspehPrijemni(42);
		s.setUspehSrednjaSkola(94);
		s.setVisokoskolskaUstanova(vsu);

		studentRepo.save(s);

		//Zvanje
		zvanje.setZvanje("profesor");
		
		zvanjeRepository.save(zvanje);
		
		//Zvanje Istorije Zvanja
		zvanje1.setZvanje("asistent");
		
		zvanjeRepository.save(zvanje1);

		// Nastavnik
		nastavnik.setIme("Milica");
		nastavnik.setPrezime("Nikolic");
		nastavnik.setSrednjeIme("Comi");
		nastavnik.setEmail("mnikolic@raf.rs");
		nastavnik.setZavrsenaVisokoskolskaUstanova("FON");
		nastavnik.setZvanje(zvanje);
		
		nastavnikRepo.save(nastavnik);
		
		
		// IstorijaZvanja
		istorijaZvanja.setDatumIzboraZvanja(LocalDate.of(2016, 05, 12));
		istorijaZvanja.setUzaNaucnaOblast("matematika");
		istorijaZvanja.setZvanje(zvanje1);
		istorijaZvanja.setNastavnik(nastavnik);
		
		istorijaZvanjaRepo.save(istorijaZvanja);
		
		// VrstaStudija
		vrstaStud.setPunNazivStudija("osnovne akademske studije");
		vrstaStud.setSkraceniNazivStudija("OAS");
		
		vrsteStudijaRepository.save(vrstaStud);
		
		
		// StudProgram
		studProgram.setBrojSemestara(8);
		studProgram.setGodinaAkreditacije(2008);
		studProgram.setNazivStudPrograma("Racunarske nauke");
		studProgram.setNazivZvanjaPoZavrsetkuStudija("Samostalni rad na razvoju softvera");
		studProgram.setOznaka("RN");
		studProgram.setVrstaStudija(vrstaStud);
		
		studProgramRepository.save(studProgram);
		
		
		// SkolskaGodina
		skolskaGodina.setSkolskaGodina(2020);
		skolskaGodina.setAktivna(true);

		skolskaGodinaRepository.save(skolskaGodina);		
		
				
		// IspitniRok
		ispitniRok.setDatumPocetkaIspitnogRoka(LocalDate.of(2021, 01, 11));
		ispitniRok.setDatumZavrsetkaIspitnogRoka(LocalDate.of(2021, 01, 27));
		ispitniRok.setSkolskaGodina(skolskaGodina);
		
		ispitniRokRepo.save(ispitniRok);
		
		
		// Indeks
		indeks.setAktivan(true);
		indeks.setBrojIndexa(4);
		indeks.setDatumAktivacijeIndexa(LocalDate.of(2018, 07, 25));
		indeks.setGodinaUpisa(2018);
		indeks.setStudent(s);
		indeks.setStudProgram(studProgram);
		
		indeksRepo.save(indeks);
		
		
		//Prebaceni predmet
		predmet1.setBrojESPBpoena(8);
		predmet1.setSifra("A2RE61");
		predmet1.setNazivPredmeta("Algoritmi i strukture podataka");
		predmet1.setOpisPredmeta("Pisanje algoritama");
		predmet1.setSemestar(3);
		predmet1.setFondCasovaPredavanja(13);
		predmet1.setFondCasovaVezbi(11);
		predmet1.setStudProgram(studProgram);
		predmet1.setUpisGodine(upisGodine);
		
		
		// UpisGodine
		upisGodine.setDatum(LocalDate.of(2020, 07, 17));
		upisGodine.setGodinaUpisa(3);
		upisGodine.setIndeks(indeks);
		upisGodine.setNapomena("Napomena!");
		
		upisGodineRepository.save(upisGodine);
		
		
		// Predmet
		predmet.setBrojESPBpoena(8);
		predmet.setSifra("ABC567");
		predmet.setNazivPredmeta("Verovatnoca i statistika");
		predmet.setOpisPredmeta("Racunanje verovatnoce i statistike");
		predmet.setSemestar(5);
		predmet.setFondCasovaPredavanja(12);
		predmet.setFondCasovaVezbi(12);
		predmet.setStudProgram(studProgram);
		predmet.setUpisGodine(upisGodine);
		
		
		predmetRepository.save(predmet);
		
		
		// Ispit
		ispit.setDatumOdrzavanjaIspita(LocalDate.of(2021, 01, 15));
		ispit.setVremeOdrzavanjaIspita(14);
		ispit.setZakljucenIspit(true);
		ispit.setPredmet(predmet);
		ispit.setNastavnik(nastavnik);
		ispit.setIspitniRok(ispitniRok);
				
		ispitRepo.save(ispit);
		
				
		// PolozenPredmet
		polozeniPredmet.setPolozen(true);
		polozeniPredmet.setOcena(9);
		polozeniPredmet.setOsvojeniPoeniNaIspitu(40);
		polozeniPredmet.setIndeks(indeks);
		polozeniPredmet.setPredmet(predmet);
		polozeniPredmet.setIspit(ispit);		
				
		polozeniPredmetRepo.save(polozeniPredmet);
				
		
		// PrijavaIspita
		prijavaIspita.setDatumPrijaveIspita(LocalDate.of(2021, 01, 1));
		prijavaIspita.setIspit(ispit);
		prijavaIspita.setIndeks(indeks);
				
		prijavaIspitaRepository.save(prijavaIspita);
		
		
		// IzlazakNaIspit
		izlazakNaIspit.setPolozenPredmet(polozeniPredmet);
		izlazakNaIspit.setPonistavaIspit(false);
		izlazakNaIspit.setNapomena("Napomena!");
		
		izlazakNaIspitRepo.save(izlazakNaIspit);
		
		
		// DrziPredmet
		drziPredmet.setNastavnik(nastavnik);
		drziPredmet.setPredmet(predmet);
		drziPredmet.setSkolskaGodina(skolskaGodina);
		drziPredmet.getIndeksi().add(indeks);
		
		drziPredmetRepo.save(drziPredmet);
		
		
		// PredispitneObaveze
		predispitneObaveze.setVrstaPredispitnihObaveza("kolokvijum");
		predispitneObaveze.setMaxBrPredispitnihPoena(60);
		predispitneObaveze.setPredmet(predmet);
		predispitneObaveze.setSkolskaGodina(skolskaGodina);
		predispitneObaveze.setNastavnik(nastavnik);
		
		predispitneObavezeRepo.save(predispitneObaveze);
		
		
		
		// OsvojeniPredispitniPoeni
		osvojeniPredispitniPoeni.setOsvojeniPredispitniPoeni(45);
		osvojeniPredispitniPoeni.setPredispitneObaveze(predispitneObaveze);
		osvojeniPredispitniPoeni.setIndeks(indeks);
		
		osvojeniPredispitniPoeniRepo.save(osvojeniPredispitniPoeni);*/
	}
}
