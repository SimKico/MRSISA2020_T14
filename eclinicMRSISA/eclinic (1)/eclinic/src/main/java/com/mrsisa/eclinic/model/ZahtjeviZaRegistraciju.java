/***********************************************************************
 * Module:  ZahtjeviZaRegistraciju.java
 * Author:  natas
 * Purpose: Defines the Class ZahtjeviZaRegistraciju
 ***********************************************************************/
package com.mrsisa.eclinic.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="zahtjevi_registracija")
public class ZahtjeviZaRegistraciju {
  
   
   
   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   @Column(name="reg_id", unique=true, nullable=false)
   private int idZahtjeva;
   
   @Column(name="eadresa", unique=true, nullable=false)
   private String eAdresa;
   
   @Column(name="lozinka", unique=true, nullable=false)
   private String lozinka;
   
   @Column(name="ime", unique=true, nullable=false)
   private String ime;
   
   @Column(name="prezime", unique=true, nullable=false)
   private String prezime;
   
   @Column(name="jbo", unique=true, nullable=false)
   private String jbo;
   
   @Column(name="adresa", unique=true, nullable=false)
   private String adresaPrebivalista;
   
   @Column(name="grad", unique=true, nullable=false)
   private String grad;
   
   @Column(name="drzava", unique=true, nullable=false)
   private String drzava;
   
   @Column(name="broj_telefona", unique=true, nullable=false)
   private String brojTefefona;
   
   @Column(name="prihvacen", unique=true, nullable=false)
   private boolean prihvacen;
   

}