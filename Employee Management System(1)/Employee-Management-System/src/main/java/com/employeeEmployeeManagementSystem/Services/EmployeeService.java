package com.employeeEmployeeManagementSystem.Services;

import com.employeeEmployeeManagementSystem.Model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    List<Employee> getAllEmployee();

    Employee getEmployeeById(int id);

    Employee updateEmployee(Employee employee, int id);

    void deleteEmployee(int id);
}
