package studsluzba.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class DrziPredmet implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
	
	@ManyToOne
	@JoinColumn(name = "idIndeks")
	private Indeks indeks;

	public DrziPredmet() {
		
	}

	public DrziPredmet(int idDrziPredmet, Nastavnik nastavnik, SkolskaGodina skolskaGodina, Predmet predmet,
			Indeks indeks) {
		super();
		this.idDrziPredmet = idDrziPredmet;
		this.nastavnik = nastavnik;
		this.skolskaGodina = skolskaGodina;
		this.predmet = predmet;
		this.indeks = indeks;
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

	public Indeks getIndeks() {
		return indeks;
	}

	public void setIndeks(Indeks indeks) {
		this.indeks = indeks;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "DrziPredmet [idDrziPredmet=" + idDrziPredmet + ", nastavnik=" + nastavnik + ", skolskaGodina="
				+ skolskaGodina + ", predmet=" + predmet + ", indeks=" + indeks + "]";
	}
}
