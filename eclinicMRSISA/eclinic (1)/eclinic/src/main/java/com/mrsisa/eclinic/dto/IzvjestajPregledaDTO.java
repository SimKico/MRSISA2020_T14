package com.mrsisa.eclinic.dto;

import java.util.Set;

import com.mrsisa.eclinic.model.IzvjestajPregleda;

public class IzvjestajPregledaDTO {
	
	private String izvjestaj;
	private DijagnozaDTO dijagnozaDTO;
	private Set<ReceptDTO> receptDTO;
	private Long pregledId;
	private String pacijentJbo;
	
	
	public IzvjestajPregledaDTO() {
		super();
	}
	
	public IzvjestajPregledaDTO(IzvjestajPregleda izvjestajPregleda,DijagnozaDTO dijagnozaDTO, Set<ReceptDTO> receptDTO, String jbo) {
		
		this.izvjestaj = izvjestajPregleda.getIzvjestaj();
		this.dijagnozaDTO = dijagnozaDTO;
		this.receptDTO = receptDTO;
		this.pregledId = izvjestajPregleda.getPregled().getPregled_id();
		this.pacijentJbo = jbo;
		
	}
	
	public IzvjestajPregledaDTO(String izvjestaj, String jbo, Long pregledId, DijagnozaDTO dijagnozaDTO, Set<ReceptDTO> receptDTO) {
		super();
		this.izvjestaj = izvjestaj;
		this.dijagnozaDTO = dijagnozaDTO;
		this.receptDTO = receptDTO;
		this.pacijentJbo = jbo;
		this.pregledId = pregledId;
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
	public Set<ReceptDTO> getReceptDTO() {
		return receptDTO;
	}
	public void setReceptDTO(Set<ReceptDTO> receptDTO) {
		this.receptDTO = receptDTO;
	}
	
	
	

}
