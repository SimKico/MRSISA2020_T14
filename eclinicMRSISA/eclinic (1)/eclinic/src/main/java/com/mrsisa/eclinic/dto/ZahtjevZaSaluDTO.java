package com.mrsisa.eclinic.dto;

import java.util.Date;

public class ZahtjevZaSaluDTO {
	
	private Date datum;
	private String satnica;
	private String jbo;
	private long ljekarId;
	private String sala;
	
	
	
	public ZahtjevZaSaluDTO() {
		super();
	}
	public ZahtjevZaSaluDTO(Date datum, String satnica, String jbo, long ljekarId, String sala) {
		super();
		this.datum = datum;
		this.satnica = satnica;
		this.jbo = jbo;
		this.ljekarId = ljekarId;
		this.sala = sala;
	}
	public Date getDatum() {
		return datum;
	}
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	public String getSatnica() {
		return satnica;
	}
	public void setSatnica(String satnica) {
		this.satnica = satnica;
	}
	public String getJbo() {
		return jbo;
	}
	public void setJbo(String jbo) {
		this.jbo = jbo;
	}
	public long getLjekarId() {
		return ljekarId;
	}
	public void setLjekarId(long ljekarId) {
		this.ljekarId = ljekarId;
	}
	public String getSala() {
		return sala;
	}
	public void setSala(String sala) {
		this.sala = sala;
	}
	
	
	

}
