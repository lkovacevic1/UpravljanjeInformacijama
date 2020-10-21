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
	
	private String nazivSK;
	
	private String mestoSK;
	
	private String vrstaSK;
	
	@OneToMany(mappedBy="srednjaSkola")
	private List<Student> studenti;
	
	public SrednjaSkola() {
		
	}

	public SrednjaSkola(int idSrednjeSkole, String nazivSK, String mestoSK, String vrstaSK, List<Student> studenti) {
		super();
		this.idSrednjeSkole = idSrednjeSkole;
		this.nazivSK = nazivSK;
		this.mestoSK = mestoSK;
		this.vrstaSK = vrstaSK;
		this.studenti = studenti;
	}

	public int getIdSrednjeSkole() {
		return idSrednjeSkole;
	}

	public void setIdSrednjeSkole(int idSrednjeSkole) {
		this.idSrednjeSkole = idSrednjeSkole;
	}

	public String getNazivSK() {
		return nazivSK;
	}

	public void setNazivSK(String nazivSK) {
		this.nazivSK = nazivSK;
	}

	public String getMestoSK() {
		return mestoSK;
	}

	public void setMestoSK(String mestoSK) {
		this.mestoSK = mestoSK;
	}

	public String getVrstaSK() {
		return vrstaSK;
	}

	public void setVrstaSK(String vrstaSK) {
		this.vrstaSK = vrstaSK;
	}

	public List<Student> getStudenti() {
		return studenti;
	}

	public void setStudenti(List<Student> studenti) {
		this.studenti = studenti;
	}

	@Override
	public String toString() {
		return "SrednjaSkola [idSrednjeSkole=" + idSrednjeSkole + ", nazivSK=" + nazivSK + ", mestoSK=" + mestoSK
				+ ", vrstaSK=" + vrstaSK + ", studenti=" + studenti + "]";
	}
}
