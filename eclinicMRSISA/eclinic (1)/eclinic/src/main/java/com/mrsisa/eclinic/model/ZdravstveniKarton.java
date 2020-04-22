/***********************************************************************
 * Module:  ZdravstveniKarton.java
 * Author:  natas
 * Purpose: Defines the Class ZdravstveniKarton
 ***********************************************************************/
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="zdravstveni_karton")
public class ZdravstveniKarton {
	
   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   @Column(name="karton_id", unique=false, nullable=false)
   private int idKartona;
   
   @Column(name="krvna_grupa", unique=false, nullable=false)
   private String krvnaGrupa;

   @Column(name="visina", unique=false, nullable=false)
   private int visinaCm;
 
   @Column(name="tezina", unique=false, nullable=false)
   private int tezinaKg;
  
   @Column(name="alergije", unique=false, nullable=false)
   private String alergije;

   @Column(name="dioptrija", unique=false, nullable=false)
   private String dioptrija;
   
   @OneToMany(cascade = {ALL}, fetch = FetchType.LAZY, mappedBy = "zdravstveniKarton")
   private Set<Operacija> operacije = new HashSet<Operacija>();
   
   @OneToOne(mappedBy="zdravstveniKarton")
   public Pacijent pacijent;
   
   @OneToMany(cascade = {ALL}, fetch = FetchType.LAZY)
   @JoinColumn(name="izvjestaj_id")
   private Set<IzvjestajPregleda> izvjestajPregleda = new HashSet<IzvjestajPregleda>();
   
   
   
 
}