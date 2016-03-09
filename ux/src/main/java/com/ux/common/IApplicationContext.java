package com.ux.common;


import javax.persistence.EntityManagerFactory;

public interface IApplicationContext {

    EntityManagerFactory createDataAccessFactory();

}
