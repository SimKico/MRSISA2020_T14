package com.mrsisa.eclinic.dto;

import java.util.Set;

import com.mrsisa.eclinic.model.Pacijent;
import com.mrsisa.eclinic.model.Pregled;
import com.mrsisa.eclinic.model.ZdravstveniKarton;

public class PacijentDTO {

	private String jedBrojOsiguranika;
	private String adresaPrebivalista;
	private String grad;
	private String drzava;
	private Set<Pregled> pregledi;
	private ZdravstveniKarton zdravstveniKarton;
	private String brojTelefona;
	
	public PacijentDTO(Pacijent pacijent) {
		this(pacijent.getJedBrojOsiguranika(),
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
	
	public PacijentDTO(String jedBrojOsiguranika, String adresaPrebivalista, String grad, String drzava, Set<Pregled> pregledi,
			ZdravstveniKarton zdravstveniKarton, String brojTelefona) {
		super();
		this.jedBrojOsiguranika = jedBrojOsiguranika;
		this.adresaPrebivalista = adresaPrebivalista;
		this.grad = grad;
		this.drzava = drzava;
		this.pregledi = pregledi;
		this.zdravstveniKarton = zdravstveniKarton;
		this.brojTelefona = brojTelefona;
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
	public ZdravstveniKarton getKarton() {
		return zdravstveniKarton;
	}
	public String getBrojTelefona() {
		return brojTelefona;
	}
	
	
	
}
