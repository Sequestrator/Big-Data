

//Possible number 1 and 2 queries, not sure. Dom Need you to Seperate into 7 different
//queries as apposed to combining #1 and #2
/*
flight
{
	flightcode://keypt.1
	date
	{
		dmy://keypt2
		day:
	}
	depttime:keypt.3
	arrivaltime:
	origin/dest airport
	{
		airport code:
		city:
		state:
	}
	plane
	{
		planecode
		seats
		airline
		{
			airlinecode:
			name:
		}
	}
	bookings:
}

//I think that this is number 3 query
travellers
{
	id:
	name:
	flightsflown:
	milesflown
	reservations[]{
		flightID:
		date:
	}
}


	reduce original collection to a collection of flights that satisfy the date restriction
	reduce that to a collection of flightCode city, the average availability of each flight from the last collection
	return the object with the max. availability from that collection


//Possible Number 4 query.
mongo.db.find{}
$max{$avg{$eq{date:x}avail:seat-bookings}} //highest demand
$min{$avg{$eq{date:x}avail:seat-bookings}} //lowest demand


//Starting 5,6,7
//5. What destination city has the most available inbound seat on a given date
flight
{
	date
	{
		dmy
		day
	}
	plane
	{
		seats //total seats
		airline
		{
			airlineCode:
			name:
		}
	}
	bookings // reserved seats
	destination airport
	{
		airportCode
		city
		state
	}
}//Basically asking, out of the seats that are booked, what city has the most bookings

//6. List by airline and day of week, the total miles flown by an airline
flight
{
	date
	{
		dmy
		date
	}//on a certain date
	plane
	{
		planecode
		airline
		{
			airlineCode
			name
		}//get the name and airline
	}//get a plane code
	travellers
	{
		id
		milesflown
	}//pulling from our initial miles flown from query 3.
}

//7.
//What is the average number of flights and miles flown by all travelers?
//What is the average number of flights and miles flown by the top N travelers?
//What is the average number of flights and miles flown by the top N% travelers?
For Top N, and N%, what is the percentage of total flights and miles that these travelers represent?

flight
{
	date
	{
		dmy
		date
	}
	plane
	{
		planeCode
		seats
		airline
		{
			airlineCode
			name
		}
	}
	travellers
	{
		id:
		name:
		flightsflown:
		milesflown:
	}
	//Not entirely sure how to calculate, require assistance
	TopN
	{
		$avg{$descending{"10"}}//call N 10
	}
	TopNPercent
	{
		$avg{$percentage{$avg{$descending{"10"}}}}
	}
	Percentage
	{
		$percentage{flightsflown FROM TopN}
		$percentage{milesflown FROM TopN}
		$percentage{flightsflown FROM TopNPercent}
		$percentage{milesflown FROM TopNPercent}
	}	
	//End Uncertainty.
	
	Top N listby{$avg{$descending{airline, "N"}} && db.collection.find().sort({ $natural: -1 }).limit(N)
	Top N% aggregate({"$project":{"percentage":{"$multiply":[{"$divide":[N]]}}}})
}
	
*/