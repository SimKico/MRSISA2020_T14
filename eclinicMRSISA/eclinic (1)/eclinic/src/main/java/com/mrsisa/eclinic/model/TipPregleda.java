/***********************************************************************
 * Module:  TipPregleda.java
 * Author:  natas
 * Purpose: Defines the Class TipPregleda
 ***********************************************************************/
package com.mrsisa.eclinic.model;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name= "tip_pregleda")
public class TipPregleda {
	

	@Column(name="cijena", unique=false, nullable=false)
   private Double cijena;

   @Id
   @Column(name="sifra", unique=true, nullable=false)
   private String sifra;
   

   @Column(name="trajanje", unique=false, nullable=false)
   private int trajanje;
   

   @Column(name="tip", unique=false, nullable=false)
   private Specijalizacija tip;
   @JsonManagedReference
   @OneToMany(fetch = FetchType.LAZY, mappedBy="tipPregleda")
   private Set<Pregled> pregledi = new HashSet<Pregled>();

public Double getCijena() {
	return cijena;
}

public void setCijena(Double cijena) {
	this.cijena = cijena;
}

public String getSifra() {
	return sifra;
}

public void setSifra(String sifra) {
	this.sifra = sifra;
}

public int getTrajanje() {
	return trajanje;
}

public void setTrajanje(int trajanje) {
	this.trajanje = trajanje;
}

public Specijalizacija getTip() {
	return tip;
}

public void setTip(Specijalizacija tip) {
	this.tip = tip;
}

public Set<Pregled> getPregledi() {
	return pregledi;
}

public void setPregledi(Set<Pregled> pregledi) {
	this.pregledi = pregledi;
}

   

}