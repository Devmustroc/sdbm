package fr.shooterdev.resources;

import fr.shooterdev.dto.TicketRequest;
import fr.shooterdev.entity.TicketEntity;
import fr.shooterdev.services.TicketService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/tickets/")
public class TicketResource {

    @Inject
    TicketService ticketService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(TicketRequest ticket) {
        TicketEntity ticketEntity ;
        ticketEntity = ticketService.create(ticket);

        return Response.status(Response.Status.CREATED).entity(ticketEntity).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getById(@PathParam("id") int id) {
        return Response.ok(ticketService.getById(id)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        return Response.ok(ticketService.getAll()).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response update(@PathParam("id") int id, TicketRequest ticket) {
        ticketService.update(id, ticket);
        return Response.ok().build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response delete(@PathParam("id") int id) {
        ticketService.delete(id);
        return Response.ok().build();
    }
}