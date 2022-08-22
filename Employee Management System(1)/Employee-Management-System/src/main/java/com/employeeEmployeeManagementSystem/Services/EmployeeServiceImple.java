package com.employeeEmployeeManagementSystem.Services;
import com.employeeEmployeeManagementSystem.Model.Employee;
import com.employeeEmployeeManagementSystem.Model.Organisation;
import com.employeeEmployeeManagementSystem.Repository.EmployeeREPO;
import com.employeeEmployeeManagementSystem.Repository.OrganisationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class EmployeeServiceImple implements EmployeeService {

    @Autowired
    private EmployeeREPO employeeREPO;
    @Autowired
    private OrganisationRepo organisationRepo;

    public EmployeeServiceImple(EmployeeREPO employeeREPO)
    {
        this.employeeREPO=employeeREPO;
    }
    @Override
    public Employee saveEmployee(Employee employee)
    {
        Organisation org=organisationRepo.findById(employee.getOrgId()).orElseThrow();
        employee.setOrganisation(org);
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
        Employee emp=employeeREPO.findById(id).orElseThrow();
        emp.getRoles().clear();
        employeeREPO.deleteById(id);
    }


}
