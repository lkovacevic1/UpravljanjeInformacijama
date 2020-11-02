package studsluzba.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@NamedQuery(name="PrijavaIspita.findAll", query="SELECT p FROM PrijavaIspita p")
public class PrijavaIspita implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPrijavaIspita;
	
	private LocalDate datumPrijaveIspita;
	
	@ManyToOne
	@JoinColumn(name = "idIspit")
	private Ispit ispit;
	
	@ManyToOne
	@JoinColumn(name = "idIndeks")
	private Indeks indeks;
	
	@OneToOne(mappedBy = "prijavaIspita")
	private IzlazakNaIspit izlazakNaIspit;

	public PrijavaIspita() {
		
	}

	public PrijavaIspita(int idPrijavaIspita, LocalDate datumPrijaveIspita, Ispit ispit, Indeks indeks,
			IzlazakNaIspit izlazakNaIspit) {
		super();
		this.idPrijavaIspita = idPrijavaIspita;
		this.datumPrijaveIspita = datumPrijaveIspita;
		this.ispit = ispit;
		this.indeks = indeks;
		this.izlazakNaIspit = izlazakNaIspit;
	}

	public int getIdPrijavaIspita() {
		return idPrijavaIspita;
	}

	public void setIdPrijavaIspita(int idPrijavaIspita) {
		this.idPrijavaIspita = idPrijavaIspita;
	}

	public LocalDate getDatumPrijaveIspita() {
		return datumPrijaveIspita;
	}

	public void setDatumPrijaveIspita(LocalDate datumPrijaveIspita) {
		this.datumPrijaveIspita = datumPrijaveIspita;
	}

	public Ispit getIspit() {
		return ispit;
	}

	public void setIspit(Ispit ispit) {
		this.ispit = ispit;
	}

	public Indeks getIndeks() {
		return indeks;
	}

	public void setIndeks(Indeks indeks) {
		this.indeks = indeks;
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

	@Override
	public String toString() {
		return "PrijavaIspita [idPrijavaIspita=" + idPrijavaIspita + ", datumPrijaveIspita=" + datumPrijaveIspita
				+ ", ispit=" + ispit + ", indeks=" + indeks + ", izlazakNaIspit=" + izlazakNaIspit + "]";
	}
}
