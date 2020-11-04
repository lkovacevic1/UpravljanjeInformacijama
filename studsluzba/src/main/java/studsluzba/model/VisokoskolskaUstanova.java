package studsluzba.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name = "VisokoskolskaUstanova.findAll", query = "SELECT v FROM VisokoskolskaUstanova v")
public class VisokoskolskaUstanova implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVisokoskolskeUstanove;

	private String nazivVisokoskolskeUstanove;

	@OneToMany(mappedBy = "visokoskolskaUstanova")
	private List<Student> studenti;

	public VisokoskolskaUstanova() {
		this.studenti = new ArrayList<Student>();
	}

	public VisokoskolskaUstanova(int idVisokoskolskeUstanove, String nazivVisokoskolskeUstanove,
			List<Student> studenti) {
		super();
		this.idVisokoskolskeUstanove = idVisokoskolskeUstanove;
		this.nazivVisokoskolskeUstanove = nazivVisokoskolskeUstanove;
		this.studenti = studenti;
	}

	public int getIdVisokoskolskeUstanove() {
		return idVisokoskolskeUstanove;
	}

	public void setIdVisokoskolskeUstanove(int idVisokoskolskeUstanove) {
		this.idVisokoskolskeUstanove = idVisokoskolskeUstanove;
	}

	public String getNazivVisokoskolskeUstanove() {
		return nazivVisokoskolskeUstanove;
	}

	public void setNazivVisokoskolskeUstanove(String nazivVisokoskolskeUstanove) {
		this.nazivVisokoskolskeUstanove = nazivVisokoskolskeUstanove;
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
				+ ", nazivVisokoskolskeUstanove=" + nazivVisokoskolskeUstanove + "]";
	}

}