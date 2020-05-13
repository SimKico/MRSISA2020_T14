package com.mrsisa.eclinic.dto;

import com.mrsisa.eclinic.model.Specijalizacija;
import com.mrsisa.eclinic.model.Klinika;
import com.mrsisa.eclinic.model.Ljekar;


public class LjekarDTO {

	
	private String ime;
	private String prezime;
	private Specijalizacija specijalizacija;
	private String klinika;
	private Integer prosjecnaOcjena;
	
	public LjekarDTO(Ljekar ljekar) {
		ime = ljekar.getIme();
		prezime = ljekar.getPrezime();
		prosjecnaOcjena = ljekar.getProsjecnaOcjena();
		specijalizacija = ljekar.getSpecijalizacija();
		klinika = ljekar.getKlinika().getNaziv();
	}
	
	public LjekarDTO() {
		super();
	}
	
	public LjekarDTO(String ime, String prezime, Integer prosjecnaOcjena, Specijalizacija specijalizacija
			,
			Klinika klinika
			) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.prosjecnaOcjena = prosjecnaOcjena;
		this.specijalizacija = specijalizacija;
		this.klinika = klinika.getNaziv();
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
	public Specijalizacija getSpecijalizacija() {
		return specijalizacija;
	}
	public void setSpecijalizacija(Specijalizacija specijalizacija) {
		this.specijalizacija = specijalizacija;
	}
	public String getKlinika() {
		return klinika;
	}
	public void setKlinika(String klinika) {
		this.klinika = klinika;
	}

	public Integer getProsjecnaOcjena() {
		return prosjecnaOcjena;
	}

	public void setProsjecnaOcjena(Integer prosjecnaOcjena) {
		this.prosjecnaOcjena = prosjecnaOcjena;
	}
	
}
