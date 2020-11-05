package studsluzba.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class DrziPredmet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDrziPredmet;

	@ManyToOne
	@JoinColumn(name = "idNastavnik")
	private Nastavnik nastavnik;

	@ManyToOne
	@JoinColumn(name = "idSkolskeGodine")
	private SkolskaGodina skolskaGodina;

	@ManyToOne
	@JoinColumn(name = "idPredmeta")
	private Predmet predmet;

	@ManyToMany
	@JoinColumn(name = "idIndeks")
	private List<Indeks> indeksi;

	public DrziPredmet() {

		this.indeksi = new ArrayList<Indeks>();
	}

	public DrziPredmet(int idDrziPredmet, Nastavnik nastavnik, SkolskaGodina skolskaGodina, Predmet predmet,
			List<Indeks> indeksi) {
		super();
		this.idDrziPredmet = idDrziPredmet;
		this.nastavnik = nastavnik;
		this.skolskaGodina = skolskaGodina;
		this.predmet = predmet;
		this.indeksi = indeksi;
	}

	public int getIdDrziPredmet() {
		return idDrziPredmet;
	}

	public void setIdDrziPredmet(int idDrziPredmet) {
		this.idDrziPredmet = idDrziPredmet;
	}

	public Nastavnik getNastavnik() {
		return nastavnik;
	}

	public void setNastavnik(Nastavnik nastavnik) {
		this.nastavnik = nastavnik;
	}

	public SkolskaGodina getSkolskaGodina() {
		return skolskaGodina;
	}

	public void setSkolskaGodina(SkolskaGodina skolskaGodina) {
		this.skolskaGodina = skolskaGodina;
	}

	public Predmet getPredmet() {
		return predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}

	public List<Indeks> getIndeksi() {
		return indeksi;
	}

	public void setIndeksi(List<Indeks> indeksi) {
		this.indeksi = indeksi;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "DrziPredmet [idDrziPredmet=" + idDrziPredmet + ", nastavnik=" + nastavnik + ", skolskaGodina="
				+ skolskaGodina + ", predmet=" + predmet + "]";
	}
}
