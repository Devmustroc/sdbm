package fr.shooterdev.resources;

import fr.shooterdev.dto.ContinentRequest;
import fr.shooterdev.entity.ContinentEntity;
import fr.shooterdev.services.ContinentService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/continents/")
public class ContinentResource {

    @Inject
    ContinentService continentService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(ContinentRequest continent) {
        ContinentEntity continentEntity ;
        continentEntity = continentService.create(continent);

        return Response.status(Response.Status.CREATED).entity(continentEntity).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getById(@PathParam("id") int id) {
        return Response.ok(continentService.getById(id)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        return Response.ok(continentService.getAll()).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response update(@PathParam("id") int id, ContinentRequest continent) {
        continentService.update(id, continent);
        return Response.ok().build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response delete(@PathParam("id") int id) {
        continentService.delete(id);
        return Response.ok().build();
    }
}