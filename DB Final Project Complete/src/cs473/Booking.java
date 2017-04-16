package cs473;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Embedded;

import java.util.Calendar;
//import java.sql.Time;
//import java.util.ArrayList;
import java.util.Date;
//import java.util.Calendar;
//import java.util.Date;

public class Booking {
	@Id
	String bookingId;
	@Embedded
	Flight flight;
	Date date;
	int reservationsMade;
	int openSeats;
	
	
	public Booking(Flight Flight, Date date_) 
	{
		this.flight = Flight;
		Calendar c = Calendar.getInstance();
		c.setTime(date_);
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		//this.flight = dayOfWeek;
		this.bookingId = Flight.flightCode + date_;
		this.reservationsMade = 1;
		this.openSeats = Flight.planeObj.seats - 1;
	}
	
	public void addReservation() {
		this.reservationsMade++;
		this.openSeats--;
	}
}
