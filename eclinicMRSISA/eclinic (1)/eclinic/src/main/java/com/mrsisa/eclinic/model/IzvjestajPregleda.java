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
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   @Column(name="izvjestaj_id", unique=true, nullable=false)
   private Long izvjestajId;
	 
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

public Long getIzvjestaj_id() {
	return izvjestajId;
}

public void setIzvjestaj_id(Long izvjestaj_id) {
	this.izvjestajId = izvjestaj_id;
}

public String getIzvjestaj() {
	return izvjestaj;
}

public void setIzvjestaj(String izvjestaj) {
	this.izvjestaj = izvjestaj;
}

public Pregled getPregled() {
	return pregled;
}

public void setPregled(Pregled pregled) {
	this.pregled = pregled;
}

public Set<Recept> getRecepti() {
	return recepti;
}

public void setRecepti(Set<Recept> recepti) {
	this.recepti = recepti;
}

public Dijagnoza getDijagnoza() {
	return dijagnoza;
}

public void setDijagnoza(Dijagnoza dijagnoza) {
	this.dijagnoza = dijagnoza;
}
   
   
   
   

}