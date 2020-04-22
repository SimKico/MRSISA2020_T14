/***********************************************************************
 * Module:  IzvjestajPregleda.java
 * Author:  natas
 * Purpose: Defines the Class IzvjestajPregleda
 ***********************************************************************/
package com.mrsisa.eclinic.model;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="izvjestaji_pregleda")
public class IzvjestajPregleda {
   
	
   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   @Column(name="izvjestaj_id", unique=true, nullable=false)
   private Long izvjestaj_id;
	 
   @Column(name="izvjestaj", unique=true, nullable=false)
   private String izvjestaj;
   
   @OneToOne(fetch=FetchType.LAZY)
   @JoinColumn(name = "pregled_id", referencedColumnName="pregled_id")
   public Pregled pregled;
   
   @OneToMany(fetch = FetchType.LAZY, mappedBy = "izvjestajPregleda")
   private Set<Recept> recepti = new HashSet<Recept>();
   
   /** @pdRoleInfo migr=no name=Dijagnoza assc=association45 mult=1..1 */
   //public Dijagnoza dijagnoza;
   
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name="sifra", referencedColumnName="sifra")
    public Dijagnoza dijagnoza;

}