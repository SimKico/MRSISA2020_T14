/***********************************************************************
 * Module:  AdminKlinickogCentra.java
 * Author:  natas
 * Purpose: Defines the Class AdminKlinickogCentra
 ***********************************************************************/
package com.mrsisa.eclinic.model;
import java.util.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("AC")
public class AdminKlinickogCentra extends Korisnik {
   
//   public java.util.Collection<ZahtjeviZaRegistraciju> zahtjeviZaRegistraciju;
//   
//   
//   public java.util.Collection<ZahtjeviZaRegistraciju> getZahtjeviZaRegistraciju() {
//      if (zahtjeviZaRegistraciju == null)
//         zahtjeviZaRegistraciju = new java.util.HashSet<ZahtjeviZaRegistraciju>();
//      return zahtjeviZaRegistraciju;
//   }
//   
//   public java.util.Iterator getIteratorZahtjeviZaRegistraciju() {
//      if (zahtjeviZaRegistraciju == null)
//         zahtjeviZaRegistraciju = new java.util.HashSet<ZahtjeviZaRegistraciju>();
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