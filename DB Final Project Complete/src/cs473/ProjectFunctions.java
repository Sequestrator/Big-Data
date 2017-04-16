package cs473;

import org.mongodb.morphia.Datastore;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

// This is the class that you will need to modify in order to make our application work.
public class ProjectFunctions 
{
    private final Datastore datastore;
    public final Map<String, Airline> airlines = new HashMap<>();
    public final Map<String, Airport> airports = new HashMap<>();
    public final Map<String, Plane> planes = new HashMap<>();
    public final Map<String, Flight> flights = new HashMap<>();
    public final Map<Integer, Traveler> travelers = new HashMap<>();
    public final Map<Integer, Reservation> reservations = new HashMap<>();
    public final Map<String, Booking> bookings = new HashMap<>();


    public ProjectFunctions(Datastore datastore) 
    {
        this.datastore = datastore;
    }

    public void addAirline(String airlineCode, String name) 
    {
        System.out.println(String.format("Adding airline %s\t%s", airlineCode, name));
        Airline thisAirline = new Airline(airlineCode, name);
        airlines.put(airlineCode, thisAirline);
    }

    public void addAirport(String airportCode, String state, String city) {
        System.out.println(String.format("Adding airport %s\t%s\t%s", airportCode, state, city));

        Airport thisAirport = new Airport(airportCode, city, state);
        airports.put(airportCode, thisAirport);
        datastore.save(thisAirport);
    }

    public void addPlane(String planeType, int seats) {
        System.out.println(String.format("Adding plane %s\t%d seats", planeType, seats));
        Plane thisPlane = new Plane(planeType, seats);
        planes.put(planeType, thisPlane);
    }
    //public void addFlight(String flightCode, String originAirportCode, String destAirportCode, String airlineCode, String planeType, int dist) {

    public void addFlight(String airlineCode, String flightCode, int day, String originAirportCode, String destAirportCode, String planeType, int dist_) {
        System.out.println(String.format("Adding flight %s\tfrom %s to %s on %d\tplane %s", flightCode, originAirportCode, destAirportCode, planeType));
    	Flight thisFlight = flights.get(flightCode);
    	if(thisFlight != null) 
    	{
    		
    		Airport originAirportObj = airports.get(originAirportCode);
            Airport destAirportObj = airports.get(destAirportCode);
            Airline airlineObj = airlines.get(airlineCode);
            Flight distance = flights.get(dist_);
            Plane planeObj = planes.get(planeType);
            System.out.println(String.format("Adding flight %s\tfrom %s to %s on %d\tplane %s", flightCode, originAirportCode, destAirportCode, day,planeType, dist_));
            //distance located here
            thisFlight = new Flight(flightCode, day, originAirportObj, destAirportObj, airlineCode, planeObj, dist_);
            flights.put(flightCode, thisFlight);
    	}
            
    	else 
    	{
    		System.out.println(String.format("Updating flight %s",flightCode));
    		System.out.println("available on day %" + day);
    		thisFlight.addDay(day);
    		flights.put(flightCode, thisFlight);
    	}
    	
        datastore.save(thisFlight);
    }

    public void addTraveler(int travelerId, String name) {
        System.out.println(String.format("Adding traveller %d\t%s", travelerId, name));
    	Date temp = new Date("2017-16-04 12:32:16.000");
        Traveler thisTraveler = new Traveler(travelerId, name);
        datastore.save(thisTraveler);
        travelers.put(travelerId, thisTraveler);
    }
    
    public void makeReservation(int reservationId, int travelerId, String flightCode, int dayOfWeek, Date date) {
        System.out.println(String.format("Making reservation %d for traveller %d on flight %s for the date %s", reservationId, travelerId, flightCode, date.toString()));
        
        Flight thisFlight = flights.get(flightCode);
        Traveler travelerObj = travelers.get(travelerId);
        travelerObj.milesFlown += thisFlight.dist;
        travelerObj.flightHistory.add(flightCode+date);
        travelers.put(travelerId, travelerObj);
        datastore.save(travelerObj);
        
        Booking bookingObj = bookings.get(flightCode+date);
        Reservation thisReserve = new Reservation(reservationId, flightCode, dayOfWeek, date, travelerId);
        
        reservations.put(reservationId, thisReserve);
        datastore.save(thisReserve);
        
        
        if(bookingObj != null) 
        {
            Flight flightObj = flights.get(flightCode);
        	bookingObj = new Booking(flightObj,date);
        	bookings.put(flightCode+date, bookingObj);
        	datastore.save(bookingObj);
        }
        else 
        {
        	bookingObj.addReservation();
        	bookings.put(flightCode+date, bookingObj);
        	datastore.save(bookingObj);
        }
    }
}