package com.employeeEmployeeManagementSystem.Services;

import com.employeeEmployeeManagementSystem.Model.Employee;
import com.employeeEmployeeManagementSystem.Repository.EmployeeREPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class SecurityContextImpl implements SecurityContext{
    @Autowired
    EmployeeREPO employeeREPO;


    @Override
    public Employee getEmployeeData() {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            return employeeREPO.findById(
                    ((Employee) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId()
            ).orElseThrow();
        } else {
            return null;
        }
    }


}
