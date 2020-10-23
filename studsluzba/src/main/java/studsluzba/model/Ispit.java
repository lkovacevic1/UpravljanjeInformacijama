package studsluzba.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="Ispit.findAll", query="SELECT i FROM Ispit i")
public class Ispit implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idIspit;
	
	private Date datumOdrzavanjaIspita;
	SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm:ss");
    private String vremeOdrzavanjaIspita = localDateFormat.format(new Date());
    private boolean zakljucenIspit;
    
    @ManyToOne
	@JoinColumn(name = "idPredmeta")
	private Predmet predmet;
    
    @ManyToOne
	@JoinColumn(name = "idNastavnik")
	private Nastavnik nastavnik;
    
    @ManyToOne
	@JoinColumn(name = "idIspitnogRoka")
	private IspitniRok ispitniRok;

    public Ispit() {
    	
    }
    
	

	public Ispit(int idIspit, Date datumOdrzavanjaIspita, SimpleDateFormat localDateFormat,
			String vremeOdrzavanjaIspita, boolean zakljucenIspit, Predmet predmet, Nastavnik nastavnik,
			IspitniRok ispitniRok) {
		super();
		this.idIspit = idIspit;
		this.datumOdrzavanjaIspita = datumOdrzavanjaIspita;
		this.localDateFormat = localDateFormat;
		this.vremeOdrzavanjaIspita = vremeOdrzavanjaIspita;
		this.zakljucenIspit = zakljucenIspit;
		this.predmet = predmet;
		this.nastavnik = nastavnik;
		this.ispitniRok = ispitniRok;
	}



	public int getIdIspit() {
		return idIspit;
	}

	public void setIdIspit(int idIspit) {
		this.idIspit = idIspit;
	}

	public Date getDatumOdrzavanjaIspita() {
		return datumOdrzavanjaIspita;
	}

	public void setDatumOdrzavanjaIspita(Date datumOdrzavanjaIspita) {
		this.datumOdrzavanjaIspita = datumOdrzavanjaIspita;
	}

	public SimpleDateFormat getLocalDateFormat() {
		return localDateFormat;
	}

	public void setLocalDateFormat(SimpleDateFormat localDateFormat) {
		this.localDateFormat = localDateFormat;
	}

	public String getVremeOdrzavanjaIspita() {
		return vremeOdrzavanjaIspita;
	}

	public void setVremeOdrzavanjaIspita(String vremeOdrzavanjaIspita) {
		this.vremeOdrzavanjaIspita = vremeOdrzavanjaIspita;
	}

	public boolean isZakljucenIspit() {
		return zakljucenIspit;
	}

	public void setZakljucenIspit(boolean zakljucenIspit) {
		this.zakljucenIspit = zakljucenIspit;
	}

	public Predmet getPredmet() {
		return predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}

	public Nastavnik getNastavnik() {
		return nastavnik;
	}

	public void setNastavnik(Nastavnik nastavnik) {
		this.nastavnik = nastavnik;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public IspitniRok getIspitniRok() {
		return ispitniRok;
	}



	public void setIspitniRok(IspitniRok ispitniRok) {
		this.ispitniRok = ispitniRok;
	}



	@Override
	public String toString() {
		return "Ispit [idIspit=" + idIspit + ", datumOdrzavanjaIspita=" + datumOdrzavanjaIspita + ", localDateFormat="
				+ localDateFormat + ", vremeOdrzavanjaIspita=" + vremeOdrzavanjaIspita + ", zakljucenIspit="
				+ zakljucenIspit + ", predmet=" + predmet + ", nastavnik=" + nastavnik + ", ispitniRok=" + ispitniRok
				+ "]";
	}

}
