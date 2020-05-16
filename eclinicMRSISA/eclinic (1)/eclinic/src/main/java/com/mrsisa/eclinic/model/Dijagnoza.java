/***********************************************************************
 * Module:  Dijagnoza.java
 * Author:  natas
 * Purpose: Defines the Class Dijagnoza
 ***********************************************************************/
package com.mrsisa.eclinic.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dijagnoze")
public class Dijagnoza {
   
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   @Column(name="sifra", unique=false, nullable=false)
   private Long sifra;
   
   @Column(name="naziv_dijagnoze", unique=false, nullable=false)
   private String naziv;
   
   public Dijagnoza() {
		super();
	}

	public Dijagnoza(String naziv) {
		super();
		this.naziv = naziv;
	}
	
	public Long getSifra() {
		return sifra;
	}
	
	public void setSifra(Long sifra) {
		this.sifra = sifra;
	}
	
	public String getNaziv() {
		return naziv;
	}
	
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
   
   

}