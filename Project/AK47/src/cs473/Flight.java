package cs473;
import org.mongodb.morphia.annotations.Id;
public class Flight 
{
	@Id
	private String airlineCode;
	private String flightCode;
	private int dayOfWeek;
	private String origAirportCode;
	private String destAirportCode;
	private String planeType;
	public Flight(String airlineCode, String flightCode, int dayOfWeek, String origAirportCode, String destAirportCode, String planeType)
	{
		this.airlineCode		= airlineCode;
		this.flightCode			= flightCode;
		this.dayOfWeek			= dayOfWeek;
		this.origAirportCode	= origAirportCode;
		this.destAirportCode	= destAirportCode;
		this.planeType			= planeType;
	}
	public String getAirlineCode(String airlineCode)
	{
		return airlineCode;
	}
	public void setAirlineCode(String airlineCode)
	{
		this.airlineCode = airlineCode;
	}
	public String getFlightCode(String flightCode)
	{
		return flightCode;
	}
	public void setFlightCode(String flightCode)
	{
		this.flightCode = flightCode;
	}
	public int getDayOfWeek(int dayOfWeek)
	{
		return dayOfWeek;
	}
	public void setDayOfWeek(int dayOfWeek)
	{
		this.dayOfWeek = dayOfWeek;
	}
	public String getOrigAirportCode(String origAirportCode)
	{
		return origAirportCode;
	}
	public void setOrigAirportCode(String origAirportCode)
	{
		this.origAirportCode = origAirportCode;
	}
	public String getDestAirportCode(String destAirportCode)
	{
		return destAirportCode;
	}
	public void setDestAirportCode(String destAirportCode)
	{
		this.destAirportCode = destAirportCode;
	}
	public String getPlaneType(String planeType)
	{
		return planeType;
	}
	public void setPlaneType(String planeType)
	{
		this.planeType= planeType;
	}
	
}
