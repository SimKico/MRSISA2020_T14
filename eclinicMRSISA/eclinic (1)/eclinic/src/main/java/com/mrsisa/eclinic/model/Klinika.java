package com.mrsisa.eclinic.model;
import static javax.persistence.CascadeType.ALL;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name= "klinike")
public class Klinika {
	
   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   @Column(name="klinika_id", unique=true, nullable=false)
   private Long id;
   
   @Column(name="naziv_klinike", unique=true, nullable=false)
   private int naziv;
   
   @Column(name="grad", unique=false, nullable=false)
   private int grad;
   
   @Column(name="tip_klinike", unique=false, nullable=false)
   private int tipKlinike;
   
   @Column(name="ocjena_klinike", unique=false, nullable=false)
   private int ocjenaKlinike;
   
   @OneToMany(cascade = {ALL}, fetch = FetchType.LAZY)
   @JoinColumn(name = "broj_sale")
   private Set<Sala> sala = new HashSet<Sala>();
  
   @OneToMany(cascade = {ALL}, fetch = FetchType.LAZY)
   @JoinColumn(name = "pregled_id")
   private Set<Pregled> pregled = new HashSet<Pregled>();
//  
   @ManyToMany
   @JoinTable(name = "TipoviPregledaUKlinici", joinColumns = @JoinColumn(name = "klinika_id",referencedColumnName = "klinika_id"), inverseJoinColumns = @JoinColumn(name = "sifra", referencedColumnName = "sifra"))
   private Set<TipPregleda> tipoviPregleda = new HashSet<TipPregleda>();
   
   @OneToMany(cascade = {ALL}, fetch = FetchType.LAZY, mappedBy = "klinika")
   private Set<AdminKlinike> adminKlinike = new HashSet<AdminKlinike>();
   
   @OneToMany(fetch=FetchType.LAZY, mappedBy="klinika")
	private Set<Ljekar> ljekari = new HashSet<Ljekar>();
   
   @OneToMany(fetch=FetchType.LAZY, mappedBy="klinika")
	private Set<MedicinskaSestra> sestre = new HashSet<MedicinskaSestra>();
   
//   /** @pdGenerated default getter */
//   public Set<Sala> getSala() {
//      if (sala == null)
//         sala = new HashSet<Sala>();
//      return sala;
//   }
//   
//   /** @pdGenerated default iterator getter */
//   public java.util.Iterator getIteratorSala() {
//      if (sala == null)
//         sala = HashSet<Sala>();	
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
//   /** @pdGenerated default getter */
//   public TipPregled getTipPregleda() {
//      if (tipPregleda == null)
//         tipPregleda = new java.util.HashSet<TipPregleda>();
//      return tipPregleda;
//   }
//   
//   /** @pdGenerated default iterator getter */
//   public java.util.Iterator getIteratorTipPregleda() {
//      if (tipPregleda == null)
//         tipPregleda = new java.util.HashSet<TipPregleda>();
//      return tipPregleda.iterator();
//   }
//   
//   /** @pdGenerated default setter
//     * @param newTipPregleda */
//   public void setTipPregleda(java.util.Collection<TipPregleda> newTipPregleda) {
//      removeAllTipPregleda();
//      for (java.util.Iterator iter = newTipPregleda.iterator(); iter.hasNext();)
//         addTipPregleda((TipPregleda)iter.next());
//   }
//   
//   /** @pdGenerated default add
//     * @param newTipPregleda */
//   public void addTipPregleda(TipPregleda newTipPregleda) {
//      if (newTipPregleda == null)
//         return;
//      if (this.tipPregleda == null)
//         this.tipPregleda = new java.util.HashSet<TipPregleda>();
//      if (!this.tipPregleda.contains(newTipPregleda))
//         this.tipPregleda.add(newTipPregleda);
//   }
//   
//   /** @pdGenerated default remove
//     * @param oldTipPregleda */
//   public void removeTipPregleda(TipPregleda oldTipPregleda) {
//      if (oldTipPregleda == null)
//         return;
//      if (this.tipPregleda != null)
//         if (this.tipPregleda.contains(oldTipPregleda))
//            this.tipPregleda.remove(oldTipPregleda);
//   }
//   
//   /** @pdGenerated default removeAll */
//   public void removeAllTipPregleda() {
//      if (tipPregleda != null)
//         tipPregleda.clear();
//   }
//   /** @pdGenerated default getter */
//   public java.util.Collection<Pregled> getPregled() {
//      if (pregled == null)
//         pregled = new java.util.HashSet<Pregled>();
//      return pregled;
//   }
//   
//   /** @pdGenerated default iterator getter */
//   public java.util.Iterator getIteratorPregled() {
//      if (pregled == null)
//         pregled = new java.util.HashSet<Pregled>();
//      return pregled.iterator();
//   }
//   
//   /** @pdGenerated default setter
//     * @param newPregled */
//   public void setPregled(java.util.Collection<Pregled> newPregled) {
//      removeAllPregled();
//      for (java.util.Iterator iter = newPregled.iterator(); iter.hasNext();)
//         addPregled((Pregled)iter.next());
//   }
//   
//   /** @pdGenerated default add
//     * @param newPregled */
//   public void addPregled(Pregled newPregled) {
//      if (newPregled == null)
//         return;
//      if (this.pregled == null)
//         this.pregled = new java.util.HashSet<Pregled>();
//      if (!this.pregled.contains(newPregled))
//         this.pregled.add(newPregled);
//   }
//   
//   /** @pdGenerated default remove
//     * @param oldPregled */
//   public void removePregled(Pregled oldPregled) {
//      if (oldPregled == null)
//         return;
//      if (this.pregled != null)
//         if (this.pregled.contains(oldPregled))
//            this.pregled.remove(oldPregled);
//   }
//   
//   /** @pdGenerated default removeAll */
//   public void removeAllPregled() {
//      if (pregled != null)
//         pregled.clear();
//   }
//
	}