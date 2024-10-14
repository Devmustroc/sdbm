package fr.shooterdev.resources;

import fr.shooterdev.dto.MarqueRequest;
import fr.shooterdev.entity.MarqueEntity;
import fr.shooterdev.services.MarqueService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/marques/")
public class MarqueResource {

    @Inject
    MarqueService marqueService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(MarqueRequest marque) {
        MarqueEntity paysEntity ;
        paysEntity = marqueService.create(marque);

        return Response.status(Response.Status.CREATED).entity(marque).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getById(@PathParam("id") int id) {
        return Response.ok(marqueService.getById(id)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        return Response.ok(marqueService.getAll()).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response update(@PathParam("id") int id, MarqueRequest marque) {
        marqueService.update(id, marque);
        return Response.ok().build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response delete(@PathParam("id") int id) {
        marqueService.delete(id);
        return Response.ok().build();
    }
}