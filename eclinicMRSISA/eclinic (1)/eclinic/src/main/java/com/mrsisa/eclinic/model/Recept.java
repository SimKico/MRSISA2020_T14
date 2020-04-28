/***********************************************************************
 * Module:  Recept.java
 * Author:  natas
 * Purpose: Defines the Class Recept
 ***********************************************************************/
package com.mrsisa.eclinic.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="recepti")
public class Recept {
  
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name="recept_id", unique=true, nullable=false)
   private Long recept_id;
  
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="lijek", referencedColumnName="naziv_lijeka")
   public Lijek lijek;
  
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="sestra_id", referencedColumnName="id")
   public MedicinskaSestra sestra;
  
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="izvjestaj_id", referencedColumnName="izvjestaj_id")
  private IzvjestajPregleda izvjestajPregleda;

public Long getRecept_id() {
	return recept_id;
}

public void setRecept_id(Long recept_id) {
	this.recept_id = recept_id;
}

public Lijek getLijek() {
	return lijek;
}

public void setLijek(Lijek lijek) {
	this.lijek = lijek;
}

public MedicinskaSestra getSestra() {
	return sestra;
}

public void setSestra(MedicinskaSestra sestra) {
	this.sestra = sestra;
}

public IzvjestajPregleda getIzvjestajPregleda() {
	return izvjestajPregleda;
}

public void setIzvjestajPregleda(IzvjestajPregleda izvjestajPregleda) {
	this.izvjestajPregleda = izvjestajPregleda;
}
  
  

}