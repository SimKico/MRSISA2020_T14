/***********************************************************************
 * Module:  Ljekar.java
 * Author:  natas
 * Purpose: Defines the Class Ljekar
 ***********************************************************************/
package com.mrsisa.eclinic.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
   
	@Column(name="specijalizacija", unique=false)
   private Specijalizacija specijalizacija;
	
	@Column(name="ocjena", unique=false)
   private Integer prosjecnaOcjena;
	
	@Column(name="info", unique=false)
   private String dodatneInfo;
   
	@Column(name="radno_vrijeme", unique=false)
   private String radnoVrijeme;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="ljekar")
	 @JsonBackReference
	private Set<Pregled> pregledi = new HashSet<Pregled>();
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="ljekar")
	private Set<ZahtjeviZaSale> sale = new HashSet<ZahtjeviZaSale>();
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="ljekar")
	private Set<ZahtjeviZaOdsustvo> odsustvo = new HashSet<ZahtjeviZaOdsustvo>();
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "klinika_id", referencedColumnName="klinika_id", nullable=true)
	 @JsonBackReference
	private Klinika klinika;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="operacije_ljekara", joinColumns =@JoinColumn(name="ljekar_id", referencedColumnName="id"), inverseJoinColumns=@JoinColumn(name="operacija_id", referencedColumnName="operacija_id"))
	private Set<Operacija> operacije = new HashSet<Operacija>();

	
	public Specijalizacija getSpecijalizacija() {
		return specijalizacija;
	}

	public void setSpecijalizacija(Specijalizacija specijalizacija) {
		this.specijalizacija = specijalizacija;
	}

	public Integer getProsjecnaOcjena() {
		return prosjecnaOcjena;
	}

	public void setProsjecnaOcjena(Integer prosjecnaOcjena) {
		this.prosjecnaOcjena = prosjecnaOcjena;
	}

	public String getDodatneInfo() {
		return dodatneInfo;
	}

	public void setDodatneInfo(String dodatneInfo) {
		this.dodatneInfo = dodatneInfo;
	}

	public String getRadnoVrijeme() {
		return radnoVrijeme;
	}

	public void setRadnoVrijeme(String radnoVrijeme) {
		this.radnoVrijeme = radnoVrijeme;
	}

	public Set<Pregled> getPregledi() {
		return pregledi;
	}

	public void setPregledi(Set<Pregled> pregledi) {
		this.pregledi = pregledi;
	}

	public Set<ZahtjeviZaSale> getSale() {
		return sale;
	}

	public void setSale(Set<ZahtjeviZaSale> sale) {
		this.sale = sale;
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

	public Set<Operacija> getOperacije() {
		return operacije;
	}

	public void setOperacije(Set<Operacija> operacije) {
		this.operacije = operacije;
	}
	
	

}