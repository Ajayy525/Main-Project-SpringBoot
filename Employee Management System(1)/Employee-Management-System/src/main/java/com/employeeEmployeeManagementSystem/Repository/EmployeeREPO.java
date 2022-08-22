package com.employeeEmployeeManagementSystem.Repository;

import com.employeeEmployeeManagementSystem.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeREPO extends JpaRepository<Employee,Integer> {
    Optional<Employee> findByEmail(String Email);
}

