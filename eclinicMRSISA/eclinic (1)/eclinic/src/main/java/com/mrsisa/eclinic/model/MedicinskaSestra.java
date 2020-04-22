/***********************************************************************
 * Module:  MedicinskaSestra.java
 * Author:  natas
 * Purpose: Defines the Class MedicinskaSestra
 ***********************************************************************/
package com.mrsisa.eclinic.model;
import java.util.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("MS")
public class MedicinskaSestra extends Korisnik {
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="sestra")
	private Set<ZahtjeviZaOdsustvo> odsustvo = new HashSet<ZahtjeviZaOdsustvo>();
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "klinika_id", referencedColumnName="klinika_id")
	private Klinika klinika;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "sestra")
	private Set<Recept> recepti = new HashSet<Recept>();
}