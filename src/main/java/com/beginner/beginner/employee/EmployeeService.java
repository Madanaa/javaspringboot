package com.beginner.beginner.employee;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(String id);
    Employee updateEmployee(String id, Employee updated);
    void deleteEmployee(String id);
    List<Employee> getEmployeesByDepartment(String department);
}
