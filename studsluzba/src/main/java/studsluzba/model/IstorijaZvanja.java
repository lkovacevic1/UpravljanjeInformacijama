package studsluzba.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class IstorijaZvanja implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idIstorijeZvanja;
	
	private LocalDate datumIzboraZvanja;
	
	private String uzaNaucnaOblast;
	
	@ManyToOne
	@JoinColumn(name = "idZvanja")
	private Zvanje zvanje;
	
	@ManyToOne
	@JoinColumn(name = "idNastavnik")
	private Nastavnik nastavnik;
	
	public IstorijaZvanja() {
		
	}

	public IstorijaZvanja(int idIstorijeZvanja, LocalDate datumIzboraZvanja, String uzaNaucnaOblast, Zvanje zvanje,
			Nastavnik nastavnik) {
		super();
		this.idIstorijeZvanja = idIstorijeZvanja;
		this.datumIzboraZvanja = datumIzboraZvanja;
		this.uzaNaucnaOblast = uzaNaucnaOblast;
		this.zvanje = zvanje;
		this.nastavnik = nastavnik;
	}

	public int getIdIstorijeZvanja() {
		return idIstorijeZvanja;
	}

	public void setIdIstorijeZvanja(int idIstorijeZvanja) {
		this.idIstorijeZvanja = idIstorijeZvanja;
	}

	public LocalDate getDatumIzboraZvanja() {
		return datumIzboraZvanja;
	}

	public void setDatumIzboraZvanja(LocalDate datumIzboraZvanja) {
		this.datumIzboraZvanja = datumIzboraZvanja;
	}

	public String getUzaNaucnaOblast() {
		return uzaNaucnaOblast;
	}

	public void setUzaNaucnaOblast(String uzaNaucnaOblast) {
		this.uzaNaucnaOblast = uzaNaucnaOblast;
	}

	public Zvanje getZvanje() {
		return zvanje;
	}

	public void setZvanje(Zvanje zvanje) {
		this.zvanje = zvanje;
	}

	public Nastavnik getNastavnik() {
		return nastavnik;
	}

	public void setNastavnik(Nastavnik nastavnik) {
		this.nastavnik = nastavnik;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "IstorijaZvanja [idIstorijeZvanja=" + idIstorijeZvanja + ", datumIzboraZvanja=" + datumIzboraZvanja
				+ ", uzaNaucnaOblast=" + uzaNaucnaOblast + "]";
	}

}
