package studsluzba.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@NamedQuery(name = "IzlazakNaIspit.findAll", query = "SELECT i FROM IzlazakNaIspit i")
public class IzlazakNaIspit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idIzlazakNaIspit;

	@OneToOne(orphanRemoval = true)
	@JoinColumn(name = "idPrijavaIspita")
	private PrijavaIspita prijavaIspita;

	private boolean ponistavaIspit;

	private String napomena;

	public IzlazakNaIspit() {

	}

	public IzlazakNaIspit(int idIzlazakNaIspit, PrijavaIspita prijavaIspita, boolean ponistavaIspit, String napomena) {
		super();
		this.idIzlazakNaIspit = idIzlazakNaIspit;
		this.prijavaIspita = prijavaIspita;
		this.ponistavaIspit = ponistavaIspit;
		this.napomena = napomena;
	}

	public int getIdIzlazakNaIspit() {
		return idIzlazakNaIspit;
	}

	public void setIdIzlazakNaIspit(int idIzlazakNaIspit) {
		this.idIzlazakNaIspit = idIzlazakNaIspit;
	}

	public PrijavaIspita getPrijavaIspita() {
		return prijavaIspita;
	}

	public void setPrijavaIspita(PrijavaIspita prijavaIspita) {
		this.prijavaIspita = prijavaIspita;
	}

	public boolean isPonistavaIspit() {
		return ponistavaIspit;
	}

	public void setPonistavaIspit(boolean ponistavaIspit) {
		this.ponistavaIspit = ponistavaIspit;
	}

	public String getNapomena() {
		return napomena;
	}

	public void setNapomena(String napomena) {
		this.napomena = napomena;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "IzlazakNaIspit [idIzlazakNaIspit=" + idIzlazakNaIspit + ", ponistavaIspit=" + ponistavaIspit
				+ ", napomena=" + napomena + "]";
	}

	
}
