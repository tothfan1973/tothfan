package com.ux.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.ux.client.AppFormService;
import com.ux.client.data.PersonItem;
import com.ux.common.ApplicationContextRegistry;
import com.ux.common.IApplicationContext;
import com.ux.server.database.PersonDao;
import com.ux.server.entity.Person;
import org.jetbrains.annotations.NotNull;

import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;


public class AppFormServiceImpl extends RemoteServiceServlet implements AppFormService {

    final IApplicationContext applicationContext = ApplicationContextRegistry.getApplicationContext();

    @Override
    public void savePerson(final PersonItem personItem) {


        final Person user = new Person(personItem.getUsername(), personItem.getEmail());
        final EntityManagerFactory entityManagerFactory = applicationContext.createDataAccessFactory();

        final PersonDao personDao = new PersonDao(entityManagerFactory);
        personDao.persist(user);

    }

    @Override
    public List<PersonItem> getPersonItems() {

        @NotNull final List<PersonItem> resultPresonItems = new ArrayList<>();

        final EntityManagerFactory entityManagerFactory = applicationContext.createDataAccessFactory();
        final PersonDao personDao = new PersonDao(entityManagerFactory);

        final List<Person> persons = personDao.findAll();
        for( final Person person : persons) {

            final PersonItem personItem = new PersonItem(person.getUsername(), person.getEmail());
            resultPresonItems.add(personItem);
        }

        return resultPresonItems;
    }
}