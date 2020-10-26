package studsluzba.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name="IspitniRok.findAll", query="SELECT i FROM IspitniRok i")
public class IspitniRok implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idIspitnogRoka;
	
	private Date datumPocetkaIspitnogRoka;
	private Date datumZavrsetkaIspitnogRoka;
	
	@OneToMany(mappedBy="ispitniRok")
	private List<Ispit> ispiti;
	
	@ManyToOne
	@JoinColumn(name = "idSkolskeGodine")
	private SkolskaGodina skolskaGodina;
	
	public IspitniRok() {
		
	}

	public IspitniRok(int idIspitnogRoka, Date datumPocetkaIspitnogRoka, Date datumZavrsetkaIspitnogRoka,
			List<Ispit> ispiti, SkolskaGodina skolskaGodina) {
		super();
		this.idIspitnogRoka = idIspitnogRoka;
		this.datumPocetkaIspitnogRoka = datumPocetkaIspitnogRoka;
		this.datumZavrsetkaIspitnogRoka = datumZavrsetkaIspitnogRoka;
		this.ispiti = ispiti;
		this.skolskaGodina = skolskaGodina;
	}

	public int getIdIspitnogRoka() {
		return idIspitnogRoka;
	}

	public void setIdIspitnogRoka(int idIspitnogRoka) {
		this.idIspitnogRoka = idIspitnogRoka;
	}

	public Date getDatumPocetkaIspitnogRoka() {
		return datumPocetkaIspitnogRoka;
	}

	public void setDatumPocetkaIspitnogRoka(Date datumPocetkaIspitnogRoka) {
		this.datumPocetkaIspitnogRoka = datumPocetkaIspitnogRoka;
	}

	public Date getDatumZavrsetkaIspitnogRoka() {
		return datumZavrsetkaIspitnogRoka;
	}

	public void setDatumZavrsetkaIspitnogRoka(Date datumZavrsetkaIspitnogRoka) {
		this.datumZavrsetkaIspitnogRoka = datumZavrsetkaIspitnogRoka;
	}

	public List<Ispit> getIspiti() {
		return ispiti;
	}

	public void setIspiti(List<Ispit> ispiti) {
		this.ispiti = ispiti;
	}

	public SkolskaGodina getSkolskaGodina() {
		return skolskaGodina;
	}

	public void setSkolskaGodina(SkolskaGodina skolskaGodina) {
		this.skolskaGodina = skolskaGodina;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "IspitniRok [idIspitnogRoka=" + idIspitnogRoka + ", datumPocetkaIspitnogRoka=" + datumPocetkaIspitnogRoka
				+ ", datumZavrsetkaIspitnogRoka=" + datumZavrsetkaIspitnogRoka + ", ispiti=" + ispiti
				+ ", skolskaGodina=" + skolskaGodina + "]";
	}
}
