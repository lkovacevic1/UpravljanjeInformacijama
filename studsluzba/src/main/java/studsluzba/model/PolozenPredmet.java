package studsluzba.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class PolozenPredmet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPolozenPredmet;

	private boolean polozen;
	private float osvojeniPoeniNaIspitu;
	private int ocena;

	@ManyToOne
	@JoinColumn(name = "idIndeks")
	private Indeks indeks;

	@ManyToOne
	@JoinColumn(name = "idPredmeta")
	private Predmet predmet;

	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "idIspit")
	private Ispit ispit;
	
	@OneToOne(mappedBy = "polozenPredmet")
	private IzlazakNaIspit izlazakNaIspit;

	public PolozenPredmet() {

	}

	public PolozenPredmet(int idPolozenPredmet, boolean polozen, int ocena, Indeks indeks, Predmet predmet,
			Ispit ispit, int osvojeniPoeniNaIspitu, IzlazakNaIspit izlazakNaIspit) {
		super();
		this.idPolozenPredmet = idPolozenPredmet;
		this.polozen = polozen;
		this.ocena = ocena;
		this.indeks = indeks;
		this.predmet = predmet;
		this.ispit = ispit;
		this.osvojeniPoeniNaIspitu = osvojeniPoeniNaIspitu;
		this.izlazakNaIspit = izlazakNaIspit;
	}

	public float getOsvojeniPoeniNaIspitu() {
		return osvojeniPoeniNaIspitu;
	}

	public void setOsvojeniPoeniNaIspitu(float osvojeniPoeniNaIspitu) {
		this.osvojeniPoeniNaIspitu = osvojeniPoeniNaIspitu;
	}

	public int getIdPolozenPredmet() {
		return idPolozenPredmet;
	}

	public void setIdPolozenPredmet(int idPolozenPredmet) {
		this.idPolozenPredmet = idPolozenPredmet;
	}

	public boolean isPolozen() {
		return polozen;
	}

	public void setPolozen(boolean polozen) {
		this.polozen = polozen;
	}

	public int getOcena() {
		return ocena;
	}

	public void setOcena(int ocena) {
		this.ocena = ocena;
	}

	public Indeks getIndeks() {
		return indeks;
	}

	public void setIndeks(Indeks indeks) {
		this.indeks = indeks;
	}

	public Predmet getPredmet() {
		return predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}

	public Ispit getIspit() {
		return ispit;
	}

	public void setIspit(Ispit ispit) {
		this.ispit = ispit;
	}
	
	public IzlazakNaIspit getIzlazakNaIspit() {
		return izlazakNaIspit;
	}

	public void setIzlazakNaIspit(IzlazakNaIspit izlazakNaIspit) {
		this.izlazakNaIspit = izlazakNaIspit;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String getImePredmeta() {
		return predmet.getNazivPredmeta();
	}
	

	@Override
	public String toString() {
		return "PolozenPredmet [idPolozenPredmet=" + idPolozenPredmet + ", polozen=" + polozen
				+ ", osvojeniPoeniNaIspitu=" + osvojeniPoeniNaIspitu + ", ocena=" + ocena + ", indeks=" + indeks
				+ ", predmet=" + predmet + ", ispit=" + ispit + ", izlazakNaIspit=" + izlazakNaIspit + "]";
	}

}
