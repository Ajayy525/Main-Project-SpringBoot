package com.employeeEmployeeManagementSystem.Services;
import com.employeeEmployeeManagementSystem.Model.Employee;
import com.employeeEmployeeManagementSystem.Repository.EmployeeREPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class EmployeeServiceImple implements EmployeeService {

    @Autowired
    private EmployeeREPO employeeREPO;
    public EmployeeServiceImple(EmployeeREPO employeeREPO)
    {
        this.employeeREPO=employeeREPO;
    }
    @Override
    public Employee saveEmployee(Employee employee)
    {
        return employeeREPO.save(employee);
    }
    @Override
    public List<Employee>getAllEmployee()
    {
        return employeeREPO.findAll();
    }


    @Override
    public Employee getEmployeeById(int id) {
        return employeeREPO.findById(id).orElseThrow();
    }

    @Override
    public Employee updateEmployee(Employee employee,int id)
    {
        Employee existingEmployee =employeeREPO.findById(id).orElseThrow();
        existingEmployee.setEmpName(employee.getEmpName());
        existingEmployee.setEmpAddres(employee.getEmpAddres());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setEmpSalary(employee.getEmpSalary());
        existingEmployee.setPassword(employee.getPassword());
        employeeREPO.save(existingEmployee);
        return existingEmployee;
    }
    @Override
    public void deleteEmployee(int id)
    {
        employeeREPO.findById(id).orElseThrow();
        employeeREPO.deleteById(id);
    }


}
