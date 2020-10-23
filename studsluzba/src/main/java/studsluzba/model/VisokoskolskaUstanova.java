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
	private int idVisokoskolskeUstanove;
	
	private String nazivVisokoskolskeUstanove;
	
	@OneToMany(mappedBy="visokoskolskaUstanova")
	private List<Student> studenti;

	public VisokoskolskaUstanova() {
	
	}
	
	public VisokoskolskaUstanova(int idVsUstanove, String nazivVSU, List<Student> studenti) {
		super();
		this.idVisokoskolskeUstanove = idVsUstanove;
		this.nazivVisokoskolskeUstanove = nazivVSU;
		this.studenti = studenti;
	}

	public int getIdVsUstanove() {
		return idVisokoskolskeUstanove;
	}

	public void setIdVsUstanove(int idVsUstanove) {
		this.idVisokoskolskeUstanove = idVsUstanove;
	}

	public String getNazivVSU() {
		return nazivVisokoskolskeUstanove;
	}

	public void setNazivVSU(String nazivVSU) {
		this.nazivVisokoskolskeUstanove = nazivVSU;
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

	@Override
	public String toString() {
		return "VisokoskolskaUstanova [idVisokoskolskeUstanove=" + idVisokoskolskeUstanove
				+ ", nazivVisokoskolskeUstanove=" + nazivVisokoskolskeUstanove + ", studenti=" + studenti + "]";
	}
	
}