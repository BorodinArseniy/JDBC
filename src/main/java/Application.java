import config.ConnectionConfig;
import config.EntityManagerFactoryUtil;
import dao.EmployeeDAO;
import dao.EmployeeDAOJdbc;
import pojo.City;
import pojo.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.sql.*;

public class Application {
    public static void main(String[] args) throws SQLException {
        /*final String url = "jdbc:postgresql://localhost:5432/skypro";
        final String user = "postgres";
        final String password = "270606";

        String query = "SELECT * FROM employee WHERE id=1";
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)){
            while (resultSet.next()) {
                String name = resultSet.getString("first_name");
                String secondName = resultSet.getString("last_name");
                String sex = resultSet.getString("gender");
                String city = resultSet.getString("city_id");
                System.out.println(name + " " + secondName + " " +  sex + " " + city);
            }
        }*/

        /*try(Connection connection = DriverManager.getConnection(url,user,password)){
                EmployeeDAO employeeDAO = new EmployeeDAOJdbc(connection);
                employeeDAO.addEmployee(new Employee("Evgeniy", "Vorobiev", "male", 65, new City(6, "Barcelona")));
            System.out.println(employeeDAO.getAll());
        }*/

        /*try {
            System.out.println(ConnectionConfig.loadProperties("application.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

        /*EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();*/

        EmployeeDAO employeeDAO = new EmployeeDAOJdbc();
        Employee employee = new Employee("Sasha", "Morozov", "male", 15, 1);

        employeeDAO.addEmployee(employee);


    }
}
