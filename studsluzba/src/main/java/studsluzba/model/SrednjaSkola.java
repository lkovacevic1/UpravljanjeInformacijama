package studsluzba.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import javax.persistence.*;

@Entity
@NamedQuery(name="SrednjaSkola.findAll", query="SELECT sk FROM SrednjaSkola sk")
public class SrednjaSkola  implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idSrednjeSkole;
	
	private String nazivSrednjeSkole;
	
	private String mestoSrednjeSkole;
	
	private String vrstaSrednjeSkole;
	
	@OneToMany(mappedBy="srSkola")
	private List<Student> studenti;
	
	public SrednjaSkola() {
		
	}

	public SrednjaSkola(int idSrednjeSkole, String nazivSK, String mestoSK, String vrstaSK, List<Student> studenti) {
		super();
		this.idSrednjeSkole = idSrednjeSkole;
		this.nazivSrednjeSkole = nazivSK;
		this.mestoSrednjeSkole = mestoSK;
		this.vrstaSrednjeSkole = vrstaSK;
		this.studenti = studenti;
	}

	public int getIdSrednjeSkole() {
		return idSrednjeSkole;
	}

	public void setIdSrednjeSkole(int idSrednjeSkole) {
		this.idSrednjeSkole = idSrednjeSkole;
	}

	public String getNazivSK() {
		return nazivSrednjeSkole;
	}

	public void setNazivSK(String nazivSK) {
		this.nazivSrednjeSkole = nazivSK;
	}

	public String getMestoSK() {
		return mestoSrednjeSkole;
	}

	public void setMestoSK(String mestoSK) {
		this.mestoSrednjeSkole = mestoSK;
	}

	public String getVrstaSK() {
		return vrstaSrednjeSkole;
	}

	public void setVrstaSK(String vrstaSK) {
		this.vrstaSrednjeSkole = vrstaSK;
	}

	public List<Student> getStudenti() {
		return studenti;
	}

	public void setStudenti(List<Student> studenti) {
		this.studenti = studenti;
	}

	@Override
	public String toString() {
		return "SrednjaSkola [idSrednjeSkole=" + idSrednjeSkole + ", nazivSK=" + nazivSrednjeSkole + ", mestoSK=" + mestoSrednjeSkole
				+ ", vrstaSK=" + vrstaSrednjeSkole + ", studenti=" + studenti + "]";
	}
}
