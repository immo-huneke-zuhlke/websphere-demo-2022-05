package com.zuhlke.training.restdemo.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class PersistenceManager {
    private EntityManagerFactory emFactory;
    private EntityManager entityManager;
    private static final String host = "host.docker.internal";

    PersistenceManager() {
        emFactory = Persistence.createEntityManagerFactory(setHostForConnectionString());
        entityManager = emFactory.createEntityManager();
    }

    private String setHostForConnectionString() {
        String persistenceUnitName = "testvm";
        try {
            //noinspection ResultOfMethodCallIgnored
            InetAddress.getByName(host);  // Result is of no interest, just whether the host is known
        } catch (UnknownHostException e) {
            persistenceUnitName = "host_os";
        }
        return persistenceUnitName;
    }

    public EntityManager getEntityManager(){
        return entityManager;
    }

    public void closeEntityManager(){
        entityManager.close();
        emFactory.close();
    }

}
