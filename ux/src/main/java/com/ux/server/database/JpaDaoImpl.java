package com.ux.server.database;

import com.ux.common.ApplicationContextRegistry;
import com.ux.common.IApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;


public class JpaDaoImpl<K, E extends Serializable> implements DaoInterface<K, E> {

    private final EntityManagerFactory entityManagerFactory;

    protected Class<E> entityClass;

    public JpaDaoImpl(final EntityManagerFactory entityManagerFactory) {

        final ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<E>) genericSuperclass.getActualTypeArguments()[1];
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public void persist(final E entity) {

        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void remove(final E entity) {

        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public E findById(final K id) {

        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        final E find = entityManager.find(entityClass, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return find;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List< E > findAll() {

        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        final Query query = entityManager.createQuery("from " + entityClass.getName());
        final List resultList = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();

        return resultList;
    }

}