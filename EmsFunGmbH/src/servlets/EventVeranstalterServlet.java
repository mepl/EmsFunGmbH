package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Datenbank.DataAccess;
import Objects.Event;
import Objects.EventKategorie;
import Objects.EventVeranstalter;

@WebServlet("/EventVeranstalterServlet")
public class EventVeranstalterServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public EventVeranstalterServlet() 
    {
    }

    public String getEventVeranstalterTable()
    {
    	StringBuilder builder = new StringBuilder();
    	ArrayList<EventVeranstalter> veranstaltungen = DataAccess.getAllVeranstalter();
    	EventVeranstalter eventVeranstalter = null;
    	
    	for(int i = 0; i < veranstaltungen.size();i++)
    	{
    		eventVeranstalter = veranstaltungen.get(i);
        	builder.append("<tr>");
    		builder.append("<td>");
    		builder.append(eventVeranstalter.getFirma());
    		builder.append("</td><td>");
    		builder.append(eventVeranstalter.getStrasse());
    		builder.append("</td><td>");
    		builder.append(eventVeranstalter.getPlz());
    		builder.append("</td><td>");
    		builder.append(eventVeranstalter.getHausNummer());
    		builder.append("</td><td>");
    		builder.append(eventVeranstalter.getOrt());
    		builder.append("</td><td>");    		
    		builder.append(eventVeranstalter.getTelefon());
    		builder.append("</td><td>");
    		builder.append(eventVeranstalter.getEmail());
    		builder.append("</td><td>");
    		builder.append(eventVeranstalter.getFax());
    		builder.append("</td>");
    		builder.append("<td><input type=\"button\" value=\"Ändern\" id=\"editEvent" + i + "\"></td>");
        	builder.append("</tr>");
    	}
    	
    	return builder.toString();
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
    	super.doPost(req, resp);
    	
    	EventVeranstalter eventVeranstalter = new EventVeranstalter();
    	eventVeranstalter.setFirma(req.getParameter("firma"));
    	eventVeranstalter.setStrasse(req.getParameter("strasse"));
    	eventVeranstalter.setPlz(req.getParameter("plz"));
    	eventVeranstalter.setHausNummer(req.getParameter("hnummer"));
    	eventVeranstalter.setOrt(req.getParameter("ort"));
    	eventVeranstalter.setTelefon(req.getParameter("tel"));
    	eventVeranstalter.setEmail(req.getParameter("mail"));
    	eventVeranstalter.setFax(req.getParameter("fax"));
    	DataAccess.insertEventVeranstalter(eventVeranstalter);
    }
    
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
    	doPost(req, resp);
    }    
}
