package com.beginner.beginner.employee;


import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
    List<Employee> findByDepartment(String department);
}

