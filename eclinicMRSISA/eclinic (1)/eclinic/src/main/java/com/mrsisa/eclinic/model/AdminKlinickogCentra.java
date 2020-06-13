/***********************************************************************
 * Module:  AdminKlinickogCentra.java
 * Author:  natas
 * Purpose: Defines the Class AdminKlinickogCentra
 ***********************************************************************/
package com.mrsisa.eclinic.model;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import static javax.persistence.CascadeType.ALL;;

@Entity
@DiscriminatorValue("AC")
public class AdminKlinickogCentra extends Korisnik {

	private static final long serialVersionUID = 1L;

	@Column(name="predefinisani", unique=false, columnDefinition = "boolean default false")
	private boolean predefinisaniAdmin;
   
   @OneToMany(cascade = {ALL}, fetch = FetchType.LAZY)
   @JoinColumn(name = "reg_id")
   public Set<ZahtjeviZaRegistraciju> zahtjeviZaRegistraciju = new HashSet<ZahtjeviZaRegistraciju>();

   public Set<ZahtjeviZaRegistraciju> getZahtjeviZaRegistraciju() {
		return zahtjeviZaRegistraciju;
   }
	
   public void setZahtjeviZaRegistraciju(Set<ZahtjeviZaRegistraciju> zahtjeviZaRegistraciju) {
		this.zahtjeviZaRegistraciju = zahtjeviZaRegistraciju;
   }

	public boolean isPredefinisaniAdmin() {
		return predefinisaniAdmin;
	}
	
	public void setPredefinisaniAdmin(boolean predefinisaniAdmin) {
		this.predefinisaniAdmin = predefinisaniAdmin;
	}
   

	public AdminKlinickogCentra(Long id, String tip, boolean aktivan, String ime, String prezime,
			boolean dodijeljenaLozinka, Prijava prijava, boolean enabled, Date lastPasswordResetDate,
			List<Authority> authorities, boolean predefinisaniAdmin,
			Set<ZahtjeviZaRegistraciju> zahtjeviZaRegistraciju) {
		super(aktivan, ime, prezime, dodijeljenaLozinka, prijava, enabled, lastPasswordResetDate, authorities,prijava.geteAdresa(), prijava.getLozinka());
		this.predefinisaniAdmin = predefinisaniAdmin;
		this.zahtjeviZaRegistraciju = zahtjeviZaRegistraciju;
	}

	public AdminKlinickogCentra() {
		
	}
	
}