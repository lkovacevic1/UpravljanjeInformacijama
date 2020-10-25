package studsluzba.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="OsvojeniPredispitniPoeni.findAll", query="SELECT o FROM OsvojeniPredispitniPoeni o")
public class OsvojeniPredispitniPoeni implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idOsvojeniPredispitniPoeni;
	
	@ManyToOne
	@JoinColumn(name = "idPredispitnihObaveza")
	private PredispitneObaveze predispitneObaveze;
	 
	@ManyToOne
	@JoinColumn(name = "idIndex")
	private Indeks indeks;
	
	
	public OsvojeniPredispitniPoeni() {
		
	}

}
