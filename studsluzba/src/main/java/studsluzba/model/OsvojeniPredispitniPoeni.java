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
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="OsvojeniPredispitniPoeni.findAll", query="SELECT o FROM OsvojeniPredispitniPoeni o")
public class OsvojeniPredispitniPoeni implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idOsvojeniPredispitniPoeni;
	
	private int osvojeniPredispitniPoeni;
	
	@ManyToOne
	@JoinColumn(name = "idPredispitnihObaveza")
	private PredispitneObaveze predispitneObaveze;
	 
	@ManyToOne
	@JoinColumn(name = "idIndeks")
	private Indeks indeks;
	
	public OsvojeniPredispitniPoeni() {
		
	}

	public OsvojeniPredispitniPoeni(int idOsvojeniPredispitniPoeni, PredispitneObaveze predispitneObaveze,
			Indeks indeks, int osvojeniPredispitniPoeni) {
		super();
		this.idOsvojeniPredispitniPoeni = idOsvojeniPredispitniPoeni;
		this.predispitneObaveze = predispitneObaveze;
		this.indeks = indeks;
		this.osvojeniPredispitniPoeni = osvojeniPredispitniPoeni;
	}
	
	

	public int getOsvojeniPredispitniPoeni() {
		return osvojeniPredispitniPoeni;
	}

	public void setOsvojeniPredispitniPoeni(int osvojeniPredispitniPoeni) {
		this.osvojeniPredispitniPoeni = osvojeniPredispitniPoeni;
	}

	public int getIdOsvojeniPredispitniPoeni() {
		return idOsvojeniPredispitniPoeni;
	}

	public void setIdOsvojeniPredispitniPoeni(int idOsvojeniPredispitniPoeni) {
		this.idOsvojeniPredispitniPoeni = idOsvojeniPredispitniPoeni;
	}

	public PredispitneObaveze getPredispitneObaveze() {
		return predispitneObaveze;
	}

	public void setPredispitneObaveze(PredispitneObaveze predispitneObaveze) {
		this.predispitneObaveze = predispitneObaveze;
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
		return "OsvojeniPredispitniPoeni [idOsvojeniPredispitniPoeni=" + idOsvojeniPredispitniPoeni
				+ ", osvojeniPredispitniPoeni=" + osvojeniPredispitniPoeni + ", predispitneObaveze="
				+ predispitneObaveze + ", indeks=" + indeks + "]";
	}
}
