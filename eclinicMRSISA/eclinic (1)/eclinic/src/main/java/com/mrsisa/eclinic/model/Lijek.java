/***********************************************************************
 * Module:  Lijek.java
 * Author:  natas
 * Purpose: Defines the Class Lijek
 ***********************************************************************/
package com.mrsisa.eclinic.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="lijekovi")
public class Lijek {
   
   @Id
   @Column(name="sifra_lijeka", unique=false, nullable=false)
   private String sifra;
   
   @Column(name="naziv_lijeka", unique=false, nullable=false)
   private String naziv;
   

}