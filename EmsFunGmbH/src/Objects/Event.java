package Objects;

public class Event 
{
	private int _eventID;
	private int _eventVeranstalterID;
	private int _eventKategorieID;
	private String _bezeichnung;
	private String _beschreibung;
	
	public int getEventID() 
	{
		return _eventID;
	}
	public void setEventID(int _eventID) 
	{
		this._eventID = _eventID;
	}
	public int getEventVeranstalterID() 
	{
		return _eventVeranstalterID;
	}
	public void setEventVeranstalterID(int _eventVeranstalterID) 
	{
		this._eventVeranstalterID = _eventVeranstalterID;
	}
	public int getEventKategorieID() 
	{
		return _eventKategorieID;
	}
	public void setEventKategorieID(int _eventKategorieID) 
	{
		this._eventKategorieID = _eventKategorieID;
	}
	public String getBezeichnung() 
	{
		return _bezeichnung;
	}
	public void setBezeichnung(String _bezeichnung) 
	{
		this._bezeichnung = _bezeichnung;
	}
	public String getBeschreibung() 
	{
		return _beschreibung;
	}
	public void setBeschreibung(String _beschreibung) 
	{
		this._beschreibung = _beschreibung;
	}
}
