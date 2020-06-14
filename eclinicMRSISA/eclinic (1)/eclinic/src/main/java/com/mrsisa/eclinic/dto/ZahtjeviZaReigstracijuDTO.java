package com.mrsisa.eclinic.dto;

public class ZahtjeviZaReigstracijuDTO {


	private String eAdresa;

	   private String lozinka;
	  
	   private String ime;

	   private String prezime;

	   private String jbo;

	   private String adresaPrebivalista;
	
	   private String grad;
	   
	   private String drzava;
	
	   private String brojTelefona;

	   private boolean prihvacen;

		public ZahtjeviZaReigstracijuDTO() {
			super();
		}
		
		

		public ZahtjeviZaReigstracijuDTO(String eAdresa, String lozinka, String ime, String prezime, String jbo,
				String adresaPrebivalista, String grad, String drzava, String brojTelefona, boolean prihvacen) {
			super();
			this.eAdresa = eAdresa;
			this.lozinka = lozinka;
			this.ime = ime;
			this.prezime = prezime;
			this.jbo = jbo;
			this.adresaPrebivalista = adresaPrebivalista;
			this.grad = grad;
			this.drzava = drzava;
			this.brojTelefona = brojTelefona;
			this.prihvacen = prihvacen;
		}

	public String geteAdresa() {
		return eAdresa;
	}

	public void seteAdresa(String eAdresa) {
		this.eAdresa = eAdresa;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getJbo() {
		return jbo;
	}

	public void setJbo(String jbo) {
		this.jbo = jbo;
	}

	public String getAdresaPrebivalista() {
		return adresaPrebivalista;
	}

	public void setAdresaPrebivalista(String adresaPrebivalista) {
		this.adresaPrebivalista = adresaPrebivalista;
	}

	public String getGrad() {
		return grad;
	}

	public void setGrad(String grad) {
		this.grad = grad;
	}

	public String getDrzava() {
		return drzava;
	}

	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}

	public String getBrojTelefona() {
		return brojTelefona;
	}

	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
	}

	public boolean isPrihvacen() {
		return prihvacen;
	}

	public void setPrihvacen(boolean prihvacen) {
		this.prihvacen = prihvacen;
	}

}
