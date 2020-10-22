package studsluzba.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="Indeks.findAll", query="SELECT i FROM Indeks i")
public class Indeks implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idIndex;
	
	@ManyToOne
	@JoinColumn(name = "idstudent")
	private Student student;

	private int godinaUpisa;
	private int brojIndexa;
	private boolean aktivan;
	private Date datumAktivacijeIndexa;
	
	@ManyToOne
	@JoinColumn(name = "idstudProgram")
	private StudProgram studProgram;

	public Indeks() {
		
	}
	
	public Indeks(int idIndex, Student student, int godinaUpisa, int brojIndexa, boolean aktivan,
			Date datumAktivacijeIndexa, StudProgram studProgram) {
		super();
		this.idIndex = idIndex;
		this.student = student;
		this.godinaUpisa = godinaUpisa;
		this.brojIndexa = brojIndexa;
		this.aktivan = aktivan;
		this.datumAktivacijeIndexa = datumAktivacijeIndexa;
		this.studProgram = studProgram;
	}
	
	

	public int getIdIndex() {
		return idIndex;
	}

	public void setIdIndex(int idIndex) {
		this.idIndex = idIndex;
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

	public Date getDatumAktivacijeIndexa() {
		return datumAktivacijeIndexa;
	}

	public void setDatumAktivacijeIndexa(Date datumAktivacijeIndexa) {
		this.datumAktivacijeIndexa = datumAktivacijeIndexa;
	}

	public StudProgram getStudProgram() {
		return studProgram;
	}

	public void setStudProgram(StudProgram studProgram) {
		this.studProgram = studProgram;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Indeks [idIndex=" + idIndex + ", student=" + student + ", godinaUpisa=" + godinaUpisa + ", brojIndexa="
				+ brojIndexa + ", aktivan=" + aktivan + ", datumAktivacijeIndexa=" + datumAktivacijeIndexa
				+ ", studProgram=" + studProgram + "]";
	}
	
}
