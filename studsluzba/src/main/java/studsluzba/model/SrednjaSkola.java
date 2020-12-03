package studsluzba.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@NamedQuery(name = "SrednjaSkola.findAll", query = "SELECT sk FROM SrednjaSkola sk")
public class SrednjaSkola implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSrednjeSkole;

	private String nazivSrednjeSkole;

	private String mestoSrednjeSkole;

	private String vrstaSrednjeSkole;

	@OneToMany(mappedBy = "srSkola")
	private List<Student> studenti;

	public SrednjaSkola() {
		this.studenti = new ArrayList<Student>();
	}

	public SrednjaSkola(int idSrednjeSkole, String nazivSrednjeSkole, String mestoSrednjeSkole,
			String vrstaSrednjeSkole, List<Student> studenti) {
		super();
		this.idSrednjeSkole = idSrednjeSkole;
		this.nazivSrednjeSkole = nazivSrednjeSkole;
		this.mestoSrednjeSkole = mestoSrednjeSkole;
		this.vrstaSrednjeSkole = vrstaSrednjeSkole;
		this.studenti = studenti;
	}

	public int getIdSrednjeSkole() {
		return idSrednjeSkole;
	}

	public void setIdSrednjeSkole(int idSrednjeSkole) {
		this.idSrednjeSkole = idSrednjeSkole;
	}

	public String getNazivSrednjeSkole() {
		return nazivSrednjeSkole;
	}

	public void setNazivSrednjeSkole(String nazivSrednjeSkole) {
		this.nazivSrednjeSkole = nazivSrednjeSkole;
	}

	public String getMestoSrednjeSkole() {
		return mestoSrednjeSkole;
	}

	public void setMestoSrednjeSkole(String mestoSrednjeSkole) {
		this.mestoSrednjeSkole = mestoSrednjeSkole;
	}

	public String getVrstaSrednjeSkole() {
		return vrstaSrednjeSkole;
	}

	public void setVrstaSrednjeSkole(String vrstaSrednjeSkole) {
		this.vrstaSrednjeSkole = vrstaSrednjeSkole;
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
		return nazivSrednjeSkole + ", " + mestoSrednjeSkole + ", " + vrstaSrednjeSkole;
	}

}
