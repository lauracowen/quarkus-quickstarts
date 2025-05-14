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
    @Path("/{my-topic}/{my-lines}")  //<2>
    public String showMeAPoem(@PathParam("my-topic") String requestedTopic, @PathParam("my-lines") int requestedLines) {  //<3>
        return aiPoemService.writeAPoem(requestedTopic, requestedLines);  // <4>
    }
}
