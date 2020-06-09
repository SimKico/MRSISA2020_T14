/***********************************************************************
 * Module:  ZdravstveniKarton.java
 * Author:  natas
 * Purpose: Defines the Class ZdravstveniKarton
 ***********************************************************************/
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="zdravstveni_karton")
public class ZdravstveniKarton {
	
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   @Column(name="karton_id", unique=false, nullable=false)
   private Long idKartona;
   
   @Column(name="krvna_grupa", unique=false)
   private String krvnaGrupa;

   @Column(name="visina", unique=false)
   private int visinaCm;
 
   @Column(name="tezina", unique=false)
   private int tezinaKg;
  
   @Column(name="alergije", unique=false)
   private String alergije;

   @Column(name="dioptrija", unique=false)
   private String dioptrija;
   
   @OneToMany(cascade = {ALL}, fetch = FetchType.LAZY, mappedBy = "zdravstveniKarton")
   private Set<Operacija> operacije = new HashSet<Operacija>();
   
   @OneToOne(mappedBy="zdravstveniKarton")
   public Pacijent pacijent;
   
   @OneToMany(cascade = {ALL}, fetch = FetchType.LAZY)
   @JoinColumn(name="karton_id")
   private Set<IzvjestajPregleda> izvjestajPregleda = new HashSet<IzvjestajPregleda>();

public Long getIdKartona() {
	return idKartona;
}

public void setIdKartona(Long idKartona) {
	this.idKartona = idKartona;
}

public String getKrvnaGrupa() {
	return krvnaGrupa;
}

public void setKrvnaGrupa(String krvnaGrupa) {
	this.krvnaGrupa = krvnaGrupa;
}

public int getVisinaCm() {
	return visinaCm;
}

public void setVisinaCm(int visinaCm) {
	this.visinaCm = visinaCm;
}

public int getTezinaKg() {
	return tezinaKg;
}

public void setTezinaKg(int tezinaKg) {
	this.tezinaKg = tezinaKg;
}

public String getAlergije() {
	return alergije;
}

public void setAlergije(String alergije) {
	this.alergije = alergije;
}

public String getDioptrija() {
	return dioptrija;
}

public void setDioptrija(String dioptrija) {
	this.dioptrija = dioptrija;
}

public Set<Operacija> getOperacije() {
	return operacije;
}

public void setOperacije(Set<Operacija> operacije) {
	this.operacije = operacije;
}

public Pacijent getPacijent() {
	return pacijent;
}

public void setPacijent(Pacijent pacijent) {
	this.pacijent = pacijent;
}

public Set<IzvjestajPregleda> getIzvjestajPregleda() {
	return izvjestajPregleda;
}

public void setIzvjestajPregleda(Set<IzvjestajPregleda> izvjestajPregleda) {
	this.izvjestajPregleda = izvjestajPregleda;
}
   
   
   
 
}