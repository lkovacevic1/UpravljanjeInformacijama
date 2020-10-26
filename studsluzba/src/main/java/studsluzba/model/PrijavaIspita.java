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
@NamedQuery(name="PrijavaIspita.findAll", query="SELECT p FROM PrijavaIspita p")
public class PrijavaIspita implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPrijavaIspita;
	
	
	@ManyToOne
	@JoinColumn(name = "idIspit")
	private Ispit ispit;
	
	@ManyToOne
	@JoinColumn(name = "idIndeks")
	private Indeks indeks;

}
