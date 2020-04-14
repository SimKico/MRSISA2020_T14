/***********************************************************************
 * Module:  AdminKlinickogCentra.java
 * Author:  natas
 * Purpose: Defines the Class AdminKlinickogCentra
 ***********************************************************************/
package com.mrsisa.eclinic.model;

/** @pdOid 159a66c6-e139-481b-b23a-0e1b29a20361 */
public class AdminKlinickogCentra extends Korisnik {
   /** @pdRoleInfo migr=no name=SifarnikDijagnoza assc=association13 mult=1..1 */
   public SifarnikDijagnoza sifarnikDijagnoza;
   /** @pdRoleInfo migr=no name=ZahtjeviZaRegistraciju assc=association21 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<ZahtjeviZaRegistraciju> zahtjeviZaRegistraciju;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<ZahtjeviZaRegistraciju> getZahtjeviZaRegistraciju() {
      if (zahtjeviZaRegistraciju == null)
         zahtjeviZaRegistraciju = new java.util.HashSet<ZahtjeviZaRegistraciju>();
      return zahtjeviZaRegistraciju;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorZahtjeviZaRegistraciju() {
      if (zahtjeviZaRegistraciju == null)
         zahtjeviZaRegistraciju = new java.util.HashSet<ZahtjeviZaRegistraciju>();
      return zahtjeviZaRegistraciju.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newZahtjeviZaRegistraciju */
   public void setZahtjeviZaRegistraciju(java.util.Collection<ZahtjeviZaRegistraciju> newZahtjeviZaRegistraciju) {
      removeAllZahtjeviZaRegistraciju();
      for (java.util.Iterator iter = newZahtjeviZaRegistraciju.iterator(); iter.hasNext();)
         addZahtjeviZaRegistraciju((ZahtjeviZaRegistraciju)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newZahtjeviZaRegistraciju */
   public void addZahtjeviZaRegistraciju(ZahtjeviZaRegistraciju newZahtjeviZaRegistraciju) {
      if (newZahtjeviZaRegistraciju == null)
         return;
      if (this.zahtjeviZaRegistraciju == null)
         this.zahtjeviZaRegistraciju = new java.util.HashSet<ZahtjeviZaRegistraciju>();
      if (!this.zahtjeviZaRegistraciju.contains(newZahtjeviZaRegistraciju))
         this.zahtjeviZaRegistraciju.add(newZahtjeviZaRegistraciju);
   }
   
   /** @pdGenerated default remove
     * @param oldZahtjeviZaRegistraciju */
   public void removeZahtjeviZaRegistraciju(ZahtjeviZaRegistraciju oldZahtjeviZaRegistraciju) {
      if (oldZahtjeviZaRegistraciju == null)
         return;
      if (this.zahtjeviZaRegistraciju != null)
         if (this.zahtjeviZaRegistraciju.contains(oldZahtjeviZaRegistraciju))
            this.zahtjeviZaRegistraciju.remove(oldZahtjeviZaRegistraciju);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllZahtjeviZaRegistraciju() {
      if (zahtjeviZaRegistraciju != null)
         zahtjeviZaRegistraciju.clear();
   }

}