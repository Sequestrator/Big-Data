package cs473;
import org.mongodb.morphia.annotations.Id;

import java.util.ArrayList;
public class Traveler 
{
	@Id
	private int travelerId;
	String name;
	long milesFlown;
	ArrayList<String> flightHistory;
	
	public Traveler(int travelerId, String name)
	{
		this.travelerId		= travelerId;
		this.name			= name;
		this.milesFlown = 0;
		this.flightHistory = new ArrayList<String>();
	}
	public Traveler(int travelerId, String name, String reservationId, int dist) {
		this.travelerId		= travelerId;
		this.name			= name;
		this.milesFlown = dist;
		this.flightHistory = new ArrayList<String>();
		flightHistory.add(reservationId);
	}
	
	public int getTravelerId()
	{
		return travelerId;
	}
	public void setTravelerId(int travelerId)
	{
		this.travelerId = travelerId;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public void addReservation(String reservationId, int dist) {
		this.milesFlown += dist;
		this.flightHistory.add(reservationId);
	}
	public void cancelReservation(String reservationId, int dist) {
		this.milesFlown -= dist;
	}
}