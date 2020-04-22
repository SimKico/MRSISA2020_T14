/***********************************************************************
 * Module:  TipPregleda.java
 * Author:  natas
 * Purpose: Defines the Class TipPregleda
 ***********************************************************************/
package com.mrsisa.eclinic.model;
import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name= "tip_pregleda")
public class TipPregleda {
	

	@Column(name="cijena", unique=false, nullable=false)
   private Double cijena;

   @Id
   @Column(name="sifra", unique=true, nullable=false)
   private String sifra;
   

   @Column(name="trajanje", unique=false, nullable=false)
   private int trajanje;
   

   @Column(name="tip", unique=false, nullable=false)
   private Specijalizacija tip;
   
//   /** @pdRoleInfo migr=no name=Pregled assc=association4 mult=0..* side=A */
//   public Pregled[] pregled;

}