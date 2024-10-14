package fr.shooterdev.resources;

import fr.shooterdev.dto.TypeBiereRequest;
import fr.shooterdev.entity.TypeBiereEntity;
import fr.shooterdev.services.TypeBiereService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/typesbiere/")
public class TypeBiereResource {

    @Inject
    TypeBiereService typeBiereService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(TypeBiereRequest typeBiere) {
        TypeBiereEntity typeBiereEntity ;
        typeBiereEntity = typeBiereService.create(typeBiere);

        return Response.status(Response.Status.CREATED).entity(typeBiere).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getById(@PathParam("id") int id) {
        return Response.ok(typeBiereService.getById(id)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        return Response.ok(typeBiereService.getAll()).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response update(@PathParam("id") int id, TypeBiereRequest typeBiere) {
        typeBiereService.update(id, typeBiere);
        return Response.ok().build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response delete(@PathParam("id") int id) {
        typeBiereService.delete(id);
        return Response.ok().build();
    }
}