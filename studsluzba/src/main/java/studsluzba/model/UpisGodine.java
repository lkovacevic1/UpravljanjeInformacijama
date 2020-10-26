package studsluzba.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class UpisGodine  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUpisGodine;
	
	private Date godinaKojaSeUpisuje;
	
	@OneToMany(mappedBy = "upisGodine")
	private List<Predmet> predmet;
	
	@OneToMany(mappedBy = "upisGodine")
	private List<Indeks> indeksi;
	
	public UpisGodine() {
		
	}

}
