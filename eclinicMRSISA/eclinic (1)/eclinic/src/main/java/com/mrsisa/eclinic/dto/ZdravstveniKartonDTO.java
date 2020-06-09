package com.mrsisa.eclinic.dto;

import java.util.Set;

import com.mrsisa.eclinic.model.Pregled;
import com.mrsisa.eclinic.model.ZdravstveniKarton;

public class ZdravstveniKartonDTO {
	
	private String krvnaGrupa;
	private int visinaCm;
	private int tezinaKg;
	private String alergije;
	private String dioptrija;
	private String jboPacijenta;
	private String imePacijenta;
	private String prezimePacijenta;
	private Long pregledId;
	private Set<IzvjestajPregledaDTO> izvjestajPregledaDTO;
	
	public ZdravstveniKartonDTO() {
		super();
	}
	
	public ZdravstveniKartonDTO(String krvnaGrupa, int visinaCm, int tezinaKg, String alergije, String dioptrija,
			String jboPacijenta, String imePacijenta, String prezimePacijenta, Long pregledId) {
		super();
		this.krvnaGrupa = krvnaGrupa;
		this.visinaCm = visinaCm;
		this.tezinaKg = tezinaKg;
		this.alergije = alergije;
		this.dioptrija = dioptrija;
		this.jboPacijenta = jboPacijenta;
		this.imePacijenta = imePacijenta;
		this.prezimePacijenta = prezimePacijenta;
		this.pregledId = pregledId;
	}




	public ZdravstveniKartonDTO(ZdravstveniKarton zk, Set<IzvjestajPregledaDTO> izvjestajPregledaDTO, Pregled pregled) {
		this.krvnaGrupa = zk.getKrvnaGrupa();
		this.visinaCm = zk.getVisinaCm();
		this.tezinaKg = zk.getTezinaKg();
		this.alergije = zk.getAlergije();
		this.dioptrija = zk.getDioptrija();
		this.jboPacijenta = zk.getPacijent().getJedBrojOsiguranika();
		this.imePacijenta = zk.getPacijent().getIme();
		this.prezimePacijenta = zk.getPacijent().getPrezime();
		this.pregledId = pregled.getPregled_id();
		this.izvjestajPregledaDTO = izvjestajPregledaDTO;
	}
	
	public ZdravstveniKartonDTO(String krvnaGrupa, int visinaCm, int tezinaKg, String alergije, String dioptrija, String jbo, String imePacijenta, String prezimePacijenta,
			Set<IzvjestajPregledaDTO> izvjestajPregledaDTO, Long pregledId) {
		super();
		this.krvnaGrupa = krvnaGrupa;
		this.visinaCm = visinaCm;
		this.tezinaKg = tezinaKg;
		this.alergije = alergije;
		this.dioptrija = dioptrija;
		this.imePacijenta = imePacijenta;
		this.prezimePacijenta = prezimePacijenta;
		this.pregledId = pregledId;
		this.izvjestajPregledaDTO = izvjestajPregledaDTO;
	}


	

	public String getJboPacijenta() {
		return jboPacijenta;
	}


	public void setJboPacijenta(String jboPacijenta) {
		this.jboPacijenta = jboPacijenta;
	}


	public String getImePacijenta() {
		return imePacijenta;
	}


	public void setImePacijenta(String imePacijenta) {
		this.imePacijenta = imePacijenta;
	}


	public String getPrezimePacijenta() {
		return prezimePacijenta;
	}


	public void setPrezimePacijenta(String prezimePacijenta) {
		this.prezimePacijenta = prezimePacijenta;
	}


	public Long getPregledId() {
		return pregledId;
	}


	public void setPregledId(Long pregledId) {
		this.pregledId = pregledId;
	}


	public String getKrvnaGrupa() {
		return krvnaGrupa;
	}
	public void setKrvnaGrupa(String krvnaGrupa) {
		this.krvnaGrupa = krvnaGrupa;
	}
	public int getVisinaCm() {
		return visinaCm;
	}
	public void setVisinaCm(int visinaCm) {
		this.visinaCm = visinaCm;
	}
	public int getTezinaKg() {
		return tezinaKg;
	}
	public void setTezinaKg(int tezinaKg) {
		this.tezinaKg = tezinaKg;
	}
	public String getAlergije() {
		return alergije;
	}
	public void setAlergije(String alergije) {
		this.alergije = alergije;
	}
	public String getDioptrija() {
		return dioptrija;
	}
	public void setDioptrija(String dioptrija) {
		this.dioptrija = dioptrija;
	}
	public Set<IzvjestajPregledaDTO> getIzvjestajPregledaDTO() {
		return izvjestajPregledaDTO;
	}
	public void setIzvjestajPregledaDTO(Set<IzvjestajPregledaDTO> izvjestajPregledaDTO) {
		this.izvjestajPregledaDTO = izvjestajPregledaDTO;
	}
	
	
	

}
