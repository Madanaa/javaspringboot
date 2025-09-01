package com.beginner.beginner.employee;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repo;

    public EmployeeServiceImpl(EmployeeRepository repo) {
        this.repo = repo;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return repo.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return repo.findAll();
    }

    @Override
    public Employee getEmployeeById(String id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Employee updateEmployee(String id, Employee updated) {
        return repo.findById(id)
                .map(emp -> {
                    emp.setName(updated.getName());
                    emp.setEmail(updated.getEmail());
                    emp.setDepartment(updated.getDepartment());
                    emp.setSalary(updated.getSalary());
                    return repo.save(emp);
                })
                .orElse(null);
    }

    @Override
    public void deleteEmployee(String id) {
        repo.deleteById(id);
    }

    @Override
    public List<Employee> getEmployeesByDepartment(String department) {
        return repo.findByDepartment(department);
    }
}

