package cs473;

import org.mongodb.morphia.annotations.Id;

import java.util.Date;

/**
 * 
 *
 * Schema being used:
 * Reservation 
 * {
 *      id:             int,
 *      flight:         String,
 *      seat:           int,
 *      travelerId:     int,
 *      travelerName:   string
 *      
 
 		id
 		
 		flight{
 		
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
			
			}
			
			seat
			
			traveler{
				id
				name
			}
		 
		 
 
 
 
 * }
 *
 */
public class Reservation 
{
    @Id
    private int id;
    //Flight flightObj;
    String flightCode;
    int DoW;
    Date date;
    int travelerId;

    public Reservation(int id, String flightCode_, int day_, Date date_, int travelerId_) 
    {
        this.id = id;
        this.flightCode = flightCode_;
        this.DoW = day_;
        this.date = date_;
        this.travelerId = travelerId_;
    }
}