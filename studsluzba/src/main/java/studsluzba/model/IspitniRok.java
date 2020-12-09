package studsluzba.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
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
@NamedQuery(name = "IspitniRok.findAll", query = "SELECT i FROM IspitniRok i")
public class IspitniRok implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idIspitnogRoka;

	private LocalDate datumPocetkaIspitnogRoka;
	private LocalDate datumZavrsetkaIspitnogRoka;
	private String imeRoka;

	@OneToMany(mappedBy = "ispitniRok")
	private List<Ispit> ispiti;

	@ManyToOne
	@JoinColumn(name = "idSkolskeGodine")
	private SkolskaGodina skolskaGodina;

	public IspitniRok() {
		this.ispiti = new ArrayList<Ispit>();
	}

	public IspitniRok(int idIspitnogRoka, LocalDate datumPocetkaIspitnogRoka, LocalDate datumZavrsetkaIspitnogRoka,
			List<Ispit> ispiti, SkolskaGodina skolskaGodina, String imeRoka) {
		super();
		this.idIspitnogRoka = idIspitnogRoka;
		this.datumPocetkaIspitnogRoka = datumPocetkaIspitnogRoka;
		this.datumZavrsetkaIspitnogRoka = datumZavrsetkaIspitnogRoka;
		this.ispiti = ispiti;
		this.skolskaGodina = skolskaGodina;
		this.imeRoka = imeRoka;
	}

	public String getImeRoka() {
		return imeRoka;
	}

	public void setImeRoka(String imeRoka) {
		this.imeRoka = imeRoka;
	}

	public int getIdIspitnogRoka() {
		return idIspitnogRoka;
	}

	public void setIdIspitnogRoka(int idIspitnogRoka) {
		this.idIspitnogRoka = idIspitnogRoka;
	}

	public LocalDate getDatumPocetkaIspitnogRoka() {
		return datumPocetkaIspitnogRoka;
	}

	public void setDatumPocetkaIspitnogRoka(LocalDate datumPocetkaIspitnogRoka) {
		this.datumPocetkaIspitnogRoka = datumPocetkaIspitnogRoka;
	}

	public LocalDate getDatumZavrsetkaIspitnogRoka() {
		return datumZavrsetkaIspitnogRoka;
	}

	public void setDatumZavrsetkaIspitnogRoka(LocalDate datumZavrsetkaIspitnogRoka) {
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
		return datumPocetkaIspitnogRoka + ", " + datumZavrsetkaIspitnogRoka;
	}
}
