/***********************************************************************
 * Module:  Pregled.java
 * Author:  natas
 * Purpose: Defines the Class Pregled
 ***********************************************************************/
package com.mrsisa.eclinic.model;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="pregledi")
public class Pregled {
   
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   @Column(name="pregled_id", unique=true, nullable=false)
   private Long pregled_id;
   
   @Column(name="datum_pregleda", unique=false, nullable=false)
   private Date datum;
   
   @Column(name="popust", unique=false, nullable=false)
   private int popust;
   
   @Column(name="vrijeme_pocetka", unique=false, nullable=false)
   private Date vrijemePocetka;
   
   @Column(name="status", unique=false, nullable=false)
   private StatusPregleda status;
   
   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name = "ljekar_id", referencedColumnName="id")
   private Ljekar ljekar;
   
   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name = "pacijent_id", referencedColumnName="id")
   private Pacijent pacijent;
   
   @OneToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="broj_sale")
   private Sala sala;
   
   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name = "sifra_pregleda", unique = false, referencedColumnName="sifra")
   @JsonBackReference
   public TipPregleda tipPregleda;

   
public Long getPregled_id() {
	return pregled_id;
}

public void setPregled_id(Long pregled_id) {
	this.pregled_id = pregled_id;
}

public Date getDatum() {
	return datum;
}

public void setDatum(Date datum) {
	this.datum = datum;
}

public int getPopust() {
	return popust;
}

public void setPopust(int popust) {
	this.popust = popust;
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

public Ljekar getLjekar() {
	return ljekar;
}

public void setLjekar(Ljekar ljekar) {
	this.ljekar = ljekar;
}

public Pacijent getPacijent() {
	return pacijent;
}

public void setPacijent(Pacijent pacijent) {
	this.pacijent = pacijent;
}

public Sala getSala() {
	return sala;
}

public void setSala(Sala sala) {
	this.sala = sala;
}

public TipPregleda getTipPregleda() {
	return tipPregleda;
}

public void setTipPregleda(TipPregleda tipPregleda) {
	this.tipPregleda = tipPregleda;
}

   
}