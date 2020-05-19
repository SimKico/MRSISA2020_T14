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
	private Set<PregledDTO> preglediDTO;
//	private ZdravstveniKartonDTO zdravstveniKartonDTO;
	private String brojTelefona;
	private String email;
	
	public PacijentDTO(Pacijent pacijent, Set<PregledDTO> preglediDTO) {
		this(	pacijent.getPrijava().geteAdresa(),
				pacijent.getIme(),
				pacijent.getPrezime(),
				pacijent.getJedBrojOsiguranika(),
				pacijent.getAdresaPrebivalista(),
				pacijent.getBrojTelefona(),
				pacijent.getDrzava(),
				pacijent.getGrad(),
				preglediDTO
				);
	}
	
	
	
	public PacijentDTO(String email, String ime, String prezime, String jedBrojOsiguranika, String adresaPrebivalista, String brojTelefona , String drzava,
			 String grad, Set<PregledDTO> preglediDTO) {
		super();
		this.email = email;
		this.ime = ime;
		this.prezime = prezime;
		this.jedBrojOsiguranika = jedBrojOsiguranika;
		this.adresaPrebivalista = adresaPrebivalista;
		this.grad = grad;
		this.drzava = drzava;
	//	this.zdravstveniKarton = zdravstveniKarton;
		this.brojTelefona = brojTelefona;
		this.preglediDTO = preglediDTO;
	}

	public PacijentDTO(Pacijent pacijent) {
		super();
		this.email = pacijent.getPrijava().geteAdresa();
		this.ime = pacijent.getIme();
		this.prezime = pacijent.getPrezime();
		this.jedBrojOsiguranika = pacijent.getJedBrojOsiguranika();
		this.adresaPrebivalista = pacijent.getAdresaPrebivalista();
		this.grad = pacijent.getGrad();
		this.drzava = pacijent.getDrzava();
	//	this.zdravstveniKarton = zdravstveniKarton;
		this.brojTelefona = pacijent.getBrojTelefona();
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

	public Set<PregledDTO> getPregledi() {
		return preglediDTO;
	}

//	public ZdravstveniKarton getZdravstveniKarton() {
//		return zdravstveniKarton;
//	}

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

	public void setPregledi(Set<PregledDTO> preglediDTO) {
		this.preglediDTO = preglediDTO;
	}

//	public void setZdravstveniKarton(ZdravstveniKarton zdravstveniKarton) {
//		this.zdravstveniKarton = zdravstveniKarton;
//	}

	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
}
