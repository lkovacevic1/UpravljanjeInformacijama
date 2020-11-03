package studsluzba.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;

@Entity
@DiscriminatorValue("obnova_godine")
@NamedQuery(name="ObnovaGodine.findAll", query="SELECT o FROM ObnovaGodine o")
public class ObnovaGodine extends AktivnostStudenta implements Serializable {
	
	private int godinaObnove;
	
	@ManyToMany(mappedBy = "obnovaGodine")
	private List<Predmet> predmeti;

	public ObnovaGodine(int idAktivnostiStudenta, LocalDate datum, String napomena, Indeks indeks, int godinaObnove,
			List<Predmet> predmeti) {
		super(idAktivnostiStudenta, datum, napomena, indeks);
		this.godinaObnove = godinaObnove;
		this.predmeti = new ArrayList<Predmet>();
	}

	public int getGodinaObnove() {
		return godinaObnove;
	}

	public void setGodinaObnove(int godinaObnove) {
		this.godinaObnove = godinaObnove;
	}

	public List<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(List<Predmet> predmeti) {
		this.predmeti = predmeti;
	}

	@Override
	public String toString() {
		return "ObnovaGodine [godinaObnove=" + godinaObnove + ", predmeti=" + predmeti + "]";
	}
}
