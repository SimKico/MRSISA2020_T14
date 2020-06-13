package com.mrsisa.eclinic.dto;

import com.mrsisa.eclinic.model.Recept;

public class ReceptDTO {
	
	String lijek;
	String eadresaMedSestre;
	String idRecepta;
	
	public ReceptDTO() {
		super();
	}
	
	public ReceptDTO(Recept r) {
		super();
		this.lijek = r.getLijek().getNaziv();
		this.eadresaMedSestre = r.getSestra().getPrijava().geteAdresa();
		this.idRecepta = Long.toString(r.getRecept_id());
	}
	
	public ReceptDTO(String lijek, String eadresaMedSestre, Long idRecepta) {
		super();
		this.lijek = lijek;
		this.eadresaMedSestre = eadresaMedSestre;
		this.idRecepta = Long.toString(idRecepta);
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

	public String getIdRecepta() {
		return idRecepta;
	}

	public void setIdRecepta(String idRecepta) {
		this.idRecepta = idRecepta;
	}
	
	
	
	
}
