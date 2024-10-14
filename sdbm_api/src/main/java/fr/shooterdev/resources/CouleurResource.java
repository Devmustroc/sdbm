package fr.shooterdev.resources;

import fr.shooterdev.dto.CouleurRequest;
import fr.shooterdev.entity.CouleurEntity;
import fr.shooterdev.services.CouleurService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/couleurs/")
public class CouleurResource {

    @Inject
    CouleurService couleurService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(CouleurRequest couleur) {
        CouleurEntity couleurEntity ;
        couleurEntity = couleurService.create(couleur);

        return Response.status(Response.Status.CREATED).entity(couleurEntity).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getById(@PathParam("id") int id) {
        return Response.ok(couleurService.getById(id)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        return Response.ok(couleurService.getAll()).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response update(@PathParam("id") int id, CouleurRequest couleur) {
        couleurService.update(id, couleur);
        return Response.ok().build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response delete(@PathParam("id") int id) {
        couleurService.delete(id);
        return Response.ok().build();
    }
}