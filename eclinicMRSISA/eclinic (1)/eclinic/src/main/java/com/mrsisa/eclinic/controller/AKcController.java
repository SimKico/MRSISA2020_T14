package com.mrsisa.eclinic.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mrsisa.eclinic.dto.AKcDTO;
import com.mrsisa.eclinic.dto.AdminKlinikeDTO;
import com.mrsisa.eclinic.dto.KlinikaDTO;
import com.mrsisa.eclinic.model.AdminKlinickogCentra;
import com.mrsisa.eclinic.model.AdminKlinike;
import com.mrsisa.eclinic.model.Authority;
import com.mrsisa.eclinic.model.KlinickiCentar;
import com.mrsisa.eclinic.model.Klinika;
import com.mrsisa.eclinic.model.Korisnik;
import com.mrsisa.eclinic.model.Prijava;
import com.mrsisa.eclinic.model.ZahtjeviZaRegistraciju;
import com.mrsisa.eclinic.service.AKCService;
import com.mrsisa.eclinic.service.AdminKlinikeService;
import com.mrsisa.eclinic.service.AuthorityService;
import com.mrsisa.eclinic.service.KcService;
import com.mrsisa.eclinic.service.KlinikaService;
import com.mrsisa.eclinic.service.KorisnikService;
import com.mrsisa.eclinic.service.PrijavaService;
import com.mrsisa.eclinic.service.ZahtjeviRegService;

@RestController
@RequestMapping("profilAKC")
public class AKcController {
	
	private AKCService akcService;
	
	private PrijavaService prijavaService;
	
	private KlinikaService klinikaService;
	
	private AdminKlinikeService akService;
	
	private KcService kcService;
	
	private KorisnikService korisnikService;
	
	private ZahtjeviRegService regService;
	
	@Autowired
	AuthorityService aService;
	
	@Autowired
	public AKcController(AKCService akcService, PrijavaService prijavaService, KlinikaService klinikaService, AdminKlinikeService akService, KcService kcService, KorisnikService korisnikService,  ZahtjeviRegService regService) {
		this.akcService = akcService;
		this.prijavaService = prijavaService;
		this.klinikaService = klinikaService;
		this.akService = akService;
		this.kcService = kcService;
		this.korisnikService = korisnikService;
		this.regService = regService;
	}
	
	
	@RequestMapping(value = "/profil", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasAuthority('ROLE_ADMINKC')")
	@ResponseBody
	public ResponseEntity<AKcDTO> getOneByEmail(@RequestParam("eadresa") String eadresa){
		System.out.print(eadresa);
		AdminKlinickogCentra akc = akcService.getAKCbyEmail(eadresa);
		return new ResponseEntity<AKcDTO>(new AKcDTO(akc), HttpStatus.OK);
	}
	
	@PostMapping(value = "/dodajAKC", consumes =  "application/json")
	@PreAuthorize("hasAuthority('ROLE_ADMINKC')")
	public ResponseEntity<AKcDTO> saveAKC(@RequestBody AKcDTO akcDto) {
		
        Korisnik korisnik = korisnikService.getKorisnikByEmail(akcDto.getEadresa());
		
		if(korisnik == null) {
			AdminKlinickogCentra akc = new AdminKlinickogCentra();
			
			Prijava prijava = new Prijava();
			prijava.seteAdresa(akcDto.getEadresa());
			
			String pw_hash = BCrypt.hashpw(akcDto.getLozinka(), BCrypt.gensalt(12));
			
			prijava.setLozinka(pw_hash);
			
			KlinickiCentar kc = kcService.getKcByName("Eclinic");
			
			akc.setAktivan(false);
			akc.setPredefinisaniAdmin(false);
			akc.setIme(akcDto.getIme());
			akc.setPrezime(akcDto.getPrezime());
			akc.setPrijava(prijava);
			akc.setPredefinisaniAdmin(false);
			akc.setDodijeljenaLozinka(true);
			akc.setEnabled(true);
			akc.setEmail(akcDto.getEadresa());
			akc.setPassword(pw_hash);
			
			Authority a = aService.findByName("ROLE_ADMINKC");
			List<Authority> aut = new ArrayList<Authority>();
			aut.add(a);
			akc.setAuthorities(aut);
			
			
			prijava = prijavaService.save(prijava);
			
			kc.getKorisnik().add(akc);
			akc = akcService.save(akc);
			
			return new ResponseEntity<AKcDTO>(akcDto, HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PostMapping(value = "/registrujKliniku", consumes = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasAuthority('ROLE_ADMINKC')")
	public ResponseEntity<KlinikaDTO> saveKlinika(@RequestBody KlinikaDTO klinikaDto) {
		
		Klinika provjera = klinikaService.findOneKlinkaByNaziv(klinikaDto.getNaziv());
		
		if(provjera == null) {
			Klinika klinika = new Klinika();
			klinika.setNaziv(klinikaDto.getNaziv());
			klinika.setGrad(klinikaDto.getGrad());
			klinika.setOcjenaKlinike(klinikaDto.getOcjenaKlinike());
			klinika.setTipKlinike(klinikaDto.getTipKlinike());
			klinika.setAdresa(klinikaDto.getAdresa());
			
			KlinickiCentar kc = kcService.getKcByName("Eclinic");
			
			kc.getKlinika().add(klinika);
			klinika = klinikaService.save(klinika);
		
			return new ResponseEntity<KlinikaDTO>(klinikaDto, HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@RequestMapping(value = "/ucitajKlinike",  method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<KlinikaDTO>> getAllKlinika(){	
		List<Klinika> listaKlinika = klinikaService.findAll();
		List<KlinikaDTO> klinike = new ArrayList<KlinikaDTO>();
		
		for(Klinika klinika : listaKlinika) {
			klinike.add(new KlinikaDTO(klinika, null,null,null));
		}
		
		return new ResponseEntity<>(klinike, HttpStatus.OK);

	}
	
	@PostMapping(value = "/registrujAdminaKlinike", consumes =  "application/json")
	@PreAuthorize("hasAuthority('ROLE_ADMINKC')")
	public ResponseEntity<AdminKlinikeDTO> saveAdminKl(@RequestBody AdminKlinikeDTO akDto) throws ParseException {
		
		Korisnik korisnik = korisnikService.getKorisnikByEmail(akDto.getEadresa());
		
		if(korisnik == null) {
			
			Klinika klinika = klinikaService.findOneKlinkaByNaziv(akDto.getNazivKlinike());

			Prijava prijava = new Prijava();
			prijava.seteAdresa(akDto.getEadresa());
			
			String pw_hash = BCrypt.hashpw(akDto.getLozinka(), BCrypt.gensalt(12));
			
			prijava.setLozinka(pw_hash);
			
			KlinickiCentar kc = kcService.getKcByName("Eclinic");
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Date datum = new Date();
			String date = sdf.format(datum);
			
			AdminKlinike ak = new AdminKlinike();
			ak.setAktivan(false);
			ak.setDodijeljenaLozinka(true);
			ak.setIme(akDto.getIme());
			ak.setPrezime(akDto.getPrezime());
			ak.setPrijava(prijava);
			ak.setKlinika(klinika);
			ak.setEmail(akDto.getEadresa());
			ak.setPassword(pw_hash);
			ak.setLastPasswordResetDate(sdf.parse(date));
			ak.setEnabled(true);
			prijava = prijavaService.save(prijava);
			
			Authority a = aService.findByName("ROLE_ADMINK");
			List<Authority> aut = new ArrayList<Authority>();
			aut.add(a);
			ak.setAuthorities(aut);
			
			kc.getKorisnik().add(ak);
			ak = akService.save(ak);
			
			return new ResponseEntity<AdminKlinikeDTO>(akDto, HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
	

	@RequestMapping(value = "/zahtjevi", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasAuthority('ROLE_ADMINKC')")
	@ResponseBody
	public ResponseEntity<List<ZahtjeviZaRegistraciju>> getRegistrationRequests(){
		
		List<ZahtjeviZaRegistraciju> zahtjevi = new ArrayList<ZahtjeviZaRegistraciju>();
		zahtjevi = regService.findAllUnaccepted(false);
		
		return new ResponseEntity<List<ZahtjeviZaRegistraciju>>(zahtjevi, HttpStatus.OK);
	}
		
	
	

}
