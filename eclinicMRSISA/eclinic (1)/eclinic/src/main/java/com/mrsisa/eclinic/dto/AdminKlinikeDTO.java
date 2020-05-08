package com.mrsisa.eclinic.dto;

import java.util.HashSet;
import java.util.Set;

import com.mrsisa.eclinic.model.AdminKlinickogCentra;
import com.mrsisa.eclinic.model.AdminKlinike;
import com.mrsisa.eclinic.model.Klinika;
import com.mrsisa.eclinic.model.ZahtjeviZaOdsustvo;
import com.mrsisa.eclinic.model.ZahtjeviZaSale;

public class AdminKlinikeDTO {
	   private Klinika klinika = null;
		private String prezime;
		private String ime;
		private String eadresa;
		private String lozinka;
		private Long Id;
		
		public AdminKlinikeDTO() {
			
		}

		public AdminKlinikeDTO(Klinika klinika, String prezime, String eadresa, String lozinka) {
			super();
			this.klinika = klinika;
			this.prezime = prezime;
			this.eadresa = eadresa;
			this.lozinka = lozinka;
		}
		
		public AdminKlinikeDTO(AdminKlinike ak) {
			this.ime = ak.getIme();
			this.prezime=ak.getPrezime();
			this.eadresa=ak.getPrijava().geteAdresa();
			this.lozinka=ak.getPrijava().getLozinka();
		}

		public Klinika getKlinika() {
			return klinika;
		}

		public void setKlinika(Klinika klinika) {
			this.klinika = klinika;
		}

		public String getPrezime() {
			return prezime;
		}

		public void setPrezime(String prezime) {
			this.prezime = prezime;
		}

		public String getIme() {
			return ime;
		}

		public void setIme(String ime) {
			this.ime = ime;
		}

		public String getEadresa() {
			return eadresa;
		}

		public void setEadresa(String eadresa) {
			this.eadresa = eadresa;
		}

		public String getLozinka() {
			return lozinka;
		}

		public void setLozinka(String lozinka) {
			this.lozinka = lozinka;
		}

		public Long getId() {
			// TODO Auto-generated method stub
			return Id;
		}
		public void setId(Long Id) {
			// TODO Auto-generated method stub
			this.Id = Id;
		}
	   
}
