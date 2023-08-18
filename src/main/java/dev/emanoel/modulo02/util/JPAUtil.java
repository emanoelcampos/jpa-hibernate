package dev.emanoel.modulo02.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("loja");

    public static EntityManager getEntityManager() {
        return ENTITY_MANAGER_FACTORY.createEntityManager();
    }
}
