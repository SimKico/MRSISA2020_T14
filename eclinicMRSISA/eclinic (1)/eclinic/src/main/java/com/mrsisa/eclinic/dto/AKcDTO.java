package com.mrsisa.eclinic.dto;

import java.util.Set;

import com.mrsisa.eclinic.model.AdminKlinickogCentra;
import com.mrsisa.eclinic.model.ZahtjeviZaRegistraciju;

public class AKcDTO {
	
	private String ime;
	private String prezime;
	private String eadresa;
	private String lozinka;
	//private Set<ZahtjeviZaRegistraciju> zahtjeviZaRegistraciju;
	
	
	public AKcDTO(String ime, String prezime, String eadresa, String lozinka) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.eadresa = eadresa;
		this.lozinka = lozinka;
		//this.zahtjeviZaRegistraciju = zahtjeviZaRegistraciju;
	}
	
	public AKcDTO(AdminKlinickogCentra akc) {
		this.ime = akc.getIme();
		this.prezime=akc.getPrezime();
		this.eadresa=akc.getPrijava().geteAdresa();
		this.lozinka=akc.getPrijava().getLozinka();
		//this.zahtjeviZaRegistraciju=akc.zahtjeviZaRegistraciju;
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
	
	
//	public Set<ZahtjeviZaRegistraciju> getZahtjeviZaRegistraciju() {
//		return zahtjeviZaRegistraciju;
//	}
//	public void setZahtjeviZaRegistraciju(Set<ZahtjeviZaRegistraciju> zahtjeviZaRegistraciju) {
//		this.zahtjeviZaRegistraciju = zahtjeviZaRegistraciju;
//	}
//
//	@Override
//	public String toString() {
//		return "AKcDTO [ime=" + ime + ", prezime=" + prezime + ", eadresa=" + eadresa + ", zahtjeviZaRegistraciju="
//				+ zahtjeviZaRegistraciju + "]";
//	}
	
	
	
	
	
	
}
