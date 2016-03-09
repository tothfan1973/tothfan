package com.ux.server.database;

import com.ux.server.entity.Person;
import javax.persistence.EntityManagerFactory;


public class PersonDao extends JpaDaoImpl<Integer, Person> implements PersonDaoInterface {

    public PersonDao(final EntityManagerFactory entityManagerFactory) {

        super(entityManagerFactory);
    }
}
