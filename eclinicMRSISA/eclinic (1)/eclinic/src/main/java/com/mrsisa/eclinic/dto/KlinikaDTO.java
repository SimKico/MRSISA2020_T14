package com.mrsisa.eclinic.dto;

import java.util.HashSet;
import java.util.Set;

import com.mrsisa.eclinic.model.AdminKlinike;
import com.mrsisa.eclinic.model.Klinika;
import com.mrsisa.eclinic.model.Ljekar;
import com.mrsisa.eclinic.model.MedicinskaSestra;
import com.mrsisa.eclinic.model.Pregled;
import com.mrsisa.eclinic.model.Sala;
import com.mrsisa.eclinic.model.TipPregleda;

public class KlinikaDTO {

	private Long id;
	private String naziv;
	 private String grad;
	 private int tipKlinike;
	 private int ocjenaKlinike;
//	 private Set<Sala> sala = new HashSet<Sala>();
//	 private Set<Pregled> pregled = new HashSet<Pregled>();
//	 private Set<TipPregleda> tipoviPregleda = new HashSet<TipPregleda>();
//	 private Set<AdminKlinike> adminKlinike = new HashSet<AdminKlinike>();
//	 private Set<Ljekar> ljekari = new HashSet<Ljekar>();
//	 private Set<MedicinskaSestra> sestre = new HashSet<MedicinskaSestra>();
	 
	public KlinikaDTO() {
		super();
	}
	
	public KlinikaDTO(Long id, String naziv, String grad, int tipKlinike,
			int ocjenaKlinike
			) 
	{
		super();
		this.id = id;
		this.naziv = naziv;
		this.grad = grad;
		this.tipKlinike = tipKlinike;
		this.ocjenaKlinike = ocjenaKlinike;

	}	 
	 
	public KlinikaDTO(Klinika klinika) {
		this(
				klinika.getId(),
				klinika.getNaziv(),
				klinika.getGrad(),
				klinika.getTipKlinike(),
				klinika.getOcjenaKlinike()
			);
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public int getOcjenaKlinike() {
		return ocjenaKlinike;
	}
	public void setOcjenaKlinike(int ocjenaKlinike) {
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
//	public Set<Ljekar> getLjekari() {
//		return ljekari;
//	}
//	public void setLjekari(Set<Ljekar> ljekari) {
//		this.ljekari = ljekari;
//	}
//	public Set<MedicinskaSestra> getSestre() {
//		return sestre;
//	}
//	public void setSestre(Set<MedicinskaSestra> sestre) {
//		this.sestre = sestre;
//	}
//	 
	 
}