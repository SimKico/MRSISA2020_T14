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
	
	private static final long serialVersionUID = 1L;

	@OneToMany(fetch=FetchType.LAZY, mappedBy="sestra")
	private Set<ZahtjeviZaOdsustvo> odsustvo = new HashSet<ZahtjeviZaOdsustvo>();
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "klinika_id", referencedColumnName="klinika_id", nullable=true)
	private Klinika klinika;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "sestra")
	private Set<Recept> recepti = new HashSet<Recept>();
	
	

	public MedicinskaSestra() {
		super();
	}

	public Set<ZahtjeviZaOdsustvo> getOdsustvo() {
		return odsustvo;
	}

	public void setOdsustvo(Set<ZahtjeviZaOdsustvo> odsustvo) {
		this.odsustvo = odsustvo;
	}

	public Klinika getKlinika() {
		return klinika;
	}

	public void setKlinika(Klinika klinika) {
		this.klinika = klinika;
	}

	public Set<Recept> getRecepti() {
		return recepti;
	}

	public void setRecepti(Set<Recept> recepti) {
		this.recepti = recepti;
	}
	public MedicinskaSestra( boolean aktivan, String ime, String prezime,
			boolean dodijeljenaLozinka, Prijava prijava, boolean enabled, Date lastPasswordResetDate,
			List<Authority> authorities, Set<ZahtjeviZaOdsustvo> odsustvo, Klinika klinika, Set<Recept> recepti) {
		super(aktivan, ime, prezime, dodijeljenaLozinka, prijava, enabled, lastPasswordResetDate, authorities,prijava.geteAdresa(),prijava.getLozinka());
		this.odsustvo = odsustvo;
		this.klinika = klinika;
		this.recepti = recepti;
	}
	
}