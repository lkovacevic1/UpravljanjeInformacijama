package studsluzba.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name = "Ispit.findAll", query = "SELECT i FROM Ispit i")
public class Ispit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idIspit;

	private LocalDate datumOdrzavanjaIspita;
	private int vremeOdrzavanjaIspita;
	private boolean zakljucenIspit;
	private String imeRoka;

	@ManyToOne
	@JoinColumn(name = "idPredmeta")
	private Predmet predmet;

	@ManyToOne
	@JoinColumn(name = "idNastavnik")
	private Nastavnik nastavnik;

	@ManyToOne
	@JoinColumn(name = "idIspitnogRoka")
	private IspitniRok ispitniRok;
	
	@OneToMany(mappedBy = "ispit")
	private List<PolozenPredmet> polozeniPredmet;

	@OneToMany(mappedBy = "ispit")
	private List<PrijavaIspita> prijavaIspita;

	public Ispit() {
		this.prijavaIspita = new ArrayList<PrijavaIspita>();
	}

	public Ispit(int idIspit, LocalDate datumOdrzavanjaIspita,
			int vremeOdrzavanjaIspita, boolean zakljucenIspit, Predmet predmet, Nastavnik nastavnik,
			IspitniRok ispitniRok, List<PolozenPredmet> polozeniPredmet, List<PrijavaIspita> prijavaIspita) {
		super();
		this.idIspit = idIspit;
		this.datumOdrzavanjaIspita = datumOdrzavanjaIspita;
		this.vremeOdrzavanjaIspita = vremeOdrzavanjaIspita;
		this.zakljucenIspit = zakljucenIspit;
		this.predmet = predmet;
		this.nastavnik = nastavnik;
		this.ispitniRok = ispitniRok;
		this.polozeniPredmet = polozeniPredmet;
		this.prijavaIspita = prijavaIspita;
	}

	public int getIdIspit() {
		return idIspit;
	}

	public void setIdIspit(int idIspit) {
		this.idIspit = idIspit;
	}

	public String getImeRoka() {
		return imeRoka;
	}

	public void setImeRoka(String imeRoka) {
		this.imeRoka = imeRoka;
	}

	public LocalDate getDatumOdrzavanjaIspita() {
		return datumOdrzavanjaIspita;
	}

	public void setDatumOdrzavanjaIspita(LocalDate datumOdrzavanjaIspita) {
		this.datumOdrzavanjaIspita = datumOdrzavanjaIspita;
	}

	public int getVremeOdrzavanjaIspita() {
		return vremeOdrzavanjaIspita;
	}

	public void setVremeOdrzavanjaIspita(int vremeOdrzavanjaIspita) {
		this.vremeOdrzavanjaIspita = vremeOdrzavanjaIspita;
	}

	public boolean isZakljucenIspit() {
		return zakljucenIspit;
	}

	public void setZakljucenIspit(boolean zakljucenIspit) {
		this.zakljucenIspit = zakljucenIspit;
	}

	public Predmet getPredmet() {
		return predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}

	public Nastavnik getNastavnik() {
		return nastavnik;
	}

	public void setNastavnik(Nastavnik nastavnik) {
		this.nastavnik = nastavnik;
	}

	public IspitniRok getIspitniRok() {
		return ispitniRok;
	}

	public void setIspitniRok(IspitniRok ispitniRok) {
		this.ispitniRok = ispitniRok;
	}

	public List<PolozenPredmet> getPolozeniPredmet() {
		return polozeniPredmet;
	}

	public void setPolozeniPredmet(List<PolozenPredmet> polozeniPredmet) {
		this.polozeniPredmet = polozeniPredmet;
	}

	public List<PrijavaIspita> getPrijavaIspita() {
		return prijavaIspita;
	}

	public void setPrijavaIspita(List<PrijavaIspita> prijavaIspita) {
		this.prijavaIspita = prijavaIspita;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		if(datumOdrzavanjaIspita == null && vremeOdrzavanjaIspita == 0)
			return imeRoka;
		else if(vremeOdrzavanjaIspita == 0)
			return imeRoka + ", " + datumOdrzavanjaIspita;
		else if(datumOdrzavanjaIspita == null)
			return imeRoka + ", " + vremeOdrzavanjaIspita;
		else
			return imeRoka + ", " + datumOdrzavanjaIspita + ", " + vremeOdrzavanjaIspita;
	}
	
}
