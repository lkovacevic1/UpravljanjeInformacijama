package studsluzba.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class AktivnostStudenta {
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected int idAktivnostiStudenta;
	
	protected LocalDate datum;
	
	protected String napomena;
	
	@ManyToOne
	@JoinColumn(name = "idIndeks")
	protected Indeks indeks;

	public AktivnostStudenta() {
		
	}

	public AktivnostStudenta(int idAktivnostiStudenta, LocalDate datum, String napomena, Indeks indeks) {
		super();
		this.idAktivnostiStudenta = idAktivnostiStudenta;
		this.datum = datum;
		this.napomena = napomena;
		this.indeks = indeks;
	}



	public int getIdAktivnostiStudenta() {
		return idAktivnostiStudenta;
	}

	public void setIdAktivnostiStudenta(int idAktivnostiStudenta) {
		this.idAktivnostiStudenta = idAktivnostiStudenta;
	}

	public LocalDate getDatum() {
		return datum;
	}

	public void setDatum(LocalDate datum) {
		this.datum = datum;
	}

	public String getNapomena() {
		return napomena;
	}

	public void setNapomena(String napomena) {
		this.napomena = napomena;
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
		return "AktivnostStudenta [idAktivnostiStudenta=" + idAktivnostiStudenta + ", datum=" + datum + ", napomena="
				+ napomena + "]";
	}
	
}
