package com.employeeEmployeeManagementSystem.Controler;


import com.employeeEmployeeManagementSystem.Model.Employee;
import com.employeeEmployeeManagementSystem.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/emp")
public class EmployeeCntrlr {

    @Autowired
    private EmployeeService employeeService;
    public EmployeeCntrlr(EmployeeService employeeService)
    {
        this.employeeService=employeeService;
    }
    @PostMapping
    public ResponseEntity<String> saveEmployee(@RequestBody Employee employee)
    {
        if(employee.getPassword().length()>0&&employee.getPassword().length()>0&&employee.getEmpName().length()>0&&employee.getPassword().length()>0&&employee.getEmpAddres().length()>0&&employee.getEmail().length()>0&&String.valueOf(employee.getEmpSalary()).length()>0)
            if(String.valueOf(employee.getEmpSalary()).length()>=5){
                if(employee.getPassword().length()>4){
                    if(employee.getEmail().contains("@")&&employee.getEmail().contains(".com")) {
                        Employee emp1 = employeeService.saveEmployee(employee);
                        if (emp1 == null) {
                            return new ResponseEntity<>("Employee Already Exist", HttpStatus.BAD_REQUEST);
                        } else {
                            return new ResponseEntity<String>("Employee added Successfully", HttpStatus.CREATED);
                        }
                    }else {
                        return new ResponseEntity<>("Invalid email id,Try with proper email format.",HttpStatus.BAD_REQUEST);
                    }
                }else {
                    return new ResponseEntity<>("Invalid, password should be greater than 4 character.",HttpStatus.BAD_REQUEST);
                }
            }else {
                return new ResponseEntity<>("Salary can not be less than 10000.",HttpStatus.BAD_REQUEST);
            }
        else {
            return new ResponseEntity<>("Empty Details cannot be Created , Please Enter the Details",HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity< List<Employee>> getAllEmployee(){
        List<Employee> employee =employeeService.getAllEmployee();
        if(employee.size()>0){
            return new ResponseEntity<>(employee,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }
    @GetMapping("/login/{id}")
    public ResponseEntity<Employee>getEmployeeById(@PathVariable("id")int id)
    {
        try {
            return new ResponseEntity<Employee>(employeeService.getEmployeeById(id),HttpStatus.OK);
        }
        catch (NoSuchElementException e)
        {
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/updateBYID/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable("id")int id, @RequestBody Employee employee)
    {
        try {
            if(employee.getPassword().length()>6&&employee.getEmpName().length()>0&&employee.getEmpAddres().length()>0&&employee.getEmail().length()>0&&!employee.getPassword().contains("-")&&employee.getEmpSalary()>=10000) {
                employeeService.updateEmployee(employee, id);
                return new ResponseEntity<String>("Employee's details updated Successfully", HttpStatus.OK);
            }
            else
            {
                return new ResponseEntity<String>("Enter valid details",HttpStatus.BAD_REQUEST);
            }
        }
        catch (NoSuchElementException e)
        {

            return new ResponseEntity<String>("Employee's details not found", HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/deleteBYID/{id}")
    public ResponseEntity<String>deleteEmployee(@PathVariable("id")int id)
    {
        try {

            employeeService.deleteEmployee(id);
            return new ResponseEntity<String>("Employee has been deleted",HttpStatus.OK);
        }
        catch (NoSuchElementException e)
        {

            return new ResponseEntity<String>("Employee is not found",HttpStatus.NOT_FOUND);
        }
    }

}
