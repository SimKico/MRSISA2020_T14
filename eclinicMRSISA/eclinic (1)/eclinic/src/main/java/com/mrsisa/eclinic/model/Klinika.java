/***********************************************************************
 * Module:  Klinika.java
 * Author:  natas
 * Purpose: Defines the Class Klinika
 ***********************************************************************/
package com.mrsisa.eclinic.model;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import static javax.persistence.CascadeType.ALL;

/** @pdOid a879aab1-3e55-40a1-9cfb-bd26efc9dec7 */
public class Klinika {
   /** @pdOid b4a4c9c7-fffb-4fa2-9d89-e0245e7d02b6 */
   private int naziv;
   /** @pdOid becf7fd1-ebed-4c67-8c8f-8a718298fa14 */
   private int grad;
   /** @pdOid c7a03e11-eb45-4018-a92b-e8cc30afdcc3 */
   private int tipKlinike;
   /** @pdOid caf4530f-5cef-4a21-acb7-f68d0d21657f */
   private int ocjenaKlinike;
   
   /** @pdRoleInfo migr=no name=Sala assc=association9 coll=java.util.Collection impl=java.util.HashSet mult=1..* */
   public java.util.Collection<Sala> sala;
   /** @pdRoleInfo migr=no name=TipPregleda assc=association10 coll=java.util.Collection impl=java.util.HashSet mult=1..* */
   public java.util.Collection<TipPregleda> tipPregleda;
   /** @pdRoleInfo migr=no name=Pregled assc=association11 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Pregled> pregled;
   /** @pdRoleInfo migr=no name=AdminKlinike assc=association3 mult=1..* side=A */
   @OneToMany(cascade = {ALL}, fetch = FetchType.LAZY, mappedBy = "adminKlinike")
   public AdminKlinike[] adminKlinike;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Sala> getSala() {
      if (sala == null)
         sala = new java.util.HashSet<Sala>();
      return sala;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorSala() {
      if (sala == null)
         sala = new java.util.HashSet<Sala>();
      return sala.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newSala */
   public void setSala(java.util.Collection<Sala> newSala) {
      removeAllSala();
      for (java.util.Iterator iter = newSala.iterator(); iter.hasNext();)
         addSala((Sala)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newSala */
   public void addSala(Sala newSala) {
      if (newSala == null)
         return;
      if (this.sala == null)
         this.sala = new java.util.HashSet<Sala>();
      if (!this.sala.contains(newSala))
         this.sala.add(newSala);
   }
   
   /** @pdGenerated default remove
     * @param oldSala */
   public void removeSala(Sala oldSala) {
      if (oldSala == null)
         return;
      if (this.sala != null)
         if (this.sala.contains(oldSala))
            this.sala.remove(oldSala);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllSala() {
      if (sala != null)
         sala.clear();
   }
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
   public java.util.Collection<Pregled> getPregled() {
      if (pregled == null)
         pregled = new java.util.HashSet<Pregled>();
      return pregled;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorPregled() {
      if (pregled == null)
         pregled = new java.util.HashSet<Pregled>();
      return pregled.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newPregled */
   public void setPregled(java.util.Collection<Pregled> newPregled) {
      removeAllPregled();
      for (java.util.Iterator iter = newPregled.iterator(); iter.hasNext();)
         addPregled((Pregled)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newPregled */
   public void addPregled(Pregled newPregled) {
      if (newPregled == null)
         return;
      if (this.pregled == null)
         this.pregled = new java.util.HashSet<Pregled>();
      if (!this.pregled.contains(newPregled))
         this.pregled.add(newPregled);
   }
   
   /** @pdGenerated default remove
     * @param oldPregled */
   public void removePregled(Pregled oldPregled) {
      if (oldPregled == null)
         return;
      if (this.pregled != null)
         if (this.pregled.contains(oldPregled))
            this.pregled.remove(oldPregled);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllPregled() {
      if (pregled != null)
         pregled.clear();
   }

}