package studsluzba.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name="Nastavnik.findAll", query="SELECT n FROM Nastavnik n")
public class Nastavnik implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idNastavnik;
	
	private String ime;
	private String prezime;
	private String srednjeIme;
	private String email;
	private String zavrsenaVisokoskolskaUstanova;
	
	@ManyToOne
	@JoinColumn(name = "idZvanja")
	private Zvanje zvanje;
	
	@OneToMany(mappedBy="nastavnik")
	private List<IstorijaZvanja> istorijeZvanja;
	
	@ManyToMany
	@JoinColumn(name="idSkolskeGodine")
	private List<SkolskaGodina> skolskeGodine;
	
	public Nastavnik() {
		
	}
	
	public Nastavnik(int idNastavnik, String ime, String prezime, String srednjeIme, String email,
			String zavrsenaVisokoskolskaUstanova, Zvanje zvanje, List<IstorijaZvanja> istorijeZvanja) {
		super();
		this.idNastavnik = idNastavnik;
		this.ime = ime;
		this.prezime = prezime;
		this.srednjeIme = srednjeIme;
		this.email = email;
		this.zavrsenaVisokoskolskaUstanova = zavrsenaVisokoskolskaUstanova;
		this.zvanje = zvanje;
		this.istorijeZvanja = istorijeZvanja;
	}

	public int getIdNastavnik() {
		return idNastavnik;
	}

	public void setIdNastavnik(int idNastavnik) {
		this.idNastavnik = idNastavnik;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getZavrsenaVisokoskolskaUstanova() {
		return zavrsenaVisokoskolskaUstanova;
	}

	public void setZavrsenaVisokoskolskaUstanova(String zavrsenaVisokoskolskaUstanova) {
		this.zavrsenaVisokoskolskaUstanova = zavrsenaVisokoskolskaUstanova;
	}

	public Zvanje getZvanje() {
		return zvanje;
	}

	public void setZvanje(Zvanje zvanje) {
		this.zvanje = zvanje;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<IstorijaZvanja> getIstorijeZvanja() {
		return istorijeZvanja;
	}

	public void setIstorijeZvanja(List<IstorijaZvanja> istorijeZvanja) {
		this.istorijeZvanja = istorijeZvanja;
	}

	@Override
	public String toString() {
		return "Nastavnik [idNastavnik=" + idNastavnik + ", ime=" + ime + ", prezime=" + prezime + ", srednjeIme="
				+ srednjeIme + ", email=" + email + ", zavrsenaVisokoskolskaUstanova=" + zavrsenaVisokoskolskaUstanova
				+ ", zvanje=" + zvanje + ", istorijeZvanja=" + istorijeZvanja + "]";
	}
}
