package com.github.Filmorum.controller;

import com.github.Filmorum.EMUtils;
import com.github.Filmorum.model.Analysis;
import com.github.Filmorum.model.Film;
import com.github.Filmorum.model.User;

import javax.persistence.EntityManager;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.text.DecimalFormat;
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

        for(Analysis analysis : listAnalysis){
            analysis.setUsers(entityManager.find(User.class, analysis.getUsers().getId()));
        }

        return listAnalysis;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response create(Analysis analysis){
        Film film = entityManager.find(Film.class, analysis.getMovie().getId());

        film.setReviews(film.getReviews() + 1);
        film.setAvaliation(atualizarReview(analysis));
        analysis.setMovie(film);

        entityManager.getTransaction().begin();
        entityManager.persist(analysis);
        entityManager.getTransaction().commit();

        return Response.status(Response.Status.OK).build();
    }

    public double atualizarReview(Analysis ana){
        entityManager.getTransaction().begin();

        List<Analysis> listAnalysis = entityManager
                .createNativeQuery("select * from analysis where movie_id = " +
                        ana.getMovie().getId(), Analysis.class).getResultList();

        double soma = 0;
        if(listAnalysis.size() == 0){
            return ana.getAvaliation();
        }

        listAnalysis.add(ana);
        for(Analysis analysis : listAnalysis){
            soma = soma + analysis.getAvaliation();
        }

        DecimalFormat df = new DecimalFormat("#,0");
        entityManager.getTransaction().commit();
        return Double.parseDouble(df.format(soma/listAnalysis.size()));
    }
}
