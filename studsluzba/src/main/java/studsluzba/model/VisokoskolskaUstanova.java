package studsluzba.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;


@Entity
@NamedQuery(name="VisokoskolskaUstanova.findAll", query="SELECT v FROM VisokoskolskaUstanova v")
public class VisokoskolskaUstanova implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idVsUstanove;
	
	private String nazivVSU;

	public VisokoskolskaUstanova(int idVsUstanove, String nazivVSU) {
		super();
		this.idVsUstanove = idVsUstanove;
		this.nazivVSU = nazivVSU;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "VisokoskolskaUstanova [idVsUstanove=" + idVsUstanove + ", nazivVSU=" + nazivVSU + "]";
	}
}
