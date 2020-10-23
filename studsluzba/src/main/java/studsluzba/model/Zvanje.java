package studsluzba.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Zvanje implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idZvanja;
	
	private String zvanje;
	
	@OneToMany(mappedBy="zvanje")
	private List<Nastavnik> nastavnici;

	public Zvanje() {
		
	}
	
	public Zvanje(int idZvanja, String zvanje, List<Nastavnik> nastavnici) {
		super();
		this.idZvanja = idZvanja;
		this.zvanje = zvanje;
		this.nastavnici = nastavnici;
	}

	public int getIdZvanja() {
		return idZvanja;
	}

	public void setIdZvanja(int idZvanja) {
		this.idZvanja = idZvanja;
	}

	public String getZvanje() {
		return zvanje;
	}

	public void setZvanje(String zvanje) {
		this.zvanje = zvanje;
	}

	public List<Nastavnik> getNastavnici() {
		return nastavnici;
	}

	public void setNastavnici(List<Nastavnik> nastavnici) {
		this.nastavnici = nastavnici;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Zvanje [idZvanja=" + idZvanja + ", zvanje=" + zvanje + "]";
	}
}
