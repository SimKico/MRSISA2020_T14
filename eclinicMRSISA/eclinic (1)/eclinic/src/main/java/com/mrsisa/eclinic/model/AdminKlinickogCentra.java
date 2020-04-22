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
   
//   
//   public java.util.Collection<ZahtjeviZaRegistraciju> getZahtjeviZaRegistraciju() {
//      if (zahtjeviZaRegistraciju == null)
//         zahtjeviZaRegistraciju = new HashSet<ZahtjeviZaRegistraciju>();
//      return zahtjeviZaRegistraciju;
//   }
//   
//   public java.util.Iterator getIteratorZahtjeviZaRegistraciju() {
//      if (zahtjeviZaRegistraciju == null)
//         zahtjeviZaRegistraciju = new HashSet<ZahtjeviZaRegistraciju>();
//      return zahtjeviZaRegistraciju.iterator();
//   }
//   
//   public void setZahtjeviZaRegistraciju(java.util.Collection<ZahtjeviZaRegistraciju> newZahtjeviZaRegistraciju) {
//      removeAllZahtjeviZaRegistraciju();
//      for (java.util.Iterator iter = newZahtjeviZaRegistraciju.iterator(); iter.hasNext();)
//         addZahtjeviZaRegistraciju((ZahtjeviZaRegistraciju)iter.next());
//   }
//   
//   public void addZahtjeviZaRegistraciju(ZahtjeviZaRegistraciju newZahtjeviZaRegistraciju) {
//      if (newZahtjeviZaRegistraciju == null)
//         return;
//      if (this.zahtjeviZaRegistraciju == null)
//         this.zahtjeviZaRegistraciju = new java.util.HashSet<ZahtjeviZaRegistraciju>();
//      if (!this.zahtjeviZaRegistraciju.contains(newZahtjeviZaRegistraciju))
//         this.zahtjeviZaRegistraciju.add(newZahtjeviZaRegistraciju);
//   }
//   
//   public void removeZahtjeviZaRegistraciju(ZahtjeviZaRegistraciju oldZahtjeviZaRegistraciju) {
//      if (oldZahtjeviZaRegistraciju == null)
//         return;
//      if (this.zahtjeviZaRegistraciju != null)
//         if (this.zahtjeviZaRegistraciju.contains(oldZahtjeviZaRegistraciju))
//            this.zahtjeviZaRegistraciju.remove(oldZahtjeviZaRegistraciju);
//   }
//   
//   public void removeAllZahtjeviZaRegistraciju() {
//      if (zahtjeviZaRegistraciju != null)
//         zahtjeviZaRegistraciju.clear();
//   }

}