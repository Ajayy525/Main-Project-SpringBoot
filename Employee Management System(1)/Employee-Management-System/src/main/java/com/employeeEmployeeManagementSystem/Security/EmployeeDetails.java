package com.employeeEmployeeManagementSystem.Security;


import com.employeeEmployeeManagementSystem.Model.Employee;
import com.employeeEmployeeManagementSystem.Repository.EmployeeREPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class EmployeeDetails implements UserDetailsService {
    @Autowired
    private EmployeeREPO employeeREPO;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Employee detail=this.employeeREPO.findByEmail(username).orElseThrow();
        return detail;
    }

}
