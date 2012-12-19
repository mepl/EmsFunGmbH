package Datenbank;
import java.sql.*;
import java.util.ArrayList;
import Objects.*;

public class DataAccess 
{
	///////////////////   Variablen   ///////////////////
	
	private static StringBuilder builder;
	private static String sDbDrv = "com.mysql.jdbc.Driver";
	private static String sDbUrl = "jdbc:mysql://localhost:3306/eventmanagementsystem";
	private static String sUsr   = "root";
	private static String sPwd   = "";
//	private String stbl   = tbl;
//	private String sIdColName = idColName;
	private static String sSql;
	
	///////////////////   Methods   ///////////////////
	
	private static void sendSQL(String str)
	{
		Connection cn = null;
    	Statement  st = null;
    	ResultSet  rs = null;
    	
		try {
			Class.forName( sDbDrv );
		cn = DriverManager.getConnection( sDbUrl, sUsr, sPwd );
		st = cn.createStatement();
		rs = st.executeQuery( sSql );
		ResultSetMetaData rsmd = rs.getMetaData();
		int n = rsmd.getColumnCount();
		rs.next();
		cn.close();
		st.close();
		rs.close();
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	///////////////////   KUNDEN   ///////////////////
	
	public static ArrayList<Kunde> getAllKunden()
	{
		ArrayList<Kunde> kundeList = new ArrayList<Kunde>();
		
		
		
		return kundeList;
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
	
	public static void insertKunden(Kunde kunde)
	{
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

	public static void deleteKunden(Kunde kunde)
	{
		builder = new StringBuilder();
		builder.append("DELETE FROM tbl_Kunden where kd_KundenID =");
		builder.append(kunde.getKundenID());
		builder.append(";");
		
		sendSQL(builder.toString());
	}
	
	///////////////////   EventVeranstalter   ///////////////////
	
	public static ArrayList<EventVeranstalter> getAllVeranstalter()
	{
		ArrayList<EventVeranstalter> veranstalterList = new ArrayList<EventVeranstalter>();
		
		
		return veranstalterList;
	}
	
	public static void updateEventVeranstalter(EventVeranstalter veranstalter)
	{
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
	
	public static void insertEventVeranstalter(EventVeranstalter veranstalter)
	{
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
	
	public static void deleteEventVeranstalter(EventVeranstalter veranstalter)
	{
		builder = new StringBuilder();
		builder.append("DELETE FROM tbl_EvVeranstalter where ev_EvVeranstalterID =");
		builder.append(veranstalter.getEventVeranstalterID());
		builder.append(";");
		
		sendSQL(builder.toString());
	}
	
	///////////////////   EventKategorie   ///////////////////
	
	public static ArrayList<EventKategorie> getAllKategorie()
	{
		ArrayList<EventKategorie> kategorieList = new ArrayList<EventKategorie>();
		
		
		return kategorieList;
	}
	
	public static void updateKategorie(EventKategorie kategorie)
	{
		builder = new StringBuilder();
		builder.append("update tbl_EvKategorie set ek_KatBezeichnung = '");
		builder.append(kategorie.getBezeichnung());
		builder.append("';");
		
		sendSQL(builder.toString());
	}
	
	public static void insertKategorie(EventKategorie kategorie)
	{
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
	
	///////////////////   Events   ///////////////////
	
	public static ArrayList<Event> getAllEvents()
	{
		ArrayList<Event> eventList = new ArrayList<Event>();
		
		
		return eventList;
	}
	
	public static void updateEvents(Event event)
	{
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
	
	public static void insertEvents(Event event)
	{
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
	
	public static void deleteEvents(Event event)
	{
		builder = new StringBuilder();
		builder.append("delte from tbl_Events where et_EventID = ");
		builder.append(event.getEventID());
		builder.append(";");
		
		sendSQL(builder.toString());
	}
	
	///////////////////   EventDaten   ///////////////////
	
	public static ArrayList<EventDaten> getAllEventDaten()
	{
		ArrayList<EventDaten> eventDatenList = new ArrayList<EventDaten>();
		
		
		return eventDatenList;
	}
	
	public static void updateEventDaten(EventDaten daten)
	{
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
	
	public static void insertEventDaten(EventDaten daten)
	{
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
	
	public static void deleteEventDaten(EventDaten daten)
	{
		builder = new StringBuilder();
		builder.append("delete from tbl_EventDaten where ed_EvDatenID = ");
		builder.append(daten.getEventDatenID());
		builder.append(";");
		
		sendSQL(builder.toString());
	}
	
	///////////////////   Buchung   ///////////////////
	
	public static ArrayList<Buchung> getAllBuchung()
	{
		ArrayList<Buchung> buchungList = new ArrayList<Buchung>();
		
		
		return buchungList;
	}
	
	public static void updateBuchung(Buchung buchung)
	{
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
	
	public static void insertBuchung(Buchung buchung)
	{
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
	
	public static void deleteBuchung(Buchung buchung)
	{
		builder = new StringBuilder();
		builder.append("delte from tbl_Buchungen where bu_BuchungsID = ");
		builder.append(buchung.getBuchungID());
		builder.append(";");
		
		sendSQL(builder.toString());
	}

}
