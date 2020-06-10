package com.mrsisa.eclinic.dto;

import java.util.Set;

import com.mrsisa.eclinic.model.IzvjestajPregleda;

public class IzvjestajPregledaDTO {
	
	private String izvjestaj;
	private DijagnozaDTO dijagnozaDTO;
	private Set<String> lijekovi;
	private Long pregledId;
	private String pacijentJbo;
	
	
	public IzvjestajPregledaDTO() {
		super();
	}
	
	public IzvjestajPregledaDTO(IzvjestajPregleda izvjestajPregleda,DijagnozaDTO dijagnozaDTO, Set<String> lijekovi, String jbo) {
		
		this.izvjestaj = izvjestajPregleda.getIzvjestaj();
		this.dijagnozaDTO = dijagnozaDTO;
		this.lijekovi = lijekovi;
		this.pregledId = izvjestajPregleda.getPregled().getPregled_id();
		this.pacijentJbo = jbo;
		
	}
	
	public IzvjestajPregledaDTO(String izvjestaj, String jbo, Long pregledId, DijagnozaDTO dijagnozaDTO, Set<String> lijekovi) {
		super();
		this.izvjestaj = izvjestaj;
		this.dijagnozaDTO = dijagnozaDTO;
		this.lijekovi = lijekovi;
		this.pacijentJbo = jbo;
		this.pregledId = pregledId;
	}
	
	


	public Long getPregledId() {
		return pregledId;
	}

	public void setPregledId(Long pregledId) {
		this.pregledId = pregledId;
	}

	public String getPacijentJbo() {
		return pacijentJbo;
	}

	public void setPacijentJbo(String pacijentJbo) {
		this.pacijentJbo = pacijentJbo;
	}

	public String getIzvjestaj() {
		return izvjestaj;
	}

	public void setIzvjestaj(String izvjestaj) {
		this.izvjestaj = izvjestaj;
	}

	public DijagnozaDTO getDijagnozaDTO() {
		return dijagnozaDTO;
	}
	public void setDijagnozaDTO(DijagnozaDTO dijagnozaDTO) {
		this.dijagnozaDTO = dijagnozaDTO;
	}
	public Set<String> getLijekovi() {
		return lijekovi;
	}
	public void setReceptDTO(Set<String> lijekovi) {
		this.lijekovi = lijekovi;
	}
	
	
	

}
