package cs473;
import org.mongodb.morphia.annotations.Id;
public class Traveler 
{
	@Id
	private int travelerId;
	private String name;
	public Traveler(int travelerId, String name)
	{
		this.travelerId		= travelerId;
		this.name			= name;
	}
	public int getTravelerId(int travelerId)
	{
		return travelerId;
	}
	public void setTravelerId(int travelerId)
	{
		this.travelerId = travelerId;
	}
	public String getName(String name)
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
}
