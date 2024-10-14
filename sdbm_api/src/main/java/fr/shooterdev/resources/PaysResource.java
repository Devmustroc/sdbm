package fr.shooterdev.resources;

import fr.shooterdev.dto.PaysRequest;
import fr.shooterdev.entity.PaysEntity;
import fr.shooterdev.services.PaysService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/pays/")
public class PaysResource {

    @Inject
    PaysService paysService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(PaysRequest pays) {
        PaysEntity paysEntity ;
        paysEntity = paysService.create(pays);

        return Response.status(Response.Status.CREATED).entity(pays).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getById(@PathParam("id") int id) {
        return Response.ok(paysService.getById(id)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        return Response.ok(paysService.getAll()).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response update(@PathParam("id") int id, PaysRequest pays) {
        paysService.update(id, pays);
        return Response.ok().build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response delete(@PathParam("id") int id) {
        paysService.delete(id);
        return Response.ok().build();
    }
}