/***********************************************************************
 * Module:  ZahtjeviZaSale.java
 * Author:  natas
 * Purpose: Defines the Class ZahtjeviZaSale
 ***********************************************************************/
package com.mrsisa.eclinic.model;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="zahtjevi_sala")
public class ZahtjeviZaSale {
	
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   @Column(name="zahtjev_sala_id", unique=true, nullable=false)
   private Long id;
	
   @Column(name="datum", unique=false, nullable=false)
   private Date datum;
   
   @Column(name="satnica", unique=false, nullable=false)
   private String satnica;
   
   @Column(name="svrha", unique=false, nullable=false)
   private String jbo;
   
   @Column(name="prihvacen", unique=false, nullable=false)
   private boolean prihvacen;
   
   @ManyToOne(fetch=FetchType.LAZY,optional = false)
   @JoinColumn(name="broj_sale")
   public Sala sala;
   
   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name = "ljekar_id", referencedColumnName="id")
   private Ljekar ljekar;
   
   

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public Date getDatum() {
	return datum;
}

public void setDatum(Date datum) {
	this.datum = datum;
}

public String getSatnica() {
	return satnica;
}

public void setSatnica(String satnica) {
	this.satnica = satnica;
}

public String getSvrha() {
	return jbo;
}

public void setSvrha(String svrha) {
	this.jbo = svrha;
}

public boolean isPrihvacen() {
	return prihvacen;
}

public void setPrihvacen(boolean prihvacen) {
	this.prihvacen = prihvacen;
}

public Sala getSala() {
	return sala;
}

public void setSala(Sala sala) {
	this.sala = sala;
}

public Ljekar getLjekar() {
	return ljekar;
}

public void setLjekar(Ljekar ljekar) {
	this.ljekar = ljekar;
}
   
   

}