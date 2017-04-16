package cs473;
import org.mongodb.morphia.annotations.Id;
public class Plane 
{
	@Id
	private String planeType;
	int seats;
	public Plane(String planeType, int seats)
	{
		this.planeType		= planeType;
		this.seats			= seats;
	}
	public String getplaneType(String planeType)
	{
		return planeType;
	}
	public void setplaneType(String planeType)
	{
		this.planeType = planeType;
	}
	public int getSeats(int seats)
	{
		return seats;
	}
	public void setSeats(int seats)
	{
		this.seats = seats;
	}
	
	
}