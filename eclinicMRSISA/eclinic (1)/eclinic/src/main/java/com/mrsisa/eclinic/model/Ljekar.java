/***********************************************************************
 * Module:  Ljekar.java
 * Author:  natas
 * Purpose: Defines the Class Ljekar
 ***********************************************************************/
package com.mrsisa.eclinic.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("LJ")
public class Ljekar extends Korisnik {
   
	@Column(name="specijalizcija", unique=false, nullable=false)
   private Specijalizacija specijalizacija;
	
	@Column(name="ocjena", unique=false, nullable=false)
   private int prosjecnaOcjena;
	
	@Column(name="info", unique=false, nullable=false)
   private String dodatneInfo;
   
	@Column(name="radno_vrijeme", unique=false, nullable=false)
   private String radnoVrijeme;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="ljekar")
	private Set<Pregled> pregledi = new HashSet<Pregled>();
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="ljekar")
	private Set<ZahtjeviZaSale> sale = new HashSet<ZahtjeviZaSale>();
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="ljekar")
	private Set<ZahtjeviZaOdsustvo> odsustvo = new HashSet<ZahtjeviZaOdsustvo>();
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "klinika_id", referencedColumnName="klinika_id")
	private Klinika klinika;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="operacije_ljekara", joinColumns =@JoinColumn(name="ljekar_id", referencedColumnName="id"), inverseJoinColumns=@JoinColumn(name="operacija_id", referencedColumnName="operacija_id"))
	private Set<Operacija> operacije = new HashSet<Operacija>();

}