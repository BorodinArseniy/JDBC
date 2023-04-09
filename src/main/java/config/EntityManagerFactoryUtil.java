package config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryUtil {


    public static EntityManager getEntityManager(EntityManagerFactory entityManagerFactory ){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager;
    }

    public static void closeEntityManager(EntityManagerFactory entityManagerFactory, EntityManager entityManager) {
        entityManagerFactory.close();
        entityManager.close();
    }

}
