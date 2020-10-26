package studsluzba.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class UpisGodine  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUpisGodine;
	
	private Date godinaKojaSeUpisuje;
	
	@OneToMany(mappedBy = "upisGodine")
	private List<Predmet> predmet;
	
	@OneToMany(mappedBy = "upisGodine")
	private List<Indeks> indeksi;
	
	private String napomena;
	
	private Date datumUpisaGodine;
	
	public UpisGodine() {
		
	}

	public UpisGodine(int idUpisGodine, Date godinaKojaSeUpisuje, List<Predmet> predmet, List<Indeks> indeksi,
			String napomena, Date datumUpisaGodine) {
		super();
		this.idUpisGodine = idUpisGodine;
		this.godinaKojaSeUpisuje = godinaKojaSeUpisuje;
		this.predmet = predmet;
		this.indeksi = indeksi;
		this.napomena = napomena;
		this.datumUpisaGodine = datumUpisaGodine;
	}

	public int getIdUpisGodine() {
		return idUpisGodine;
	}

	public void setIdUpisGodine(int idUpisGodine) {
		this.idUpisGodine = idUpisGodine;
	}

	public Date getGodinaKojaSeUpisuje() {
		return godinaKojaSeUpisuje;
	}

	public void setGodinaKojaSeUpisuje(Date godinaKojaSeUpisuje) {
		this.godinaKojaSeUpisuje = godinaKojaSeUpisuje;
	}

	public List<Predmet> getPredmet() {
		return predmet;
	}

	public void setPredmet(List<Predmet> predmet) {
		this.predmet = predmet;
	}

	public List<Indeks> getIndeksi() {
		return indeksi;
	}

	public void setIndeksi(List<Indeks> indeksi) {
		this.indeksi = indeksi;
	}

	public String getNapomena() {
		return napomena;
	}

	public void setNapomena(String napomena) {
		this.napomena = napomena;
	}

	public Date getDatumUpisaGodine() {
		return datumUpisaGodine;
	}

	public void setDatumUpisaGodine(Date datumUpisaGodine) {
		this.datumUpisaGodine = datumUpisaGodine;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "UpisGodine [idUpisGodine=" + idUpisGodine + ", godinaKojaSeUpisuje=" + godinaKojaSeUpisuje
				+ ", predmet=" + predmet + ", indeksi=" + indeksi + ", napomena=" + napomena + ", datumUpisaGodine="
				+ datumUpisaGodine + "]";
	}
}
