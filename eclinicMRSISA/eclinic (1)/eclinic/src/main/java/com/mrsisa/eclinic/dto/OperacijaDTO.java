package com.mrsisa.eclinic.dto;

import java.util.HashSet;
import java.util.Set;

import com.mrsisa.eclinic.model.Operacija;
import com.mrsisa.eclinic.model.Sala;


public class OperacijaDTO {
	private Integer trajanje;
	   
	   private String tipOperacije;
	   
	   private String vrijemePocetka;
	   
	   public String sala;
	   
	   private Set<LjekarDTO> ljekari = new HashSet<LjekarDTO>();
	   
	   public ZdravstveniKartonDTO zdravstveniKarton;
	   
	   private String klinika;
	   
	   private String ljekar;
	   
	 

	   public OperacijaDTO() {
		super();
	}

	public OperacijaDTO(Integer trajanje, String tipOperacije, String vrijemePocetka, String sala, Set<LjekarDTO> ljekari,
			ZdravstveniKartonDTO zdravstveniKarton) {
		super();
		this.trajanje = trajanje;
		this.tipOperacije = tipOperacije;
		this.vrijemePocetka = vrijemePocetka;
		this.sala = sala;
		this.ljekari = ljekari;
		this.zdravstveniKarton = zdravstveniKarton;
	}


	public OperacijaDTO(Operacija o) {
		this.trajanje = o.getTrajanje();
		this.tipOperacije = o.getTipOperacije();
		this.ljekar = o.getLjekari().toString();
		this.klinika = o.getSala().getKlinika().toString();
	
	}

	public Integer getTrajanje() {
		return trajanje;
	}

	public void setTrajanje(Integer trajanje) {
		this.trajanje = trajanje;
	}

	public String getTipOperacije() {
		return tipOperacije;
	}

	public void setTipOperacije(String tipOperacije) {
		this.tipOperacije = tipOperacije;
	}

	public String getVrijemePocetka() {
		return vrijemePocetka;
	}

	public void setVrijemePocetka(String vrijemePocetka) {
		this.vrijemePocetka = vrijemePocetka;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public Set<LjekarDTO> getLjekari() {
		return ljekari;
	}

	public void setLjekari(Set<LjekarDTO> ljekari) {
		this.ljekari = ljekari;
	}

	public ZdravstveniKartonDTO getZdravstveniKarton() {
		return zdravstveniKarton;
	}

	public void setZdravstveniKarton(ZdravstveniKartonDTO zdravstveniKarton) {
		this.zdravstveniKarton = zdravstveniKarton;
	}

	public String getKlinika() {
		return klinika;
	}

	public void setKlinika(String klinika) {
		this.klinika = klinika;
	}

	public String getLjekar() {
		return ljekar;
	}

	public void setLjekar(String ljekar) {
		this.ljekar = ljekar;
	}
}
