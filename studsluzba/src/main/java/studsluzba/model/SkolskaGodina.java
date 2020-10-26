package studsluzba.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class SkolskaGodina  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSkolskeGodine;
	
	private Date skolskaGodina;
	
	private boolean aktivna;
	
	@ManyToMany(mappedBy = "skolskeGodine")
	private List<Nastavnik> nastavnici;
	
	@OneToMany(mappedBy = "skolskaGodina")
	private List<IspitniRok> ispitniRokovi;
	
	@OneToMany(mappedBy = "skolskaGodina")
	private List<PredispitneObaveze> predispitneObaveze;
	
	@OneToMany(mappedBy = "skolskaGodina")
	private List<DrziPredmet> drziPredmete;
	
	public SkolskaGodina() {
		
	}

	public SkolskaGodina(int idSkolskeGodine, Date skolskaGodina, boolean aktivna, List<Nastavnik> nastavnici,
			List<IspitniRok> ispitniRokovi, List<PredispitneObaveze> predispitneObaveze,
			List<DrziPredmet> drziPredmete) {
		super();
		this.idSkolskeGodine = idSkolskeGodine;
		this.skolskaGodina = skolskaGodina;
		this.aktivna = aktivna;
		this.nastavnici = nastavnici;
		this.ispitniRokovi = ispitniRokovi;
		this.predispitneObaveze = predispitneObaveze;
		this.drziPredmete = drziPredmete;
	}

	public int getIdSkolskeGodine() {
		return idSkolskeGodine;
	}

	public void setIdSkolskeGodine(int idSkolskeGodine) {
		this.idSkolskeGodine = idSkolskeGodine;
	}

	public Date getSkolskaGodina() {
		return skolskaGodina;
	}

	public void setSkolskaGodina(Date skolskaGodina) {
		this.skolskaGodina = skolskaGodina;
	}

	public boolean isAktivna() {
		return aktivna;
	}

	public void setAktivna(boolean aktivna) {
		this.aktivna = aktivna;
	}

	public List<Nastavnik> getNastavnici() {
		return nastavnici;
	}

	public void setNastavnici(List<Nastavnik> nastavnici) {
		this.nastavnici = nastavnici;
	}

	public List<IspitniRok> getIspitniRokovi() {
		return ispitniRokovi;
	}

	public void setIspitniRokovi(List<IspitniRok> ispitniRokovi) {
		this.ispitniRokovi = ispitniRokovi;
	}

	public List<PredispitneObaveze> getPredispitneObaveze() {
		return predispitneObaveze;
	}

	public void setPredispitneObaveze(List<PredispitneObaveze> predispitneObaveze) {
		this.predispitneObaveze = predispitneObaveze;
	}

	public List<DrziPredmet> getDrziPredmete() {
		return drziPredmete;
	}

	public void setDrziPredmete(List<DrziPredmet> drziPredmete) {
		this.drziPredmete = drziPredmete;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "SkolskaGodina [idSkolskeGodine=" + idSkolskeGodine + ", skolskaGodina=" + skolskaGodina + ", aktivna="
				+ aktivna + ", nastavnici=" + nastavnici + ", ispitniRokovi=" + ispitniRokovi + ", predispitneObaveze="
				+ predispitneObaveze + ", drziPredmete=" + drziPredmete + "]";
	}
}
