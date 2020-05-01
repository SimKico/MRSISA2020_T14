package com.mrsisa.eclinic.dto;

import java.util.Set;

import com.mrsisa.eclinic.model.Pacijent;
import com.mrsisa.eclinic.model.Pregled;
import com.mrsisa.eclinic.model.ZdravstveniKarton;

public class PacijentDTO {

	private String ime;
	private String prezime;
	private String jedBrojOsiguranika;
	private String adresaPrebivalista;
	private String grad;
	private String drzava;
	private Set<Pregled> pregledi;
	private ZdravstveniKarton zdravstveniKarton;
	private String brojTelefona;
	
	public PacijentDTO(Pacijent pacijent) {
		this(pacijent.getIme(),
				pacijent.getPrezime(),
				pacijent.getJedBrojOsiguranika(),
				pacijent.getAdresaPrebivalista(),
				pacijent.getBrojTelefona(),
				pacijent.getDrzava(),
				pacijent.getPregledi(),
				pacijent.getZdravstveniKarton(),
				pacijent.getGrad()
				);
	}
	
	public PacijentDTO() {
		
	}
	
	public PacijentDTO(String ime, String prezime, String jedBrojOsiguranika, String adresaPrebivalista, String grad, String drzava, Set<Pregled> pregledi,
			ZdravstveniKarton zdravstveniKarton, String brojTelefona) {
		super();
		this.setIme(ime);
		this.setPrezime(prezime);
		this.jedBrojOsiguranika = jedBrojOsiguranika;
		this.adresaPrebivalista = adresaPrebivalista;
		this.grad = grad;
		this.drzava = drzava;
		this.pregledi = pregledi;
		this.zdravstveniKarton = zdravstveniKarton;
		this.brojTelefona = brojTelefona;
	}

	public String getIme() {
		return ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public String getJedBrojOsiguranika() {
		return jedBrojOsiguranika;
	}

	public String getAdresaPrebivalista() {
		return adresaPrebivalista;
	}

	public String getGrad() {
		return grad;
	}

	public String getDrzava() {
		return drzava;
	}

	public Set<Pregled> getPregledi() {
		return pregledi;
	}

	public ZdravstveniKarton getZdravstveniKarton() {
		return zdravstveniKarton;
	}

	public String getBrojTelefona() {
		return brojTelefona;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public void setJedBrojOsiguranika(String jedBrojOsiguranika) {
		this.jedBrojOsiguranika = jedBrojOsiguranika;
	}

	public void setAdresaPrebivalista(String adresaPrebivalista) {
		this.adresaPrebivalista = adresaPrebivalista;
	}

	public void setGrad(String grad) {
		this.grad = grad;
	}

	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}

	public void setPregledi(Set<Pregled> pregledi) {
		this.pregledi = pregledi;
	}

	public void setZdravstveniKarton(ZdravstveniKarton zdravstveniKarton) {
		this.zdravstveniKarton = zdravstveniKarton;
	}

	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
	}

	
	
}
