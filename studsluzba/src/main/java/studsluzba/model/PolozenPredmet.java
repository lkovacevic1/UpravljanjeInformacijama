package studsluzba.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class PolozenPredmet implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPolozenPredmet;

	private boolean polozen;
	private int ocena;
	
	@ManyToOne
	@JoinColumn(name = "idIndeks")
	private Indeks indeks;
	
	@ManyToOne
	@JoinColumn(name = "idPredmeta")
	private Predmet predmet;
	
	@OneToOne
	@JoinColumn(name = "idIspit")
	private Ispit ispit;
	
	public PolozenPredmet() {
		
	}
}
