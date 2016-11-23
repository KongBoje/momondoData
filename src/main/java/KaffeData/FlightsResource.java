/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KaffeData;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import com.google.gson.Gson;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Michael
 */
@Path("flights")
public class FlightsResource {
    
    private static final Gson gson = new Gson();

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
        return fakedata();
    }

    @GET // Fetches available flights from and to a specific location, given a date 
    @Path("/{from}/{to}/{date}/{tickets}")
    @Produces(MediaType.APPLICATION_JSON)
    public String fromToDateTick(@PathParam("from") String from, @PathParam("to") String to, @PathParam("date") String date, @PathParam("tickets") int tickets) {
        return fakedata();
    }
    
    private String fakedata() {
        return "{\n" +
"    \"airline\": \"Kaffemantours\",\n" +
"    \"flights\":[\n" +
"        {\n" +
"            \"flightID\": \"5342-5374581236347\",\n" +
"            \"flightNumber\": \"KAF6666\",\n" +
"            \"date\": \"2016-11-22T12:00:00.000Z\",\n" +
"            \"numberOfSeats\": 6,\n" +
"            \"totalPrice\": 67,\n" +
"            \"traveltime\": 240,\n" +
"            \"origin\": \"CPH\",\n" +
"            \"destination\": \"MOW\"\n" +
"        },\n" +
"        {\n" +
"            \"flightID\": \"4443-8765989054363\",\n" +
"            \"flightNumber\": \"KAF3466\",\n" +
"            \"date\": \"2016-12-03T16:00:00.000Z\",\n" +
"            \"numberOfSeats\": 9,\n" +
"            \"totalPrice\": 239,\n" +
"            \"traveltime\": 120,\n" +
"            \"origin\": \"OSL\",\n" +
"            \"destination\": \"ARN\"\n" +
"        },\n" +
"        {\n" +
"            \"flightID\": \"2323-8675048485030\",\n" +
"            \"flightNumber\": \"KAF6622\",\n" +
"            \"date\": \"2016-03-12T15:00:00.000Z\",\n" +
"            \"numberOfSeats\": 4,\n" +
"            \"totalPrice\": 190,\n" +
"            \"traveltime\": 60,\n" +
"            \"origin\": \"BAL\",\n" +
"            \"destination\": \"AAR\"\n" +
"        },\n" +
"        {\n" +
"            \"flightID\": \"8765-0101909245668\",\n" +
"            \"flightNumber\": \"KAF5789\",\n" +
"            \"date\": \"2017-01-05T12:00:00.000Z\",\n" +
"            \"numberOfSeats\": 12,\n" +
"            \"totalPrice\": 300,\n" +
"            \"traveltime\": 264,\n" +
"            \"origin\": \"BER\",\n" +
"            \"destination\": \"BGK\"\n" +
"        },\n" +
"        {\n" +
"            \"flightID\": \"6464-0192837465951\",\n" +
"            \"flightNumber\": \"KAF1113\",\n" +
"            \"date\": \"2017-02-01T12:00:00.000Z\",\n" +
"            \"numberOfSeats\": 14,\n" +
"            \"totalPrice\": 200,\n" +
"            \"traveltime\": 210,\n" +
"            \"origin\": \"DAS\",\n" +
"            \"destination\": \"HAM\"\n" +
"        }\n" +
"    ]\n" +
"}\n" +
"";
    }
}
