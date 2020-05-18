--Dodavanje sifarnika dijagnoza--
insert into sifarnik_dijagnoza(naziv_sifarnika)values('Sifarnik dijagnoza');
--Dodavanje sifarnika lijekova--
insert into sifarnik_lijekova(naziv_sifarnika)values('Sifarnik lijekova');



--Dodavanje klinickog centra--
insert into klinicki_centar(kc_id,sif_dij_id, sif_lijek_id)values('Eclinic',1, 1);
--Dodavanje predefinisanog admina klinickog centra--
insert into tabela_prijava(eadresa, lozinka)values('predefinisani@eclinic.com', 'padmin');
insert into tabela_korisnika(type, aktivan, ime, prezime, dodijeljena_lozinka, predefinisani, info, ocjena, radno_vrijeme, specijalizacija, adresa, broj_telefona, drzava, grad,jbo,prijava_id,klinika_id,karton_id, kc_id) 
values('AC', false, 'Marko', 'Maricic', false, true, null, null, null, null, null, null, null, null, null, 'predefinisani@eclinic.com', null,null, 'Eclinic');


--Dodavanje nekog pacijenta--
insert into zdravstveni_karton (krvna_grupa) values (null);
insert into tabela_prijava(eadresa, lozinka)values('pacijent1@eclinic.com', 'ppacijent');

insert into tabela_prijava(eadresa, lozinka)values('dr1@eclinic.com', 'pljekar');
insert into tabela_korisnika(type, aktivan, ime, prezime, dodijeljena_lozinka, predefinisani, info, ocjena, radno_vrijeme, specijalizacija, adresa, broj_telefona, drzava, grad,jbo,prijava_id,klinika_id,karton_id, kc_id) 
						values('P', false, 'Snjezana', 'Simic', false, false, null, null, null, null, 'Hajduk Veljka bb', '066617528', 'Bosna', 'Derventa', '123456', 'pacijent1@eclinic.com', null,1, 'Eclinic');

insert into zdravstveni_karton (krvna_grupa) values (null);
insert into tabela_prijava(eadresa, lozinka)values('vaso@eclinic.com', 'valoz');

insert into tabela_korisnika(type, prijava_id, kc_id, ime, prezime, jbo, adresa, grad, drzava, broj_telefona, karton_id)
values('P', 'vaso@eclinic.com', 'Eclinic', 'Vaso', 'Vasic', '222222', 'Jevrjeska', 'Novi Sad', 'Srbija', '066553334', 2 );


--Dodavanje klinika--
insert into klinike(grad,adresa, naziv_klinike, ocjena_klinike, tip_klinike, kc_id)
values('Beograd','adr','VMA', '4', 0, 'Eclinic');

insert into klinike(grad,adresa, naziv_klinike, ocjena_klinike, tip_klinike, kc_id)
values('Banjaluka','adr','UKC', '4', 0, 'Eclinic');

insert into klinike(grad,adresa, naziv_klinike, ocjena_klinike, tip_klinike, kc_id)
values('Sarajevo','adr' ,'Kosevo', '2', 0, 'Eclinic');

insert into klinike(grad,adresa, naziv_klinike, ocjena_klinike, tip_klinike, kc_id)
values('Zagreb','adr', 'Nasa Klinika', '5', 3, 'Eclinic');

insert into klinike(grad, adresa,naziv_klinike, ocjena_klinike, tip_klinike, kc_id)
values('Novi Sad','adr' ,'Klinika Svjetlost', '3', 4, 'Eclinic');

insert into klinike(grad, adresa,naziv_klinike, ocjena_klinike, tip_klinike, kc_id)
values('Sarajevo','adr', 'Nova Bolnica', '4', 3, 'Eclinic');

insert into klinike(grad, adresa,naziv_klinike, ocjena_klinike, tip_klinike, kc_id)
values('Zagreb','adr', 'Dr Pavlovic', '5', 3, 'Eclinic');

insert into klinike(grad,adresa, naziv_klinike, ocjena_klinike, tip_klinike, kc_id)
values('Novi Sad','adr', 'Klinika Diva', '3', 4, 'Eclinic');

--Ljekari--
insert into tabela_prijava(eadresa, lozinka)values('ljekar1@eclinic.com', 'pljekar');
insert into tabela_korisnika(type, ime, prezime,info, ocjena,radno_vrijeme,specijalizacija,prijava_id,klinika_id,karton_id, kc_id)
values('LJ', 'Stojan', 'Mutikasa','Studirao u Beogradu.',5,'09:00-17:00',0, 'ljekar1@eclinic.com',1,null,'Eclinic' );

insert into tabela_prijava(eadresa, lozinka)values('ljekar2@eclinic.com', 'pljekar');
insert into tabela_korisnika(type, ime, prezime,info, ocjena,radno_vrijeme,specijalizacija,prijava_id,klinika_id,karton_id, kc_id)
values('LJ', 'Stanko', 'Stanic','Studirao u Novom Sadu.',5,'09:00-17:00',0, 'ljekar2@eclinic.com',2,null,'Eclinic' );

insert into tabela_prijava(eadresa, lozinka)values('ljekar3@eclinic.com', 'pljekar');
insert into tabela_korisnika(type, ime, prezime,info, ocjena,radno_vrijeme,specijalizacija,prijava_id,klinika_id,karton_id, kc_id)
values('LJ', 'Vladimir', 'Stojanovic','Studirao u Beogradu.',5,'09:00-17:00',0, 'ljekar3@eclinic.com',3,null,'Eclinic' );

insert into tabela_prijava(eadresa, lozinka)values('ljekar4@eclinic.com', 'pljekar');
insert into tabela_korisnika(type, ime, prezime,info, ocjena,radno_vrijeme,specijalizacija,prijava_id,klinika_id,karton_id, kc_id)
values('LJ', 'Micomir', 'Perkovic','Studirao u Banjaluci.',5,'09:00-17:00',1, 'ljekar4@eclinic.com',4,null,'Eclinic' );

insert into tabela_prijava(eadresa, lozinka)values('ljekar5@eclinic.com', 'pljekar');
insert into tabela_korisnika(type, ime, prezime,info, ocjena,radno_vrijeme,specijalizacija,prijava_id,klinika_id,karton_id, kc_id)
values('LJ', 'Vladimir', 'Velimirovic','Studirao u Beogradu.',5,'09:00-17:00',1, 'ljekar5@eclinic.com',1,null,'Eclinic' );

--Zahtjevi za registraciju--
insert into zahtjevi_registracija(eAdresa, lozinka, ime, prezime, jbo, adresa, grad, drzava, broj_telefona)
values('mile@eclinic.com', 'miloz', 'Mile', 'Milic', '144555', 'Stepe Stapanovica bb', 'Banja Luka', 'BiH', '066555444' );

insert into zahtjevi_registracija(eAdresa, lozinka, ime, prezime, jbo, adresa, grad, drzava, broj_telefona)
values('pero@eclinic.com', 'peloz', 'Pero', 'Peric', '111111', 'Gavrila Principa', 'Derventa', 'BiH', '066775444' );

insert into zahtjevi_registracija(eAdresa, lozinka, ime, prezime, jbo, adresa, grad, drzava, broj_telefona)
values('boro@eclinic.com', 'boloz', 'Boro', 'Boric', '143355', 'Gajeva', 'Novi Sad', 'Srbija', '066558844' );

insert into zahtjevi_registracija(eAdresa, lozinka, ime, prezime, jbo, adresa, grad, drzava, broj_telefona)
values('vaso@eclinic.com', 'boloz', 'Vaso', 'Vasic', '222222', 'Jevrjeska', 'Novi Sad', 'Srbija', '066553334' );

insert into zahtjevi_registracija(eAdresa, lozinka, ime, prezime, jbo, adresa, grad, drzava, broj_telefona)
values('Rade@eclinic.com', 'boloz', 'Rade', 'Radic', '123456', 'Cara Dusana', 'Novi Sad', 'Srbija', '066599844' );


--Admin klinike--
insert into tabela_prijava(eadresa, lozinka)values('admink1@eclinic.com', 'pak');
insert into tabela_korisnika(type, aktivan, ime, prezime, dodijeljena_lozinka, predefinisani, info, ocjena, radno_vrijeme, specijalizacija, adresa, broj_telefona, drzava, grad,jbo,prijava_id,klinika_id,karton_id, kc_id) 
values('AK', false, 'Nikola', 'Nikic', false, false, null, null, null, null, null, null, null, null, null,'admink1@eclinic.com', 1,null, 'Eclinic');

--Dodavanje tip_pregleda --
insert into tip_pregleda(cijena, sifra, trajanje, tip)values(12.5, 'specoft',1,0);
insert into tip_pregleda(cijena, sifra, trajanje, tip)values(12.5, 'specpulmo',1,1);

--Dodavanje pregleda--
insert into pregledi(datum_pregleda, popust, status, vrijeme_pocetka, sifra_pregleda, ljekar_id)
			values('Mon Jun 01 00:00:00 CEST 2020', 0,0, '09:00', 'specoft',4);
insert into pregledi(datum_pregleda, popust, status, vrijeme_pocetka, sifra_pregleda,ljekar_id)
			values('Mon Jun 01 00:00:00 CEST 2020', 0,0, '08:00', 'specpulmo',5);
			
insert into pregledi(datum_pregleda, popust, status, vrijeme_pocetka, sifra_pregleda, ljekar_id)
			values('Mon Jun 01 00:00:00 CEST 2020', 0,0, '11:00', 'specoft',6);
			
insert into pregledi(datum_pregleda, popust, status, vrijeme_pocetka, sifra_pregleda, ljekar_id)
			values('Mon Jun 01 00:00:00 CEST 2020', 0,0, '07:00', 'specoft',7);
			
insert into pregledi(datum_pregleda, popust, status, vrijeme_pocetka, sifra_pregleda, ljekar_id)
			values('Mon Jun 01 00:00:00 CEST 2020', 0,0, '12:00', 'specoft',8);
			
--zahtjevi za odsustvo--
insert into zahtjevi_odsustava(kraj, pocetak, prihvacen, tip_odsustva, ljekar_id)
						values('2001-08-28','2001-07-27',true, 0, 5);
						
insert into zahtjevi_odsustava(kraj, pocetak, prihvacen, tip_odsustva, ljekar_id)
						values('2001-08-28','2001-07-29',true, 0, 6);
						
----tipovi pregleda u klinici--
insert into tipovi_pregledauklinici(klinika_id,sifra)
							values(1,'specoft');
insert into tipovi_pregledauklinici(klinika_id,sifra)
							values(2,'specoft');
insert into tipovi_pregledauklinici(klinika_id,sifra)
							values(3,'specoft');