package com.mrsisa.eclinic.dto;

import com.mrsisa.eclinic.model.Specijalizacija;

import java.util.List;

import com.mrsisa.eclinic.model.Klinika;
import com.mrsisa.eclinic.model.Ljekar;


public class LjekarDTO {

	private String eadresa;
	private String ime;
	private String prezime;
	private Specijalizacija specijalizacija;
	private String klinika;
	private Integer prosjecnaOcjena;
	private String radnoVrijeme;
	private List<String> slobodniTermini;
	private Long id;
	
	public LjekarDTO(Ljekar ljekar) {
		ime = ljekar.getIme();
		prezime = ljekar.getPrezime();
		prosjecnaOcjena = ljekar.getProsjecnaOcjena();
		specijalizacija = ljekar.getSpecijalizacija();
		klinika = ljekar.getKlinika().getNaziv();
		setRadnoVrijeme(ljekar.getRadnoVrijeme());
		eadresa = ljekar.getPrijava().geteAdresa();
		id = ljekar.getId();
	}
	public LjekarDTO(Ljekar ljekar, List<String> slobodniTermini1) {
		ime = ljekar.getIme();
		prezime = ljekar.getPrezime();
		prosjecnaOcjena = ljekar.getProsjecnaOcjena();
		specijalizacija = ljekar.getSpecijalizacija();
		klinika = ljekar.getKlinika().getNaziv();
		setRadnoVrijeme(ljekar.getRadnoVrijeme());
		slobodniTermini = slobodniTermini1;
		eadresa = ljekar.getPrijava().geteAdresa();
	}
	
	public LjekarDTO() {
		super();
	}
	
	public LjekarDTO(String ime, String prezime, Integer prosjecnaOcjena, Specijalizacija specijalizacija
			,
			String nazivKlinike, List<String> slobodniTermini
			) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.prosjecnaOcjena = prosjecnaOcjena;
		this.specijalizacija = specijalizacija;
		this.klinika = nazivKlinike;
		this.slobodniTermini = slobodniTermini;
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

	public String getRadnoVrijeme() {
		return radnoVrijeme;
	}

	public void setRadnoVrijeme(String radnoVrijeme) {
		this.radnoVrijeme = radnoVrijeme;
	}
	public List<String> getSlobodniTermini() {
		return slobodniTermini;
	}
	public void setSlobodniTermini(List<String> slobodniTermini) {
		this.slobodniTermini = slobodniTermini;
	}
	public String getEadresa() {
		return eadresa;
	}
	public void setEadresa(String eadresa) {
		this.eadresa = eadresa;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	
}
