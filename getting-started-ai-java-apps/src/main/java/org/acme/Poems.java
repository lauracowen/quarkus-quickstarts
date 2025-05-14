package org.acme;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/poems")
public class Poems {

    @Inject
    AiPoemService aiPoemService;  //<1>

    @GET
    @Produces(MediaType.TEXT_HTML)
    @Path("/{mytopic}/{mylines}")  //<2>
    public String showMeAPoem(@PathParam("mytopic") String requestedtopic, @PathParam("mylines") int requestedlines) {  //<3>
        return aiPoemService.writeAPoem(requestedtopic, requestedlines);  // <4>
    }
}
