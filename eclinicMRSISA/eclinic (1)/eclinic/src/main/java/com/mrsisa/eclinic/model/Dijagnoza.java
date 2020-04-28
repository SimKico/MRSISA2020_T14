/***********************************************************************
 * Module:  Dijagnoza.java
 * Author:  natas
 * Purpose: Defines the Class Dijagnoza
 ***********************************************************************/
package com.mrsisa.eclinic.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dijagnoze")
public class Dijagnoza {
   
   @Id
   @Column(name="sifra", unique=false, nullable=false)
   private String sifra;
   
   @Column(name="naziv_dijagnoze", unique=false, nullable=false)
   private String naziv;

public String getSifra() {
	return sifra;
}

public void setSifra(String sifra) {
	this.sifra = sifra;
}

public String getNaziv() {
	return naziv;
}

public void setNaziv(String naziv) {
	this.naziv = naziv;
}
   
   

}