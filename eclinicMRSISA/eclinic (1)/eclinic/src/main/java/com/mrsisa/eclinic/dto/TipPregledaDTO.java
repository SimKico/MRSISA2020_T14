package com.mrsisa.eclinic.dto;

import com.mrsisa.eclinic.model.TipPregleda;

public class TipPregledaDTO {
	
	private int trajanje;
	private String specijalizacija;
	
	public TipPregledaDTO() {
		super();
	}
	
	public TipPregledaDTO(int trajanje, String specijalizacija) {
		this.trajanje = trajanje;
		this.specijalizacija = specijalizacija;
	}
	
	public TipPregledaDTO(TipPregleda tp) {
		this.trajanje = tp.getTrajanje();
		this.specijalizacija = tp.getTip().name();
	}

	public int getTrajanje() {
		return trajanje;
	}

	public void setTrajanje(int trajanje) {
		this.trajanje = trajanje;
	}

	public String getSpecijalizacija() {
		return specijalizacija;
	}

	public void setSpecijalizacija(String specijalizacija) {
		this.specijalizacija = specijalizacija;
	}
	

}
