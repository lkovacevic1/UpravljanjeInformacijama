package studsluzba.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name = "Predmet.findAll", query = "SELECT p FROM Predmet p")
public class Predmet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPredmeta;

	@ManyToOne
	@JoinColumn(name = "idstudProgram")
	private StudProgram studProgram;

	private String sifra;
	private String nazivPredmeta;
	private String opisPredmeta;
	private int brojESPBpoena;
	private int semestar;
	private int fondCasovaPredavanja;
	private int fondCasovaVezbi;

	@OneToMany(mappedBy = "predmet")
	private List<PredispitneObaveze> predispitneObaveze;

	@OneToMany(mappedBy = "predmet")
	private List<Ispit> ispiti;

	@OneToMany(mappedBy = "predmet")
	private List<DrziPredmet> drziPredmete;

	@OneToMany(mappedBy = "predmet")
	private List<PolozenPredmet> polozeniPredmeti;

	@ManyToOne
	@JoinColumn(name = "idUpisGodine")
	private UpisGodine upisGodine;

	@ManyToOne
	@JoinColumn(name = "idObnovaGodine")
	private ObnovaGodine obnovaGodine;

	public Predmet() {
		this.predispitneObaveze = new ArrayList<PredispitneObaveze>();
		this.ispiti = new ArrayList<Ispit>();
		this.drziPredmete = new ArrayList<DrziPredmet>();
		this.polozeniPredmeti = new ArrayList<PolozenPredmet>();
	}

	public Predmet(int idPredmeta, StudProgram studProgram, String sifra, String nazivPredmeta, String opisPredmeta,
			int brojESPBpoena, int semestar, int fondCasovaPredavanja, int fondCasovaVezbi,
			List<PredispitneObaveze> predispitneObaveze, List<Ispit> ispiti, List<DrziPredmet> drziPredmete,
			List<PolozenPredmet> polozeniPredmeti, UpisGodine upisGodine, ObnovaGodine obnovaGodine) {
		super();
		this.idPredmeta = idPredmeta;
		this.studProgram = studProgram;
		this.sifra = sifra;
		this.nazivPredmeta = nazivPredmeta;
		this.opisPredmeta = opisPredmeta;
		this.brojESPBpoena = brojESPBpoena;
		this.semestar = semestar;
		this.fondCasovaPredavanja = fondCasovaPredavanja;
		this.fondCasovaVezbi = fondCasovaVezbi;
		this.predispitneObaveze = predispitneObaveze;
		this.ispiti = ispiti;
		this.drziPredmete = drziPredmete;
		this.polozeniPredmeti = polozeniPredmeti;
		this.upisGodine = upisGodine;
		this.obnovaGodine = obnovaGodine;
	}

	public int getIdPredmeta() {
		return idPredmeta;
	}

	public void setIdPredmeta(int idPredmeta) {
		this.idPredmeta = idPredmeta;
	}

	public StudProgram getStudProgram() {
		return studProgram;
	}

	public void setStudProgram(StudProgram studProgram) {
		this.studProgram = studProgram;
	}

	public String getSifra() {
		return sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	public String getNazivPredmeta() {
		return nazivPredmeta;
	}

	public void setNazivPredmeta(String nazivPredmeta) {
		this.nazivPredmeta = nazivPredmeta;
	}

	public String getOpisPredmeta() {
		return opisPredmeta;
	}

	public void setOpisPredmeta(String opisPredmeta) {
		this.opisPredmeta = opisPredmeta;
	}

	public int getBrojESPBpoena() {
		return brojESPBpoena;
	}

	public void setBrojESPBpoena(int brojESPBpoena) {
		this.brojESPBpoena = brojESPBpoena;
	}

	public int getSemestar() {
		return semestar;
	}

	public void setSemestar(int semestar) {
		this.semestar = semestar;
	}

	public int getFondCasovaPredavanja() {
		return fondCasovaPredavanja;
	}

	public void setFondCasovaPredavanja(int fondCasovaPredavanja) {
		this.fondCasovaPredavanja = fondCasovaPredavanja;
	}

	public int getFondCasovaVezbi() {
		return fondCasovaVezbi;
	}

	public void setFondCasovaVezbi(int fondCasovaVezbi) {
		this.fondCasovaVezbi = fondCasovaVezbi;
	}

	public List<PredispitneObaveze> getPredispitneObaveze() {
		return predispitneObaveze;
	}

	public void setPredispitneObaveze(List<PredispitneObaveze> predispitneObaveze) {
		this.predispitneObaveze = predispitneObaveze;
	}

	public List<Ispit> getIspiti() {
		return ispiti;
	}

	public void setIspiti(List<Ispit> ispiti) {
		this.ispiti = ispiti;
	}

	public List<DrziPredmet> getDrziPredmete() {
		return drziPredmete;
	}

	public void setDrziPredmete(List<DrziPredmet> drziPredmete) {
		this.drziPredmete = drziPredmete;
	}

	public List<PolozenPredmet> getPolozeniPredmeti() {
		return polozeniPredmeti;
	}

	public void setPolozeniPredmeti(List<PolozenPredmet> polozeniPredmeti) {
		this.polozeniPredmeti = polozeniPredmeti;
	}

	public UpisGodine getUpisGodine() {
		return upisGodine;
	}

	public void setUpisGodine(UpisGodine upisGodine) {
		this.upisGodine = upisGodine;
	}

	public ObnovaGodine getObnovaGodine() {
		return obnovaGodine;
	}

	public void setObnovaGodine(ObnovaGodine obnovaGodine) {
		this.obnovaGodine = obnovaGodine;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Predmet [idPredmeta=" + idPredmeta + ", studProgram=" + studProgram + ", sifra=" + sifra
				+ ", nazivPredmeta=" + nazivPredmeta + ", opisPredmeta=" + opisPredmeta + ", brojESPBpoena="
				+ brojESPBpoena + ", semestar=" + semestar + ", fondCasovaPredavanja=" + fondCasovaPredavanja
				+ ", fondCasovaVezbi=" + fondCasovaVezbi + ", upisGodine=" + upisGodine + ", obnovaGodine="
				+ obnovaGodine + "]";
	}
	
}
