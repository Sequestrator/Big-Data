package cs473;
import org.mongodb.morphia.annotations.Id;

import java.util.Date;

public class Reservation 
{
	@Id
	private int reservationId; 
	private int travelerId;
	private String flightCode;
	private int dayOfWeek;
	private Date date;
	public Reservation(int reservationId, int travelerId, String flightCode, int dayOfWeek, Date date)
	{
		this.reservationId		= reservationId;
		this.travelerId			= travelerId;
		this.flightCode			= flightCode;
		this.dayOfWeek			= dayOfWeek;
		this.date				= date;
	}
	public int getReservationId(int reservationId)
	{
		return reservationId;
	}
	public void setReservationId(int reservationId)
	{
		this.reservationId = reservationId;
	}
	public int getTravelerId(int travelerId)
	{
		return travelerId;
	}
	public void setTravelerId(int travelerId)
	{
		this.travelerId = travelerId;
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
	public Date getDate(Date date)
	{
		return date;
	}
	public void setDate(Date date)
	{
		this.date = date;
	}
}
