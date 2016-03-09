package com.ux.common;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HsqldbConnectionFactory {

    private static final String THINK = "think";

    private final EntityManagerFactory entityManagerFactory;

    public HsqldbConnectionFactory() {

        entityManagerFactory = Persistence.createEntityManagerFactory(THINK);
    }

    public EntityManagerFactory getEntityManagerFactory() {

        return entityManagerFactory;
    }
}
