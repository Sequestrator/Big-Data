package cs473;

import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Embedded;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

/**
 * 
 *
 * Schema being used:
	flightCode
	originAirport{
		airportCode
		state
		city
	}
	destAirport{
		airportCode
		state
		city
	}
	days[]
	
	plane{
		planeType
		seats
	}
	dist

 */
public class Flight 
{
    @Id
    // flight structure
    String flightCode;
    String originAirportCode;
    String destAirportCode;
    
    @Embedded
    Airport originAirportObj;
    
    @Embedded
    Airport destAirportObj;
    
    // airline embedding
    String airlineCode;
    //int day;
    
    // plane embedding
    @Embedded
    Plane planeObj;
    
    int dist;
    
    boolean sun;
    boolean mon;
    boolean tue;
    boolean wed;
    boolean thr;
    boolean fri;
    boolean sat;
    
    //private int travelerId;
	//private String name;
    private int distance;
    
    public Flight(String flightCode_, int day, Airport originAirportObj_, Airport destAirportObj_, String airlineCode_, Plane planeObj_, int dist_) 
    {	
    	this.flightCode	= flightCode_;
    	this.originAirportObj = originAirportObj_;
    	this.destAirportObj = destAirportObj_;
    	this.airlineCode = airlineCode_;
		this.planeObj = planeObj_;
		//this.day = day;
		this.distance = dist_;
		
		this.sun = this.mon = this.tue = this.wed = this.thr = this.fri = this.sat = false;
		switch(day) {
			case 0:
				this.sun = true;
				break;
			case 1:
				this.mon = true;
				break;
			case 2:
				this.tue = true;
				break;
			case 3:
				this.wed = true;
				break;
			case 4:
				this.thr = true;
				break;
			case 5:
				this.fri = true;
				break;
			case 6:
				this.sat = true;
				break;
		}
		
    }
    
    public void addDay(int day) 
    {
    	switch(day) {
		case 0:
			this.sun = true;
			break;
		case 1:
			this.mon = true;
			break;
		case 2:
			this.tue = true;
			break;
		case 3:
			this.wed = true;
			break;
		case 4:
			this.thr = true;
			break;
		case 5:
			this.fri = true;
			break;
		case 6:
			this.sat = true;
			break;
    	}
    }
    
/*
    public void setFlightDetails(String airlineCode, String airlineName, String code, String originAirportID, String destAirportID, String planeCode, int planeSeats) 
    {
        this.flightCode = code;
        this.originAirportID = originAirportID;
        this.destAirportID = destAirportID;
        this.airlineCode = airlineCode;
        this.airlineName = airlineName;
        this.planeCode = planeCode;
        this.planeSeats = planeSeats;
    }*/
}