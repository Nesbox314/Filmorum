package com.github.Filmorum.controller;

import com.github.Filmorum.EMUtils;
import com.github.Filmorum.model.Analysis;

import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/analysis")
public class AnalysisController {

    EntityManager entityManager = EMUtils.getEntityManager();

    @GET
    @Produces
    @Path("/")
    public List<Analysis> list(){
        List<Analysis> listAnalysis = entityManager.createNativeQuery("select * from analysis", Analysis.class).getResultList();

        return listAnalysis;
    }
}
