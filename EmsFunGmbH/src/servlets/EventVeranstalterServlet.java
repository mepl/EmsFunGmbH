package servlets;

import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import Datenbank.DataAccess;
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
}
