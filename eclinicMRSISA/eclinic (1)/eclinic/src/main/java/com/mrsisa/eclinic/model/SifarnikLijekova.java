/***********************************************************************
 * Module:  SifarnikLijekova.java
 * Author:  natas
 * Purpose: Defines the Class SifarnikLijekova
 ***********************************************************************/
package com.mrsisa.eclinic.model;
import static javax.persistence.CascadeType.ALL;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="sifarnik_lijekova")
public class SifarnikLijekova {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="sif_lijek_id", unique=true, nullable=false)
    private Long sifLid;
	
	@Column(name="naziv_sifarnika", unique=true, nullable=false)
	 private String naziv;
	
	@OneToMany(cascade = {ALL}, fetch = FetchType.LAZY)
	@JoinColumn(name="sif_lijek_id")
	private Set<Lijek> lijekovi = new HashSet<Lijek>();

	public Long getSifLid() {
		return sifLid;
	}

	public void setSifLid(Long sifLid) {
		this.sifLid = sifLid;
	}

	public Set<Lijek> getLijekovi() {
		return lijekovi;
	}

	public void setLijekovi(Set<Lijek> lijekovi) {
		this.lijekovi = lijekovi;
	}
   
   
   
   
}