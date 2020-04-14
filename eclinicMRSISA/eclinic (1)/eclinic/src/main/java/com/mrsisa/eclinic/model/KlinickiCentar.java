/***********************************************************************
 * Module:  KlinickiCentar.java
 * Author:  natas
 * Purpose: Defines the Class KlinickiCentar
 ***********************************************************************/
package com.mrsisa.eclinic.model;

import java.util.*;

/** @pdOid 5f647c13-b785-4ee0-9189-d42d8a25533e */
public class KlinickiCentar {
   /** @pdRoleInfo migr=no name=Klinika assc=association12 coll=java.util.Collection impl=java.util.HashSet mult=1..* */
   public java.util.Collection<Klinika> klinika;
   /** @pdRoleInfo migr=no name=Korisnik assc=association14 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Korisnik> korisnik;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Klinika> getKlinika() {
      if (klinika == null)
         klinika = new java.util.HashSet<Klinika>();
      return klinika;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorKlinika() {
      if (klinika == null)
         klinika = new java.util.HashSet<Klinika>();
      return klinika.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newKlinika */
   public void setKlinika(java.util.Collection<Klinika> newKlinika) {
      removeAllKlinika();
      for (java.util.Iterator iter = newKlinika.iterator(); iter.hasNext();)
         addKlinika((Klinika)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newKlinika */
   public void addKlinika(Klinika newKlinika) {
      if (newKlinika == null)
         return;
      if (this.klinika == null)
         this.klinika = new java.util.HashSet<Klinika>();
      if (!this.klinika.contains(newKlinika))
         this.klinika.add(newKlinika);
   }
   
   /** @pdGenerated default remove
     * @param oldKlinika */
   public void removeKlinika(Klinika oldKlinika) {
      if (oldKlinika == null)
         return;
      if (this.klinika != null)
         if (this.klinika.contains(oldKlinika))
            this.klinika.remove(oldKlinika);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllKlinika() {
      if (klinika != null)
         klinika.clear();
   }
   /** @pdGenerated default getter */
   public java.util.Collection<Korisnik> getKorisnik() {
      if (korisnik == null)
         korisnik = new java.util.HashSet<Korisnik>();
      return korisnik;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorKorisnik() {
      if (korisnik == null)
         korisnik = new java.util.HashSet<Korisnik>();
      return korisnik.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newKorisnik */
   public void setKorisnik(java.util.Collection<Korisnik> newKorisnik) {
      removeAllKorisnik();
      for (java.util.Iterator iter = newKorisnik.iterator(); iter.hasNext();)
         addKorisnik((Korisnik)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newKorisnik */
   public void addKorisnik(Korisnik newKorisnik) {
      if (newKorisnik == null)
         return;
      if (this.korisnik == null)
         this.korisnik = new java.util.HashSet<Korisnik>();
      if (!this.korisnik.contains(newKorisnik))
         this.korisnik.add(newKorisnik);
   }
   
   /** @pdGenerated default remove
     * @param oldKorisnik */
   public void removeKorisnik(Korisnik oldKorisnik) {
      if (oldKorisnik == null)
         return;
      if (this.korisnik != null)
         if (this.korisnik.contains(oldKorisnik))
            this.korisnik.remove(oldKorisnik);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllKorisnik() {
      if (korisnik != null)
         korisnik.clear();
   }

}