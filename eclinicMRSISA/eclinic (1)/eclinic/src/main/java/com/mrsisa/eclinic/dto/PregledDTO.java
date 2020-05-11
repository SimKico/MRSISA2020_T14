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
	private Ljekar ljekar;
	public TipPregleda tipPregleda;

	public PregledDTO() {
		super();
	}
	
	public PregledDTO(Pregled pregled) {
		this(
				pregled.getDatum(),
				pregled.getVrijemePocetka(),
				pregled.getStatus(),
				pregled.getLjekar(),
				pregled.getTipPregleda()
				);
	}
	public PregledDTO(Date datum, Date vrijemePocetka, StatusPregleda status, Ljekar ljekar,
			TipPregleda tipPregleda) {
		super();
		this.datum = datum;
		this.vrijemePocetka = vrijemePocetka;
		this.status = status;
		this.ljekar = ljekar;
		this.tipPregleda = tipPregleda;
	}
	

}
