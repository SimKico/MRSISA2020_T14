/***********************************************************************
 * Module:  AdminKlinike.java
 * Author:  natas
 * Purpose: Defines the Class AdminKlinike
 ***********************************************************************/
package com.mrsisa.eclinic.model;
import static javax.persistence.CascadeType.ALL;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("AK")
public class AdminKlinike extends Korisnik {
   
   @ManyToOne
   @JoinColumn(name = "klinika_id", referencedColumnName = "klinika_id", nullable = false)
   public Klinika klinika;
   
   @OneToMany(cascade = {ALL}, fetch = FetchType.LAZY)
   @JoinColumn(name = "id")
   public Set<ZahtjeviZaOdsustvo> zahtjeviZaOdsustvo = new HashSet<ZahtjeviZaOdsustvo>();
   
	
  @OneToMany(cascade = {ALL}, fetch = FetchType.LAZY)
  @JoinColumn(name = "id") 
  public Set<ZahtjeviZaSale> zahtjeviZaSale = new HashSet<ZahtjeviZaSale>();
 


public Klinika getKlinika() {
	return klinika;
}

public void setKlinika(Klinika klinika) {
	this.klinika = klinika;
}


}