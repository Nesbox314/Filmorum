package com.github.Filmorum.controller;

import com.github.Filmorum.EMUtils;
import com.github.Filmorum.model.Analysis;
import com.github.Filmorum.model.Film;

import javax.persistence.EntityManager;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/analysis")
public class AnalysisController {

    EntityManager entityManager = EMUtils.getEntityManager();

    @GET
    @Produces
    @Path("/")
    public List<Analysis> list(){
        List<Analysis> listAnalysis = entityManager
                .createNativeQuery("select * from analysis", Analysis.class).getResultList();

        return listAnalysis;
    }

    @GET
    @Produces
    @Path("/film/{id}")
    public List<Analysis> listByFilms(@PathParam("id") Long id){
        List<Analysis> listAnalysis = entityManager
                .createNativeQuery("select * from analysis where movie_id = " + id, Analysis.class).getResultList();

        return listAnalysis;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response create(Analysis analysis){
        entityManager.getTransaction().begin();
        entityManager.persist(analysis);
        entityManager.getTransaction().commit();
        return Response.status(Response.Status.OK).build();
    }
}
