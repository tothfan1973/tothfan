package com.ux.common;


import javax.persistence.EntityManagerFactory;

public class ApplicationContex implements IApplicationContext {

    private final HsqldbConnectionFactory jdbcConnectionFactory;

    public ApplicationContex(final HsqldbConnectionFactory jdbcConnectionFactory) {

        this.jdbcConnectionFactory = jdbcConnectionFactory;
    }


    @Override
    public EntityManagerFactory createDataAccessFactory() {

        return jdbcConnectionFactory.getEntityManagerFactory();
    }
}
