package Objects;

import java.sql.Date;

public class EventDaten
{
	private String _eventDatenID;
	private int _eventID;
	private float _preis;
	private Date _beginn;
	private Date _ende;
	private String _startOrt;
	private String _zielOrt;
	private int _maxTeilnehmer;
	private int _aktTeilnehmer;
	private int _freigegeben;
	private float _rabatt;
	private int _veranstalterBenachricht;
	
	public String getEventDatenID() 
	{
		return _eventDatenID;
	}
	public void setEventDatenID(String _eventDatenID) 
	{
		this._eventDatenID = _eventDatenID;
	}
	public int getEventID() 
	{
		return _eventID;
	}
	public void setEventID(int _eventID) 
	{
		this._eventID = _eventID;
	}
	public float getPreis() 
	{
		return _preis;
	}
	public void setPreis(float _preis) 
	{
		this._preis = _preis;
	}
	public Date getBeginn() 
	{
		return _beginn;
	}
	public void setBeginn(Date _beginn) 
	{
		this._beginn = _beginn;
	}
	public Date getEnde() 
	{
		return _ende;
	}
	public void setEnde(Date _ende) 
	{
		this._ende = _ende;
	}
	public String getStartOrt() 
	{
		return _startOrt;
	}
	public void setStartOrt(String _startOrt) 
	{
		this._startOrt = _startOrt;
	}
	public String getZielOrt() 
	{
		return _zielOrt;
	}
	public void setZielOrt(String _zielOrt) 
	{
		this._zielOrt = _zielOrt;
	}
	public int getMaxTeilnehmer() 
	{
		return _maxTeilnehmer;
	}
	public void setMaxTeilnehmer(int _maxTeilnehmer) 
	{
		this._maxTeilnehmer = _maxTeilnehmer;
	}
	public int getAktTeilnehmer() 
	{
		return _aktTeilnehmer;
	}
	public void setAktTeilnehmer(int _aktTeilnehmer) 
	{
		this._aktTeilnehmer = _aktTeilnehmer;
	}
	public int isFreigegeben() 
	{
		return _freigegeben;
	}
	public void setFreigegeben(int _freigegeben) 
	{
		this._freigegeben = _freigegeben;
	}
	public float getRabatt() 
	{
		return _rabatt;
	}
	public void setRabatt(float _rabatt) 
	{
		this._rabatt = _rabatt;
	}
	public int isVeranstalterBenachricht() 
	{
		return _veranstalterBenachricht;
	}
	public void setVeranstalterBenachricht(int _veranstalterBenachricht) 
	{
		this._veranstalterBenachricht = _veranstalterBenachricht;
	}
	
}
