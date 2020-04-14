/***********************************************************************
 * Module:  AdminKlinike.java
 * Author:  natas
 * Purpose: Defines the Class AdminKlinike
 ***********************************************************************/
package com.mrsisa.eclinic.model;

import java.util.*;

/** @pdOid cfa93a6a-92d5-4426-ba2d-acecb1b0ace1 */
public class AdminKlinike extends Korisnik {
   /** @pdRoleInfo migr=no name=Klinika assc=association3 mult=1..1 */
   public Klinika klinika;
   /** @pdRoleInfo migr=no name=TipPregleda assc=association6 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<TipPregleda> tipPregleda;
   /** @pdRoleInfo migr=no name=Ljekar assc=association8 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Ljekar> ljekar;
   /** @pdRoleInfo migr=no name=ZahtjeviZaOdsustvo assc=association19 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<ZahtjeviZaOdsustvo> zahtjeviZaOdsustvo;
   /** @pdRoleInfo migr=no name=ZahtjeviZaSale assc=association20 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<ZahtjeviZaSale> zahtjeviZaSale;
   /** @pdRoleInfo migr=no name=Operacija assc=association25 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Operacija> operacija;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<TipPregleda> getTipPregleda() {
      if (tipPregleda == null)
         tipPregleda = new java.util.HashSet<TipPregleda>();
      return tipPregleda;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorTipPregleda() {
      if (tipPregleda == null)
         tipPregleda = new java.util.HashSet<TipPregleda>();
      return tipPregleda.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newTipPregleda */
   public void setTipPregleda(java.util.Collection<TipPregleda> newTipPregleda) {
      removeAllTipPregleda();
      for (java.util.Iterator iter = newTipPregleda.iterator(); iter.hasNext();)
         addTipPregleda((TipPregleda)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newTipPregleda */
   public void addTipPregleda(TipPregleda newTipPregleda) {
      if (newTipPregleda == null)
         return;
      if (this.tipPregleda == null)
         this.tipPregleda = new java.util.HashSet<TipPregleda>();
      if (!this.tipPregleda.contains(newTipPregleda))
         this.tipPregleda.add(newTipPregleda);
   }
   
   /** @pdGenerated default remove
     * @param oldTipPregleda */
   public void removeTipPregleda(TipPregleda oldTipPregleda) {
      if (oldTipPregleda == null)
         return;
      if (this.tipPregleda != null)
         if (this.tipPregleda.contains(oldTipPregleda))
            this.tipPregleda.remove(oldTipPregleda);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllTipPregleda() {
      if (tipPregleda != null)
         tipPregleda.clear();
   }
   /** @pdGenerated default getter */
   public java.util.Collection<Ljekar> getLjekar() {
      if (ljekar == null)
         ljekar = new java.util.HashSet<Ljekar>();
      return ljekar;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorLjekar() {
      if (ljekar == null)
         ljekar = new java.util.HashSet<Ljekar>();
      return ljekar.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newLjekar */
   public void setLjekar(java.util.Collection<Ljekar> newLjekar) {
      removeAllLjekar();
      for (java.util.Iterator iter = newLjekar.iterator(); iter.hasNext();)
         addLjekar((Ljekar)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newLjekar */
   public void addLjekar(Ljekar newLjekar) {
      if (newLjekar == null)
         return;
      if (this.ljekar == null)
         this.ljekar = new java.util.HashSet<Ljekar>();
      if (!this.ljekar.contains(newLjekar))
         this.ljekar.add(newLjekar);
   }
   
   /** @pdGenerated default remove
     * @param oldLjekar */
   public void removeLjekar(Ljekar oldLjekar) {
      if (oldLjekar == null)
         return;
      if (this.ljekar != null)
         if (this.ljekar.contains(oldLjekar))
            this.ljekar.remove(oldLjekar);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllLjekar() {
      if (ljekar != null)
         ljekar.clear();
   }
   /** @pdGenerated default getter */
   public java.util.Collection<ZahtjeviZaOdsustvo> getZahtjeviZaOdsustvo() {
      if (zahtjeviZaOdsustvo == null)
         zahtjeviZaOdsustvo = new java.util.HashSet<ZahtjeviZaOdsustvo>();
      return zahtjeviZaOdsustvo;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorZahtjeviZaOdsustvo() {
      if (zahtjeviZaOdsustvo == null)
         zahtjeviZaOdsustvo = new java.util.HashSet<ZahtjeviZaOdsustvo>();
      return zahtjeviZaOdsustvo.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newZahtjeviZaOdsustvo */
   public void setZahtjeviZaOdsustvo(java.util.Collection<ZahtjeviZaOdsustvo> newZahtjeviZaOdsustvo) {
      removeAllZahtjeviZaOdsustvo();
      for (java.util.Iterator iter = newZahtjeviZaOdsustvo.iterator(); iter.hasNext();)
         addZahtjeviZaOdsustvo((ZahtjeviZaOdsustvo)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newZahtjeviZaOdsustvo */
   public void addZahtjeviZaOdsustvo(ZahtjeviZaOdsustvo newZahtjeviZaOdsustvo) {
      if (newZahtjeviZaOdsustvo == null)
         return;
      if (this.zahtjeviZaOdsustvo == null)
         this.zahtjeviZaOdsustvo = new java.util.HashSet<ZahtjeviZaOdsustvo>();
      if (!this.zahtjeviZaOdsustvo.contains(newZahtjeviZaOdsustvo))
         this.zahtjeviZaOdsustvo.add(newZahtjeviZaOdsustvo);
   }
   
   /** @pdGenerated default remove
     * @param oldZahtjeviZaOdsustvo */
   public void removeZahtjeviZaOdsustvo(ZahtjeviZaOdsustvo oldZahtjeviZaOdsustvo) {
      if (oldZahtjeviZaOdsustvo == null)
         return;
      if (this.zahtjeviZaOdsustvo != null)
         if (this.zahtjeviZaOdsustvo.contains(oldZahtjeviZaOdsustvo))
            this.zahtjeviZaOdsustvo.remove(oldZahtjeviZaOdsustvo);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllZahtjeviZaOdsustvo() {
      if (zahtjeviZaOdsustvo != null)
         zahtjeviZaOdsustvo.clear();
   }
   /** @pdGenerated default getter */
   public java.util.Collection<ZahtjeviZaSale> getZahtjeviZaSale() {
      if (zahtjeviZaSale == null)
         zahtjeviZaSale = new java.util.HashSet<ZahtjeviZaSale>();
      return zahtjeviZaSale;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorZahtjeviZaSale() {
      if (zahtjeviZaSale == null)
         zahtjeviZaSale = new java.util.HashSet<ZahtjeviZaSale>();
      return zahtjeviZaSale.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newZahtjeviZaSale */
   public void setZahtjeviZaSale(java.util.Collection<ZahtjeviZaSale> newZahtjeviZaSale) {
      removeAllZahtjeviZaSale();
      for (java.util.Iterator iter = newZahtjeviZaSale.iterator(); iter.hasNext();)
         addZahtjeviZaSale((ZahtjeviZaSale)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newZahtjeviZaSale */
   public void addZahtjeviZaSale(ZahtjeviZaSale newZahtjeviZaSale) {
      if (newZahtjeviZaSale == null)
         return;
      if (this.zahtjeviZaSale == null)
         this.zahtjeviZaSale = new java.util.HashSet<ZahtjeviZaSale>();
      if (!this.zahtjeviZaSale.contains(newZahtjeviZaSale))
         this.zahtjeviZaSale.add(newZahtjeviZaSale);
   }
   
   /** @pdGenerated default remove
     * @param oldZahtjeviZaSale */
   public void removeZahtjeviZaSale(ZahtjeviZaSale oldZahtjeviZaSale) {
      if (oldZahtjeviZaSale == null)
         return;
      if (this.zahtjeviZaSale != null)
         if (this.zahtjeviZaSale.contains(oldZahtjeviZaSale))
            this.zahtjeviZaSale.remove(oldZahtjeviZaSale);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllZahtjeviZaSale() {
      if (zahtjeviZaSale != null)
         zahtjeviZaSale.clear();
   }
   /** @pdGenerated default getter */
   public java.util.Collection<Operacija> getOperacija() {
      if (operacija == null)
         operacija = new java.util.HashSet<Operacija>();
      return operacija;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorOperacija() {
      if (operacija == null)
         operacija = new java.util.HashSet<Operacija>();
      return operacija.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newOperacija */
   public void setOperacija(java.util.Collection<Operacija> newOperacija) {
      removeAllOperacija();
      for (java.util.Iterator iter = newOperacija.iterator(); iter.hasNext();)
         addOperacija((Operacija)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newOperacija */
   public void addOperacija(Operacija newOperacija) {
      if (newOperacija == null)
         return;
      if (this.operacija == null)
         this.operacija = new java.util.HashSet<Operacija>();
      if (!this.operacija.contains(newOperacija))
         this.operacija.add(newOperacija);
   }
   
   /** @pdGenerated default remove
     * @param oldOperacija */
   public void removeOperacija(Operacija oldOperacija) {
      if (oldOperacija == null)
         return;
      if (this.operacija != null)
         if (this.operacija.contains(oldOperacija))
            this.operacija.remove(oldOperacija);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllOperacija() {
      if (operacija != null)
         operacija.clear();
   }

}