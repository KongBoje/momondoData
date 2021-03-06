/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KaffeData;

import Entity.Airline;
import Entity.Flight;
import javax.ws.rs.core.UriInfo;
import com.google.gson.Gson;
import java.util.ArrayList;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Michael
 */
@Path("flights")
public class FlightsResource {

    private static final Gson gson = new Gson();

    ArrayList<Flight> flightList = new ArrayList<Flight>() {
        {
            add(new Flight("5342-5374581236347", "KAF6666", "2017-11-22T12:00:00.000Z", 6, 67, 240, "CPH", "SXF"));
            add(new Flight("4443-8765989054363", "KAF3466", "2017-12-03T16:00:00.000Z", 9, 239, 120, "CPH", "STN"));
            add(new Flight("2323-8675048485030", "KAF6622", "2018-03-12T15:00:00.000Z", 4, 190, 60, "STN", "SXF"));
            add(new Flight("8765-0101909245668", "KAF5789", "2017-01-05T12:00:00.000Z", 12, 300, 264, "STN", "CPH"));
            add(new Flight("6464-0192837465951", "KAF1113", "2017-02-01T12:00:00.000Z", 14, 200, 210, "SXF", "CPH"));
        }
    };
    

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public FlightsResource() {
    }

    /**
     * Retrieves representation of an instance of Rest.FlightsResource
     *
     * @param from
     * @param date
     * @param tickets
     * @return an instance of java.lang.String
     * @throws Exceptions.FlightException
     */
    @GET // Fetches available flights from a specific location, given a date
    @Path("/{from}/{date}/{tickets}")
    @Produces(MediaType.APPLICATION_JSON)
    public String fromDate(@PathParam("from") String from, @PathParam("date") String date, @PathParam("tickets") int tickets) {
        Airline airline = new Airline("Kaffemænd Tours");
        for(Flight x : flightList) {
            if(x.getDate().equals(date) && x.getOrigin().equals(from)) {
                airline.addFlight(x);
            }
        }
        String res = gson.toJson(airline);
        return res;
    }

    @GET // Fetches available flights from and to a specific location, given a date 
    @Path("/{from}/{to}/{date}/{tickets}")
    @Produces(MediaType.APPLICATION_JSON)
    public String fromToDateTick(@PathParam("from") String from, @PathParam("to") String to, @PathParam("date") String date, @PathParam("tickets") int tickets) {
        Airline airline = new Airline("Kaffemænd Tours");
        for(Flight x : flightList) {
            if(x.getDate().equals(date) && x.getOrigin().equals(from) && x.getDestination().equals(to)) {
                airline.addFlight(x);
            }
        }
        String res = gson.toJson(airline);
        return res;
    }

}
