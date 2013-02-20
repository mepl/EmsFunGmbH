package Datenbank;

import java.sql.*;
import java.util.ArrayList;
import Objects.*;

public class DataAccess {
	// ///////////////// Variablen ///////////////////

	private static StringBuilder builder;
	private static String sDbDrv = "com.mysql.jdbc.Driver";
	private static String sDbUrl = "jdbc:mysql://localhost:3306/kundenbuchungssystem";
	private static String sUsr = "root";
	private static String sPwd = "";

	// ///////////////// Interfaces ///////////////////

	private interface SQLReader 
	{
		Object read(ResultSet res);
	}

	// ///////////////// Methods ///////////////////

	private static void sendSQL(String command) 
	{
		Connection connection = null;
		Statement statement = null;

		try {
			Class.forName(sDbDrv);
			connection = DriverManager.getConnection(sDbUrl, sUsr, sPwd);
			statement = connection.createStatement();
			statement.executeUpdate(command);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null && !connection.isClosed())
					connection.close();
				if (statement != null && !statement.isClosed())
					statement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private static Object readSQL(SQLReader reader,String command) 
	{
		Connection connection = null;
		Statement statement = null;
		ResultSet result = null;
		Object obj = null;

		try {
			Class.forName(sDbDrv);
			connection = DriverManager.getConnection(sDbUrl, sUsr, sPwd);
			statement = connection.createStatement();
			result = statement.executeQuery(command);
			obj = reader.read(result);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null && !connection.isClosed())
					connection.close();
				if (statement != null && !statement.isClosed())
					statement.close();
				if (result != null && !result.isClosed())
					result.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return obj;
	}

	// ///////////////// KUNDEN ///////////////////

	public static ArrayList<Kunde> getAllKunden() 
	{
		Object obj = readSQL(new SQLReader() {
			public Object read(ResultSet res) {
				try 
				{
					ArrayList<Kunde> kundeList = new ArrayList<Kunde>();
					Kunde kunde = null;
					
					while (res.next()) {
						
						kunde = new Kunde();

						kunde.setKundenID(res.getInt("kd_KundenID"));
						kunde.setName(res.getString("kd_Name"));
						kunde.setVorname(res.getString("kd_Vorname"));
						kunde.setStrasse(res.getString("kd_Strasse"));
						kunde.setHausNummer(res.getString("kd_HNummer"));
						kunde.setPlz(res.getString("kd_PLZ"));
						kunde.setOrt(res.getString("kd_Ort"));
						kunde.setTelefon(res.getString("kd_Telefon"));
						kunde.setEmail(res.getString("kd_EMail"));

						kundeList.add(kunde);
					}

					return kundeList;
				} 
				catch (Exception ex)
				{
					ex.printStackTrace();
					return null;
				}
			}
		},"select * from tbl_Kunden;");
		
		return (ArrayList<Kunde>) obj;
	}

	public static void updateKunden(Kunde kunde) 
	{
		builder = new StringBuilder();
		builder.append("update tbl_Kunden set kd_Name = '");
		builder.append(kunde.getName());
		builder.append("',kd_Vorname ='");
		builder.append(kunde.getVorname());
		builder.append("',kd_Strasse ='");
		builder.append(kunde.getStrasse());
		builder.append("',kd_HNummer ='");
		builder.append(kunde.getHausNummer());
		builder.append("',kd_PLZ ='");
		builder.append(kunde.getPlz());
		builder.append("',kd_Ort ='");
		builder.append(kunde.getOrt());
		builder.append("',kd_Telefon ='");
		builder.append(kunde.getTelefon());
		builder.append("',kd_EMail ='");
		builder.append(kunde.getEmail());
		builder.append("' WHERE kd_KundenID = '");
		builder.append(kunde.getKundenID());
		builder.append("';");

		sendSQL(builder.toString());
	}

	public static void insertKunden(Kunde kunde) {
		builder = new StringBuilder();
		builder.append("insert into tbl_kunden(kd_Name, kd_Vorname, kd_Strasse, kd_HNummer, kd_PLZ, kd_Ort, kd_Telefon, kd_EMail) VALUES ('");
		builder.append(kunde.getName());
		builder.append("','");
		builder.append(kunde.getVorname());
		builder.append("','");
		builder.append(kunde.getStrasse());
		builder.append("','");
		builder.append(kunde.getHausNummer());
		builder.append("','");
		builder.append(kunde.getPlz());
		builder.append("','");
		builder.append(kunde.getOrt());
		builder.append("','");
		builder.append(kunde.getTelefon());
		builder.append("','");
		builder.append(kunde.getEmail());
		builder.append("');");

		sendSQL(builder.toString());
	}

	public static void deleteKunden(Kunde kunde) {
		builder = new StringBuilder();
		builder.append("DELETE FROM tbl_Kunden where kd_KundenID =");
		builder.append(kunde.getKundenID());
		builder.append(";");

		sendSQL(builder.toString());
	}

	// ///////////////// EventVeranstalter ///////////////////

	public static ArrayList<EventVeranstalter> getAllVeranstalter() {

		Object obj = readSQL(new SQLReader() {
			public Object read(ResultSet res) {
				try 
				{
					ArrayList<EventVeranstalter> veranstalterList = new ArrayList<EventVeranstalter>();
					EventVeranstalter veranstalter = null;
					
					while (res.next()) {
						
						veranstalter = new EventVeranstalter();

						veranstalter.setEventVeranstalterID(res.getInt("ev_EvVeranstalterID"));
						veranstalter.setFirma(res.getString("ev_Firma"));
						veranstalter.setStrasse(res.getString("ev_Strasse"));
						veranstalter.setHausNummer(res.getString("ev_HNummer"));
						veranstalter.setPlz(res.getString("ev_PLZ"));
						veranstalter.setOrt(res.getString("ev_Ort"));
						veranstalter.setTelefon(res.getString("ev_Telefon"));
						veranstalter.setEmail(res.getString("ev_EMail"));

						veranstalterList.add(veranstalter);
					}

					return veranstalterList;
				} 
				catch (Exception ex)
				{
					ex.printStackTrace();
					return null;
				}
			}
		},"select * from tbl_EvVeranstalter;");
		
		return (ArrayList<EventVeranstalter>) obj;
	}

	public static void updateEventVeranstalter(EventVeranstalter veranstalter) {
		builder = new StringBuilder();
		builder.append("update tbl_EvVeranstalter set ev_Firma = '");
		builder.append(veranstalter.getFirma());
		builder.append("', ev_Strasse = '");
		builder.append(veranstalter.getStrasse());
		builder.append("', ev_PLZ = '");
		builder.append(veranstalter.getPlz());
		builder.append("', ev_HNummer = '");
		builder.append(veranstalter.getHausNummer());
		builder.append("', ev_Ort ='");
		builder.append(veranstalter.getOrt());
		builder.append("', ev_Telefon ='");
		builder.append(veranstalter.getTelefon());
		builder.append("', ev_EMail = '");
		builder.append(veranstalter.getEmail());
		builder.append("', ev_Fax = '");
		builder.append(veranstalter.getFax());
		builder.append("' WHERE ev_EvVeranstalterID = ");
		builder.append(veranstalter.getEventVeranstalterID());
		builder.append(";");

		sendSQL(builder.toString());
	}

	public static void insertEventVeranstalter(EventVeranstalter veranstalter) {
		builder = new StringBuilder();
		builder.append("insert into tbl_EvVeranstalter(ev_Firma, ev_Strasse, ev_PLZ, ev_HNummer, ev_Ort, ev_Telefon, ev_EMail, ev_Fax) VALUES ('");
		builder.append(veranstalter.getFirma());
		builder.append("','");
		builder.append(veranstalter.getStrasse());
		builder.append("','");
		builder.append(veranstalter.getPlz());
		builder.append("','");
		builder.append(veranstalter.getHausNummer());
		builder.append("','");
		builder.append(veranstalter.getOrt());
		builder.append("','");
		builder.append(veranstalter.getTelefon());
		builder.append("','");
		builder.append(veranstalter.getEmail());
		builder.append("','");
		builder.append(veranstalter.getFax());
		builder.append("');");

		sendSQL(builder.toString());
	}

	public static void deleteEventVeranstalter(EventVeranstalter veranstalter) {
		builder = new StringBuilder();
		builder.append("DELETE FROM tbl_EvVeranstalter where ev_EvVeranstalterID =");
		builder.append(veranstalter.getEventVeranstalterID());
		builder.append(";");

		sendSQL(builder.toString());
	}

	// ///////////////// EventKategorie ///////////////////

	public static ArrayList<EventKategorie> getAllKategorie() {
		
		Object obj = readSQL(new SQLReader() {
			public Object read(ResultSet res) {
				try 
				{
					ArrayList<EventKategorie> kategorieList = new ArrayList<EventKategorie>();
					EventKategorie kategorie = null;
					
					while (res.next()) {
						
						kategorie = new EventKategorie();

						kategorie.setEventKategorieID(res.getInt("ek_EvKategorieID"));
						kategorie.setBezeichnung(res.getString("ek_KatBezeichnung"));

						kategorieList.add(kategorie);
					}

					return kategorieList;
				} 
				catch (Exception ex)
				{
					ex.printStackTrace();
					return null;
				}
			}
		},"select * from tbl_EvKategorie;");
		
		return (ArrayList<EventKategorie>) obj;
	}

	public static void updateKategorie(EventKategorie kategorie) {
		builder = new StringBuilder();
		builder.append("update tbl_EvKategorie set ek_KatBezeichnung = '");
		builder.append(kategorie.getBezeichnung());
		builder.append("';");

		sendSQL(builder.toString());
	}

	public static void insertKategorie(EventKategorie kategorie) {
		builder = new StringBuilder();
		builder.append("insert into tbl_EvKategorie(ek_KatBezeichnung) VALUES ('");
		builder.append(kategorie.getBezeichnung());
		builder.append("');");

		sendSQL(builder.toString());
	}

	public static void deleteKategorie(EventKategorie kategorie) 
	{
		builder = new StringBuilder();
		builder.append("delete from tbl_EvKategorie where ek_EvKategorieID = ");
		builder.append(kategorie.getEventKategorieID());
		builder.append(";");

		sendSQL(builder.toString());
	}

	// ///////////////// Events ///////////////////

	public static ArrayList<Event> getAllEvents() {
		Object obj = readSQL(new SQLReader() {
			public Object read(ResultSet res) {
				try {

					ArrayList<Event> eventList = new ArrayList<Event>();
					Event event= null;
					while (res.next()) {
						event = new Event();

						event.setEventID(res.getInt("et_EventID"));
						event.setEventVeranstalterID(res.getInt("ev_EvVeranstalterID"));
						event.setEventKategorieID(res.getInt("ek_EvKategorieID"));
						event.setBezeichnung(res.getString("et_Bezeichnung"));
						event.setBeschreibung(res.getString("et_Beschreibung"));

						eventList.add(event);
					}

					return eventList;
				} 
				catch (Exception ex)
				{
					ex.printStackTrace();
					return null;
				}
			}
		},"select * from tbl_Events");

		return (ArrayList<Event>) obj;
	}

	public static void updateEvents(Event event) {
		
		builder = new StringBuilder();
		builder.append("update tbl_Events set ev_EvVeranstalterID = ");
		builder.append(event.getEventVeranstalterID());
		builder.append(", ek_EvKategorieID = ");
		builder.append(event.getEventKategorieID());
		builder.append(", et_Bezeichnung = '");
		builder.append(event.getBezeichnung());
		builder.append("', et_Beschreibung = '");
		builder.append(event.getBeschreibung());
		builder.append("' WHERE et_EventID = ;");
		builder.append(event.getEventID());
		builder.append(";");

		sendSQL(builder.toString());
	}

	public static void insertEvents(Event event) {
		
		builder = new StringBuilder();
		builder.append("insert into tbl_Events(ev_EvVeranstalterID,ek_EvKategorieID,et_Bezeichnung,et_Beschreibung) VALUES (");
		builder.append(event.getEventVeranstalterID());
		builder.append(",");
		builder.append(event.getEventKategorieID());
		builder.append(",'");
		builder.append(event.getBezeichnung());
		builder.append("','");
		builder.append(event.getBeschreibung());
		builder.append("');");

		sendSQL(builder.toString());
	}

	public static void deleteEvents(Event event) {
		
		builder = new StringBuilder();
		builder.append("delte from tbl_Events where et_EventID = ");
		builder.append(event.getEventID());
		builder.append(";");

		sendSQL(builder.toString());
	}

	// ///////////////// EventDaten ///////////////////

	public static ArrayList<EventDaten> getAllEventDaten() {
		Object obj = readSQL(new SQLReader() {
			public Object read(ResultSet res) {
				try 
				{
					ArrayList<EventDaten> eventDatenList = new ArrayList<EventDaten>();
					EventDaten daten = null;
					
					while (res.next()) {
						daten = new EventDaten();
						
						daten.setAktTeilnehmer(res.getInt("ed_AktTeilnehmer"));
						daten.setBeginn(res.getDate("ed_Beginn"));
						daten.setEnde(res.getDate("ed_Ende"));
						daten.setEventDatenID(res.getString("ed_EvDatenID"));
						daten.setEventID(res.getInt("et_EventID"));
						daten.setFreigegeben(res.getBoolean("ed_Freigegeben"));
						daten.setMaxTeilnehmer(res.getInt("ed_MaxTeilnehmer"));
						daten.setPreis(res.getFloat("ed_Preis"));
						daten.setRabatt(res.getFloat("ed_Rabatt"));
						daten.setStartOrt(res.getString("ed_StartOrt"));
						daten.setVeranstalterBenachricht(res.getBoolean("ed_VeranstalterBenachrichtigt"));
						daten.setZielOrt(res.getString("ed_ZielOrt"));
						
						eventDatenList.add(daten);
					}
					
					return eventDatenList;
				} 
				catch (Exception ex)
				{
					ex.printStackTrace();
					return null;
				}
			}
		},"select * from tbl_EventDaten");
		
		return (ArrayList<EventDaten>) obj;
	}

	public static void updateEventDaten(EventDaten daten) {
		
		builder = new StringBuilder();
		builder.append("update tbl_EventDaten set et_EventID = '");
		builder.append(daten.getEventID());
		builder.append("', ed_Preis = ");
		builder.append(daten.getPreis());
		builder.append(", ed_Beginn = '");
		builder.append(daten.getBeginn());
		builder.append("', ed_Ende = '");
		builder.append(daten.getEnde());
		builder.append("', ed_StartOrt = '");
		builder.append(daten.getStartOrt());
		builder.append("', ed_ZielOrt = '");
		builder.append(daten.getZielOrt());
		builder.append("', ed_MaxTeilnehmer = ");
		builder.append(daten.getMaxTeilnehmer());
		builder.append(", ed_AktTeilnehmer = ");
		builder.append(daten.getAktTeilnehmer());
		builder.append(", ed_Freigegeben = '");
		builder.append(daten.isFreigegeben());
		builder.append("', ed_Rabatt = ");
		builder.append(daten.getRabatt());
		builder.append(", ed_VeranstalterBenachrichtigt = '");
		builder.append(daten.isVeranstalterBenachricht());
		builder.append("' WHERE ed_EvDatenID =");
		builder.append(daten.getEventDatenID());
		builder.append(";");

		sendSQL(builder.toString());
	}

	public static void insertEventDaten(EventDaten daten) {
		
		builder = new StringBuilder();
		builder.append("insert into tbl_EventDaten (et_EventID,ed_Preis,ed_Beginn,ed_Ende,ed_StartOrt,ed_ZielOrt,ed_MaxTeilnehmer,ed_AktTeilnehmer,ed_Freigegeben,ed_Rabatt,ed_VeranstalterBenachrichtigt) VALUES(");
		builder.append(daten.getEventID());
		builder.append(",");
		builder.append(daten.getPreis());
		builder.append(",'");
		builder.append(daten.getBeginn());
		builder.append("','");
		builder.append(daten.getEnde());
		builder.append("','");
		builder.append(daten.getStartOrt());
		builder.append("','");
		builder.append(daten.getZielOrt());
		builder.append("',");
		builder.append(daten.getMaxTeilnehmer());
		builder.append(",");
		builder.append(daten.getAktTeilnehmer());
		builder.append(",'");
		builder.append(daten.isFreigegeben());
		builder.append("',");
		builder.append(daten.getRabatt());
		builder.append(",'");
		builder.append(daten.isVeranstalterBenachricht());
		builder.append("');");

		sendSQL(builder.toString());
	}

	public static void deleteEventDaten(EventDaten daten) {
		
		builder = new StringBuilder();
		builder.append("delete from tbl_EventDaten where ed_EvDatenID = ");
		builder.append(daten.getEventDatenID());
		builder.append(";");

		sendSQL(builder.toString());
	}

	// ///////////////// Buchung ///////////////////

	public static ArrayList<Buchung> getAllBuchung() {
		
		Object obj = readSQL(new SQLReader() {
			public Object read(ResultSet res) {
				try 
				{
					ArrayList<Buchung> buchungList = new ArrayList<Buchung>();
					Buchung buchung = null;
					
					while (res.next()) {
						buchung = new Buchung();
						
						buchung.setBezahlt(res.getBoolean("bu_Bezahlt"));
						buchung.setBuchungID(res.getInt("bu_BuchungsID"));
						buchung.setEventDatenID(res.getInt("ed_EvDatenID"));
						buchung.setGebuchtePlaetze(res.getInt("bu_GebuchtePlaetze"));
						buchung.setKundenID(res.getInt("kd_KundenID"));
						buchung.setRechnungErstellt(res.getBoolean("bu_RechnungErstellt"));
						buchung.setStoniert(res.getBoolean("bu_Stoniert"));
						
						buchungList.add(buchung);
					}

					return buchungList;
				} 
				catch (Exception ex)
				{
					ex.printStackTrace();
					return null;
				}
			}
		},"select * from tbl_Buchungen");
		
		return (ArrayList<Buchung>) obj;
		
	}

	public static void updateBuchung(Buchung buchung) {
		
		builder = new StringBuilder();
		builder.append("update tbl_Buchungen set kd_KundenID = ");
		builder.append(buchung.getKundenID());
		builder.append(", ed_EvDatenID = ");
		builder.append(buchung.getEventDatenID());
		builder.append(", bu_GebuchtePlaetze = ");
		builder.append(buchung.getGebuchtePlaetze());
		builder.append(", bu_Bezahlt = '");
		builder.append(buchung.isBezahlt());
		builder.append("', bu_Stoniert = '");
		builder.append(buchung.isStoniert());
		builder.append("', bu_RechnungErstellt = '");
		builder.append(buchung.isRechnungErstellt());
		builder.append("' where bu_BuchungsID =");
		builder.append(buchung.getBuchungID());
		builder.append(";");

		sendSQL(builder.toString());
	}

	public static void insertBuchung(Buchung buchung) {
		
		builder = new StringBuilder();
		builder.append("insert into tbl_Buchungen(kd_KundenID,ed_EvDatenID,bu_GebuchtePlaetze,bu_Bezahlt,bu_Stoniert,bu_RechnungErstellt) VALUES(");
		builder.append(buchung.getKundenID());
		builder.append(",");
		builder.append(buchung.getEventDatenID());
		builder.append(",");
		builder.append(buchung.getGebuchtePlaetze());
		builder.append(",'");
		builder.append(buchung.isBezahlt());
		builder.append("','");
		builder.append(buchung.isStoniert());
		builder.append("','");
		builder.append(buchung.isRechnungErstellt());
		builder.append("');");

		sendSQL(builder.toString());
	}

	public static void deleteBuchung(Buchung buchung) {
		
		builder = new StringBuilder();
		builder.append("delte from tbl_Buchungen where bu_BuchungsID = ");
		builder.append(buchung.getBuchungID());
		builder.append(";");

		sendSQL(builder.toString());
	}

}
