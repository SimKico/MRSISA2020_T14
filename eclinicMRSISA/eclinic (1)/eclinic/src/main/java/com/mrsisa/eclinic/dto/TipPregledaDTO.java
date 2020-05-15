package com.mrsisa.eclinic.dto;

import java.util.Set;

import com.mrsisa.eclinic.model.Pregled;
import com.mrsisa.eclinic.model.Specijalizacija;
import com.mrsisa.eclinic.model.TipPregleda;

public class TipPregledaDTO {

	private Double cijena;
	private String sifra;
	private int trajanje;
	private Specijalizacija specijalizacija;
//	private Set<PregledDTO> preglediDTO;
	
	public TipPregledaDTO() {
		super();
	}
	
	public TipPregledaDTO(Double cijena, String sifra, int trajanje, Specijalizacija specijalizacija
//			,
//			Set<PregledDTO> preglediDTO
			) {
		super();
		this.cijena = cijena;
		this.sifra = sifra;
		this.trajanje = trajanje;
		this.specijalizacija = specijalizacija;
//		this.preglediDTO = preglediDTO;
	}

	public TipPregledaDTO(TipPregleda tipPregleda
//			, Set<PregledDTO> preglediDTO
			) {
		this(
				tipPregleda.getCijena(),
				tipPregleda.getSifra(),
				tipPregleda.getTrajanje(),
				tipPregleda.getTip()
//				,
//				preglediDTO
				);
		
	}

	public Double getCijena() {
		return cijena;
	}
	public void setCijena(Double cijena) {
		this.cijena = cijena;
	}
	public String getSifra() {
		return sifra;
	}
	public void setSifra(String sifra) {
		this.sifra = sifra;
	}
	public int getTrajanje() {
		return trajanje;
	}
	public void setTrajanje(int trajanje) {
		this.trajanje = trajanje;
	}
	public Specijalizacija getSpecijalizacija() {
		return specijalizacija;
	}
	public void setSpecijalizacija(Specijalizacija specijalizacija) {
		this.specijalizacija = specijalizacija;
	}
//	public Set<PregledDTO> getPreglediDTO() {
//		return preglediDTO;
//	}
//	public void setPreglediDTO(Set<PregledDTO> preglediDTO) {
//		this.preglediDTO = preglediDTO;
//	}
//	
}
