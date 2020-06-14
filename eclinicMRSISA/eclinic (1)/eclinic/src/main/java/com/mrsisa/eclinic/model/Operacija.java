/***********************************************************************
 * Module:  Operacija.java
 * Author:  natas
 * Purpose: Defines the Class Operacija
 ***********************************************************************/
package com.mrsisa.eclinic.model;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="operacije")
public class Operacija {
   
   public Operacija(String idOperacije, Integer trajanje, String tipOperacije, String vrijemePocetka, Sala sala,
			Set<Ljekar> ljekari, ZdravstveniKarton zdravstveniKarton) {
		super();
		this.idOperacije = idOperacije;
		this.trajanje = trajanje;
		this.tipOperacije = tipOperacije;
		this.vrijemePocetka = vrijemePocetka;
		this.sala = sala;
		this.ljekari = ljekari;
		this.zdravstveniKarton = zdravstveniKarton;
	}

@Id
   @Column(name="operacija_id", unique=false, nullable=false)
   private String idOperacije;
   
   @Column(name="trajanje", unique=false, nullable=false)
   private Integer trajanje;
   
   @Column(name="tip_operacije", unique=false, nullable=false)
   private String tipOperacije;
   
   @Column(name="vrijeme_pocetka", unique=false, nullable=false)
   private String vrijemePocetka;
   
   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name = "broj_sale", referencedColumnName="broj_sale")
   public Sala sala;
   
   @ManyToMany(fetch=FetchType.LAZY, mappedBy="operacije")
   private Set<Ljekar> ljekari = new HashSet<Ljekar>();
   
   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="karton_id", referencedColumnName="karton_id")
   public ZdravstveniKarton zdravstveniKarton;

public String getIdOperacije() {
	return idOperacije;
}

public void setIdOperacije(String idOperacije) {
	this.idOperacije = idOperacije;
}

public Integer getTrajanje() {
	return trajanje;
}

public void setTrajanje(Integer trajanje) {
	this.trajanje = trajanje;
}

public String getTipOperacije() {
	return tipOperacije;
}

public void setTipOperacije(String tipOperacije) {
	this.tipOperacije = tipOperacije;
}

public String getVrijemePocetka() {
	return vrijemePocetka;
}

public void setVrijemePocetka(String vrijemePocetka) {
	this.vrijemePocetka = vrijemePocetka;
}

public Sala getSala() {
	return sala;
}

public void setSala(Sala sala) {
	this.sala = sala;
}

public Set<Ljekar> getLjekari() {
	return ljekari;
}

public void setLjekari(Set<Ljekar> ljekari) {
	this.ljekari = ljekari;
}

public ZdravstveniKarton getZdravstveniKarton() {
	return zdravstveniKarton;
}

public void setZdravstveniKarton(ZdravstveniKarton zdravstveniKarton) {
	this.zdravstveniKarton = zdravstveniKarton;
}
	
   


}