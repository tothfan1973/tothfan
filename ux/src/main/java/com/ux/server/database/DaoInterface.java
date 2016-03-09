package com.ux.server.database;

import java.io.Serializable;
import java.util.List;

public interface DaoInterface <K, E extends Serializable> {

    void persist(E entity);

    void remove(E entity);

    E findById(K id);

    List< E > findAll();
}