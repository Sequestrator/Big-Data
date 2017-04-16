/*package cs473;
import java.util.Iterator;
import java.util.List;

import org.mongodb.morphia.aggregation.AggregationPipeline;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.Datastore;
public class TestQuery 
{
	private Datastore datastore;
	public TestQuery(Datastore datastore)
	{
		this.datastore = datastore;
	}
	public Flight simpleQueryOne(String airlineCode)
	{	//Returns the first available found
		//return datastore.createQuery(Flight.class).field("code").equal(airlineCode).asList().get();
		return (Flight) datastore.createQuery(Flight.class).field("code").equal(airlineCode).asList();
	}
	public List<Flight> aggregateQuery()
	{
		AggregationPipeline pipeline = datastore.createAggregation(Flight.class);
		pipeline.limit(5);
		Iterator<Flight> i = pipeline.aggregate(Flight.class);
		Iterator<Flight> u = datastore.createQuery(Flight.class).iterator();
		while(u.hasNext())
		{
			Flight f = i.next();
			Flight f2 = datastore.createQuery(Flight.class).field("partnerCode").equal(f.getflightCode().get);
			merge(f,f2);
		}
		return null;
	}
	private void merge(Flight f, Flight f2) {
		// TODO Auto-generated method stub
		
	}

}*/
