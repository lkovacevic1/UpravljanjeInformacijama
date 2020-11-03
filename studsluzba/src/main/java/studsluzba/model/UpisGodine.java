package studsluzba.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
@DiscriminatorValue("upis_godine")
public class UpisGodine extends AktivnostStudenta implements Serializable {
	
	private int godinaUpisa;
	
	@ManyToMany(mappedBy = "upisGodine")
	private List<Predmet> predmeti;
	
	public UpisGodine(int idAktivnostiStudenta, LocalDate datum, String napomena, Indeks indeks, int godinaUpisa,
			List<Predmet> predmeti) {
		super(idAktivnostiStudenta, datum, napomena, indeks);
		this.godinaUpisa = godinaUpisa;
		this.predmeti = new ArrayList<Predmet>();
	}

	public int getGodinaUpisa() {
		return godinaUpisa;
	}

	public void setGodinaUpisa(int godinaUpisa) {
		this.godinaUpisa = godinaUpisa;
	}

	public List<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(List<Predmet> predmeti) {
		this.predmeti = predmeti;
	}

	@Override
	public String toString() {
		return "UpisGodine [godinaUpisa=" + godinaUpisa + ", predmeti=" + predmeti + "]";
	}
}
