/***********************************************************************
 * Module:  Ljekar.java
 * Author:  natas
 * Purpose: Defines the Class Ljekar
 ***********************************************************************/
package com.mrsisa.eclinic.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

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

}