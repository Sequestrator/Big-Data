package cs473;
import org.mongodb.morphia.annotations.Id;
public class Airport 
{
	@Id
	private String airportCode;
	private String state;
	private String city;
	public Airport(String airportCode, String state, String city)
	{
		this.airportCode	= airportCode;
		this.state			= state;
		this.city			= city;
	}
	public String getAirportCode(String airportCode)
	{
		return airportCode;
	}
	public void setAirportCode(String airportCode)
	{
		this.airportCode = airportCode;
	}
	public String getState(String state)
	{
		return state;
	}
	public void setState(String state)
	{
		this.state = state;
	}
	public String getCity(String city)
	{
		return city;
	}
	public void setCity(String city)
	{
		this.city = city;
	}
}
