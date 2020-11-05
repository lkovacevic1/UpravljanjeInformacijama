package studsluzba.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name = "Indeks.findAll", query = "SELECT i FROM Indeks i")
public class Indeks implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idIndeks;

	@ManyToOne
	@JoinColumn(name = "idstudent")
	private Student student;

	private int godinaUpisa;
	private int brojIndexa;
	private boolean aktivan;
	private LocalDate datumAktivacijeIndexa;

	@ManyToOne
	@JoinColumn(name = "idstudProgram")
	private StudProgram studProgram;

	@ManyToMany(mappedBy = "indeksi")
	private List<DrziPredmet> drziPredmete;

	@OneToMany(mappedBy = "indeks")
	private List<PolozenPredmet> polozeniPredmeti;

	@OneToMany(mappedBy = "indeks")
	private List<PrijavaIspita> prijavaIspita;

	@OneToMany(mappedBy = "indeks")
	private List<OsvojeniPredispitniPoeni> osvojeniPredispitniPOeni;

	@ManyToOne
	@JoinColumn(name = "idObnovaGodine")
	private ObnovaGodine obnovaGodine;

	@ManyToOne
	@JoinColumn(name = "idUpisGodine")
	private UpisGodine upisGodine;

	public Indeks() {

		this.drziPredmete = new ArrayList<DrziPredmet>();
		this.polozeniPredmeti = new ArrayList<PolozenPredmet>();
		this.prijavaIspita = new ArrayList<PrijavaIspita>();
		this.osvojeniPredispitniPOeni = new ArrayList<OsvojeniPredispitniPoeni>();
	}

	public Indeks(int idIndeks, Student student, int godinaUpisa, int brojIndexa, boolean aktivan,
			LocalDate datumAktivacijeIndexa, StudProgram studProgram, List<DrziPredmet> drziPredmete,
			List<PolozenPredmet> polozeniPredmeti, List<PrijavaIspita> prijavaIspita,
			List<OsvojeniPredispitniPoeni> osvojeniPredispitniPOeni, ObnovaGodine obnovaGodine, UpisGodine upisGodine) {
		super();
		this.idIndeks = idIndeks;
		this.student = student;
		this.godinaUpisa = godinaUpisa;
		this.brojIndexa = brojIndexa;
		this.aktivan = aktivan;
		this.datumAktivacijeIndexa = datumAktivacijeIndexa;
		this.studProgram = studProgram;
		this.drziPredmete = drziPredmete;
		this.polozeniPredmeti = polozeniPredmeti;
		this.prijavaIspita = prijavaIspita;
		this.osvojeniPredispitniPOeni = osvojeniPredispitniPOeni;
		this.obnovaGodine = obnovaGodine;
		this.upisGodine = upisGodine;
	}

	public int getIdIndeks() {
		return idIndeks;
	}

	public void setIdIndeks(int idIndeks) {
		this.idIndeks = idIndeks;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public int getGodinaUpisa() {
		return godinaUpisa;
	}

	public void setGodinaUpisa(int godinaUpisa) {
		this.godinaUpisa = godinaUpisa;
	}

	public int getBrojIndexa() {
		return brojIndexa;
	}

	public void setBrojIndexa(int brojIndexa) {
		this.brojIndexa = brojIndexa;
	}

	public boolean isAktivan() {
		return aktivan;
	}

	public void setAktivan(boolean aktivan) {
		this.aktivan = aktivan;
	}

	public LocalDate getDatumAktivacijeIndexa() {
		return datumAktivacijeIndexa;
	}

	public void setDatumAktivacijeIndexa(LocalDate datumAktivacijeIndexa) {
		this.datumAktivacijeIndexa = datumAktivacijeIndexa;
	}

	public StudProgram getStudProgram() {
		return studProgram;
	}

	public void setStudProgram(StudProgram studProgram) {
		this.studProgram = studProgram;
	}

	public List<DrziPredmet> getDrziPredmete() {
		return drziPredmete;
	}

	public void setDrziPredmete(List<DrziPredmet> drziPredmete) {
		this.drziPredmete = drziPredmete;
	}

	public List<PolozenPredmet> getPolozeniPredmeti() {
		return polozeniPredmeti;
	}

	public void setPolozeniPredmeti(List<PolozenPredmet> polozeniPredmeti) {
		this.polozeniPredmeti = polozeniPredmeti;
	}

	public List<PrijavaIspita> getPrijavaIspita() {
		return prijavaIspita;
	}

	public void setPrijavaIspita(List<PrijavaIspita> prijavaIspita) {
		this.prijavaIspita = prijavaIspita;
	}

	public List<OsvojeniPredispitniPoeni> getOsvojeniPredispitniPOeni() {
		return osvojeniPredispitniPOeni;
	}

	public void setOsvojeniPredispitniPOeni(List<OsvojeniPredispitniPoeni> osvojeniPredispitniPOeni) {
		this.osvojeniPredispitniPOeni = osvojeniPredispitniPOeni;
	}

	public ObnovaGodine getObnovaGodine() {
		return obnovaGodine;
	}

	public void setObnovaGodine(ObnovaGodine obnovaGodine) {
		this.obnovaGodine = obnovaGodine;
	}

	public UpisGodine getUpisGodine() {
		return upisGodine;
	}

	public void setUpisGodine(UpisGodine upisGodine) {
		this.upisGodine = upisGodine;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Indeks [idIndeks=" + idIndeks + ", student=" + student + ", godinaUpisa=" + godinaUpisa
				+ ", brojIndexa=" + brojIndexa + ", aktivan=" + aktivan + ", datumAktivacijeIndexa="
				+ datumAktivacijeIndexa + "]";
	}

}
