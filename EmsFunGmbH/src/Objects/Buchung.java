package Objects;

public class Buchung 
{
	private int _buchungID;
	private int _kundenID;
	private int _eventDatenID;
	private int _gebuchtePlaetze;
	private boolean _bezahlt;
	private boolean _stoniert;
	private boolean _rechnungErstellt;
	
	public Buchung()
	{
	}
	
	public int getBuchungID() 
	{
		return _buchungID;
	}
	public void setBuchungID(int _buchungID) 
	{
		this._buchungID = _buchungID;
	}
	public int getKundenID() 
	{
		return _kundenID;
	}
	public void setKundenID(int _kundenID) 
	{
		this._kundenID = _kundenID;
	}
	public int getEventDatenID() 
	{
		return _eventDatenID;
	}
	public void setEventDatenID(int _eventDatenID) 
	{
		this._eventDatenID = _eventDatenID;
	}
	public int getGebuchtePlaetze() 
	{
		return _gebuchtePlaetze;
	}
	public void setGebuchtePlaetze(int _gebuchtePlaetze) 
	{
		this._gebuchtePlaetze = _gebuchtePlaetze;
	}
	public boolean isBezahlt() 
	{
		return _bezahlt;
	}
	public void setBezahlt(boolean _bezahlt) 
	{
		this._bezahlt = _bezahlt;
	}
	public boolean isStoniert() 
	{
		return _stoniert;
	}
	public void setStoniert(boolean _stoniert) 
	{
		this._stoniert = _stoniert;
	}
	public boolean isRechnungErstellt() 
	{
		return _rechnungErstellt;
	}
	public void setRechnungErstellt(boolean _rechnungErstellt) 
	{
		this._rechnungErstellt = _rechnungErstellt;
	}
}
