/***********************************************************************
 * Module:  SifarnikDijagnoza.java
 * Author:  natas
 * Purpose: Defines the Class SifarnikDijagnoza
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
import javax.persistence.Table;

@Entity
@Table(name="sifarnik_dijagnoza")
public class SifarnikDijagnoza {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="sif_dij_id", unique=true, nullable=false)
    private Long sifDid;
	
	@OneToMany(cascade = {ALL}, fetch = FetchType.LAZY)
	@JoinColumn(name="sif_dij_id")
	private Set<Dijagnoza> dijagnoze = new HashSet<Dijagnoza>();

	public Long getSifDid() {
		return sifDid;
	}

	public void setSifDid(Long sifDid) {
		this.sifDid = sifDid;
	}

	public Set<Dijagnoza> getDijagnoze() {
		return dijagnoze;
	}

	public void setDijagnoze(Set<Dijagnoza> dijagnoze) {
		this.dijagnoze = dijagnoze;
	}
	
	
   

}