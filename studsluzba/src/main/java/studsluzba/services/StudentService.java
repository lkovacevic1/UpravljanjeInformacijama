package studsluzba.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studsluzba.model.Indeks;
import studsluzba.model.ObnovaGodine;
import studsluzba.model.SrednjaSkola;
import studsluzba.model.StudProgram;
import studsluzba.model.Student;
import studsluzba.model.UpisGodine;
import studsluzba.model.VisokoskolskaUstanova;
import studsluzba.repositories.IndeksRepository;
import studsluzba.repositories.StudentRepository;

@Service
public class StudentService {
	
	@Autowired 
	StudentRepository studentRepo;
	
	@Autowired
	IndeksRepository indeksRepo;
	
	public Student saveStudent(String ime, String prezime, String srednjeIme, String jmbg,
			LocalDate datumRodjenja, String emailFakultet, String emailPrivatan, String brTelefona,
			String adresaPrebivalista, String mestoRodjenja, String drzavaRodjenja, String drzavljanstvo,
			String nacionalnost, String brojLicneKarte, String izdavacLicneKarte, SrednjaSkola srSkola,
			String uspehSrednjaSkola, String uspehPrijemni, VisokoskolskaUstanova visokoskolskaUstanova, String pol) {
		Student st = new Student();
		st.setIme(ime);
		st.setPrezime(prezime);
		st.setSrednjeIme(srednjeIme);
		st.setJmbg(jmbg);
		st.setDatumRodjenja(datumRodjenja);
		st.setEmailFakultet(emailFakultet);
		st.setEmailPrivatan(emailPrivatan);
		st.setBrTelefona(brTelefona);
		st.setAdresaPrebivalista(adresaPrebivalista);
		st.setMestoRodjenja(mestoRodjenja);
		st.setDrzavaRodjenja(drzavaRodjenja);
		st.setDrzavljanstvo(drzavljanstvo);
		st.setNacionalnost(nacionalnost);
		st.setBrojLicneKarte(brojLicneKarte);
		st.setIzdavacLicneKarte(izdavacLicneKarte);
		st.setSrSkola(srSkola);
		st.setUspehSrednjaSkola(Float.parseFloat(uspehSrednjaSkola));
		st.setUspehPrijemni(Float.parseFloat(uspehPrijemni));
		st.setVisokoskolskaUstanova(visokoskolskaUstanova);
		st.setPol(pol);
		return studentRepo.save(st);
	}
	
	public Student updateStudent(Student st, String ime, String prezime, String srednjeIme, String jmbg,
			LocalDate datumRodjenja, String emailFakultet, String emailPrivatan, String brTelefona,
			String adresaPrebivalista, String mestoRodjenja, String drzavaRodjenja, String drzavljanstvo,
			String nacionalnost, String brojLicneKarte, String izdavacLicneKarte, SrednjaSkola srSkola,
			String uspehSrednjaSkola, String uspehPrijemni, VisokoskolskaUstanova visokoskolskaUstanova, String pol) {
		st.setIme(ime);
		st.setPrezime(prezime);
		st.setSrednjeIme(srednjeIme);
		st.setJmbg(jmbg);
		st.setDatumRodjenja(datumRodjenja);
		st.setEmailFakultet(emailFakultet);
		st.setEmailPrivatan(emailPrivatan);
		st.setBrTelefona(brTelefona);
		st.setAdresaPrebivalista(adresaPrebivalista);
		st.setMestoRodjenja(mestoRodjenja);
		st.setDrzavaRodjenja(drzavaRodjenja);
		st.setDrzavljanstvo(drzavljanstvo);
		st.setNacionalnost(nacionalnost);
		st.setBrojLicneKarte(brojLicneKarte);
		st.setIzdavacLicneKarte(izdavacLicneKarte);
		st.setSrSkola(srSkola);
		st.setUspehSrednjaSkola(Float.parseFloat(uspehSrednjaSkola));
		st.setUspehPrijemni(Float.parseFloat(uspehPrijemni));
		st.setVisokoskolskaUstanova(visokoskolskaUstanova);
		st.setPol(pol);
		return studentRepo.save(st);
	}
	
	public void deleteStudent(Student s) {
		studentRepo.delete(s);
	}
	
	public List<Student> loadAll(){
		Iterable<Student> iter = studentRepo.findAll();
		List<Student> rez = new ArrayList<Student>();		
		iter.forEach(rez::add);
		return rez;
	}
	
	//Promeni indeks na neaktivan
	
	public Indeks promeniAktivanIndeksNaNeaktivan(Indeks i) {
		i.setAktivan(false);
		
		return indeksRepo.save(i);
	}
	
	public Indeks saveIndeks(Student s, int brojIndeksa, StudProgram studProgram, ObnovaGodine obnova, UpisGodine upis) {
		LocalDate today = LocalDate.now();
		int year = Calendar.getInstance().get(Calendar.YEAR);
		Indeks i = new Indeks();
		i.setStudent(s);
		i.setGodinaUpisa(year);
		i.setBrojIndexa(brojIndeksa);
		i.setAktivan(true);
		i.setDatumAktivacijeIndexa(today);
		i.setStudProgram(studProgram);
		i.setObnovaGodine(obnova);
		i.setUpisGodine(upis);
		return indeksRepo.save(i);
	}
}
