package com.github.Filmorum.controller;

import com.github.Filmorum.EMUtils;
import com.github.Filmorum.model.Film;
import com.github.Filmorum.model.User;

import javax.persistence.EntityManager;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/film")
public class FilmController {

    EntityManager entityManager = EMUtils.getEntityManager();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public List<Film> list(){
        List<Film> listFilms = entityManager.createNativeQuery("select * from Film", Film.class).getResultList();

        return listFilms;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Film get(@PathParam("id") Long id){
        Film film;

        film = entityManager.find(Film.class, id);

        return film;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response create(Film film){
        entityManager.getTransaction().begin();
        entityManager.persist(film);
        entityManager.getTransaction().commit();
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