package com.mrsisa.eclinic.dto;

import java.sql.Date;

public class PretragaLjekaraDTO {
	String ime;
	String prezime;
	String tip;
	Date datum;
	Integer ocjena;
	public PretragaLjekaraDTO() {
		super();
	}
	public PretragaLjekaraDTO(String ime, String prezime, String tip, Integer ocjena) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.tip = tip;
		//this.datum = date;
		this.ocjena = ocjena;
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
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public Date getDatum() {
		return datum;
	}
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	public int getOcjena() {
		return ocjena;
	}
	public void setOcjena(int ocjena) {
		this.ocjena = ocjena;
	}
	
	
	
}
