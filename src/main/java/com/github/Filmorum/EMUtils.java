package com.github.Filmorum;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMUtils {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    public static void createEntityManager(){
        entityManagerFactory = Persistence.createEntityManagerFactory("filmorum");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public static EntityManager getEntityManager() {
        return entityManager;
    }

}
