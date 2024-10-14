package fr.shooterdev.resources;

import fr.shooterdev.dto.FabricantRequest;
import fr.shooterdev.entity.FabricantEntity;
import fr.shooterdev.services.FabricantService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/fabricant/")
public class FabricantResource {

    @Inject
    FabricantService fabricantService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(FabricantRequest fabricant) {
        FabricantEntity fabricantEntity ;
        fabricantEntity = fabricantService.create(fabricant);

        return Response.status(Response.Status.CREATED).entity(fabricant).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getById(@PathParam("id") int id) {
        return Response.ok(fabricantService.getById(id)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        return Response.ok(fabricantService.getAll()).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response update(@PathParam("id") int id, FabricantRequest fabricant) {
        fabricantService.update(id, fabricant);
        return Response.ok().build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response delete(@PathParam("id") int id) {
        fabricantService.delete(id);
        return Response.ok().build();
    }
}