package dao;

import pojo.Employee;

import java.util.List;

public interface EmployeeDAO {

    void addEmployee(Employee employee);

    Employee getEmployeeById(int id);

    List<Employee> getAll();

    Employee updateEmployee(Employee employee);

    void deleteEmployee(Employee employee);
}
