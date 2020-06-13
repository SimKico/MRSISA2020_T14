/***********************************************************************
 * Module:  AdminKlinike.java
 * Author:  natas
 * Purpose: Defines the Class AdminKlinike
 ***********************************************************************/
package com.mrsisa.eclinic.model;
import static javax.persistence.CascadeType.ALL;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
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

	private static final long serialVersionUID = 1L;

   @ManyToOne
   @JoinColumn(name = "klinika_id", referencedColumnName = "klinika_id")
   public Klinika klinika;
   
   @OneToMany(cascade = {ALL}, fetch = FetchType.LAZY)
   @JoinColumn(name = "id")
   public Set<ZahtjeviZaOdsustvo> zahtjeviZaOdsustvo = new HashSet<ZahtjeviZaOdsustvo>();
   
	
  @OneToMany(cascade = {ALL}, fetch = FetchType.LAZY)
  @JoinColumn(name = "id") 
  public Set<ZahtjeviZaSale> zahtjeviZaSale = new HashSet<ZahtjeviZaSale>();
 
  @OneToMany(cascade = {ALL}, fetch = FetchType.LAZY)
  @JoinColumn(name = "id") 
  public Set<ZahtjeviZaPregled> zahtjeviZaPregled = new HashSet<ZahtjeviZaPregled>();
 
  public AdminKlinike(Long id, String tip, boolean aktivan, String ime, String prezime, boolean dodijeljenaLozinka,
			Prijava prijava, boolean enabled, Date lastPasswordResetDate, List<Authority> authorities, Klinika klinika,
			Set<ZahtjeviZaOdsustvo> zahtjeviZaOdsustvo, Set<ZahtjeviZaSale> zahtjeviZaSale,
			Set<ZahtjeviZaPregled> zahtjeviZaPregled) {
		super( aktivan, ime, prezime, dodijeljenaLozinka, prijava, enabled, lastPasswordResetDate, authorities, prijava.geteAdresa(),prijava.getLozinka());
		this.klinika = klinika;
		this.zahtjeviZaOdsustvo = zahtjeviZaOdsustvo;
		this.zahtjeviZaSale = zahtjeviZaSale;
		this.zahtjeviZaPregled = zahtjeviZaPregled;
	}


public AdminKlinike() {
	// TODO Auto-generated constructor stub
}


public Klinika getKlinika() {
	return klinika;
}

public void setKlinika(Klinika klinika) {
	this.klinika = klinika;
}


}