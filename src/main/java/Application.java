import dao.EmployeeDAO;
import dao.EmployeeDAOJdbc;
import pojo.City;
import pojo.Employee;

import java.sql.*;

public class Application {
    public static void main(String[] args) throws SQLException {
        final String url = "jdbc:postgresql://localhost:5432/skypro";
        final String user = "postgres";
        final String password = "270606";

        /*String query = "SELECT * FROM employee WHERE id=1";
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

        try(Connection connection = DriverManager.getConnection(url,user,password)){
                EmployeeDAO employeeDAO = new EmployeeDAOJdbc(connection);
                employeeDAO.addEmployee(new Employee(5, "Evgeniy", "Vorobiev", "male", 65, new City(6, "Barcelona")));
            System.out.println(employeeDAO.getEmployeeById(1));
            System.out.println(employeeDAO.getEmployeeById(5));
        }


    }
}
