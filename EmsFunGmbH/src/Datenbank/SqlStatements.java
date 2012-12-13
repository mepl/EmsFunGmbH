package Datenbank;

public class SqlStatements {
//	########## Datenbank ##########
//
//	create database KundenBuchungsSystem;
//	use kundenBuchungsSystem;
//
//
//	######################################## Kunde ##################################################
//
//	create table tbl_Kunden( kd_KundenID int primary key auto_increment, kd_Name varchar(50) not null, kd_Vorname varchar(50) not null, kd_Strasse varchar(50) not null, kd_HNummer varchar(10) not null, kd_PLZ varchar(10) not null, kd_Ort varchar(50) not null, kd_Telefon varchar(25), kd_EMail varchar(50));
//
//	#----SELECT----#
//
//			select * from tbl_Kunden;
//
//	#----INSERT----#
//
//			insert into tbl_kunden(kd_Name, kd_Vorname, kd_Strasse, kd_HNummer, kd_PLZ, kd_Ort, kd_Telefon, kd_EMail) VALUES
//			('Test','TesstVorname','TestStrasse','123A','80853','München','123456','mi@test');
//
//			Kunde kunde = new Kunde();
//			StringBuilder builder = new StringBuilder();
//			builder.append("insert into tbl_kunden(kd_Name, kd_Vorname, kd_Strasse, kd_HNummer, kd_PLZ, kd_Ort, kd_Telefon, kd_EMail) VALUES ('");
//			builder.append(kunde.getName());
//			builder.append("','");
//			builder.append(kunde.getVorname());
//			builder.append("','");
//			builder.append(kunde.getStrasse());
//			builder.append("','");
//			builder.append(kunde.getHausNummer());
//			builder.append("','");
//			builder.append(kunde.getPlz());
//			builder.append("','");
//			builder.append(kunde.getOrt());
//			builder.append("','");
//			builder.append(kunde.getTelefon());
//			builder.append("','");
//			builder.append(kunde.getEmail());
//			builder.append("');");
//
//	#----UPDATE----#
//
//			StringBuilder builder = new StringBuilder();
//			builder.append("update tbl_Kunden set kd_Name = '");
//			builder.append(kunde.getName());
//			builder.append("',kd_Vorname ='");
//			builder.append(kunde.getVorname());
//			builder.append("',kd_Strasse ='");
//			builder.append(kunde.getStrasse());
//			builder.append("',kd_HNummer ='");
//			builder.append(kunde.getHausNummer());
//			builder.append("',kd_PLZ ='");
//			builder.append(kunde.getPlz());
//			builder.append("',kd_Ort ='");
//			builder.append(kunde.getOrt());
//			builder.append("',kd_Telefon ='");
//			builder.append(kunde.getTelefon());
//			builder.append("',kd_EMail ='");
//			builder.append(kunde.getEmail());
//			builder.append("' WHERE kd_KundenID = '");
//			builder.append(kunde.getKundenID);
//			builder.append("';");
//
//	#----DELETE----#
//
//			StringBuilder builder = new StringBuilder();
//			builder.append("DELETE FROM tbl_Kunden where kd_KundenID =");
//			builder.append(kunde.getKundenID());
//			builder.append(";");
//
//	######################################## Veranstalter ##################################################
//
//	create table tbl_EvVeranstalter(ev_EvVeranstalterID int primary key auto_increment,ev_Firma varchar(50) not null,ev_Strasse varchar(50) not null,ev_PLZ varchar(10) not null,ev_HNummer varchar(10) not null,ev_Ort varchar(50) not null,ev_Telefon varchar(25),ev_EMail varchar(50),ev_Fax varchar(50));
//
//	#----SELECT----#
//
//			select * from tbl_EvVeranstalter;
//			select * from tbl_EvVeranstalter where ev_EvVeranstalterID = ;
//
//	#----INSERT----#
//
//			EventVeranstalter veranstalter = new EventVeranstalter();
//			builder = new StringBuilder();
//			builder.append("insert into tbl_EvVeranstalter(ev_Firma, ev_Strasse, ev_PLZ, ev_HNummer, ev_Ort, ev_Telefon, ev_EMail, ev_Fax) VALUES ('");
//			builder.append(veranstalter.getFirma());
//			builder.append("','");
//			builder.append(veranstalter.getStrasse());
//			builder.append("','");
//			builder.append(veranstalter.getPlz());
//			builder.append("','");
//			builder.append(veranstalter.getHausNummer());
//			builder.append("','");
//			builder.append(veranstalter.getOrt());
//			builder.append("','");
//			builder.append(veranstalter.getTelefon());
//			builder.append("','");
//			builder.append(veranstalter.getEmail());
//			builder.append("','");
//			builder.append(veranstalter.getFax());
//			builder.append("');");
//
//	#----UPDATE----#
//
//			builder = new StringBuilder();
//			builder.append("update tbl_EvVeranstalter set ev_Firma = '");
//			builder.append(veranstalter.getFirma());
//			builder.append("', ev_Strasse = '");
//			builder.append(veranstalter.getStrasse());
//			builder.append("', ev_PLZ = '");
//			builder.append(veranstalter.getPlz());
//			builder.append("', ev_HNummer = '");
//			builder.append(veranstalter.getHausNummer());
//			builder.append("', ev_Ort ='");
//			builder.append(veranstalter.getOrt());
//			builder.append("', ev_Telefon ='");
//			builder.append(veranstalter.getTelefon());
//			builder.append("', ev_EMail = '");
//			builder.append(veranstalter.getEmail());
//			builder.append("', ev_Fax = '");
//			builder.append(veranstalter.getFax());
//			builder.append("' WHERE ev_EvVeranstalterID = ");
//			builder.append(veranstalter.getEventVeranstalterID);
//			builder.append(";");
//			
//	#----DELETE----#
//
//			builder = new StringBuilder();
//			builder.append("DELETE FROM tbl_EvVeranstalter where ev_EvVeranstalterID =");
//			builder.append(veranstalter.getEventVeranstalterID());
//			builder.append(";");
//
//	######################################## Kategorie ##################################################
//
//	create table tbl_EvKategorie(ek_EvKategorieID int primary key auto_increment,ek_KatBezeichnung varchar(15) not null);
//
//	#----SELECT----#
//
//			select * from tbl_EvKategorie;
//
//	#----INSERT----#
//
//			EventKategorie kategorie = new EventKategorie();
//			builder = new StringBuilder();
//			builder.append("insert into tbl_EvKategorie(ek_KatBezeichnung) VALUES ('");
//			builder.append(kategorie.getBezeichnung());
//			builder.append("');");
//
//	#----UPDATE----#
//
//			EventKategorie kategorie = new EventKategorie();
//			builder = new StringBuilder();
//			builder.append("update tbl_EvKategorie set ek_KatBezeichnung = '");
//			builder.append(kategorie.getBezeichnung());
//			builder.append("';");
//
//	#----DELETE----#
//
//			EventKategorie kategorie = new EventKategorie();
//			builder = new StringBuilder();
//			builder.append("delete from tbl_EvKategorie where ek_EvKategorieID = ");
//			builder.append(kategorie.getEventKategorieID());
//			builder.append(";");
//
//	######################################## Event ##################################################
//
//	create table tbl_Events(et_EventID int primary key auto_increment,ev_EvVeranstalterID int not null,ek_EvKategorieID int not null,et_Bezeichnung varchar(50) not null,et_Beschreibung mediumtext,foreign key tbl_EvKategorie_tbl_Events_FK1(ek_EvKategorieID) references tbl_EvKategorie(ek_EvKategorieID), foreign key tbl_EvVeranstalter_tbl_Events_FK1(ev_EvVeranstalterID) references tbl_EvVeranstalter(ev_EvVeranstalterID));
//
//	#----SELECT----#
//			
//			select * from tbl_Events;
//			
//	#----INSERT----#
//
//			Event event = new Event();
//			builder = new StringBuilder();
//			builder.append("insert into tbl_Events(ev_EvVeranstalterID,ek_EvKategorieID,et_Bezeichnung,et_Beschreibung) VALUES (");
//			builder.append(event.getEventVeranstalterID());
//			builder.append(",");
//			builder.append(event.getEventKategorieID());
//			builder.append(",'");
//			builder.append(event.getBezeichnung());
//			builder.append("','");
//			builder.append(event.getBeschreibung());
//			builder.append("');");
//
//	#----UPDATE----#
//
//			Event event = new Event();
//			builder = new StringBuilder();
//			builder.append("update tbl_Events set ev_EvVeranstalterID = ");
//			builder.append(event.getEventVeranstalterID());
//			builder.append(", ek_EvKategorieID = ");
//			builder.append(event.getEventKategorieID());
//			builder.append(", et_Bezeichnung = '");
//			builder.append(event.getBezeichnung());
//			builder.append("', et_Beschreibung = '");
//			builder.append(event.getBeschreibung());
//			builder.append("' WHERE et_EventID = ;");
//			builder.append(event.getEventID());
//			builder.append(";");
//
//	#----DELETE----#
//
//			Event event = new Event();
//			builder = new StringBuilder();
//			builder.append("delte from tbl_Events where et_EventID = ");
//			builder.append(event.getEventID());
//			builder.append(";");
//
//	######################################## Eventdaten ##################################################
//
//	create table tbl_EventDaten(ed_EvDatenID int primary key auto_increment,et_EventID int not null,ed_Preis decimal(10,2) not null,ed_Beginn date not null,ed_Ende date not null,ed_StartOrt varchar(50) not null,ed_ZielOrt varchar(50),ed_MaxTeilnehmer int not null,ed_AktTeilnehmer int not null,ed_Freigegeben tinyint(1) not null default 0,ed_Rabatt decimal(18,0) not null default 0,ed_VeranstalterBenachrichtigt tinyint(1) not null default 0,foreign key tbl_Events_tbl_EvDaten_FK1(et_EventID) references tbl_Events(et_EventID));
//
//	#----SELECT----#
//
//			select * from tbl_EventDaten;
//
//	#----INSERT----#
//
//			EventDaten daten = new EventDaten();
//			builder = new StringBuilder();
//			builder.append("insert into tbl_EventDaten (et_EventID,ed_Preis,ed_Beginn,ed_Ende,ed_StartOrt,ed_ZielOrt,ed_MaxTeilnehmer,ed_AktTeilnehmer,ed_Freigegeben,ed_Rabatt,ed_VeranstalterBenachrichtigt) VALUES(");
//			builder.append(daten.getEventID());
//			builder.append(",");
//			builder.append(daten.getPreis());
//			builder.append(",'");
//			builder.append(daten.getBeginn());
//			builder.append("','");
//			builder.append(daten.getEnde());
//			builder.append("','");
//			builder.append(daten.getStartOrt());
//			builder.append("','");
//			builder.append(daten.getZielOrt());
//			builder.append("',");
//			builder.append(daten.getMaxTeilnehmer());
//			builder.append(",");
//			builder.append(daten.getAktTeilnehmer());
//			builder.append(",'");
//			builder.append(daten.isFreigegeben());
//			builder.append("',");
//			builder.append(daten.getRabatt());
//			builder.append(",'");
//			builder.append(daten.isVeranstalterBenachricht());
//			builder.append("');");
//
//	#----UPDATE----#
//
//			EventDaten daten = new EventDaten();
//			builder = new StringBuilder();
//			builder.append("update tbl_EventDaten set et_EventID = '");
//			builder.append(daten.getEventID());
//			builder.append("', ed_Preis = ");
//			builder.append(daten.getPreis());
//			builder.append(", ed_Beginn = '");
//			builder.append(daten.getBeginn());
//			builder.append("', ed_Ende = '");
//			builder.append(daten.getEnde());
//			builder.append("', ed_StartOrt = '");
//			builder.append(daten.getStartOrt());
//			builder.append("', ed_ZielOrt = '");
//			builder.append(daten.getZielOrt());
//			builder.append("', ed_MaxTeilnehmer = ");
//			builder.append(daten.getMaxTeilnehmer());
//			builder.append(", ed_AktTeilnehmer = ");
//			builder.append(daten.getAktTeilnehmer());
//			builder.append(", ed_Freigegeben = '");
//			builder.append(daten.isFreigegeben());
//			builder.append("', ed_Rabatt = ");
//			builder.append(daten.getRabatt());
//			builder.append(", ed_VeranstalterBenachrichtigt = '");
//			builder.append(daten.isVeranstalterBenachricht());
//			builder.append("' WHERE ed_EvDatenID =");
//			builder.append(daten.getEventDatenID());
//			builder.append(";");
//			
//	#----DELETE----#
//
//			EventDaten daten = new EventDaten();
//			builder = new StringBuilder();
//			builder.append("delete from tbl_EventDaten where ed_EvDatenID = ");
//			builder.append(daten.getEventDatenID());
//			builder.append(";");
//
//	######################################## Buchungen ##################################################
//
//	create table tbl_Buchungen(bu_BuchungsID int primary key auto_increment,kd_KundenID int not null,ed_EvDatenID int not null,bu_GebuchtePlaetze int not null,bu_Bezahlt tinyint(1) not null default 0,bu_Stoniert tinyint(1) not null default 0,bu_RechnungErstellt tinyint(1) not null default 0);
//
//	#----SELECT----#
//
//			select * from tbl_Buchungen;
//
//	#----INSERT----#
//
//			Buchung buchung = new Buchung();
//			builder = new StringBuilder();
//			builder.append("insert into tbl_Buchungen(kd_KundenID,ed_EvDatenID,bu_GebuchtePlaetze,bu_Bezahlt,bu_Stoniert,bu_RechnungErstellt) VALUES(");
//			builder.append(buchung.getKundenID());
//			builder.append(",");
//			builder.append(buchung.getEventDatenID());
//			builder.append(",");
//			builder.append(buchung.getGebuchtePlaetze());
//			builder.append(",'");
//			builder.append(buchung.isBezahlt());
//			builder.append("','");
//			builder.append(buchung.isStoniert());
//			builder.append("','");
//			builder.append(buchung.isRechnungErstellt());
//			builder.append("');");
//
//	#----UPDATE----#
//
//			buchung = new Buchung();
//			builder = new StringBuilder();
//			builder.append("update tbl_Buchungen set kd_KundenID = ");
//			builder.append(buchung.getKundenID());
//			builder.append(", ed_EvDatenID = ");
//			builder.append(buchung.getEventDatenID());
//			builder.append(", bu_GebuchtePlaetze = ");
//			builder.append(buchung.getGebuchtePlaetze());
//			builder.append(", bu_Bezahlt = '");
//			builder.append(buchung.isBezahlt());
//			builder.append("', bu_Stoniert = '");
//			builder.append(buchung.isStoniert());
//			builder.append("', bu_RechnungErstellt = '");
//			builder.append(buchung.isRechnungErstellt());
//			builder.append("' where bu_BuchungsID =");
//			builder.append(buchung.getBuchungID());
//			builder.append(";");
//
//	#----DELETE----#
//
//			Buchung buchung = new Buchung();
//			builder = new StringBuilder();
//			builder.append("delte from tbl_Buchungen where bu_BuchungsID = ");
//			builder.append(buchung.getBuchungID());
//			builder.append(";");
//			
//			
//			
//			
//			
//			
//			
//			
}
