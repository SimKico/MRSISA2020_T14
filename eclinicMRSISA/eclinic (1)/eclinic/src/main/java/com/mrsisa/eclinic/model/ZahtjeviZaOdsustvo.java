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

}