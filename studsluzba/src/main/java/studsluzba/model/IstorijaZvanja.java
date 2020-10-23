package studsluzba.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
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
	
	private Date datumIzboraZvanja;
	
	private String uzaNaucnaOblast;
	
	@ManyToOne
	@JoinColumn(name = "idZvanja")
	private Zvanje zvanje;
	
	@ManyToOne
	@JoinColumn(name = "idNastavnik")
	private Nastavnik nastavnik;
	
	public IstorijaZvanja() {
		
	}

	public IstorijaZvanja(int idIstorijeZvanja, Date datumIzboraZvanja, String uzaNaucnaOblast, Zvanje zvanje,
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

	public Date getDatumIzboraZvanja() {
		return datumIzboraZvanja;
	}

	public void setDatumIzboraZvanja(Date datumIzboraZvanja) {
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
				+ ", uzaNaucnaOblast=" + uzaNaucnaOblast + ", zvanje=" + zvanje + ", nastavnik=" + nastavnik + "]";
	}
}
