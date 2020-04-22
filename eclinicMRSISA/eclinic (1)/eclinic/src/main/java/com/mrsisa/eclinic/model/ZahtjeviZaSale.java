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
   @GeneratedValue(strategy=GenerationType.AUTO)
   @Column(name="zahtjev_sala_id", unique=true, nullable=false)
   private Long id;
	
   @Column(name="datum", unique=false, nullable=false)
   private Date datum;
   
   @Column(name="satnica", unique=false, nullable=false)
   private String satnica;
   
   @Column(name="svrha", unique=false, nullable=false)
   private String svrha;
   
   @Column(name="prihvacen", unique=false, nullable=false)
   private boolean prihvacen;
   
   @ManyToOne(fetch=FetchType.LAZY,optional = false)
   @JoinColumn(name="broj_sale")
   public Sala sala;
   
   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name = "ljekar_id", referencedColumnName="id")
   private Ljekar ljekar;

}