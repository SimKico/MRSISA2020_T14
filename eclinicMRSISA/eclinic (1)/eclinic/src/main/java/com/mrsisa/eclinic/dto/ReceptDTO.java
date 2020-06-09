package com.mrsisa.eclinic.dto;

public class ReceptDTO {
	
	String lijek;
	String eadresaMedSestre;
	
	public ReceptDTO() {
		super();
	}
	
	public ReceptDTO(LijekDTO lijekDTO){
		this.lijek = lijekDTO.lijek;
		//this.eadresaMedSestre = null;
	}
	
	public ReceptDTO(String lijek, String eadresaMedSestre) {
		super();
		this.lijek = lijek;
		this.eadresaMedSestre = eadresaMedSestre;
	}



	public String getLijek() {
		return lijek;
	}
	
	public void setLijek(String lijek) {
		this.lijek = lijek;
	}
	
	public String getEadresaMedSestre() {
		return eadresaMedSestre;
	}
	
	public void setEadresaMedSestre(String eadresaMedSestre) {
		this.eadresaMedSestre = eadresaMedSestre;
	}
	
	
}
