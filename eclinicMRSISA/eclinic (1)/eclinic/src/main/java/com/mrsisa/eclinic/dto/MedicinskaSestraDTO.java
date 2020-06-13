package com.mrsisa.eclinic.dto;

import com.mrsisa.eclinic.model.MedicinskaSestra;

public class MedicinskaSestraDTO {
	
	private String ime;
	private String prezime;
	private String eadresa;
	private String lozinka;
	private String nazivKlinike;
	
	
	public MedicinskaSestraDTO() {
		super();
	}
	public MedicinskaSestraDTO(MedicinskaSestra sestra) {
		super();
		this.ime = sestra.getIme();
		this.prezime = sestra.getPrezime();
		this.eadresa = sestra.getPrijava().geteAdresa();
		this.lozinka = sestra.getPrijava().getLozinka();
		this.nazivKlinike = sestra.getKlinika().getNaziv();
	}
	public MedicinskaSestraDTO(String ime, String prezime, String eadresa, String lozinka, String nazivKlinike) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.eadresa = eadresa;
		this.lozinka = lozinka;
		this.nazivKlinike = nazivKlinike;
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
	public String getEadresa() {
		return eadresa;
	}
	public void setEadresa(String eadresa) {
		this.eadresa = eadresa;
	}
	public String getLozinka() {
		return lozinka;
	}
	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}
	public String getNazivKlinike() {
		return nazivKlinike;
	}
	public void setNazivKlinike(String nazivKlinike) {
		this.nazivKlinike = nazivKlinike;
	}
	
	
	
}
