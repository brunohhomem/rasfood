package br.com.rasmoo.restaurant.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    private static final EntityManagerFactory RASFOOD = Persistence.createEntityManagerFactory("rasfood");

    public static EntityManager getEntityManagerRasFood() {
        return RASFOOD.createEntityManager();
    }
}
