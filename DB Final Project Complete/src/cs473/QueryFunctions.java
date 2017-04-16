package cs473;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.MapReduceOptions;
import org.mongodb.morphia.aggregation.AggregationPipeline;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.query.Criteria;
import org.mongodb.morphia.query.Query;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.DBObjectCodec;
import com.mongodb.MapReduceCommand;

import java.util.*;

/*
 * Queries That Need to Be Executed
 * 1. What flights have availability between any 2 given cities in a certain date range
 * 2. What flights are overbooked either by a destination city or an arrival city in a certain
date range.
 * 3. What city has the highest demand (demand is the percentage of possible seats
originating in a city that are sold) in a given date range or on a given day of week
 * 4. Conversely what city has the lowest demand. (demand is the percentage of possible seats
originating in a city that are sold) in a given date range or on a given day of week
 * 5. What destination city has the most available inbound seats in a given date range.
 * 6. List by airline and day of week, how many total miles are flown by that airline
 * 7. What is the average number of flights and miles flown by all travelers, by the top n
travelers, by the top n% travelers. For the later two, what is the percentage of total flights and total miles that these travelers represent.
 */

public class QueryFunctions 
{	@Embedded
    Datastore datastore;
	@Embedded
    String originAirportCode;
	@Embedded
    String destAirportCode;
	@Embedded
    Date date;
	@Embedded
    Plane plane;
	@Embedded
	Traveler travelerObj;
	@Embedded
	int openSeats;
	@Embedded
	int seats;
	@Embedded
	int day;
	@Embedded
	int dist_;
	@Embedded
	int milesFlown;
	@Embedded
	String travelerId;
	@Embedded
	String bookingId;
	public final Map<String, Flight> flights = new HashMap<>();
    public final Map<Integer, Reservation> reservations = new HashMap<>();
    public final Map<Integer, Traveler> travelers = new HashMap<>();

    
    public QueryFunctions(Datastore datastore)
    {
        this.datastore = datastore;
    }
    // query.filter("price").greaterThanOrEq(1000);
    /*
     * datastore.createQuery(UserLocation.class)
     *	.field("x").lessthan(5)
	 *	.field("y").greaterThan(6)
     */
    
    /*
     Airline
	{
		_id: 1,
		airlineCode: SWA,
		name: Southwest
	}
	Query<Airline> QueryAirline = datastore.createQuery(Airline.class);
	List<Airline> AirlineList = QueryAirline.asList();
	List<Airline> AirlineList = QueryAirline.filter("airlineCode = ", "SWA").asList();
	List<Airline> AirlineList = QueryAirline.field("code").equals("SWA").asList(); 
    ----
    Query<Airline> q = datastore.createQuery(Airline.class).filter("flightCode = ", 1).asList();
	datastore.createAggregation(Airline.class)
		.match(q)
		.project(p)
		.lookup("inventory", "item", "sku", "inventoryDocs") 
     */ 
      
     
     
    
    
    /**
     * Returns all flights between the two airports on a given date. Note that I have simplified this from the
     * original requirements that specified a date range.  This function returns a generic Object so you can return
     * any object type that makes sense for your data model. The class your return should override the toString() method
     * and print something useful. Look at the sample Airline object for an example of this.
     */
    public List<Flight> flightAvailability(String originAirportCode, String destAirportCode, Date date) 
    {
        //So, we need an Origin, and a Destination.
    	//originationAirportCode
    	//day

    	List<Flight> av = datastore.createQuery(Flight.class)
    			.field("origin").equal(originAirportCode)
    			.field("destination").equal(destAirportCode)
    			.filter("day = ", true).asList();
    			//.field(getDate(date)).equals(true).asList();
    			//.filter("day = ", true).asList();
    			//.field(getDate(day)).equals(true).asList();
    	return av;
    	
    }


	private String getDate(Date date) {
		
		int sun;
	    int mon;
	    int tue;
	    int wed;
	    int thu;
	    int fri;
	    int sat;
		return null;
	}

	/**
     * Returns all flights that are overbooked on the given day at the airport in question. If the boolean
     * checkOriginationCity is true, then you should check flights leaving the airport on the day. If the value is
     * false then you should check flight arriving at the airport that day. I have simplified this to a single date
     * instead of a date range.
     */
    public List<Object> flightOverbooked(boolean checkOriginationCity, String airportCode, Date date) 
    {
    	//day
    	Query<Flight> qF = datastore.createQuery(Flight.class)
    			.field("origin").equal(airportCode)
    			.field("destination").equal(airportCode);
    	if(checkOriginationCity == true){qF.field("origin").equal(originAirportCode);}
    	if(checkOriginationCity == false){qF.field("destination").equal(destAirportCode);}
        return null;
    }

    /**
     * Returns the airport code of the airport with the highest demand on the given date. Note that this clarifies
     * the original requirements and should return an individual airport and not a city, which may have multiple
     * airports. This also limits the require to only a date and not a day or week.
     *
     * Demand is to be calculated as the percentage of possible seats originating at the airport that are sold.
     */
    public String highestDemand(Date date) 
    {
    	Query <Flight> hD = datastore.createQuery(Flight.class).field(getDate(date)).equal(1)
    			.field("origin").equal(destAirportCode)
    			.field("seats").equal(openSeats)
    			.field("totalSeats").equal(seats);
    	
    	if(dayOfWeek(date) == 1)
    	{
    		float percentage;
    		percentage = (openSeats / seats);
    		percentage *= 100;
    	}
    	//return perc with highest demand
        return null;
    }

    /**
     * Same as above with two changes. First this provides a day of week instead of a single date. This means you have
     * to look at all flights on that day of week, not just on an individual date. This is thus covering many more
     * flights. This is also looking for the lowest demand, computed with the same definition as above.
     */
    public String lowestDemand(int day) 
    {
    	Query <Flight> LqA = datastore.createQuery(Flight.class).field(getDate(date)).equal(1)
    			.field("origin").equal(originAirportCode)
    			.field("seats").equal(seats)
    			.field("openSeats").equal(openSeats);
    	
    	if(dayOfWeek(date) == 1) //Needs to be changed to a specific day "Mon"
    	{
    		float percentage;
    		percentage = (openSeats/seats);
    		percentage *= 100;
    	}
    	//return perc with lowest demand
    	return null;
        
    }

    /**
     * Returns the airport code for the airport with the most available seats on a given date. Once again I have
     * simplified to a single date from a range and are requesting a single airport instead of a city. This may be a
     * different airport than the one with the lowest demand.
     */
    public String mostAvailableSeats(Date date) 
    {
    	List<Flight> mAv = datastore.createQuery(Flight.class).field(getDate(date)).equal(1)
    			.field("origin").equal(originAirportCode)
    			.field("seats").equal(openSeats).asList();
        return null;
    }

    /**
     * For this query you are going to return a map of maps. The outmost map will have as keys the airline codes. Each
     * entry in this map will map a day of week (integers 0 - 6) to the number of miles flown.
     */
    public Map<String, Map<Integer, Integer>> totalMilesAnalysis() 
    {
    	/*
    	String originAirportCode;
    	String destAirportCode;
    	int openSeats;
		int seats;
		int day;
		int dist;
    	int oAC is contained in flights
    	str day is contained in travelers
    	str milesFlown is contained in reservations
    	
    	Map<Flight, Map<Traveler, Reservation>> total = new HashMap<>();
    	Map<Traveler, Reservation> totalC = new HashMap<>();
    	//firstLevelMap.get(key1);
    	
    	if (totalC == null) 
    	{
            totalC = new HashMap<>();
            totalC.put(totalC, flights);
        }*/
    	//Map<Flight, Map<Traveler, Reservation>> total = new HashMap<>();
    	//private Map<String, Map<Integer, Integer> planes = new HashMap<String, HashMap<Integer, Integer>>();
    	Map<Flight, Map<Traveler, Reservation>> total = new HashMap<>();
    	Map<Traveler, Reservation> totalC = new HashMap<>();
    	MapReduceCommand cmd = new MapReduceCommand((DBCollection) flights, travelerId, bookingId, null, MapReduceCommand.OutputType.INLINE, null);
    	Query <Flight> d = datastore.createQuery(Flight.class).field(getDate(date)).equal(1);
    	
    	Query<Flight> f = datastore.find(Flight.class);    
    	System.out.println(f.countAll());
    	//Iterable<Traveler> t = t.countAll();
    	for (Flight r : f) 
    	{
    	    System.out.println(f);
    	}
    
        return null;
    }

    /**
     * This is a simplified version of the query in the original documentation. You simply need to give the
     * average miles flown by the 100 travellers with the most miles flown all time.
     */
    public int top100TravellerMiles() 
    {
    	//Traveler travelerObj = travelers.get(travelerId);
    	//travelerObj.milesFlown += thisFlight.dist;
    	//travelerObj.flightHistory.add(flightCode+date);
    	DBObject T100s = new BasicDBObject("_id", 0);
    	Query <Flight> T100 = datastore.createQuery(Flight.class)
    			.field("travelers.milesFlown").equal(milesFlown)
    			.field("flights.dist").equal(dist_)
    			.field("travelers.travelerId").equal(travelerId);
    	T100s.put(travelerId, new BasicDBObject( "$avg", dist_));
    	DBObject average = new BasicDBObject("$group", T100s);
        return 0;
    }

    /**
     * This function will get the day of week for a date. It has to subtract one from the value returned from c.get(...)
     * because Java calendar uses 1 for Sunday, 2 for Monday and our data starts at 0 for Sunday.
     */
    private int dayOfWeek(Date date) 
    {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.DAY_OF_WEEK) - 1;
    }


}
