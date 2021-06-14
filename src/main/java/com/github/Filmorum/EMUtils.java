package com.github.Filmorum;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMUtils {

    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("filmorum");
    private static EntityManager entityManager = entityManagerFactory.createEntityManager();

    public static EntityManager getEntityManager() {
        return entityManager;
    }
}
