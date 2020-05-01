/***********************************************************************
 * Module:  AdminKlinickogCentra.java
 * Author:  natas
 * Purpose: Defines the Class AdminKlinickogCentra
 ***********************************************************************/
package com.mrsisa.eclinic.model;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import static javax.persistence.CascadeType.ALL;;

@Entity
@DiscriminatorValue("AC")
public class AdminKlinickogCentra extends Korisnik {
   
   @OneToMany(cascade = {ALL}, fetch = FetchType.LAZY)
   @JoinColumn(name = "reg_id")
   public Set<ZahtjeviZaRegistraciju> zahtjeviZaRegistraciju = new HashSet<ZahtjeviZaRegistraciju>();

public Set<ZahtjeviZaRegistraciju> getZahtjeviZaRegistraciju() {
	return zahtjeviZaRegistraciju;
}

public void setZahtjeviZaRegistraciju(Set<ZahtjeviZaRegistraciju> zahtjeviZaRegistraciju) {
	this.zahtjeviZaRegistraciju = zahtjeviZaRegistraciju;
}
   

}