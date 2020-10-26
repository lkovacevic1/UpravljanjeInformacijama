package studsluzba.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name="ObnovaGodine.findAll", query="SELECT o FROM ObnovaGodine o")
public class ObnovaGodine implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idObnovaGodine;
	
	
	@OneToMany(mappedBy="obnovaGodine")
	private List<Indeks> indeks;
	
	@OneToMany(mappedBy="obnovaGodine")
	private List<Predmet> predmeti;
	
	private String napomena;
	
	private Date datumObnoveGodine;
	
	public ObnovaGodine() {
		
	}

	public ObnovaGodine(int idObnovaGodine, List<Indeks> indeks, List<Predmet> predmeti, String napomena,
			Date datumObnoveGodine) {
		super();
		this.idObnovaGodine = idObnovaGodine;
		this.indeks = indeks;
		this.predmeti = predmeti;
		this.napomena = napomena;
		this.datumObnoveGodine = datumObnoveGodine;
	}

	public int getIdObnovaGodine() {
		return idObnovaGodine;
	}

	public void setIdObnovaGodine(int idObnovaGodine) {
		this.idObnovaGodine = idObnovaGodine;
	}

	public List<Indeks> getIndeks() {
		return indeks;
	}

	public void setIndeks(List<Indeks> indeks) {
		this.indeks = indeks;
	}

	public List<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(List<Predmet> predmeti) {
		this.predmeti = predmeti;
	}

	public String getNapomena() {
		return napomena;
	}

	public void setNapomena(String napomena) {
		this.napomena = napomena;
	}

	public Date getDatumObnoveGodine() {
		return datumObnoveGodine;
	}

	public void setDatumObnoveGodine(Date datumObnoveGodine) {
		this.datumObnoveGodine = datumObnoveGodine;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ObnovaGodine [idObnovaGodine=" + idObnovaGodine + ", indeks=" + indeks + ", predmeti=" + predmeti
				+ ", napomena=" + napomena + ", datumObnoveGodine=" + datumObnoveGodine + "]";
	}
}
