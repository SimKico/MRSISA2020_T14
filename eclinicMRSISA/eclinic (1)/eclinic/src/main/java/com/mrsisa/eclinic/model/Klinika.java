package com.mrsisa.eclinic.model;
import static javax.persistence.CascadeType.ALL;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name= "klinike")
public class Klinika {


@Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   @Column(name="klinika_id", unique=true, nullable=false)
   private Long id;
   
   @Column(name="naziv_klinike", unique=true, nullable=false)
   private String naziv;
   
   @Column(name="grad", unique=false, nullable=false)
   private String grad;
   
   @Column(name="tip_klinike", unique=false, nullable=false)
   private int tipKlinike;
   
   @Column(name="ocjena_klinike", unique=false, nullable=false)
   private int ocjenaKlinike;
   
   @OneToMany(cascade = {ALL}, fetch = FetchType.LAZY)
   @JoinColumn(name = "broj_sale")
   private Set<Sala> sala = new HashSet<Sala>();
  
   @OneToMany(cascade = {ALL}, fetch = FetchType.LAZY)
   @JoinColumn(name = "pregled_id")
   private Set<Pregled> pregled = new HashSet<Pregled>();
//  
   @ManyToMany
   @JoinTable(name = "TipoviPregledaUKlinici", joinColumns = @JoinColumn(name = "klinika_id",referencedColumnName = "klinika_id"), inverseJoinColumns = @JoinColumn(name = "sifra", referencedColumnName = "sifra"))
   private Set<TipPregleda> tipoviPregleda = new HashSet<TipPregleda>();
   
   @OneToMany(cascade = {ALL}, fetch = FetchType.LAZY, mappedBy = "klinika")
   private Set<AdminKlinike> adminKlinike = new HashSet<AdminKlinike>();
   
   @OneToMany(fetch=FetchType.LAZY, mappedBy="klinika")
   @JsonManagedReference
   private Set<Ljekar> ljekari = new HashSet<Ljekar>();
   
   @OneToMany(fetch=FetchType.LAZY, mappedBy="klinika")
	private Set<MedicinskaSestra> sestre = new HashSet<MedicinskaSestra>();

   
	
   public Klinika() {
		super();
	}
   
   public Klinika(Long id, String naziv, String grad, int tipKlinike, int ocjenaKlinike) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.grad = grad;
		this.tipKlinike = tipKlinike;
		this.ocjenaKlinike = ocjenaKlinike;
	}

   

   public Klinika(Long id, String naziv, String grad, int tipKlinike, int ocjenaKlinike, Set<Sala> sala,
			Set<Pregled> pregled, Set<TipPregleda> tipoviPregleda, Set<AdminKlinike> adminKlinike, Set<Ljekar> ljekari,
			Set<MedicinskaSestra> sestre) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.grad = grad;
		this.tipKlinike = tipKlinike;
		this.ocjenaKlinike = ocjenaKlinike;
		this.sala = sala;
		this.pregled = pregled;
		this.tipoviPregleda = tipoviPregleda;
		this.adminKlinike = adminKlinike;
		this.ljekari = ljekari;
		this.sestre = sestre;
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

public Set<Sala> getSala() {
	return sala;
}

public void setSala(Set<Sala> sala) {
	this.sala = sala;
}

public Set<Pregled> getPregled() {
	return pregled;
}

public void setPregled(Set<Pregled> pregled) {
	this.pregled = pregled;
}

public Set<TipPregleda> getTipoviPregleda() {
	return tipoviPregleda;
}

public void setTipoviPregleda(Set<TipPregleda> tipoviPregleda) {
	this.tipoviPregleda = tipoviPregleda;
}

public Set<AdminKlinike> getAdminKlinike() {
	return adminKlinike;
}

public void setAdminKlinike(Set<AdminKlinike> adminKlinike) {
	this.adminKlinike = adminKlinike;
}

public Set<Ljekar> getLjekari() {
	return ljekari;
}

public void setLjekari(Set<Ljekar> ljekari) {
	this.ljekari = ljekari;
}

public Set<MedicinskaSestra> getSestre() {
	return sestre;
}

public void setSestre(Set<MedicinskaSestra> sestre) {
	this.sestre = sestre;
}
   

	}