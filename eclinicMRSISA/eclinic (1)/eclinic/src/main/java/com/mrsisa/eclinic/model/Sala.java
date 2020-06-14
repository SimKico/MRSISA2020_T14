package com.mrsisa.eclinic.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name="sale")
public class Sala {

	@Id
	@Column(name="broj_sale", unique=true, nullable=false)
    private String brojSale;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "klinika_id", referencedColumnName="klinika_id", nullable=true)
	 @JsonBackReference
	private Klinika klinika;

	public Klinika getKlinika() {
		return klinika;
	}

	public void setKlinika(Klinika klinika) {
		this.klinika = klinika;
	}

	public String getBrojSale() {
		return brojSale;
	}

	public void setBrojSale(String brojSale) {
		this.brojSale = brojSale;
	}
	
	

}