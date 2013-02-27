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

@WebServlet("/EventKategorieServlet")
public class EventKategorieServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public EventKategorieServlet() 
    {
    }

    public String getEventKategorieTable()
    {
    	StringBuilder builder = new StringBuilder();
    	ArrayList<EventKategorie> kategorien = DataAccess.getAllKategorie();
    	EventKategorie kategorie = null;
    	
    	for(int i = 0; i < kategorien.size();i++)
    	{
    		kategorie = kategorien.get(i);
        	builder.append("<tr>");
    		builder.append("<td>");
    		builder.append(kategorie.getBezeichnung());
    		builder.append("</td>");
    		builder.append("<td><input type=\"button\" value=\"Ändern\" id=\"editEvent" + i + "\"></td>");
        	builder.append("</tr>");
    	}
    	
    	return builder.toString();
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
    	super.doPost(req, resp);
    	
    	EventKategorie eventkategorie = new EventKategorie();
    	eventkategorie.setBezeichnung(req.getParameter("kbez"));
    	DataAccess.insertKategorie(eventkategorie);
    }
    
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
    	doPost(req, resp);
    }

}
