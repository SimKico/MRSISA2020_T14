package com.mrsisa.eclinic.dto;

import java.util.Date;

import com.mrsisa.eclinic.model.Ljekar;
import com.mrsisa.eclinic.model.Pregled;
import com.mrsisa.eclinic.model.StatusPregleda;
import com.mrsisa.eclinic.model.TipPregleda;


public class PregledDTO {
	
	private Date datum;
	private Date vrijemePocetka;
	private StatusPregleda status;
	private LjekarDTO ljekarDTO;
	private TipPregledaDTO tipPregledaDTO;
	private String adresaKlinike;
	private String grad;
	private	Double ocjenaKlinike;

	
	public PregledDTO(Pregled pregled, LjekarDTO ljekarDTO, TipPregledaDTO tipPregledaDTO
			, String adresaKlinike, String grad, Double ocjenaKlinike
			) {
		this(
				pregled.getDatum(),
				pregled.getVrijemePocetka(),
				pregled.getStatus(),
				ljekarDTO,
				tipPregledaDTO, 
				adresaKlinike,
				grad,
				ocjenaKlinike
				);
	}
	public PregledDTO(Date datum, Date vrijemePocetka, StatusPregleda status, LjekarDTO ljekarDTO,
			TipPregledaDTO tipPregledaDTO, String adresaKlinike,String grad, Double ocjenaKlinike) {
		super();
		this.datum = datum;
		this.vrijemePocetka = vrijemePocetka;
		this.status = status;
		this.ljekarDTO = ljekarDTO;
		this.tipPregledaDTO = tipPregledaDTO;
		this.setAdresaKlinike(adresaKlinike);
		this.setGrad(grad);
		this.setOcjenaKlinike(ocjenaKlinike);
	}


	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public Date getVrijemePocetka() {
		return vrijemePocetka;
	}

	public void setVrijemePocetka(Date vrijemePocetka) {
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
	

}
