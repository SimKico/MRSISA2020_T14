/***********************************************************************
 * Module:  Korisnik.java
 * Author:  natas
 * Purpose: Defines the Class Korisnik
 ***********************************************************************/
package com.mrsisa.eclinic.model;
import java.util.*;

import static javax.persistence.DiscriminatorType.STRING;
import static javax.persistence.InheritanceType.SINGLE_TABLE;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="tabela_korisnika")
//jedna tabela po hijerarhiji
@Inheritance(strategy=SINGLE_TABLE)
//diskriminaciona kolona - pomocu koje znamo je li doktor, med. sestra...
@DiscriminatorColumn(name="type", discriminatorType=STRING)
abstract class Korisnik {
   
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   @Column(name="id", unique=true, nullable=false)
   private Long id;
	
   @Column(name="aktivan", unique=false, nullable=false)
   private boolean aktivan;
   
   @Column(name="ime", unique=false, nullable=false)
   private String ime;
   
   @Column(name="prezime", unique=false, nullable=false)
   private String prezime;
   
   @Column(name="dodijeljena_lozinka", unique=false,columnDefinition = "boolean default false")
	private boolean dodijeljenaLozinka;
   
   @OneToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="prijava_id", referencedColumnName="eadresa")
   public Prijava prijava;
   
   
   public boolean prijava() {
      // TODO: implement
      return false;
   }


	public Long getId() {
		return id;
	}
	
	
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public boolean isAktivan() {
		return aktivan;
	}
	
	
	public void setAktivan(boolean aktivan) {
		this.aktivan = aktivan;
	}
	
	
	public String getIme() {
		return ime;
	}
	
	
	public void setIme(String ime) {
		this.ime = ime;
	}
	
	
	public String getPrezime() {
		return prezime;
	}
	
	
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	
	
	public Prijava getPrijava() {
		return prijava;
	}
	
	
	public void setPrijava(Prijava prijava) {
		this.prijava = prijava;
	}
	   
   

}