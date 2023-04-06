package dao;

import pojo.Employee;

import java.util.List;

public interface EmployeeDAO {

    void addEmployee(Employee employee);

    Employee getEmployeeById(int id);

    List<Employee> getAll();

    void changeEmployeeById(int id, Employee employee);

    void deleteEmployeeById(Employee employee);
}
