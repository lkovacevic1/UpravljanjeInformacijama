package studsluzba.model;

import java.io.Serializable;

import javax.persistence.Entity;
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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPolozenPredmet;

	private boolean polozen;
	
	private int ocena;
	
	@ManyToOne
	@JoinColumn(name = "idIndeks")
	private Indeks indeks;
	
	@ManyToOne
	@JoinColumn(name = "idPredmeta")
	private Predmet predmet;
	
	@OneToOne
	@JoinColumn(name = "idIspit")
	private Ispit ispit;
	
	public PolozenPredmet() {
		
	}

	public PolozenPredmet(int idPolozenPredmet, boolean polozen, int ocena, Indeks indeks, Predmet predmet,
			Ispit ispit) {
		super();
		this.idPolozenPredmet = idPolozenPredmet;
		this.polozen = polozen;
		this.ocena = ocena;
		this.indeks = indeks;
		this.predmet = predmet;
		this.ispit = ispit;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "PolozenPredmet [idPolozenPredmet=" + idPolozenPredmet + ", polozen=" + polozen + ", ocena=" + ocena
				+ ", indeks=" + indeks + ", predmet=" + predmet + ", ispit=" + ispit + "]";
	}
}
