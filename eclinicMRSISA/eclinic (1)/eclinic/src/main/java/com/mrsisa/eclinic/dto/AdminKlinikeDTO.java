package com.mrsisa.eclinic.dto;

import java.util.HashSet;
import java.util.Set;

import com.mrsisa.eclinic.model.AdminKlinickogCentra;
import com.mrsisa.eclinic.model.AdminKlinike;
import com.mrsisa.eclinic.model.Klinika;
import com.mrsisa.eclinic.model.ZahtjeviZaOdsustvo;
import com.mrsisa.eclinic.model.ZahtjeviZaSale;


import com.mrsisa.eclinic.model.AdminKlinike;
import com.mrsisa.eclinic.model.Klinika;
import com.mrsisa.eclinic.model.Prijava;

public class AdminKlinikeDTO {
	
	private String ime;
	private String prezime;
	private String eadresa;
	private String lozinka;
	private String nazivKlinike;
	
	public AdminKlinikeDTO(){
		super();
	}
	
	public AdminKlinikeDTO(AdminKlinike ak){
		this.ime = ak.getIme();
		this.prezime = ak.getPrezime();
		this.eadresa = ak.getPrijava().geteAdresa();
		this.lozinka = ak.getPrijava().getLozinka();
		this.nazivKlinike = ak.getKlinika().getNaziv();
	}
	
	
	
	public AdminKlinikeDTO(String ime, String prezime, String eadresa, String lozinka, String nazivKlinike) {
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