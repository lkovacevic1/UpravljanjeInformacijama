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
@NamedQuery(name="VisokoskolskaUstanova.findAll", query="SELECT v FROM VisokoskolskaUstanova v")
public class VisokoskolskaUstanova implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idVsUstanove;
	
	private String nazivVSU;
	
	@OneToMany(mappedBy="visokoskolskaUstanova")
	private List<Student> studenti;

	public VisokoskolskaUstanova() {
	
	}
	
	public VisokoskolskaUstanova(int idVsUstanove, String nazivVSU, List<Student> studenti) {
		super();
		this.idVsUstanove = idVsUstanove;
		this.nazivVSU = nazivVSU;
		this.studenti = studenti;
	}

	public int getIdVsUstanove() {
		return idVsUstanove;
	}

	public void setIdVsUstanove(int idVsUstanove) {
		this.idVsUstanove = idVsUstanove;
	}

	public String getNazivVSU() {
		return nazivVSU;
	}

	public void setNazivVSU(String nazivVSU) {
		this.nazivVSU = nazivVSU;
	}

	public List<Student> getStudenti() {
		return studenti;
	}

	public void setStudenti(List<Student> studenti) {
		this.studenti = studenti;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}