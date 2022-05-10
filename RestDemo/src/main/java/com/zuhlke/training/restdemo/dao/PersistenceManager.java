package com.zuhlke.training.restdemo.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceManager {
    private EntityManagerFactory emFactory = null;
    private EntityManager entityManager = null;
    PersistenceManager() {
        emFactory = Persistence.createEntityManagerFactory("testvm");
        entityManager = emFactory.createEntityManager();
    }

    public EntityManager getEntityManager(){
        return entityManager;
    }

    public void closeEntityManager(){
        entityManager.close();
        emFactory.close();
    }

}
