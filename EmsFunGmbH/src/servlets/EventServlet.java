package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;
import org.apache.jasper.tagplugins.jstl.core.Url;

import Datenbank.DataAccess;
import Objects.Event;
import Objects.EventDaten;
import Objects.EventKategorie;
import Objects.EventVeranstalter;

@WebServlet("/EventServlet")
public class EventServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
    public EventServlet() 
    {
    }
    
    public String getEventTable()
    {
    	StringBuilder builder = new StringBuilder();
    	ArrayList<Event> events = DataAccess.getAllEvents();
    	Event event = null;
    	
    	for(int i = 0; i < events.size();i++)
    	{
    		event = events.get(i);
        	builder.append("<tr><td>");
        	builder.append(event.getEventVeranstalterID());
    		builder.append("</td><td>");
    		builder.append(event.getEventKategorieID());
    		builder.append("</td><td>");
    		builder.append(event.getBezeichnung());
    		builder.append("</td><td>");
    		builder.append(event.getBeschreibung());
    		builder.append("</td><td><input type=\"button\" value=\"Ändern\" id=\"editEvent\"></td></tr>");
    	}
    	
    	return builder.toString();
    }
    
    public String getEventKategorie()
    {
    	ArrayList<EventKategorie> verList = DataAccess.getAllKategorie();
    	StringBuilder builder = new StringBuilder();
    	
    	for(int i = 0; i < verList.size(); i++)
    	{
    		builder.append("<option>");
    		builder.append(verList.get(i).getEventKategorieID());
    		builder.append("</option>");
    	}
    	
    	return builder.toString();
    }
    
    public String getEventVeranstalter()
    {
    	ArrayList<EventVeranstalter> verList = DataAccess.getAllVeranstalter();
    	StringBuilder builder = new StringBuilder();
    	
    	for(int i = 0; i < verList.size(); i++)
    	{
    		builder.append("<option>");
    		builder.append(verList.get(i).getEventVeranstalterID());
    		builder.append("</option>");
    	}
    	
    	return builder.toString();
    }
    
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
    	super.doPost(req, resp);
    	
    	Event event = new Event();
    	event.setBezeichnung(req.getParameter("bez"));
    	event.setBeschreibung(req.getParameter("bes"));
    	event.setEventKategorieID(Integer.parseInt(req.getParameter("kat")));
    	event.setEventVeranstalterID(Integer.parseInt(req.getParameter("ver")));
    	DataAccess.insertEvents(event);
//    	req.setAttribute("data", "index.jsp");
//    	RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
//    	rd.forward(req, resp);
    }
    
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
    	doPost(req, resp);
    }
}
