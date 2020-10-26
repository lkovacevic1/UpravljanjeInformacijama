package studsluzba.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name="VrstaStudija.findAll", query="SELECT v FROM VrstaStudija v")
public class VrstaStudija implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idVrstaStudija;
	
	private String punNazivStudija;
	private String skraceniNazivStudija;
	
	@OneToMany(mappedBy="vrstaStudija")
	private List<StudProgram> studProgrami;

	public VrstaStudija() {
		
	}

	public VrstaStudija(int idVrstaStudija, String punNazivStudija, String skraceniNazivStudija,
			List<StudProgram> studProgrami) {
		super();
		this.idVrstaStudija = idVrstaStudija;
		this.punNazivStudija = punNazivStudija;
		this.skraceniNazivStudija = skraceniNazivStudija;
		this.studProgrami = studProgrami;
	}

	public int getIdVrstaStudija() {
		return idVrstaStudija;
	}

	public void setIdVrstaStudija(int idVrstaStudija) {
		this.idVrstaStudija = idVrstaStudija;
	}

	public String getPunNazivStudija() {
		return punNazivStudija;
	}

	public void setPunNazivStudija(String punNazivStudija) {
		this.punNazivStudija = punNazivStudija;
	}

	public String getSkraceniNazivStudija() {
		return skraceniNazivStudija;
	}

	public void setSkraceniNazivStudija(String skraceniNazivStudija) {
		this.skraceniNazivStudija = skraceniNazivStudija;
	}

	public List<StudProgram> getStudProgrami() {
		return studProgrami;
	}

	public void setStudProgrami(List<StudProgram> studProgrami) {
		this.studProgrami = studProgrami;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "VrstaStudija [idVrstaStudija=" + idVrstaStudija + ", punNazivStudija=" + punNazivStudija
				+ ", skraceniNazivStudija=" + skraceniNazivStudija + ", studProgrami=" + studProgrami + "]";
	}
}
