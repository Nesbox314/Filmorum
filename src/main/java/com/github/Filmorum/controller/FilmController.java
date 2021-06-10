package com.github.Filmorum.controller;

import com.github.Filmorum.model.Film;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/film")
public class FilmController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public List<Film> list(){
        List<Film> films = null;

        return films;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Film get(@PathParam("id") Long id){
        Film film = new Film();
        film.setId(id);

        return film;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response create(Film film){
        return Response.status(Response.Status.OK).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response update(Film film){
        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id){
        return Response.status(Response.Status.OK).build();
    }
}