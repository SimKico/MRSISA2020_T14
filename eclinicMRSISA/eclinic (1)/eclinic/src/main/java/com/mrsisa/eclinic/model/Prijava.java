/***********************************************************************
 * Module:  Prijava.java
 * Author:  natas
 * Purpose: Defines the Class Prijava
 ***********************************************************************/
package com.mrsisa.eclinic.model;
import java.util.*;

import static javax.persistence.DiscriminatorType.STRING;
import static javax.persistence.InheritanceType.SINGLE_TABLE;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tabela_prijava")
public class Prijava {
   
   
//   @GeneratedValue(strategy=GenerationType.AUTO)
//   private Long id;
	
   @Id
   @Column(name="eadresa", unique=true, nullable=false)
   private String eAdresa;
   
   @Column(name="lozinka", unique=false, nullable=false)
   private String lozinka;
   
   @OneToOne(mappedBy="prijava")
   public Korisnik korisnik;

}