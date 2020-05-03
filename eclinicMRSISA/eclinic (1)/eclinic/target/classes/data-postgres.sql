--Dodavanje sifarnika dijagnoza--
insert into sifarnik_dijagnoza(naziv_sifarnika)values('Sifarnik dijagnoza');
--Dodavanje sifarnika lijekova--
insert into sifarnik_lijekova(naziv_sifarnika)values('Sifarnik lijekova');
--Dodavanje klinickog centra--
insert into klinicki_centar(kc_id,sif_dij_id, sif_lijek_id)values('Eclinic',1, 1);
--Dodavanje predefinisanog admina klinickog centra--
insert into tabela_prijava(eadresa, lozinka)values('predefinisani@eclinic.com', 'padmin');
insert into tabela_korisnika(type, aktivan, ime, prezime, dodijeljena_lozinka, predefinisani, info, ocjena, radno_vrijeme, specijalizacija, adresa, broj_telefona, drzava, grad,jbo,prijava_id,klinika_id,karton_id, kc_id) values('AC', true, 'Marko', 'Maricic', false, true, null, null, null, null, null, null, null, null, null, 'predefinisani@eclinic.com', null,null, 'Eclinic');


--Dodavanje nekog pacijenta--
insert into tabela_prijava(eadresa, lozinka)values('pacijent1@eclinic.com', 'ppacijent');
insert into tabela_korisnika(type, aktivan, ime, prezime, dodijeljena_lozinka, predefinisani, info, ocjena, radno_vrijeme, specijalizacija, adresa, broj_telefona, drzava, grad,jbo,prijava_id,klinika_id,karton_id, kc_id) 
						values('P', true, 'Pacijent', 'Pacijentcic', false, false, null, null, null, null, 'Hajduk Veljka bb', '066617528', 'Bosna', 'Derventa', '123456', 'pacijent1@eclinic.com', null,null, 'Eclinic');
						
insert into klinike(grad, naziv_klinike, ocjena_klinike, tip_klinike, kc_id)
values('Beograd', 'vma', '5', 1, 'Eclinic');

insert into klinike(grad, naziv_klinike, ocjena_klinike, tip_klinike, kc_id)
values('Banjaluka', 'UKC', '5', 2, 'Eclinic');

insert into klinike(grad, naziv_klinike, ocjena_klinike, tip_klinike, kc_id)
values('Sarajevo', 'Kosevo', '5', 3, 'Eclinic');