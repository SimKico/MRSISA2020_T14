package com.mrsisa.eclinic.dto;

import java.util.Date;

import com.mrsisa.eclinic.model.Pregled;
import com.mrsisa.eclinic.model.StatusPregleda;


public class PregledDTO {
	
	private Date datum;
	private String vrijemePocetka;
	private StatusPregleda status;
	private LjekarDTO ljekarDTO;
	private TipPregledaDTO tipPregledaDTO;
	private String adresaKlinike;
	private String grad;
	private	Double ocjenaKlinike;
	private PacijentDTO pacijentDTO;
	private Long id;
	
	public PregledDTO(Pregled pregled, LjekarDTO ljekarDTO, TipPregledaDTO tipPregledaDTO
			, String adresaKlinike, String grad, Double ocjenaKlinike, PacijentDTO pacijentDTO
			) {
		this(
				pregled.getPregled_id(),
				pregled.getDatum(),
				pregled.getVrijemePocetka(),
				pregled.getStatus(),
				ljekarDTO,
				tipPregledaDTO, 
				adresaKlinike,
				grad,
				ocjenaKlinike,
				pacijentDTO
				);
	}
	public PregledDTO(Long id, Date datum, String vrijemePocetka, StatusPregleda status, LjekarDTO ljekarDTO,
			TipPregledaDTO tipPregledaDTO, String adresaKlinike,String grad, Double ocjenaKlinike, PacijentDTO pacijentDTO) {
		super();
		this.setId(id);
		this.datum = datum;
		this.vrijemePocetka = vrijemePocetka;
		this.status = status;
		this.ljekarDTO = ljekarDTO;
		this.tipPregledaDTO = tipPregledaDTO;
		this.setAdresaKlinike(adresaKlinike);
		this.setGrad(grad);
		this.setOcjenaKlinike(ocjenaKlinike);
		this.setPacijentDTO(pacijentDTO);
	}
	
	

	public PregledDTO() {
		// TODO Auto-generated constructor stub
	}
	public PacijentDTO getPacijentDTO() {
		return pacijentDTO;
	}
	public void setPacijentDTO(PacijentDTO pacijentDTO) {
		this.pacijentDTO = pacijentDTO;
	}
	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public String getVrijemePocetka() {
		return vrijemePocetka;
	}

	public void setVrijemePocetka(String vrijemePocetka) {
		this.vrijemePocetka = vrijemePocetka;
	}

	public StatusPregleda getStatus() {
		return status;
	}

	public void setStatus(StatusPregleda status) {
		this.status = status;
	}

	public LjekarDTO getLjekarDTO() {
		return ljekarDTO;
	}

	public void setLjekarDTO(LjekarDTO ljekarDTO) {
		this.ljekarDTO = ljekarDTO;
	}

	public TipPregledaDTO getTipPregledaDTO() {
		return tipPregledaDTO;
	}

	public void setTipPregledaDTO(TipPregledaDTO tipPregledaDTO) {
		this.tipPregledaDTO = tipPregledaDTO;
	}
	public String getAdresaKlinike() {
		return adresaKlinike;
	}
	public void setAdresaKlinike(String adresaKlinike) {
		this.adresaKlinike = adresaKlinike;
	}
	public Double getOcjenaKlinike() {
		return ocjenaKlinike;
	}
	public void setOcjenaKlinike(Double ocjenaKlinike) {
		this.ocjenaKlinike = ocjenaKlinike;
	}
	public String getGrad() {
		return grad;
	}
	public void setGrad(String grad) {
		this.grad = grad;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	

}
