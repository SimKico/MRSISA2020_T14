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
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   @Column(name="klinika_id", unique=true, nullable=false)
   private Long id;
   
   @Column(name="naziv_klinike", unique=true, nullable=false)
   private String naziv;
   
   @Column(name="grad", unique=false, nullable=false)
   private String grad;
   
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
   

	}