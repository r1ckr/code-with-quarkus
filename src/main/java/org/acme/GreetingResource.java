package org.acme;

import io.quarkus.logging.Log;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response hello() {
        Log.info("Replying hello");
        Person person = new Person();
        person.setFirstName("Richard");
        person.setLastName("Pablito");
        return Response.ok(person).build();
    }
}