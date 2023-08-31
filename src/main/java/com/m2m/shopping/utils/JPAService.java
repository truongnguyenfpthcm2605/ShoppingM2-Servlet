package com.m2m.shopping.utils;

import lombok.NoArgsConstructor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@NoArgsConstructor
public class JPAService {
    private static EntityManagerFactory factory;

    static public EntityManager getEntityManager() {
        if(factory==null || !factory.isOpen()) {
            factory = Persistence.createEntityManagerFactory("shopping");
        }
        return factory.createEntityManager();
    }
    static public void shutdown() {
        if(factory!=null && factory.isOpen()) {
            factory.close();
        }
        factory =null;
    }
}
