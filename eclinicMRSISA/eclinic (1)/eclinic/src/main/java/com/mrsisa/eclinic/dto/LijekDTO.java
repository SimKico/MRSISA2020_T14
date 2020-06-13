package com.mrsisa.eclinic.dto;

import com.mrsisa.eclinic.model.Lijek;

public class LijekDTO {
	
	String lijek;
	
	public LijekDTO(Lijek lijek){
		this.lijek = lijek.getNaziv();
	}
	
	public LijekDTO(){
		
	}
	
	public LijekDTO(String lijek) {
		super();
		this.lijek = lijek;
	}

	public String getLijek() {
		return lijek;
	}

	public void setLijek(String lijek) {
		this.lijek = lijek;
	}
	
	
}
