/***********************************************************************
 * Module:  Pregled.java
 * Author:  natas
 * Purpose: Defines the Class Pregled
 ***********************************************************************/
package com.mrsisa.eclinic.model;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="pregledi")
public class Pregled {
   
   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   @Column(name="pregled_id", unique=true, nullable=false)
   private Long pregled_id;
   
   @Column(name="datum_pregleda", unique=false, nullable=false)
   private Date datum;
   
   @Column(name="popust", unique=false, nullable=false)
   private int popust;
   
   @Column(name="vrijeme_pocetka", unique=false, nullable=false)
   private Date vrijemePocetka;
   
   @Column(name="status", unique=false, nullable=false)
   private StatusPregleda status;
   
   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name = "ljekar_id", referencedColumnName="id")
   private Ljekar ljekar;
   
   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name = "pacijent_id", referencedColumnName="id")
   private Pacijent pacijent;
   
   @OneToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="broj_sale")
   private Sala sala;
   
   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name = "sifra_pregleda", referencedColumnName="sifra")
   public TipPregleda tipPregleda;
//   
//   public java.util.Collection<Sala> sala;
//   
//   
//   /** @pdGenerated default getter */
//   public java.util.Collection<Sala> getSala() {
//      if (sala == null)
//         sala = new java.util.HashSet<Sala>();
//      return sala;
//   }
//   
//   /** @pdGenerated default iterator getter */
//   public java.util.Iterator getIteratorSala() {
//      if (sala == null)
//         sala = new java.util.HashSet<Sala>();
//      return sala.iterator();
//   }
//   
//   /** @pdGenerated default setter
//     * @param newSala */
//   public void setSala(java.util.Collection<Sala> newSala) {
//      removeAllSala();
//      for (java.util.Iterator iter = newSala.iterator(); iter.hasNext();)
//         addSala((Sala)iter.next());
//   }
//   
//   /** @pdGenerated default add
//     * @param newSala */
//   public void addSala(Sala newSala) {
//      if (newSala == null)
//         return;
//      if (this.sala == null)
//         this.sala = new java.util.HashSet<Sala>();
//      if (!this.sala.contains(newSala))
//         this.sala.add(newSala);
//   }
//   
//   /** @pdGenerated default remove
//     * @param oldSala */
//   public void removeSala(Sala oldSala) {
//      if (oldSala == null)
//         return;
//      if (this.sala != null)
//         if (this.sala.contains(oldSala))
//            this.sala.remove(oldSala);
//   }
//   
//   /** @pdGenerated default removeAll */
//   public void removeAllSala() {
//      if (sala != null)
//         sala.clear();
//   }

}