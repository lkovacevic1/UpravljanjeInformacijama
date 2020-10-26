package studsluzba.model;

import java.io.Serializable;
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
@NamedQuery(name="PredispitneObaveze.findAll", query="SELECT p FROM PredispitneObaveze p")
public class PredispitneObaveze implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPredispitnihObaveza;
	
	
	private String vrstaPredispitnihObaveza;
	private int maxBrPredispitnihPoena;
	
	@ManyToOne
	@JoinColumn(name = "idPredmeta")
	private Predmet predmet;
	
	@ManyToOne
	@JoinColumn(name = "idSkolskeGodine")
	private SkolskaGodina skolskaGodina;

	@ManyToOne
	@JoinColumn(name = "idNastavnik")
	private Nastavnik nastavnik;
	
	@OneToMany(mappedBy = "predispitneObaveze")
	private List<OsvojeniPredispitniPoeni> osvojeniPredispitniPoeni;
	
	public PredispitneObaveze() {
		
	}

	public PredispitneObaveze(int idPredispitnihObaveza, String vrstaPredispitnihObaveza, int maxBrPredispitnihPoena,
			Predmet predmet, SkolskaGodina skolskaGodina, Nastavnik nastavnik,
			List<OsvojeniPredispitniPoeni> osvojeniPredispitniPoeni) {
		super();
		this.idPredispitnihObaveza = idPredispitnihObaveza;
		this.vrstaPredispitnihObaveza = vrstaPredispitnihObaveza;
		this.maxBrPredispitnihPoena = maxBrPredispitnihPoena;
		this.predmet = predmet;
		this.skolskaGodina = skolskaGodina;
		this.nastavnik = nastavnik;
		this.osvojeniPredispitniPoeni = osvojeniPredispitniPoeni;
	}

	public int getIdPredispitnihObaveza() {
		return idPredispitnihObaveza;
	}

	public void setIdPredispitnihObaveza(int idPredispitnihObaveza) {
		this.idPredispitnihObaveza = idPredispitnihObaveza;
	}

	public String getVrstaPredispitnihObaveza() {
		return vrstaPredispitnihObaveza;
	}

	public void setVrstaPredispitnihObaveza(String vrstaPredispitnihObaveza) {
		this.vrstaPredispitnihObaveza = vrstaPredispitnihObaveza;
	}

	public int getMaxBrPredispitnihPoena() {
		return maxBrPredispitnihPoena;
	}

	public void setMaxBrPredispitnihPoena(int maxBrPredispitnihPoena) {
		this.maxBrPredispitnihPoena = maxBrPredispitnihPoena;
	}

	public Predmet getPredmet() {
		return predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}

	public SkolskaGodina getSkolskaGodina() {
		return skolskaGodina;
	}

	public void setSkolskaGodina(SkolskaGodina skolskaGodina) {
		this.skolskaGodina = skolskaGodina;
	}

	public Nastavnik getNastavnik() {
		return nastavnik;
	}

	public void setNastavnik(Nastavnik nastavnik) {
		this.nastavnik = nastavnik;
	}

	public List<OsvojeniPredispitniPoeni> getOsvojeniPredispitniPoeni() {
		return osvojeniPredispitniPoeni;
	}

	public void setOsvojeniPredispitniPoeni(List<OsvojeniPredispitniPoeni> osvojeniPredispitniPoeni) {
		this.osvojeniPredispitniPoeni = osvojeniPredispitniPoeni;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "PredispitneObaveze [idPredispitnihObaveza=" + idPredispitnihObaveza + ", vrstaPredispitnihObaveza="
				+ vrstaPredispitnihObaveza + ", maxBrPredispitnihPoena=" + maxBrPredispitnihPoena + ", predmet="
				+ predmet + ", skolskaGodina=" + skolskaGodina + ", nastavnik=" + nastavnik
				+ ", osvojeniPredispitniPoeni=" + osvojeniPredispitniPoeni + "]";
	}
}
