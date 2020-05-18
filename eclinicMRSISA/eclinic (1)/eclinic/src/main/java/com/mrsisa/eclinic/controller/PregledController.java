package com.mrsisa.eclinic.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import com.mrsisa.eclinic.dto.PregledDTO;
import com.mrsisa.eclinic.model.Klinika;
import com.mrsisa.eclinic.model.Korisnik;
import com.mrsisa.eclinic.model.Ljekar;
import com.mrsisa.eclinic.model.Pacijent;
import com.mrsisa.eclinic.model.Pregled;
import com.mrsisa.eclinic.model.Specijalizacija;
import com.mrsisa.eclinic.model.StatusPregleda;
import com.mrsisa.eclinic.model.TipPregleda;
import com.mrsisa.eclinic.model.ZahtjeviZaRegistraciju;
import com.mrsisa.eclinic.repository.TipPregledaRepository;
import com.mrsisa.eclinic.service.KlinikaService;
import com.mrsisa.eclinic.service.LjekarService;
import com.mrsisa.eclinic.service.PregledService;

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
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	//private Date dateNaissance;
	
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
	@RequestMapping(value ="/pretragaPregleda/{tipPregleda}/{datum}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<KlinikaDTO>> getPretragaPregleda(@PathVariable("tipPregleda") String tipPregleda,@PathVariable("datum") String datum) throws Exception{
		System.out.println(Specijalizacija.oftamologija + tipPregleda + datum);
		Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(datum); 
		
		System.out.println(Specijalizacija.valueOf(tipPregleda) + tipPregleda +" " +date1);
		
		List<KlinikaDTO> preglediKlinike = klinikaService.searchKlinka(date1, Specijalizacija.valueOf(tipPregleda));
		System.out.println("pregledi klinike :");
		System.out.println(preglediKlinike);
		return new ResponseEntity<>(preglediKlinike, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/pretragaPregleda/{tipPregleda}/{datum}/{naziv}",  method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<KlinikaDTO> getKlinika(@PathVariable("tipPregleda") String tipPregleda,@PathVariable("datum") String datum,@PathVariable("naziv") String naziv) throws ParseException{	
		Klinika klinika = klinikaService.findOneKlinkaByNaziv(naziv);
		Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(datum);
		System.out.println("odavde");
		System.out.println(klinika);
		System.out.println(naziv);
		System.out.println(tipPregleda);
		Set<Ljekar> ljekari = klinika.getLjekari();
		System.out.println(ljekari);
		Set<LjekarDTO> ljekariDTO = new HashSet<>();
		
		for(Ljekar lj : ljekari) {
			System.out.println(lj.getSpecijalizacija());
			if(lj.getSpecijalizacija().equals(Specijalizacija.valueOf(tipPregleda))) {
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
				String t11= t1.split(":")[0];
				int pocetak = Integer.parseInt(t11);
				String t2 = tokens[1];
				String t21= t2.split(":")[0];
				int kraj = Integer.parseInt(t21);
				System.out.println(pocetak);
				System.out.println(kraj);
				List<String> slobodniTermini = new ArrayList<String>();
				List<String> sviTermini = new ArrayList<String>();
				while( pocetak < kraj) {
					if(pocetak <10) {
						String tk = "0" + String.valueOf(pocetak++)+":00" + ",1";
						sviTermini.add(tk);
					}
					else
					{
						String tk = String.valueOf(pocetak++)+":00" + ",1";
						sviTermini.add(tk);
					}
	
					
				}
				List<String> termini = ljekarService.slobodniTermini(date1, lj.getId());
				
				for(String t: sviTermini)
				{
					

						if(termini.contains(t))
						{
							System.out.println("zauzet");
						}
						else
						{	
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
		
		//klinika.setLjekari(ljekari);
		KlinikaDTO klinikaDTO = new KlinikaDTO(klinika, ljekariDTO,null, null);
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
	
	
	@PostMapping(value = "/zakaziPregled" )
	public ResponseEntity<String> zakaziPregled(@RequestParam String tipPregleda, @RequestParam String datumPregleda, @RequestParam String emailLjekara,@RequestParam String vrijemePregleda ) throws ParseException {
		System.out.println("alkgasdkg;laksdg0");
		System.out.println(tipPregleda);
		System.out.println(datumPregleda);
		System.out.println(emailLjekara);
		System.out.println(vrijemePregleda);
		Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(datumPregleda); 
		
		Ljekar lj = ljekarService.findOneByEmail(emailLjekara);
		TipPregleda tipP = tipPregledaRepository.findOneBytip(Specijalizacija.valueOf(tipPregleda));
		Pregled zakazaniPregled = new Pregled();
		zakazaniPregled.setStatus(StatusPregleda.zakazan);
		zakazaniPregled.setLjekar(lj);
		zakazaniPregled.setTipPregleda(tipP);
		zakazaniPregled.setVrijemePocetka(vrijemePregleda);
		zakazaniPregled.setDatum(date1);
		zakazaniPregled = pregledService.save(zakazaniPregled);
		
		return new ResponseEntity<>("Pregled je dodan!",HttpStatus.CREATED);
	}
	
}
