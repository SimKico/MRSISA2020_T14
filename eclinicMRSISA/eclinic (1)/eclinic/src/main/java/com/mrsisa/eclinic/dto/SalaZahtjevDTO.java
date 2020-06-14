package com.mrsisa.eclinic.dto;

import java.util.List;

public class SalaZahtjevDTO {
	
	private Long idLjekara;
	private List<LjekarDTO> ljekari;
	
	
	
	public SalaZahtjevDTO() {
		super();
	}
	public SalaZahtjevDTO(Long idLjekara, List<LjekarDTO> ljekari) {
		super();
		this.idLjekara = idLjekara;
		this.ljekari = ljekari;
	}
	public Long getIdLjekara() {
		return idLjekara;
	}
	public void setIdLjekara(Long idLjekara) {
		this.idLjekara = idLjekara;
	}
	public List<LjekarDTO> getLjekari() {
		return ljekari;
	}
	public void setLjekari(List<LjekarDTO> ljekari) {
		this.ljekari = ljekari;
	}
	
	
	

}
