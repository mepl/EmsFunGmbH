package Datenbank;

public class SqlStatements {
	
//	create database KundenBuchungsSystem;
//
//	use kundenBuchungsSystem;
//
//	CREATE TABLE tbl_Kunden( kd_KundenID int primary key auto_increment, kd_Name varchar(50) not null, kd_Vorname varchar(50) not null, kd_Strasse varchar(50) not null, kd_HNummer varchar(10) not null, kd_PLZ varchar(10) not null, kd_Ort varchar(50) not null, kd_Telefon varchar(25), kd_EMail varchar(50));
//
//	create table tbl_EvVeranstalter(ev_EvVeranstalterID int primary key auto_increment,ev_Firma varchar(50) not null,ev_Strasse varchar(50) not null,ev_PLZ varchar(10) not null,ev_HNummer varchar(10) not null,ev_Ort varchar(50) not null,ev_Telefon varchar(25),ev_EMail varchar(50),ev_Fax varchar(50));
//
//	create table tbl_EvKategorie(ek_EvKategorieID int primary key auto_increment,ek_KatBezeichnung varchar(15) not null);
//
//	create table tbl_Events(et_EventID int primary key auto_increment,ev_EvVeranstalterID int not null,ek_EvKategorieID int not null,et_Bezeichnung varchar(50) not null,et_Beschreibung mediumtext,foreign key tbl_EvKategorie_tbl_Events_FK1(ek_EvKategorieID) references tbl_EvKategorie(ek_EvKategorieID), foreign key tbl_EvVeranstalter_tbl_Events_FK1(ev_EvVeranstalterID) references tbl_EvVeranstalter(ev_EvVeranstalterID));
//
//	create table tbl_EventDaten(ed_EvDatenID int primary key auto_increment,et_EventID int not null,ed_Preis decimal(10,2) not null,ed_Beginn date not null,ed_Ende date not null,ed_StartOrt varchar(50) not null,ed_ZielOrt varchar(50),ed_MaxTeilnehmer int not null,ed_AktTeilnehmer int not null,ed_Freigegeben tinyint(1) not null default 0,ed_Rabatt decimal(18,0) not null default 0,ed_VeranstalterBenachrichtigt tinyint(1) not null default 0,foreign key tbl_Events_tbl_EvDaten_FK1(et_EventID) references tbl_Events(et_EventID));
//
//	create table tbl_Buchungen(bu_BuchungsID int primary key auto_increment,kd_KundenID int not null,ed_EvDatenID int not null,bu_GebuchtePlaetze int not null,bu_Bezahlt tinyint(1) not null default 0,bu_Stoniert tinyint(1) not null default 0,bu_RechnungErstellt tinyint(1) not null default 0);
	
}
