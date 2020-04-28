/***********************************************************************
 * Module:  Pacijent.java
 * Author:  natas
 * Purpose: Defines the Class Pacijent
 ***********************************************************************/
package com.mrsisa.eclinic.model;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("P")
public class Pacijent extends Korisnik {
   
   @Column(name="jbo", unique=false, nullable=false)
   private String jedBrojOsiguranika;
   
   @Column(name="broj_telefona", unique=false, nullable=false)
   private String brojTelefona;
   
   @Column(name="adresa", unique=false, nullable=false)
   private String adresaPrebivalsta;
   
   @Column(name="grad", unique=false, nullable=false)
   private String grad;
  
   @Column(name="drzava", unique=false, nullable=false)
   private String drzava;
   
   @OneToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="karton_id", referencedColumnName="karton_id")
   public ZdravstveniKarton zdravstveniKarton;
   
   @OneToMany(fetch=FetchType.LAZY, mappedBy="pacijent")
   private Set<Pregled> pregledi = new HashSet<Pregled>();

public String getJedBrojOsiguranika() {
	return jedBrojOsiguranika;
}

public void setJedBrojOsiguranika(String jedBrojOsiguranika) {
	this.jedBrojOsiguranika = jedBrojOsiguranika;
}

public String getBrojTelefona() {
	return brojTelefona;
}

public void setBrojTelefona(String brojTelefona) {
	this.brojTelefona = brojTelefona;
}

public String getAdresaPrebivalsta() {
	return adresaPrebivalsta;
}

public void setAdresaPrebivalsta(String adresaPrebivalsta) {
	this.adresaPrebivalsta = adresaPrebivalsta;
}

public String getGrad() {
	return grad;
}

public void setGrad(String grad) {
	this.grad = grad;
}

public String getDrzava() {
	return drzava;
}

public void setDrzava(String drzava) {
	this.drzava = drzava;
}

public ZdravstveniKarton getZdravstveniKarton() {
	return zdravstveniKarton;
}

public void setZdravstveniKarton(ZdravstveniKarton zdravstveniKarton) {
	this.zdravstveniKarton = zdravstveniKarton;
}

public Set<Pregled> getPregledi() {
	return pregledi;
}

public void setPregledi(Set<Pregled> pregledi) {
	this.pregledi = pregledi;
}
   
   

}