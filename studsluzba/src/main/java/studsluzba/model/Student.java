package studsluzba.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@NamedQuery(name="Student.findAll", query="SELECT s FROM Student s")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idstudent;
	
	@OneToMany(mappedBy="student")
	private List<Indeks> indeks;

	private String ime;
	
	private String prezime;
	
	private String srednjeIme;
	
	private String jmbg;
	
	private LocalDate datumRodjenja;
	
	private String mestoRodjenja;
	
	private String drzavaRodjenja;
	
	private String drzavljanstvo;
	
	private String nacionalnost;
	
	private String pol;
	
	private String adresaPrebivalista;
	
	private String brTelefona;
	
	private String emailFakultet;
	
	private String emailPrivatan;
	
	private String brojLicneKarte;
	
	private String izdavacLicneKarte;
	
	private float uspehSrednjaSkola;
	
	private float uspehPrijemni;
	
	@ManyToOne
	@JoinColumn(name = "idVisokoskolskeUstanove")
	private VisokoskolskaUstanova visokoskolskaUstanova;
	
	@ManyToOne
	@JoinColumn(name = "idSrednjeSkole")
	private SrednjaSkola srSkola;

	public Student() {
		this.indeks = new ArrayList<Indeks>();
	}

	public Student(int idstudent, List<Indeks> indeks, String ime, String prezime, String srednjeIme, String jmbg,
			LocalDate datumRodjenja, String mestoRodjenja, String drzavaRodjenja, String drzavljanstvo, String nacionalnost,
			String pol, String adresaPrebivalista, String brTelefona, String emailFakultet, String emailPrivatan,
			String brojLicneKarte, String izdavacLicneKarte, float uspehSrednjaSkola, float uspehPrijemni,
			VisokoskolskaUstanova visokoskolskaUstanova, SrednjaSkola srSkola) {
		super();
		this.idstudent = idstudent;
		this.indeks = indeks;
		this.ime = ime;
		this.prezime = prezime;
		this.srednjeIme = srednjeIme;
		this.jmbg = jmbg;
		this.datumRodjenja = datumRodjenja;
		this.mestoRodjenja = mestoRodjenja;
		this.drzavaRodjenja = drzavaRodjenja;
		this.drzavljanstvo = drzavljanstvo;
		this.nacionalnost = nacionalnost;
		this.pol = pol;
		this.adresaPrebivalista = adresaPrebivalista;
		this.brTelefona = brTelefona;
		this.emailFakultet = emailFakultet;
		this.emailPrivatan = emailPrivatan;
		this.brojLicneKarte = brojLicneKarte;
		this.izdavacLicneKarte = izdavacLicneKarte;
		this.uspehSrednjaSkola = uspehSrednjaSkola;
		this.uspehPrijemni = uspehPrijemni;
		this.visokoskolskaUstanova = visokoskolskaUstanova;
		this.srSkola = srSkola;
	}

	public int getIdstudent() {
		return idstudent;
	}

	public void setIdstudent(int idstudent) {
		this.idstudent = idstudent;
	}

	public List<Indeks> getIndeks() {
		return indeks;
	}

	public void setIndeks(List<Indeks> indeks) {
		this.indeks = indeks;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getSrednjeIme() {
		return srednjeIme;
	}

	public void setSrednjeIme(String srednjeIme) {
		this.srednjeIme = srednjeIme;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String string) {
		this.jmbg = string;
	}

	public LocalDate getDatumRodjenja() {
		return datumRodjenja;
	}

	public void setDatumRodjenja(LocalDate datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	public String getMestoRodjenja() {
		return mestoRodjenja;
	}

	public void setMestoRodjenja(String mestoRodjenja) {
		this.mestoRodjenja = mestoRodjenja;
	}

	public String getDrzavaRodjenja() {
		return drzavaRodjenja;
	}

	public void setDrzavaRodjenja(String drzavaRodjenja) {
		this.drzavaRodjenja = drzavaRodjenja;
	}

	public String getDrzavljanstvo() {
		return drzavljanstvo;
	}

	public void setDrzavljanstvo(String drzavljanstvo) {
		this.drzavljanstvo = drzavljanstvo;
	}

	public String getNacionalnost() {
		return nacionalnost;
	}

	public void setNacionalnost(String nacionalnost) {
		this.nacionalnost = nacionalnost;
	}

	public String getPol() {
		return pol;
	}

	public void setPol(String pol) {
		this.pol = pol;
	}

	public String getAdresaPrebivalista() {
		return adresaPrebivalista;
	}

	public void setAdresaPrebivalista(String adresaPrebivalista) {
		this.adresaPrebivalista = adresaPrebivalista;
	}

	public String getBrTelefona() {
		return brTelefona;
	}

	public void setBrTelefona(String brTelefona) {
		this.brTelefona = brTelefona;
	}

	public String getEmailFakultet() {
		return emailFakultet;
	}

	public void setEmailFakultet(String emailFakultet) {
		this.emailFakultet = emailFakultet;
	}

	public String getEmailPrivatan() {
		return emailPrivatan;
	}

	public void setEmailPrivatan(String emailPrivatan) {
		this.emailPrivatan = emailPrivatan;
	}

	public String getBrojLicneKarte() {
		return brojLicneKarte;
	}

	public void setBrojLicneKarte(String brojLicneKarte) {
		this.brojLicneKarte = brojLicneKarte;
	}

	public String getIzdavacLicneKarte() {
		return izdavacLicneKarte;
	}

	public void setIzdavacLicneKarte(String izdavacLicneKarte) {
		this.izdavacLicneKarte = izdavacLicneKarte;
	}

	public float getUspehSrednjaSkola() {
		return uspehSrednjaSkola;
	}

	public void setUspehSrednjaSkola(float uspehSrednjaSkola) {
		this.uspehSrednjaSkola = uspehSrednjaSkola;
	}

	public float getUspehPrijemni() {
		return uspehPrijemni;
	}

	public void setUspehPrijemni(float uspehPrijemni) {
		this.uspehPrijemni = uspehPrijemni;
	}

	public VisokoskolskaUstanova getVisokoskolskaUstanova() {
		return visokoskolskaUstanova;
	}

	public void setVisokoskolskaUstanova(VisokoskolskaUstanova visokoskolskaUstanova) {
		this.visokoskolskaUstanova = visokoskolskaUstanova;
	}

	public SrednjaSkola getSrSkola() {
		return srSkola;
	}

	public void setSrSkola(SrednjaSkola srSkola) {
		this.srSkola = srSkola;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Student [idstudent=" + idstudent + ", indeks=" + indeks + ", ime=" + ime + ", prezime=" + prezime
				+ ", srednjeIme=" + srednjeIme + ", jmbg=" + jmbg + ", datumRodjenja=" + datumRodjenja
				+ ", mestoRodjenja=" + mestoRodjenja + ", drzavaRodjenja=" + drzavaRodjenja + ", drzavljanstvo="
				+ drzavljanstvo + ", nacionalnost=" + nacionalnost + ", pol=" + pol + ", adresaPrebivalista="
				+ adresaPrebivalista + ", brTelefona=" + brTelefona + ", emailFakultet=" + emailFakultet
				+ ", emailPrivatan=" + emailPrivatan + ", brojLicneKarte=" + brojLicneKarte + ", izdavacLicneKarte="
				+ izdavacLicneKarte + ", uspehSrednjaSkola=" + uspehSrednjaSkola + ", uspehPrijemni=" + uspehPrijemni
				+ ", visokoskolskaUstanova=" + visokoskolskaUstanova + ", srSkola=" + srSkola + "]";
	}
}