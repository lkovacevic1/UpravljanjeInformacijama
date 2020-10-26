package studsluzba.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the studprogram database table.
 * 
 */
@Entity
@NamedQuery(name="StudProgram.findAll", query="SELECT s FROM StudProgram s")
public class StudProgram implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idstudProgram;

	private String oznaka;
	private String nazivStudPrograma;
	private int godinaAkreditacije;
	private String nazivZvanjaPoZavrsetkuStudija;
	private int brojSemestara;
	
	@ManyToOne
	@JoinColumn(name = "idVrstaStudija")
	private VrstaStudija vrstaStudija;
	
	@OneToMany(mappedBy="studProgram")
	private List<Indeks> indeksi;
	
	@OneToMany(mappedBy="studProgram")
	private List<Predmet> predmeti;

	public StudProgram() {
		
	}

	public StudProgram(int idstudProgram, String oznaka, String nazivStudPrograma, int godinaAkreditacije,
			String nazivZvanjaPoZavrsetkuStudija, int brojSemestara, VrstaStudija vrstaStudija, List<Indeks> indeksi,
			List<Predmet> predmeti) {
		super();
		this.idstudProgram = idstudProgram;
		this.oznaka = oznaka;
		this.nazivStudPrograma = nazivStudPrograma;
		this.godinaAkreditacije = godinaAkreditacije;
		this.nazivZvanjaPoZavrsetkuStudija = nazivZvanjaPoZavrsetkuStudija;
		this.brojSemestara = brojSemestara;
		this.vrstaStudija = vrstaStudija;
		this.indeksi = indeksi;
		this.predmeti = predmeti;
	}

	public int getIdstudProgram() {
		return idstudProgram;
	}

	public void setIdstudProgram(int idstudProgram) {
		this.idstudProgram = idstudProgram;
	}

	public String getOznaka() {
		return oznaka;
	}

	public void setOznaka(String oznaka) {
		this.oznaka = oznaka;
	}

	public String getNazivStudPrograma() {
		return nazivStudPrograma;
	}

	public void setNazivStudPrograma(String nazivStudPrograma) {
		this.nazivStudPrograma = nazivStudPrograma;
	}

	public int getGodinaAkreditacije() {
		return godinaAkreditacije;
	}

	public void setGodinaAkreditacije(int godinaAkreditacije) {
		this.godinaAkreditacije = godinaAkreditacije;
	}

	public String getNazivZvanjaPoZavrsetkuStudija() {
		return nazivZvanjaPoZavrsetkuStudija;
	}

	public void setNazivZvanjaPoZavrsetkuStudija(String nazivZvanjaPoZavrsetkuStudija) {
		this.nazivZvanjaPoZavrsetkuStudija = nazivZvanjaPoZavrsetkuStudija;
	}

	public int getBrojSemestara() {
		return brojSemestara;
	}

	public void setBrojSemestara(int brojSemestara) {
		this.brojSemestara = brojSemestara;
	}

	public VrstaStudija getVrstaStudija() {
		return vrstaStudija;
	}

	public void setVrstaStudija(VrstaStudija vrstaStudija) {
		this.vrstaStudija = vrstaStudija;
	}

	public List<Indeks> getIndeksi() {
		return indeksi;
	}

	public void setIndeksi(List<Indeks> indeksi) {
		this.indeksi = indeksi;
	}

	public List<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(List<Predmet> predmeti) {
		this.predmeti = predmeti;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "StudProgram [idstudProgram=" + idstudProgram + ", oznaka=" + oznaka + ", nazivStudPrograma="
				+ nazivStudPrograma + ", godinaAkreditacije=" + godinaAkreditacije + ", nazivZvanjaPoZavrsetkuStudija="
				+ nazivZvanjaPoZavrsetkuStudija + ", brojSemestara=" + brojSemestara + ", vrstaStudija=" + vrstaStudija
				+ ", indeksi=" + indeksi + ", predmeti=" + predmeti + "]";
	}
}