package studsluzba.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studsluzba.model.SrednjaSkola;
import studsluzba.model.StudProgram;
import studsluzba.model.Student;
import studsluzba.model.VisokoskolskaUstanova;
import studsluzba.repositories.StudentRepository;

@Service
public class StudentService {
	
	@Autowired 
	StudentRepository studentRepo;
	
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
}
