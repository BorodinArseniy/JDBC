package dao;

import config.EntityManagerFactoryUtil;
import pojo.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class EmployeeDAOJdbc implements EmployeeDAO{

    private static EntityManagerFactory entityManagerFactory;

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

    }

    @Override
    public Employee getEmployeeById(int id) {

        Query query = entityManager.createNativeQuery("SELECT * FROM employee WHERE id = ?");
        query.setParameter(1, id);
        return (Employee) query;
    }

    @Override
    public List<Employee> getAll() {
        return null;
    }

    @Override
    public void changeEmployeeById(int id, Employee employee) {

    }

    @Override
    public void deleteEmployeeById(Employee employee) {

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
