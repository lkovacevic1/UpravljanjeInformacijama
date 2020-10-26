package studsluzba.model;

import java.io.Serializable;
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

}
