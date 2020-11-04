package studsluzba.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name = "Nastavnik.findAll", query = "SELECT n FROM Nastavnik n")
public class Nastavnik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idNastavnik;

	private String ime;
	private String prezime;
	private String srednjeIme;
	private String email;
	private String zavrsenaVisokoskolskaUstanova;

	@ManyToOne
	@JoinColumn(name = "idZvanja")
	private Zvanje zvanje;

	@OneToMany(mappedBy = "nastavnik")
	private List<IstorijaZvanja> istorijeZvanja;

	@OneToMany(mappedBy = "nastavnik")
	private List<DrziPredmet> drziPredmete;

	@OneToMany
	@JoinColumn(name = "idPredispitnihObaveza")
	private List<PredispitneObaveze> predispitneObaveze;

	@OneToMany
	@JoinColumn(name = "idIspit")
	private List<Ispit> ispiti;

	public Nastavnik() {
		this.istorijeZvanja = new ArrayList<IstorijaZvanja>();
		this.drziPredmete = new ArrayList<DrziPredmet>();
		this.predispitneObaveze = new ArrayList<PredispitneObaveze>();
		this.ispiti = new ArrayList<Ispit>();
	}

	public Nastavnik(int idNastavnik, String ime, String prezime, String srednjeIme, String email,
			String zavrsenaVisokoskolskaUstanova, Zvanje zvanje, List<IstorijaZvanja> istorijeZvanja,
			List<DrziPredmet> drziPredmete,
			List<PredispitneObaveze> predispitneObaveze, List<Ispit> ispiti) {
		super();
		this.idNastavnik = idNastavnik;
		this.ime = ime;
		this.prezime = prezime;
		this.srednjeIme = srednjeIme;
		this.email = email;
		this.zavrsenaVisokoskolskaUstanova = zavrsenaVisokoskolskaUstanova;
		this.zvanje = zvanje;
		this.istorijeZvanja = istorijeZvanja;
		this.drziPredmete = drziPredmete;
		this.predispitneObaveze = predispitneObaveze;
		this.ispiti = ispiti;
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

	public List<IstorijaZvanja> getIstorijeZvanja() {
		return istorijeZvanja;
	}

	public void setIstorijeZvanja(List<IstorijaZvanja> istorijeZvanja) {
		this.istorijeZvanja = istorijeZvanja;
	}

	public List<DrziPredmet> getDrziPredmete() {
		return drziPredmete;
	}

	public void setDrziPredmete(List<DrziPredmet> drziPredmete) {
		this.drziPredmete = drziPredmete;
	}

	public List<PredispitneObaveze> getPredispitneObaveze() {
		return predispitneObaveze;
	}

	public void setPredispitneObaveze(List<PredispitneObaveze> predispitneObaveze) {
		this.predispitneObaveze = predispitneObaveze;
	}

	public List<Ispit> getIspiti() {
		return ispiti;
	}

	public void setIspiti(List<Ispit> ispiti) {
		this.ispiti = ispiti;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Nastavnik [idNastavnik=" + idNastavnik + ", ime=" + ime + ", prezime=" + prezime + ", srednjeIme="
				+ srednjeIme + ", email=" + email + ", zavrsenaVisokoskolskaUstanova=" + zavrsenaVisokoskolskaUstanova
				+ "]";
	}
}
