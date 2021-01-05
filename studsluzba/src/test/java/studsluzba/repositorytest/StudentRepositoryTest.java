package studsluzba.repositorytest;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
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
		/*int brojac = studentRepo.countBrojIzlazakaNaIspit(4, 2018, "RN", "Verovatnoca i statistika");
		System.out.println("\n");
		System.out.println(brojac);
		System.out.println("\n");*/
		
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
				vsu.setNazivVisokoskolskeUstanove("Arhitektonski fakultet");

				visokoskolskaUstanovaRepo.save(vsu);

				/// Srednja Skola
				sk.setNazivSrednjeSkole("Peta gimnazija");
				sk.setMestoSrednjeSkole("Ilije Garasanina 24");
				sk.setVrstaSrednjeSkole("Gimnazija");

				srednjaSkolaRepo.save(sk);

				/// Student
				s.setIme("Nadja");
				s.setPrezime("Ranitovic");
				s.setSrednjeIme("Nadjolinka");
				s.setAdresaPrebivalista("Jurija Gagarina 56");
				s.setBrTelefona("0633474387");
				s.setBrojLicneKarte("423784337");
				s.setIzdavacLicneKarte("PS Novi Beograd");
				s.setDatumRodjenja(LocalDate.of(1999, 02, 15));
				s.setJmbg("4238479239932");
				s.setDrzavaRodjenja("Srbija");
				s.setDrzavljanstvo("Srpsko");
				s.setMestoRodjenja("Beograd");
				s.setNacionalnost("Srpkinja");
				s.setEmailFakultet("nranitovic1719rn@raf.rs");
				s.setEmailPrivatan("nadjaranitovic@gmail.com");
				s.setPol("Zenski");
				s.setSrSkola(sk);
				s.setVisokoskolskaUstanova(vsu);
				
				studentRepo.save(s);
				
				
				//Zvanje
				zvanje.setZvanje("Vanredni profesor");
				
				zvanjeRepository.save(zvanje);

				// Nastavnik
				nastavnik.setIme("Vesna");
				nastavnik.setPrezime("Cavic");
				nastavnik.setSrednjeIme("Veki");
				nastavnik.setEmail("vsesum@raf.rs");
				nastavnik.setZavrsenaVisokoskolskaUstanova("FON");
				nastavnik.setZvanje(zvanje);
				nastavnik.setAktivan(true);
				
				nastavnikRepo.save(nastavnik);
				
				
				// VrstaStudija
				vrstaStud.setPunNazivStudija("Osnovne akademske studije");
				vrstaStud.setSkraceniNazivStudija("OAS");
				
				vrsteStudijaRepository.save(vrstaStud);
				
				// StudProgram
				studProgram.setNazivStudPrograma("Racunarsko inzinjerstvo");
				studProgram.setOznaka("RI");
				studProgram.setNazivZvanjaPoZavrsetkuStudija("Diplomirani inzenjer elektrotehnike i racunara");
				studProgram.setGodinaAkreditacije(2009);
				studProgram.setBrojSemestara(8);
				studProgram.setVrstaStudija(vrstaStud);
				
				studProgramRepository.save(studProgram);
				
				// SkolskaGodina
				skolskaGodina.setSkolskaGodina(2019);
				skolskaGodina.setAktivna(false);
				
				skolskaGodinaRepository.save(skolskaGodina);
				
				
				// IspitniRok
				ispitniRok.setDatumPocetkaIspitnogRoka(LocalDate.of(2020, 06, 16));
				ispitniRok.setDatumZavrsetkaIspitnogRoka(LocalDate.of(2020, 07, 02));
				ispitniRok.setSkolskaGodina(skolskaGodina);
				ispitniRok.setImeRoka("junski");
				
				ispitniRokRepo.save(ispitniRok);
				
				IspitniRok ispitniRok2 = new IspitniRok();
				
				ispitniRok2.setDatumPocetkaIspitnogRoka(LocalDate.of(2020, 07, 03));
				ispitniRok2.setDatumZavrsetkaIspitnogRoka(LocalDate.of(2020, 07, 17));
				ispitniRok2.setSkolskaGodina(skolskaGodina);
				ispitniRok2.setImeRoka("julski");
				
				ispitniRokRepo.save(ispitniRok2);
				
				
				// Indeks
				indeks.setBrojIndexa(500);
				indeks.setGodinaUpisa(2019);
				indeks.setStudent(s);
				indeks.setStudProgram(studProgram);
				indeks.setAktivan(true);
				indeks.setDatumAktivacijeIndexa(LocalDate.of(2019, 06, 20));
				indeks.setOsvojeniPoeni(96);
				
				indeksRepo.save(indeks);
				
				
				// UpisGodine
				upisGodine.setIndeks(indeks);
				upisGodine.setGodinaUpisa(2);
				upisGodine.setDatum(LocalDate.of(2020, 07, 15));
				upisGodine.setNapomena("Spremite se !");
				
				upisGodineRepository.save(upisGodine);
				
				// Predmet
				Predmet predmet2 = new Predmet();
				
				predmet.setNazivPredmeta("Algoritmi i strukture podataka");
				predmet.setOpisPredmeta("Rad sa algoritmima");
				predmet.setSemestar(3);
				predmet.setBrojESPBpoena(8);
				predmet.setSifra("BMU456");
				predmet.setFondCasovaPredavanja(12);
				predmet.setFondCasovaVezbi(12);
				predmet.setStudProgram(studProgram);
				predmet.setUpisGodine(upisGodine);
				
				predmetRepository.save(predmet);
				
				predmet2.setNazivPredmeta("Matematicka analiza");
				predmet2.setOpisPredmeta("Matematika");
				predmet2.setSemestar(4);
				predmet2.setBrojESPBpoena(6);
				predmet2.setSifra("FEK586");
				predmet2.setFondCasovaPredavanja(13);
				predmet2.setFondCasovaVezbi(13);
				predmet2.setStudProgram(studProgram);
				predmet2.setUpisGodine(upisGodine);
				
				predmetRepository.save(predmet2);
				
				
				// Ispit
				ispit.setDatumOdrzavanjaIspita(LocalDate.of(2020, 06, 20));
				ispit.setVremeOdrzavanjaIspita(10);
				ispit.setZakljucenIspit(true);
				ispit.setPredmet(predmet);
				ispit.setNastavnik(nastavnik);
				ispit.setIspitniRok(ispitniRok);
				
				ispitRepo.save(ispit);
				
				Ispit ispit2 = new Ispit();
				
				ispit2.setDatumOdrzavanjaIspita(LocalDate.of(2020, 07, 15));
				ispit2.setVremeOdrzavanjaIspita(9);
				ispit2.setZakljucenIspit(true);
				ispit2.setPredmet(predmet2);
				ispit2.setNastavnik(nastavnik);
				ispit2.setIspitniRok(ispitniRok2);
				
				ispitRepo.save(ispit2);
				
						
				// PolozenPredmet
				polozeniPredmet.setPredmet(predmet);
				polozeniPredmet.setIndeks(indeks);
				polozeniPredmet.setIspit(ispit);
				polozeniPredmet.setOsvojeniPoeniNaIspitu(46);
				polozeniPredmet.setOcena(10);
				polozeniPredmet.setPolozen(true);
				
				polozeniPredmetRepo.save(polozeniPredmet);
				
				PolozenPredmet polozeniPredmet2 = new PolozenPredmet();
				
				polozeniPredmet2.setPredmet(predmet2);
				polozeniPredmet2.setIndeks(indeks);
				polozeniPredmet2.setIspit(ispit2);
				polozeniPredmet2.setOsvojeniPoeniNaIspitu(50);
				polozeniPredmet2.setOcena(10);
				polozeniPredmet2.setPolozen(true);
				
				polozeniPredmetRepo.save(polozeniPredmet2);
						
				
				// PrijavaIspita
				prijavaIspita.setIspit(ispit);
				prijavaIspita.setIndeks(indeks);
				prijavaIspita.setDatumPrijaveIspita(LocalDate.of(2020, 06, 10));
				
				prijavaIspitaRepository.save(prijavaIspita);
				
				PrijavaIspita prijavaIspita2 = new PrijavaIspita();
				
				prijavaIspita2.setIspit(ispit2);
				prijavaIspita2.setIndeks(indeks);
				prijavaIspita2.setDatumPrijaveIspita(LocalDate.of(2021, 07, 01));
				
				prijavaIspitaRepository.save(prijavaIspita2);
				
				
				// IzlazakNaIspit
				izlazakNaIspit.setPolozenPredmet(polozeniPredmet);
				izlazakNaIspit.setPonistavaIspit(false);
				izlazakNaIspit.setNapomena("Spremite se dobro!");
			
				izlazakNaIspitRepo.save(izlazakNaIspit);
				
				IzlazakNaIspit izlazakNaIspit2 = new IzlazakNaIspit();
				
				izlazakNaIspit2.setPolozenPredmet(polozeniPredmet2);
				izlazakNaIspit2.setPonistavaIspit(false);
				izlazakNaIspit2.setNapomena("Bez zabusavanja !");
				
				izlazakNaIspitRepo.save(izlazakNaIspit2);
				
				List<Indeks> indeksi = new ArrayList<Indeks>();
				indeksi.add(indeks);
				
				// DrziPredmet
				drziPredmet.setNastavnik(nastavnik);
				drziPredmet.setPredmet(predmet);
				drziPredmet.setSkolskaGodina(skolskaGodina);
				drziPredmet.setIndeksi(indeksi);
				
				drziPredmetRepo.save(drziPredmet);
				
				DrziPredmet drziPredmet2 = new DrziPredmet();
				
				drziPredmet2.setNastavnik(nastavnik);
				drziPredmet2.setPredmet(predmet2);
				drziPredmet2.setSkolskaGodina(skolskaGodina);
				drziPredmet2.setIndeksi(indeksi);
				
				drziPredmetRepo.save(drziPredmet2);
				
				// PredispitneObaveze
				predispitneObaveze.setPredmet(predmet);
				predispitneObaveze.setVrstaPredispitnihObaveza("Kolokvijum");
				predispitneObaveze.setMaxBrPredispitnihPoena(50);
				predispitneObaveze.setSkolskaGodina(skolskaGodina);
				predispitneObaveze.setNastavnik(nastavnik);
				
				predispitneObavezeRepo.save(predispitneObaveze);
				
				PredispitneObaveze predispitneObaveze2 = new PredispitneObaveze();
				
				predispitneObaveze2.setPredmet(predmet2);
				predispitneObaveze2.setVrstaPredispitnihObaveza("Kolokvijum");
				predispitneObaveze2.setMaxBrPredispitnihPoena(50);
				predispitneObaveze2.setSkolskaGodina(skolskaGodina);
				predispitneObaveze2.setNastavnik(nastavnik);
				
				predispitneObavezeRepo.save(predispitneObaveze2);
				
				// OsvojeniPredispitniPoeni
				osvojeniPredispitniPoeni.setPredispitneObaveze(predispitneObaveze);
				osvojeniPredispitniPoeni.setIndeks(indeks);
				osvojeniPredispitniPoeni.setOsvojeniPredispitniPoeni(50);
				
				osvojeniPredispitniPoeniRepo.save(osvojeniPredispitniPoeni);
				
				OsvojeniPredispitniPoeni osvojeniPredispitniPoeni2 = new OsvojeniPredispitniPoeni();
				
				osvojeniPredispitniPoeni2.setPredispitneObaveze(predispitneObaveze2);
				osvojeniPredispitniPoeni2.setIndeks(indeks);
				osvojeniPredispitniPoeni2.setOsvojeniPredispitniPoeni(46);
				
				osvojeniPredispitniPoeniRepo.save(osvojeniPredispitniPoeni2);
		
		
	}
}
