package studsluzba.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class SkolskaGodina  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSkolskeGodine;
	
	private Date skolskaGodina;
	
	private boolean aktivna;
	
	@ManyToMany(mappedBy = "skolskeGodine")
	private List<Nastavnik> nastavnici;
	
	@OneToMany(mappedBy = "skolskaGodina")
	private List<IspitniRok> ispitniRokovi;
	
	@OneToMany(mappedBy = "skolskaGodina")
	private List<PredispitneObaveze> predispitneObaveze;
	
	public SkolskaGodina() {
		
	}
}
