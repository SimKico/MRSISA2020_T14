package com.mrsisa.eclinic.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.mrsisa.eclinic.model.AdminKlinike;
import com.mrsisa.eclinic.model.Klinika;
import com.mrsisa.eclinic.model.Ljekar;
import com.mrsisa.eclinic.model.MedicinskaSestra;
import com.mrsisa.eclinic.model.Pregled;
import com.mrsisa.eclinic.model.Sala;
import com.mrsisa.eclinic.model.TipPregleda;

public class KlinikaDTO {
     private String naziv;
	 private String grad;
	 private String adresa;
	 private int tipKlinike;
	 private double ocjenaKlinike;
//	 private Set<Sala> sala = new HashSet<Sala>();
//	 private Set<Pregled> pregled = new HashSet<Pregled>();
//	 private Set<TipPregleda> tipoviPregleda = new HashSet<TipPregleda>();
//	 private Set<AdminKlinike> adminKlinike = new HashSet<AdminKlinike>();
	 private Set<LjekarDTO> ljekari =  new HashSet<LjekarDTO>();
//	 private Set<MedicinskaSestra> sestre = new HashSet<MedicinskaSestra>();
	 
	public KlinikaDTO() {
		super();
	}
	
	public KlinikaDTO(String naziv, String grad,String adresa,  int tipKlinike, double ocjenaKlinike
			, Set<LjekarDTO> ljekari
			) {
		super();
		this.naziv = naziv;
		this.grad = grad;
		this.setAdresa(adresa);
		this.tipKlinike = tipKlinike;
		this.ocjenaKlinike = ocjenaKlinike;
		this.ljekari = ljekari;
	}
	 
	public KlinikaDTO(Klinika klinika, Set<LjekarDTO> ljekariDTO) {
		this(
				klinika.getNaziv(),
				klinika.getGrad(),
				klinika.getAdresa(),
				klinika.getTipKlinike(),
				klinika.getOcjenaKlinike(),
				ljekariDTO
			);
	}

	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getGrad() {
		return grad;
	}
	public void setGrad(String grad) {
		this.grad = grad;
	}
	public int getTipKlinike() {
		return tipKlinike;
	}
	public void setTipKlinike(int tipKlinike) {
		this.tipKlinike = tipKlinike;
	}
	public Double getOcjenaKlinike() {
		return ocjenaKlinike;
	}
	public void setOcjenaKlinike(Double ocjenaKlinike) {
		this.ocjenaKlinike = ocjenaKlinike;
	}
//	public Set<Sala> getSala() {
//		return sala;
//	}
//	public void setSala(Set<Sala> sala) {
//		this.sala = sala;
//	}
//	public Set<Pregled> getPregled() {
//		return pregled;
//	}
//	public void setPregled(Set<Pregled> pregled) {
//		this.pregled = pregled;
//	}
//	public Set<TipPregleda> getTipoviPregleda() {
//		return tipoviPregleda;
//	}
//	public void setTipoviPregleda(Set<TipPregleda> tipoviPregleda) {
//		this.tipoviPregleda = tipoviPregleda;
//	}
//	public Set<AdminKlinike> getAdminKlinike() {
//		return adminKlinike;
//	}
//	public void setAdminKlinike(Set<AdminKlinike> adminKlinike) {
//		this.adminKlinike = adminKlinike;
//	}
	public Set<LjekarDTO> getLjekari() {
		return ljekari;
	}
	public void setLjekari(Set<LjekarDTO> ljekari) {
		this.ljekari = ljekari;
	}
//	public Set<MedicinskaSestra> getSestre() {
//		return sestre;
//	}
//	public void setSestre(Set<MedicinskaSestra> sestre) {
//		this.sestre = sestre;
//	}
//	 

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	 
}
