# MRSISA2020_T14

Raspodjela posla:

 1. Student --- Simić Snježana SW/82-2018 simic.snjezana@uns.ac.rs  -> sve kartice na trelu oznacene sa SS
 2. Student --- Zelić Slobodan SW/5-2017 slobodan.zelic@uns.ac.rs 
 3. Student --- Nataša Kovačević SW/81-2018 kovacevic.natasa@uns.ac.rs -> sve kartice na trelu oznacene na NK
 
Trello tabla - https://trello.com/b/YQF0T5XZ/mrsisa2020t14 

UPUTSTVO ZA INSTALACIJU I POKRETANJE PROJEKTA

Nije neophodna instalacija dodatnih biblioteka, sve biblioteke su dostupne zajedno sa projektom na gore pomenutom repozitorijumu. Takodje, bibloteke su na ispravan nacin ukljucene u rad projekta, tako da dodatna podesavanja nisu neophodna.

Projekat se pokrece iz razvojnog okruzenja koje podrzava rad sa Maven projektima. Preporucuje se pokretanje iz razvojnog okruzenja Eclipse, iz razloga sto je projekat razvijan u pomenutom okruzenju.

U Eclipse okruzenju projekat se importuje na sledeci nacin:
- Odabere se radni prostor za Eclipse (workspace).
- Uveze se projekat komandom: File->Import->Existing Maven Projects 
- Odabere se projekat sa lokacije na disku

Projekat se pokrece iz Eclipse-a komandom Run As -> Spring Boot Application

Kada je server pokrenut u zeljenom pretrazivacu (Opera, Chrome, Microsoft Edge) uneti adresu servera i port: http://localhost:8080

Prikazuje se pocetna strana aplikacije i korisnik moze dalje da je koristi.

*napomena za odabir klinike iz liste klinika
 -ne radi uvijek iz prvog puta odabir klinike, nekad mora vise puta da se klikne na hiperlink
 
*napomena za zakazivanje predmeta: 
 - nakon zakazivanja pregleda stize email, u zavisnosti od browsera moze da se ceka neko vrijeme na povratnu info

*napomena za aktivacije naloge preko email-a :
 - koristen je privatan nalog, pa ako zelite da provjerite funkcionalnost unesite svoj email u emailService


Logovanje na sistem:
- pacijent:  pacijent1, 123
- ljekar: ljekar1@eclinic.com, 123
- admin klinickog centra : user, 123
- admin klinike : admink1@eclinic.com, 123
- medicinska sestra : medicinskaSestra4@eclinic.com, 123

Ostale korisnike mozete naci u tabeli tabela_prijava u data-postgres.sql
-
