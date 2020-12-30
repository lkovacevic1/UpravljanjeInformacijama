package studsluzba.client.reports;

public class IndeksNaIspituEntity {

	private String indeksStudenta;
	private String punoImeStudenta;
	private float poeniStudenta;
	private int ocenaStudenta;
	private String ponistio;
	
	public IndeksNaIspituEntity(String indeksStudenta, String punoImeStudenta, float poeniStudenta, int ocenaStudenta, String ponistio) {
		super();
		this.indeksStudenta = indeksStudenta;
		this.punoImeStudenta = punoImeStudenta;
		this.poeniStudenta = poeniStudenta;
		this.ocenaStudenta = ocenaStudenta;
		this.ponistio = ponistio;
	}
	
	public String getIndeksStudenta() {
		return indeksStudenta;
	}
	public void setIndeksStudenta(String indeksStudenta) {
		this.indeksStudenta = indeksStudenta;
	}
	public String getPunoImeStudenta() {
		return punoImeStudenta;
	}
	public void setPunoImeStudenta(String punoImeStudenta) {
		this.punoImeStudenta = punoImeStudenta;
	}
	public float getPoeniStudenta() {
		return poeniStudenta;
	}
	public void setPoeniStudenta(float poeniStudenta) {
		this.poeniStudenta = poeniStudenta;
	}
	public int getOcenaStudenta() {
		return ocenaStudenta;
	}
	public void setOcenaStudenta(int ocenaStudenta) {
		this.ocenaStudenta = ocenaStudenta;
	}
	public String getPonistio() {
		return ponistio;
	}
	public void setPonistio(String ponistio) {
		this.ponistio = ponistio;
	}
}
