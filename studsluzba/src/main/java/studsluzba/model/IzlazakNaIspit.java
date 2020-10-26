package studsluzba.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@NamedQuery(name="IzlazakNaIspit.findAll", query="SELECT i FROM IzlazakNaIspit i")
public class IzlazakNaIspit implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idIzlazakNaIspit;
	
	@OneToOne
	@JoinColumn(name = "idPrijavaIspita")
	private PrijavaIspita prijavaIspita;

}
