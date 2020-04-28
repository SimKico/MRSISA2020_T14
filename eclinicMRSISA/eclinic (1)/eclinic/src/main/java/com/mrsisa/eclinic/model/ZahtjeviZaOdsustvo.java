/***********************************************************************
 * Module:  ZahtjeviZaOdsustvo.java
 * Author:  natas
 * Purpose: Defines the Class ZahtjeviZaOdsustvo
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
@Table(name="zahtjevi_odsustava")
public class ZahtjeviZaOdsustvo {
	
   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   @Column(name="odsustvo_id", unique=true, nullable=false)
   private Long id;
   
   @Column(name="pocetak", unique=false, nullable=false)
   private Date pocetak;
  
   @Column(name="kraj", unique=false, nullable=false)
   private Date kraj;
   
   @Column(name="tip_odsustva", unique=false, nullable=false)
   private Odsustvo tipOdsustva;
   
   @Column(name="prihvacen", unique=false, nullable=false)
   private boolean prihvacen;
   
   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name = "ljekar_id", referencedColumnName="id", nullable = false)
   private Ljekar ljekar;
   
   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name = "sestra_id", referencedColumnName="id", nullable = false)
   private MedicinskaSestra sestra;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public Date getPocetak() {
	return pocetak;
}

public void setPocetak(Date pocetak) {
	this.pocetak = pocetak;
}

public Date getKraj() {
	return kraj;
}

public void setKraj(Date kraj) {
	this.kraj = kraj;
}

public Odsustvo getTipOdsustva() {
	return tipOdsustva;
}

public void setTipOdsustva(Odsustvo tipOdsustva) {
	this.tipOdsustva = tipOdsustva;
}

public boolean isPrihvacen() {
	return prihvacen;
}

public void setPrihvacen(boolean prihvacen) {
	this.prihvacen = prihvacen;
}

public Ljekar getLjekar() {
	return ljekar;
}

public void setLjekar(Ljekar ljekar) {
	this.ljekar = ljekar;
}

public MedicinskaSestra getSestra() {
	return sestra;
}

public void setSestra(MedicinskaSestra sestra) {
	this.sestra = sestra;
}
   
   

}