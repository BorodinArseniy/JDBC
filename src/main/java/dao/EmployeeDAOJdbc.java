package dao;

import config.EntityManagerFactoryUtil;
import pojo.Employee;

import javax.persistence.*;
import java.util.List;


public class EmployeeDAOJdbc implements EmployeeDAO{

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
    EntityManager entityManager = EntityManagerFactoryUtil.getEntityManager(entityManagerFactory);
            /*
    @Override
    public void addEmployee(Employee employee) {
        try(PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO employee" +
                " (first_name, last_name, gender, age, city_id) VALUES ((?), (?), (?), (?), (?))")){
            preparedStatement.setString(1, employee.getFirst_name());
            preparedStatement.setString(2, employee.getLast_name());
            preparedStatement.setString(3, employee.getGender());
            preparedStatement.setInt(4, employee.getAge());
            preparedStatement.setInt(5, employee.getCity());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }*/

    @Override
    public void addEmployee(Employee employee) {
        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.getTransaction().commit();

        EntityManagerFactoryUtil.closeEntityManager(entityManagerFactory, entityManager);

    }

    @Override
    public Employee getEmployeeById(int id) {
        entityManager.getTransaction().begin();

        Employee employee = entityManager.find(Employee.class, id);
        entityManager.getTransaction().commit();
        EntityManagerFactoryUtil.closeEntityManager(entityManagerFactory, entityManager);
        return employee;

    }

    @Override
    public List<Employee> getAll() {
        entityManager.getTransaction().begin();

        String jpqlQuery = "SELECT s FROM Employee s";
        TypedQuery<Employee> query = entityManager.createQuery(jpqlQuery, Employee.class);
        List<Employee> employees = query.getResultList();

        entityManager.getTransaction().commit();
        EntityManagerFactoryUtil.closeEntityManager(entityManagerFactory, entityManager);
        return employees;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        entityManager.getTransaction().begin();
        Employee employee1 = entityManager.merge(employee);

        entityManager.getTransaction().commit();
        EntityManagerFactoryUtil.closeEntityManager(entityManagerFactory, entityManager);
        return employee1;
    }

    @Override
    public void deleteEmployee(Employee employee) {
        entityManager.getTransaction().begin();
        Employee employee1 = entityManager.find(Employee.class, employee.getId());
        System.out.println(employee1);
        entityManager.remove(employee1);
        entityManager.getTransaction().commit();
        EntityManagerFactoryUtil.closeEntityManager(entityManagerFactory, entityManager);
    }
    /*

    @Override
    public List<Employee> getAll() {
        List<Employee> employees = new ArrayList<>();
        try(PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employee" +
                " INNER JOIN city ON employee.city_id = city.city_id")){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                String gender = resultSet.getString("gender");
                int age = resultSet.getInt("age");
                int city = resultSet.getInt("city_id");
                employees.add(new Employee(first_name, last_name, gender, age, city));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return employees;
    }

    @Override
    public void changeEmployeeById(int id, Employee employee) {
        try(PreparedStatement preparedStatement = connection.prepareStatement("UPDATE INTO employee" +
                " SET first_name = (?), last_name = (?), gender = (?), age = (?), city_id = (?)")){
            preparedStatement.setString(1, employee.getFirst_name());
            preparedStatement.setString(2, employee.getLast_name());
            preparedStatement.setString(3, employee.getGender());
            preparedStatement.setInt(4, employee.getAge());
            preparedStatement.setInt(5, employee.getCity());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteEmployeeById(Employee employee) {
        try(PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM employee WHERE id = (?)")){
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    } */
}
