package fr.shooterdev.resources;

import fr.shooterdev.dto.ArticleRequest;
import fr.shooterdev.entity.ArticleEntity;
import fr.shooterdev.services.ArticleService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/articles/")
public class ArticleResource {

    @Inject
    ArticleService articleService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(ArticleRequest pays) {
        ArticleEntity articleEntity ;
        articleEntity = articleService.create(pays);

        return Response.status(Response.Status.CREATED).entity(articleEntity).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getById(@PathParam("id") int id) {
        return Response.ok(articleService.getById(id)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        return Response.ok(articleService.getAll()).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response update(@PathParam("id") int id, ArticleRequest pays) {
        articleService.update(id, pays);
        return Response.ok().build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response delete(@PathParam("id") int id) {
        articleService.delete(id);
        return Response.ok().build();
    }
}