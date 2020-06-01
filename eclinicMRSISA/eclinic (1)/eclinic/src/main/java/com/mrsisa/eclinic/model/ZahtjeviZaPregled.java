package com.mrsisa.eclinic.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="zahtjevi_pregledi")
public class ZahtjeviZaPregled {
	
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 @Column(name="pregled_zahtjev_id", unique=true, nullable=false)
	 private Long idZahtjeva;
	 
	 @Column(name="datum", unique=false, nullable=false)
	 private Date datum;
	 
	 //TO DO:mozda sve staviti u jedan Date termin  - datum i satnicu
	 @Column(name="satnica", unique=false, nullable=false)
	 private String satnica;
	 
	 @Column(name="ljekar", unique=false, nullable=false)
	 private String ljekar;
	 
	 @Column(name="tipPregleda", unique=false, nullable=false)
	 private String tipPregleda;
	 
	 @Column(name="prihvacen", nullable=false, columnDefinition = "boolean default false")
	   private boolean prihvacen;
	
	 
	 public ZahtjeviZaPregled() {
		super();
	}

	public ZahtjeviZaPregled(Long idZahtjeva, Date datum, String satnica, String ljekar, String tipPregleda,
			boolean prihvacen) {
		super();
		this.idZahtjeva = idZahtjeva;
		this.datum = datum;
		this.satnica = satnica;
		this.ljekar = ljekar;
		this.tipPregleda = tipPregleda;
		this.prihvacen = prihvacen;
	}

	public Long getIdZahtjeva() {
		return idZahtjeva;
	}

	public void setIdZahtjeva(Long idZahtjeva) {
		this.idZahtjeva = idZahtjeva;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public String getSatnica() {
		return satnica;
	}

	public void setSatnica(String satnica) {
		this.satnica = satnica;
	}

	public String getLjekar() {
		return ljekar;
	}

	public void setLjekar(String ljekar) {
		this.ljekar = ljekar;
	}

	public String getTipPregleda() {
		return tipPregleda;
	}

	public void setTipPregleda(String tipPregleda) {
		this.tipPregleda = tipPregleda;
	}

	public boolean isPrihvacen() {
		return prihvacen;
	}

	public void setPrihvacen(boolean prihvacen) {
		this.prihvacen = prihvacen;
	}
	 
	 
}
