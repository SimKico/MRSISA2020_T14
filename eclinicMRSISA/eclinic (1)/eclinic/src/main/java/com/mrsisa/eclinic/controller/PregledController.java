package com.mrsisa.eclinic.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mrsisa.eclinic.dto.KlinikaDTO;
import com.mrsisa.eclinic.dto.LjekarDTO;
import com.mrsisa.eclinic.dto.ZakaziPregledDTO;
import com.mrsisa.eclinic.model.Klinika;
import com.mrsisa.eclinic.model.Ljekar;
import com.mrsisa.eclinic.model.Pregled;
import com.mrsisa.eclinic.model.Specijalizacija;
import com.mrsisa.eclinic.model.StatusPregleda;
import com.mrsisa.eclinic.model.ZahtjeviZaPregled;
import com.mrsisa.eclinic.repository.TipPregledaRepository;
import com.mrsisa.eclinic.service.EmailService;
import com.mrsisa.eclinic.service.KlinikaService;
import com.mrsisa.eclinic.service.LjekarService;
import com.mrsisa.eclinic.service.PregledService;
import com.mrsisa.eclinic.service.ZahtjeviPregledService;

@RestController
@RequestMapping("/pregled")
@CrossOrigin("*")
public class PregledController {

	@Autowired
	private PregledService pregledService;

	@Autowired
	private KlinikaService klinikaService;

	@Autowired
	private LjekarService ljekarService;

	@Autowired
	private TipPregledaRepository tipPregledaRepository;

	@Autowired
	private EmailService emailService;

	@Autowired
	private ZahtjeviPregledService zahtjeviZaPregledService;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	// private Date dateNaissance;

//	@RequestMapping(value ="/pretragaPregleda/{tipPregleda}/{datum}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<List<PregledDTO>> getPretragaPregleda(@PathVariable("tipPregleda") String tipPregleda,@PathVariable("datum") String datum) throws Exception{
//		System.out.println(Specijalizacija.valueOf(tipPregleda) + tipPregleda + datum);
//		Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(datum); 
//		
//		System.out.println(Specijalizacija.valueOf(tipPregleda) + tipPregleda +" " +date1);
//		
//		List<PregledDTO> preglediKlinike = pregledService.pretraziPreglede(date1, Specijalizacija.valueOf(tipPregleda));
//		System.out.println("pregledi klinike :");
//		System.out.println(preglediKlinike);
//		for(PregledDTO rezultat : preglediKlinike)
//		{
////			System.out.println(rezultat.getLjekari());
////			System.out.println(rezultat.getNaziv());
//		}
//		return new ResponseEntity<>(preglediKlinike, HttpStatus.OK);
//	}
	@RequestMapping(value = "/pretragaPregleda/{tipPregleda}/{datum}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<KlinikaDTO>> getPretragaPregleda(@PathVariable("tipPregleda") String tipPregleda,
			@PathVariable("datum") String datum) throws Exception {
		System.out.println(Specijalizacija.oftamologija + tipPregleda + datum);
		Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(datum);

		System.out.println(Specijalizacija.valueOf(tipPregleda) + tipPregleda + " " + date1);

		List<KlinikaDTO> preglediKlinike = klinikaService.searchKlinka(date1, Specijalizacija.valueOf(tipPregleda));
		System.out.println("pregledi klinike :");
		System.out.println(preglediKlinike);
		return new ResponseEntity<>(preglediKlinike, HttpStatus.OK);
	}

	@RequestMapping(value = "/pretragaPregleda/{tipPregleda}/{datum}/{naziv}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<KlinikaDTO> getKlinika(@PathVariable("tipPregleda") String tipPregleda,
			@PathVariable("datum") String datum, @PathVariable("naziv") String naziv) throws ParseException {
		Klinika klinika = klinikaService.findOneKlinkaByNaziv(naziv);
		Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(datum);
		System.out.println("odavde");
		System.out.println(klinika);
		System.out.println(naziv);
		System.out.println(tipPregleda);
		Set<Ljekar> ljekari = klinika.getLjekari();
		System.out.println(ljekari);
		Set<LjekarDTO> ljekariDTO = new HashSet<>();

		for (Ljekar lj : ljekari) {
			System.out.println(lj.getSpecijalizacija());
			if (lj.getSpecijalizacija().equals(Specijalizacija.valueOf(tipPregleda))) {
				LjekarDTO ljekarDTO = new LjekarDTO();
				System.out.println("jednaci su xD");
				ljekarDTO.setIme(lj.getIme());
				ljekarDTO.setPrezime(lj.getPrezime());
				ljekarDTO.setProsjecnaOcjena(lj.getProsjecnaOcjena());
				ljekarDTO.setSpecijalizacija(lj.getSpecijalizacija());
				ljekarDTO.setRadnoVrijeme(lj.getRadnoVrijeme());
				String radnoVrijeme = lj.getRadnoVrijeme();
				System.out.println(radnoVrijeme);
				String[] tokens = radnoVrijeme.split("-");
				String t1 = tokens[0];
				System.out.println(t1);
				String t11 = t1.split(":")[0];
				int pocetak = Integer.parseInt(t11);
				String t2 = tokens[1];
				String t21 = t2.split(":")[0];
				int kraj = Integer.parseInt(t21);
				System.out.println(pocetak);
				System.out.println(kraj);
				List<String> slobodniTermini = new ArrayList<String>();
				List<String> sviTermini = new ArrayList<String>();
				while (pocetak < kraj) {
					if (pocetak < 10) {
						String tk = "0" + String.valueOf(pocetak++) + ":00" + ",1";
						sviTermini.add(tk);
					} else {
						String tk = String.valueOf(pocetak++) + ":00" + ",1";
						sviTermini.add(tk);
					}

				}
				List<String> termini = ljekarService.slobodniTermini(date1, lj.getId());

				for (String t : sviTermini) {

					if (termini.contains(t)) {
						System.out.println("zauzet");
					} else {
						String konacanTermin = t.split(",")[0];
						slobodniTermini.add(konacanTermin);
					}

				}
				System.out.println(sviTermini);
				System.out.println(termini);
				System.out.println(slobodniTermini);
				ljekarDTO.setSlobodniTermini(slobodniTermini);
				ljekarDTO.setEadresa(lj.getPrijava().geteAdresa());
				ljekariDTO.add(ljekarDTO);
			}

		}

		// klinika.setLjekari(ljekari);
		KlinikaDTO klinikaDTO = new KlinikaDTO(klinika, ljekariDTO, null, null);
		System.out.println(klinika.getId());
		System.out.println(klinika.getLjekari());
		System.out.println(ljekariDTO);
		System.out.println("nesto");
		System.out.println(naziv);
//		if (klinika == null) {
//			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//		}
		return new ResponseEntity<>(klinikaDTO, HttpStatus.OK);
	}

	@PostMapping(value = "/zakaziPregled/{email}")
	@PreAuthorize("hasRole('PACIENT')")
	public ResponseEntity<String> zakaziPregled(@PathVariable("email") String email,@RequestParam String tipPregleda, @RequestParam String datumPregleda,
			@RequestParam String emailLjekara, @RequestParam String vrijemePregleda, @RequestParam String klinika)
			throws ParseException {

		Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(datumPregleda);

		Ljekar lj = ljekarService.findOneByEmail(emailLjekara);
		Klinika kl = klinikaService.findOneKlinkaByNaziv(klinika);
//		TipPregleda tipP = tipPregledaRepository.findOneBytip(Specijalizacija.valueOf(tipPregleda));
		ZahtjeviZaPregled zakaziPregled = new ZahtjeviZaPregled();
		// TO DO poslati zahjtev za pregled administratoru klinike
		System.out.println("naerknaslkdnfasenf");
		zakaziPregled.setDatum(date1);
		zakaziPregled.setLjekar(lj.getPrijava().geteAdresa());
		zakaziPregled.setTipPregleda(tipPregleda);
		zakaziPregled.setSatnica(vrijemePregleda);
//		zakaziPregled.setPrihvacen(false);
		zakaziPregled = zahtjeviZaPregledService.save(zakaziPregled);
		emailService.requestPregledEmail(tipPregleda, datumPregleda, emailLjekara, vrijemePregleda, kl,email);

		return new ResponseEntity<>("Pregled je dodan!", HttpStatus.CREATED);
	}

	@PutMapping(value = "/zakaziBrzi/{email}")
	@PreAuthorize("hasRole('PACIENT')")
	public ResponseEntity<String> zakaziBrzi(@PathVariable("email") String email,@RequestParam String id) throws ParseException {
		System.out.println("idemo");
		Long id_pregleda = Long.parseLong(id);
		Pregled p = pregledService.getOneByid(id_pregleda);
		String emailLjekara = p.getLjekar().getPrijava().geteAdresa();
		emailService.requestBrziPregledEmail(p.getTipPregleda(), p.getDatum(), emailLjekara, p.getVrijemePocetka(),
				p.getLjekar().getKlinika(), email);
		ZahtjeviZaPregled zakaziPregled = new ZahtjeviZaPregled();
		// TO DO poslati zahjtev za pregled administratoru klinike

		zakaziPregled.setDatum(p.getDatum());
		zakaziPregled.setLjekar(p.getLjekar().getEmail());
		zakaziPregled.setTipPregleda(p.getTipPregleda().getTip().toString());
		zakaziPregled.setSatnica(p.getVrijemePocetka());
//		zakaziPregled.setPrihvacen(false);
		zakaziPregled = zahtjeviZaPregledService.save(zakaziPregled);
		// TO DO poslati zahtjev administratoru klinike za pregled
//		p.setStatus(StatusPregleda.zakazan);
//		p = pregledService.save(p);
//		System.out.println(p);

		return new ResponseEntity<>(
				"Zahtjev za pregled je poslat. Dobicete odgovor u sto kracem roku. Hvala Vam na povjerenju!",
				HttpStatus.OK);
	}
	@PutMapping(value = "/otkaziPregled/{email}")
	@PreAuthorize("hasRole('PACIENT')")
	public ResponseEntity<String> otkaziPregled(@RequestParam String id) throws ParseException {
		System.out.println("alkgasdkg;laksdg0");
		System.out.println(id);
		Long id_pregleda = Long.parseLong(id);
		Pregled p = pregledService.getOneByid(id_pregleda);
		
		p.setStatus(StatusPregleda.slobodan);
		p.setPacijent(null);
		p = pregledService.save(p);
		System.out.println(p);

		return new ResponseEntity<>(
				"Otkazali ste pregled.",
				HttpStatus.OK);
	}

	@PostMapping(value = "/noviPregled", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasAuthority('ROLE_LJEKAR')")
	public ResponseEntity<ZakaziPregledDTO> zakaziPregled(@RequestBody ZakaziPregledDTO zpDTO) throws ParseException {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

		Pregled tekuci = pregledService.getOneByid(zpDTO.getIdTekucegPregleda());
		Klinika klinika = klinikaService.findOneKlinkaByNaziv(tekuci.getLjekar().getKlinika().getNaziv());
		List<Pregled> preglediLjekara = pregledService.getAllByLjekarId(tekuci.getLjekar().getId());

		LocalTime pocetak = LocalTime.parse(zpDTO.getVrijemePocetka());

		LocalTime kraj = pocetak.plusHours(tekuci.getTipPregleda().getTrajanje());

		for (Pregled p : preglediLjekara) {

			LocalTime pocetak2 = LocalTime.parse(p.getVrijemePocetka());

			LocalTime kraj2 = pocetak2.plusHours(p.getTipPregleda().getTrajanje());

			if (p.getStatus() == StatusPregleda.zakazan) {
				if (formatter.format(p.getDatum()).equals(formatter.format(zpDTO.getDatum()))
						&& p.getVrijemePocetka().equals(zpDTO.getVrijemePocetka())) {
					return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

				} else if (formatter.format(p.getDatum()).equals(formatter.format(zpDTO.getDatum()))
						&& (pocetak.isAfter(pocetak2)) && pocetak.isBefore(kraj2)) {
					return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
				} else if (formatter.format(p.getDatum()).equals(formatter.format(zpDTO.getDatum()))
						&& (kraj.isAfter(pocetak2)) && kraj.isBefore(kraj2)) {
					return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
				} else if (p.getStatus() == StatusPregleda.slobodan) {
					if (formatter.format(p.getDatum()).equals(formatter.format(zpDTO.getDatum()))) {
						p.setStatus(StatusPregleda.zakazan);
						p.setPacijent(tekuci.getPacijent());
						p = pregledService.save(p);
						return new ResponseEntity<>(zpDTO, HttpStatus.CREATED);
					}
				}
			}
		}

		Pregled novi = new Pregled();
		novi.setDatum(zpDTO.getDatum());
		novi.setVrijemePocetka(zpDTO.getVrijemePocetka());
		novi.setStatus(StatusPregleda.zakazan);
		novi.setPopust(zpDTO.getPopust());
		novi.setPacijent(tekuci.getPacijent());
		novi.setLjekar(tekuci.getLjekar());
		novi.setTipPregleda(tekuci.getTipPregleda());
		klinika.getPregled().add(novi);
		novi = pregledService.save(novi);
		return new ResponseEntity<>(zpDTO, HttpStatus.CREATED);

	}
	
	

}
