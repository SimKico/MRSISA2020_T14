package com.mrsisa.eclinic.dto;

import java.util.Date;

public class ZakaziPregledDTO {
	
	private Date datum;
	private int popust;
	private String vrijemePocetka;
	private Long idTekucegPregleda;
	
	
	public ZakaziPregledDTO() {
		super();
	}
	public ZakaziPregledDTO(Date datum, int popust, String vrijemePocetka, Long idTekucegPregleda) {
		super();
		this.datum = datum;
		this.popust = popust;
		this.vrijemePocetka = vrijemePocetka;
		this.idTekucegPregleda = idTekucegPregleda;
	}
	public Date getDatum() {
		return datum;
	}
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	public int getPopust() {
		return popust;
	}
	public void setPopust(int popust) {
		this.popust = popust;
	}
	public String getVrijemePocetka() {
		return vrijemePocetka;
	}
	public void setVrijemePocetka(String vrijemePocetka) {
		this.vrijemePocetka = vrijemePocetka;
	}
	public Long getIdTekucegPregleda() {
		return idTekucegPregleda;
	}
	public void setIdTekucegPregleda(Long idTekucegPregleda) {
		this.idTekucegPregleda = idTekucegPregleda;
	}
	
	

}
