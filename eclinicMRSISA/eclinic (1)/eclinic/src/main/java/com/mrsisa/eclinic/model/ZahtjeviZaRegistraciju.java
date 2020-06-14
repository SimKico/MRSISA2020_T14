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
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   @Column(name="reg_id", unique=true, nullable=false)
   private Long idZahtjeva;
   
   @Column(name="eadresa", unique=true, nullable=false)
   private String eAdresa;
   
   @Column(name="lozinka", nullable=false)
   private String lozinka;
   
   @Column(name="ime", nullable=false)
   private String ime;
   
   @Column(name="prezime", nullable=false)
   private String prezime;
   
   @Column(name="jbo", unique=true, nullable=false)
   private String jbo;
   
   @Column(name="adresa", nullable=false)
   private String adresaPrebivalista;
   
   @Column(name="grad", nullable=false)
   private String grad;
   
   @Column(name="drzava", nullable=false)
   private String drzava;
   
   @Column(name="broj_telefona", unique=true, nullable=false)
   private String brojTelefona;
   
   @Column(name="prihvacen", nullable=false, columnDefinition = "boolean default false")
   private boolean prihvacen;
   

public ZahtjeviZaRegistraciju(Long idZahtjeva, String eAdresa, String lozinka, String ime, String prezime,
			String jbo, String adresaPrebivalista, String grad, String drzava, String brojTelefona, boolean prihvacen) {
		super();
		this.idZahtjeva = idZahtjeva;
		this.eAdresa = eAdresa;
		this.lozinka = lozinka;
		this.ime = ime;
		this.prezime = prezime;
		this.jbo = jbo;
		this.adresaPrebivalista = adresaPrebivalista;
		this.grad = grad;
		this.drzava = drzava;
		this.brojTelefona = brojTelefona;
		this.prihvacen = prihvacen;
	}

   public ZahtjeviZaRegistraciju() {
		super();
	}

	public Long getIdZahtjeva() {
		return idZahtjeva;
	}
	
	public void setIdZahtjeva(Long idZahtjeva) {
		this.idZahtjeva = idZahtjeva;
	}
	
	public String geteAdresa() {
		return eAdresa;
	}
	
	public void seteAdresa(String eAdresa) {
		this.eAdresa = eAdresa;
	}
	
	public String getLozinka() {
		return lozinka;
	}

public void setLozinka(String lozinka) {
	this.lozinka = lozinka;
}

public String getIme() {
	return ime;
}

public void setIme(String ime) {
	this.ime = ime;
}

public String getPrezime() {
	return prezime;
}

public void setPrezime(String prezime) {
	this.prezime = prezime;
}

public String getJbo() {
	return jbo;
}

public void setJbo(String jbo) {
	this.jbo = jbo;
}

public String getAdresaPrebivalista() {
	return adresaPrebivalista;
}

public void setAdresaPrebivalista(String adresaPrebivalista) {
	this.adresaPrebivalista = adresaPrebivalista;
}

public String getGrad() {
	return grad;
}

public void setGrad(String grad) {
	this.grad = grad;
}

public String getDrzava() {
	return drzava;
}

public void setDrzava(String drzava) {
	this.drzava = drzava;
}

public String getBrojTelefona() {
	return brojTelefona;
}

public void setBrojTelefona(String brojTelefona) {
	this.brojTelefona = brojTelefona;
}

public boolean isPrihvacen() {
	return prihvacen;
}

public void setPrihvacen(boolean prihvacen) {
	this.prihvacen = prihvacen;
}
   
   
   

}