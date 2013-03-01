package servlets;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Datenbank.DataAccess;
import Objects.Event;
import Objects.EventDaten;
import Objects.EventKategorie;

@WebServlet("/EventDatenServlet")
public class EventDatenServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public EventDatenServlet() 
    {
    }

    public String getEventDatenTable()
    {
    	StringBuilder builder = new StringBuilder();
    	ArrayList<EventDaten> events = DataAccess.getAllEventDaten();
    	EventDaten eventdaten = null;
    	
    	for(int i = 0; i < events.size();i++)
    	{
    		eventdaten = events.get(i);
    		builder.append("<tr><td>");
    		builder.append(eventdaten.getEventID());
        	builder.append("</td><td>");
    		builder.append(eventdaten.getPreis());
    		builder.append("</td><td>");
    		builder.append(eventdaten.getBeginn());
    		builder.append("</td><td>");
    		builder.append(eventdaten.getEnde());
    		builder.append("</td><td>");
    		builder.append(eventdaten.getStartOrt());
    		builder.append("</td><td>");
    		builder.append(eventdaten.getZielOrt());
    		builder.append("</td><td>");
    		builder.append(eventdaten.getMaxTeilnehmer());
    		builder.append("</td><td>");
    		builder.append(eventdaten.getAktTeilnehmer());
    		builder.append("</td><td>");
    		builder.append(eventdaten.isFreigegeben());
    		builder.append("</td><td>");
    		builder.append(eventdaten.getRabatt());
    		builder.append("</td><td>");
    		builder.append(eventdaten.isVeranstalterBenachricht());
    		builder.append("</td><td><input type=\"button\" value=\"Ändern\" id=\"editEvent" + i + "\"></td></tr>");
    	}
    	
    	return builder.toString();
    }
    
    public String getEvents()
    {
    	ArrayList<Event> eventList = DataAccess.getAllEvents();
    	StringBuilder builder = new StringBuilder();
    	
    	for(int i = 0; i < eventList.size(); i++)
    	{
    		builder.append("<option>");
    		builder.append(eventList.get(i).getEventID());
    		builder.append("</option>");
    	}
    	
    	return builder.toString();
    }
    
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
    	super.doPost(req, resp);
    	String strende = req.getParameter("ende");
    	String strbeginn = req.getParameter("beginn");
    	String strpreis = req.getParameter("preis");
    	String strmaxT = req.getParameter("mteilnehmer");
    	String straktT = req.getParameter("ateilnehmer");
    	String strrabatt = req.getParameter("rabatt");
    	String strfreigegeben = req.getParameter("frei");
    	String strvbenachrichtigt = req.getParameter("vbenachrichtigt");
    	
    	if(strende == null || strbeginn == null || strpreis== null || strmaxT == null || straktT == null || strrabatt == null)
    	{
    		// Success = false !!!
    		// Eingabe pflicht    resp.sendError(arg0)
    	}
    	// Prüfung auf Integer ..
    	
    	SimpleDateFormat sdf = new SimpleDateFormat("dd.mm.yy");
    	Date ende = null;
    	Date beginn = null;
    	int preis = 0;
    	int maxT = 0;
    	int aktT = 0;
    	int rabatt = 0;
    	int frei = 0;
    	int bena = 0;
		try {
			ende = new Date(sdf.parse(strende).getTime());
			beginn = new Date(sdf.parse(strbeginn).getTime());
			preis = Integer.parseInt(strpreis);
			maxT = Integer.parseInt(strmaxT);
			aktT = Integer.parseInt(straktT);
			rabatt = Integer.parseInt(strrabatt);
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	
    	EventDaten eventdaten = new EventDaten();
    	eventdaten.setPreis(preis);
    	eventdaten.setEnde(ende);
    	eventdaten.setBeginn(beginn);
    	eventdaten.setStartOrt(req.getParameter("sort"));
    	eventdaten.setZielOrt(req.getParameter("zort"));
    	eventdaten.setMaxTeilnehmer(maxT);
    	eventdaten.setAktTeilnehmer(aktT);
    	eventdaten.setFreigegeben(Integer.parseInt(req.getParameter("frei")));
    	eventdaten.setRabatt(rabatt);
    	eventdaten.setVeranstalterBenachricht(Integer.parseInt(req.getParameter("vbenachrichtigt")));
    	DataAccess.insertEventDaten(eventdaten);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
    	doPost(req, resp);
    }
}
