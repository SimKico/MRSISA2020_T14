/***********************************************************************
 * Module:  KlinickiCentar.java
 * Author:  natas
 * Purpose: Defines the Class KlinickiCentar
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
@Table(name="klinicki_centar")
public class KlinickiCentar {
	
   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   @Column(name="kc_id", unique=true, nullable=false)
   private String KCid;
   
   @OneToOne(fetch=FetchType.LAZY)
   @JoinColumn(name = "sif_lijek_id", referencedColumnName="sif_lijek_id")
   public SifarnikLijekova sifarnikLijekova;
   
   @OneToOne(fetch=FetchType.LAZY)
   @JoinColumn(name = "sif_dij_id", referencedColumnName="sif_dij_id")
   public SifarnikDijagnoza sifarnikDijagnoza;
   
   @OneToMany(cascade = {ALL}, fetch = FetchType.LAZY)
	@JoinColumn(name="klinika_id")
	private Set<Klinika> klinika = new HashSet<Klinika>();
   
   @OneToMany(cascade = {ALL}, fetch = FetchType.LAZY)
   @JoinColumn(name="korisnik_id")
   private Set<Korisnik> korisnik = new HashSet<Korisnik>();
   
  
   
   
   
}