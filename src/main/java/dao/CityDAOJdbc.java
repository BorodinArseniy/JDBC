package dao;

import config.EntityManagerFactoryUtil;
import pojo.City;
import pojo.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class CityDAOJdbc implements CityDAO{

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
    EntityManager entityManager = EntityManagerFactoryUtil.getEntityManager(entityManagerFactory);
    @Override
    public void addCity(City city) {
        entityManager.getTransaction().begin();
        entityManager.persist(city);
        entityManager.getTransaction().commit();

        EntityManagerFactoryUtil.closeEntityManager(entityManagerFactory, entityManager);
    }

    @Override
    public City getCityById(int id) {
        entityManager.getTransaction().begin();

        City city = entityManager.find(City.class, id);
        entityManager.getTransaction().commit();
        EntityManagerFactoryUtil.closeEntityManager(entityManagerFactory, entityManager);
        return city;
    }

    @Override
    public List<City> getAll() {
        entityManager.getTransaction().begin();

        String jpqlQuery = "SELECT s FROM City s";
        TypedQuery<City> query = entityManager.createQuery(jpqlQuery, City.class);
        List<City> cities = query.getResultList();

        entityManager.getTransaction().commit();
        EntityManagerFactoryUtil.closeEntityManager(entityManagerFactory, entityManager);
        return cities;
    }

    @Override
    public City updateCity(City city) {
        entityManager.getTransaction().begin();
        City city1 = entityManager.merge(city);

        entityManager.getTransaction().commit();
        EntityManagerFactoryUtil.closeEntityManager(entityManagerFactory, entityManager);
        return city1;
    }

    @Override
    public void deleteCity(City city) {
        entityManager.getTransaction().begin();
        City city1 = entityManager.find(City.class, city.getCity_id());
        System.out.println(city1);
        entityManager.remove(city1);
        entityManager.getTransaction().commit();
        EntityManagerFactoryUtil.closeEntityManager(entityManagerFactory, entityManager);
    }
}
