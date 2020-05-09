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
insert into tabela_prijava(eadresa, lozinka)values('pacijent1@eclinic.com', 'ppacijent');

insert into tabela_prijava(eadresa, lozinka)values('dr1@eclinic.com', 'pljekar');
insert into tabela_korisnika(type, aktivan, ime, prezime, dodijeljena_lozinka, predefinisani, info, ocjena, radno_vrijeme, specijalizacija, adresa, broj_telefona, drzava, grad,jbo,prijava_id,klinika_id,karton_id, kc_id) 
						values('P', false, 'Snjezana', 'Simic', false, false, null, null, null, null, 'Hajduk Veljka bb', '066617528', 'Bosna', 'Derventa', '123456', 'pacijent1@eclinic.com', null,null, 'Eclinic');
			
--Dodavanje klinika--
insert into klinike(grad, naziv_klinike, ocjena_klinike, tip_klinike, kc_id)
values('Beograd', 'VMA', '4', 1, 'Eclinic');

insert into klinike(grad, naziv_klinike, ocjena_klinike, tip_klinike, kc_id)
values('Banjaluka', 'UKC', '4', 2, 'Eclinic');

insert into klinike(grad, naziv_klinike, ocjena_klinike, tip_klinike, kc_id)
values('Sarajevo', 'Kosevo', '2', 3, 'Eclinic');

insert into klinike(grad, naziv_klinike, ocjena_klinike, tip_klinike, kc_id)
values('Zagreb', 'Nasa Klinika', '5', 3, 'Eclinic');

insert into klinike(grad, naziv_klinike, ocjena_klinike, tip_klinike, kc_id)
values('Novi Sad', 'Klinika Svjetlost', '3', 3, 'Eclinic');

--Ljekari--
--insert into tabela_prijava(eadresa, lozinka)values('ljekar1@eclinic.com', 'pljekar');
--insert into tabela_korisnika(type, ime, prezime,info, ocjena,radno_vrijeme,specijalizacija,prijava_id,klinika_id,karton_id, kc_id)
--values('LJ', 'Stojan', 'Mutikasa','Studirao u Beogradu.',5,'09:00-17:00',2, 'ljekar1@eclinic.com',1,null,'Eclinic' );

insert into tabela_prijava(eadresa, lozinka)values('ljekar2@eclinic.com', 'pljekar');
insert into tabela_korisnika(type, ime, prezime,info, ocjena,radno_vrijeme,specijalizacija,prijava_id,klinika_id,karton_id, kc_id)
values('LJ', 'Stanko', 'Stanic','Studirao u Novom Sadu.',5,'09:00-17:00',2, 'ljekar2@eclinic.com',2,null,'Eclinic' );

insert into tabela_prijava(eadresa, lozinka)values('ljekar3@eclinic.com', 'pljekar');
insert into tabela_korisnika(type, ime, prezime,info, ocjena,radno_vrijeme,specijalizacija,prijava_id,klinika_id,karton_id, kc_id)
values('LJ', 'Vladimir', 'Stojanovic','Studirao u Beogradu.',5,'09:00-17:00',3, 'ljekar3@eclinic.com',3,null,'Eclinic' );

insert into tabela_prijava(eadresa, lozinka)values('ljekar4@eclinic.com', 'pljekar');
insert into tabela_korisnika(type, ime, prezime,info, ocjena,radno_vrijeme,specijalizacija,prijava_id,klinika_id,karton_id, kc_id)
values('LJ', 'Micomir', 'Perkovic','Studirao u Banjaluci.',5,'09:00-17:00',3, 'ljekar3@eclinic.com',4,null,'Eclinic' );

insert into tabela_prijava(eadresa, lozinka)values('ljekar5@eclinic.com', 'pljekar');
insert into tabela_korisnika(type, ime, prezime,info, ocjena,radno_vrijeme,specijalizacija,prijava_id,klinika_id,karton_id, kc_id)
values('LJ', 'Vladimir', 'Velimirovic','Studirao u Beogradu.',5,'09:00-17:00',3, 'ljekar3@eclinic.com',1,null,'Eclinic' );

--Zahtjevi za registraciju--
insert into zahtjevi_registracija(eAdresa, lozinka, ime, prezime, jbo, adresa, grad, drzava, broj_telefona)
values('mile@eclinic.com', 'miloz', 'Mile', 'Milic', '144555', 'Stepe Stapanovica bb', 'Banja Luka', 'BiH', '066555444' );

insert into zahtjevi_registracija(eAdresa, lozinka, ime, prezime, jbo, adresa, grad, drzava, broj_telefona)
values('pero@eclinic.com', 'peloz', 'Pero', 'Peric', '111111', 'Gavrila Principa', 'Derventa', 'BiH', '066775444' );

insert into zahtjevi_registracija(eAdresa, lozinka, ime, prezime, jbo, adresa, grad, drzava, broj_telefona)
values('boro@eclinic.com', 'boloz', 'Boro', 'Boric', '143355', 'Gajeva', 'Novi Sad', 'Srbija', '066558844' );

insert into tabela_prijava(eadresa, lozinka)values('admink1@eclinic.com', 'pak');
insert into tabela_korisnika(type, aktivan, ime, prezime, dodijeljena_lozinka, predefinisani, info, ocjena, radno_vrijeme, specijalizacija, adresa, broj_telefona, drzava, grad,jbo,prijava_id,klinika_id,karton_id, kc_id) 
values('AK', false, 'Nikola', 'Nikic', false, false, null, null, null, null, null, null, null, null, null,'admink1@eclinic.com', 1,null, 'Eclinic');

----Dodavanje doktora--
--insert into tabela_korisnika(type, aktivan, ime, prezime, dodijeljena_lozinka, predefinisani, info, ocjena, radno_vrijeme, specijalizacija, adresa, broj_telefona, drzava, grad,jbo,prijava_id,klinika_id,karton_id, kc_id) 
--						values('LJ', true, 'Biljana', 'Maksimovic', false , false, null, '5', '8', 1, null,null,null, null, null, 'dr1@eclinic.com', 1,null, 'Eclinic');
--										
--			

----Dodavanje doktora--
--insert into tabela_korisnika(type, aktivan, ime, prezime, dodijeljena_lozinka, predefinisani, info, ocjena, radno_vrijeme, specijalizacija, adresa, broj_telefona, drzava, grad,jbo,prijava_id,klinika_id,karton_id, kc_id) 
--						values('LJ', true, 'Ratko', 'Nikolic', false, false, null, 4, null, 2, null,null,null, null, null, null, 1,null, 'Eclinic');
--						
----Dodavanje doktora--
--insert into tabela_korisnika(type, aktivan, ime, prezime, dodijeljena_lozinka, predefinisani, info, ocjena, radno_vrijeme, specijalizacija, adresa, broj_telefona, drzava, grad,jbo,prijava_id,klinika_id,karton_id, kc_id) 
--						values('LJ', true, 'Gordana', 'Radic', false, false, null, 3, null, 1, null,null,null, null, null, null, 2,null, 'Eclinic');		
--						
----Dodavanje doktora--
--insert into tabela_korisnika(type, aktivan, ime, prezime, dodijeljena_lozinka, predefinisani, info, ocjena, radno_vrijeme, specijalizacija, adresa, broj_telefona, drzava, grad,jbo,prijava_id,klinika_id,karton_id, kc_id) 
--						values('LJ', true, 'Miodrag', 'Rakic', false, false, null, 2, null, 5, null,null,null, null, null, null, 3,null, 'Eclinic');