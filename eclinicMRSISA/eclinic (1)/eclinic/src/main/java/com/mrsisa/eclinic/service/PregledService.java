package com.mrsisa.eclinic.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrsisa.eclinic.dto.KlinikaDTO;
import com.mrsisa.eclinic.dto.LjekarDTO;
import com.mrsisa.eclinic.dto.PregledDTO;
import com.mrsisa.eclinic.model.Pregled;
import com.mrsisa.eclinic.model.Specijalizacija;
import com.mrsisa.eclinic.model.StatusPregleda;
import com.mrsisa.eclinic.model.TipPregleda;
import com.mrsisa.eclinic.repository.KlinikaRepository;
import com.mrsisa.eclinic.repository.LjekarRepository;
import com.mrsisa.eclinic.repository.PregledRepository;
import com.mrsisa.eclinic.repository.TipPregledaRepository;

@Service
public class PregledService {
	
	@Autowired 
	private PregledRepository pregledRepository;
	
	@Autowired
	private KlinikaRepository klinikaRepository;

	public List<KlinikaDTO> pretraziPreglede(Date datum, Specijalizacija tipPregleda) throws Exception{
		System.out.println("iz pretraziPreglede  "+datum+tipPregleda);
		List<Pregled> pregled1 = pregledRepository.findAllBydatum(datum); 
		System.out.println("rezultat::: " + pregled1);
		List<PregledDTO> rezultatPretrage = new ArrayList<PregledDTO>();
		List<KlinikaDTO> klinikeDTO = new ArrayList<KlinikaDTO>();
		for(Pregled pregled : pregled1) {
			System.out.println("PRETLJA :::");
			System.out.println(pregled.getStatus());

			System.out.println(pregled.getStatus().equals(StatusPregleda.slobodan));
			if(pregled.getStatus().equals(StatusPregleda.slobodan)) {
				System.out.println("Status pregleda::: ");
				System.out.println(pregled.getStatus());
				System.out.println("tipPregleda:::");
				System.out.println(pregled.getTipPregleda().getTip());

				System.out.println(tipPregleda);
				if(pregled.getTipPregleda().getTip().equals(tipPregleda)) {
					System.out.println("u petlji:::");
					System.out.println(pregled.getTipPregleda().getTip().equals(tipPregleda));
					PregledDTO pregledDTO = new PregledDTO(pregled);
					Set<LjekarDTO> ljekari = new HashSet();
					LjekarDTO ljekar = new LjekarDTO(pregled.getLjekar());
					ljekari.add(ljekar);
					//TO DO neki eror je kad stavim ljekare u konstruktor
					KlinikaDTO klinikaDTO = new KlinikaDTO(pregled.getLjekar().getKlinika(), null);
					klinikeDTO.add(klinikaDTO);
					rezultatPretrage.add(pregledDTO);
				}
				System.out.println("izasao iz petlje:::");
				System.out.println(rezultatPretrage);
			}
			System.out.println("izasao iz petlje2:::");
			System.out.println(rezultatPretrage);
		}
		if (rezultatPretrage == null) {
            throw new Exception("Ne postoji trazeni pregled.");
        }
		System.out.println("saf");
		System.out.println(rezultatPretrage);
		
		
		
		return klinikeDTO;
	}
}
