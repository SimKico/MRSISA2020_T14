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
   
   @OneToMany(cascade = {ALL}, fetch = FetchType.LAZY, mappedBy = "ZahtjeviZaOdsustvo")
   public Set<ZahtjeviZaOdsustvo> zahtjeviZaOdsustvo = new HashSet<ZahtjeviZaOdsustvo>();
   
   @OneToMany(cascade = {ALL}, fetch = FetchType.LAZY, mappedBy = "ZahtjeviZaSale")
   public Set<ZahtjeviZaSale> zahtjeviZaSale = new HashSet<ZahtjeviZaSale>();
   
   @OneToMany(cascade = {ALL}, fetch = FetchType.LAZY, mappedBy = "operacija")
   public Set<Operacija> operacija = new HashSet<Operacija>();
   
   public java.util.Collection<ZahtjeviZaOdsustvo> getZahtjeviZaOdsustvo() {
      if (zahtjeviZaOdsustvo == null)
         zahtjeviZaOdsustvo = new java.util.HashSet<ZahtjeviZaOdsustvo>();
      return zahtjeviZaOdsustvo;
   }
   
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