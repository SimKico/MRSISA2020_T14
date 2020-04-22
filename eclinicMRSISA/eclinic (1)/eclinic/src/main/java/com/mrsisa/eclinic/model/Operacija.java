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
	


}