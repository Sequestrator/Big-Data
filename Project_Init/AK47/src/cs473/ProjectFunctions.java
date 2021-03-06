package cs473;

import org.mongodb.morphia.Datastore;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

// This is the class that you will need to modify in order to make our application work.
public class ProjectFunctions
{
    private final Datastore datastore;
    private final Map<String, Airline> airlines = new HashMap<>();
    private final Map<String, Airport> airports = new HashMap<>();
    private final Map<String, Plane> planes = new HashMap<>();
    private final Map<Integer, Traveler> travelers = new HashMap<>();
    private final Map<String, Flight> flights = new HashMap<>();
    private final Map<Integer, Reservation> reservations = new HashMap<>();
    
    public ProjectFunctions(Datastore datastore) 
    {
        this.datastore = datastore;
    }

    public void addAirline(String airlineCode, String name) 
    {
        System.out.println(String.format("Adding airline %s\t%s", airlineCode, name));

        // Here is an example of creating a mapping object and writing it to the database
        Airline airline = new Airline(airlineCode, name);
        datastore.save(airline);
        airlines.put(airlineCode, airline);
        // It is possible that you might not want to write the airline to a document but rather keep it around
        // to be used in other documents. Remember, we will be building denormalized documents so there won't
        // necessarily be a collection for every one of the entities that are being loaded. A map is a good way to do
        // this. We can still use an object to store the airline data, even if we don't write it to the database.
        //airlines.put(airlineCode, airline);
    }

    public void addAirport(String airportCode, String state, String city) 
    {
        System.out.println(String.format("Adding airport %s\t%s\t%s", airportCode, state, city));
        Airport airport = new Airport(airportCode, state, city);
        datastore.save(airport);
        airports.put(airportCode, airport);
        
    }

    public void addPlane(String planeType, int seats) 
    {
        System.out.println(String.format("Adding plane %s\t%d seats", planeType, seats));
        Plane plane = new Plane(planeType, seats);
        datastore.save(plane);
        planes.put(planeType, plane);
        
    }

    public void addFlight(String airlineCode, String flightCode, int dayOfWeek, String origAirportCode, String destAirportCode, String planeType) 
    {
        System.out.println(String.format("Adding flight %s\tfrom %s to %s on %d\tplane %s", flightCode, origAirportCode, destAirportCode, dayOfWeek, planeType));
        Flight flight = new Flight(airlineCode, flightCode, dayOfWeek, origAirportCode, destAirportCode, planeType);
        datastore.save(flight);
        flights.put(airlineCode, flight);
        //Flight Flighter = flights.get(airlineCode);
        
        // If you are denormalizing airline then to add a flight you will have to go get the airline data from the map
        // you are using to store airline information while you are loading the data. To do this use the following
        // code.
    }

    public void addTraveler(int travelerId, String name) 
    {
        System.out.println(String.format("Adding traveller %d\t%s", travelerId, name));
        Traveler traveler = new Traveler(travelerId, name);
        datastore.save(traveler);
        travelers.put(travelerId, traveler);
    }

    public void makeReservation(int reservationId, int travelerId, String flightCode, int dayOfWeek, Date date) 
    {
        System.out.println(String.format("Making reservation %d for traveller %d on flight %s for the date %s", reservationId, travelerId, flightCode, date.toString()));
        Reservation reservation = new Reservation(reservationId, travelerId, flightCode, dayOfWeek, date);
        datastore.save(reservation);
        reservations.put(reservationId, reservation);
        
    }
}
