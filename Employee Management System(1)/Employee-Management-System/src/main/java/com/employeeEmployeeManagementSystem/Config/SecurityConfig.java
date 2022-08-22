package com.employeeEmployeeManagementSystem.Config;

import com.employeeEmployeeManagementSystem.Security.EmployeeDetails;
import org.apache.catalina.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authorization.AuthenticatedAuthorizationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private EmployeeDetails employeeDetails;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()

                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/orgn").hasAnyAuthority("Admin","Manager","Employee")
                .antMatchers(HttpMethod.PUT, "/api/orgn").hasAnyAuthority("Admin","Manager")
                .antMatchers(HttpMethod.POST, "/api/orgn").hasAnyAuthority("Admin")
                .antMatchers(HttpMethod.DELETE,"/api/Orgn/**").hasAnyAuthority("Admin")

                .antMatchers(HttpMethod.GET, "/api/emp/**").hasAnyAuthority("Admin", "Manager")
                .antMatchers(HttpMethod.PUT, "/api/emp/**").hasAnyAuthority("Admin","Manager")
                .antMatchers(HttpMethod.DELETE, "/api/emp/**").hasAnyAuthority("Admin")
                .antMatchers(HttpMethod.POST, "/api/emp/**").hasAnyAuthority("Admin")

                .antMatchers(HttpMethod.GET, "/api/assets/**").hasAnyAuthority("Admin","Manager","Employee")
                .antMatchers(HttpMethod.PUT, "/api/assets").hasAnyAuthority("Admin","Manager")
                .antMatchers(HttpMethod.DELETE, "/api/assets").hasAnyAuthority("Admin")
                .antMatchers(HttpMethod.POST, "/api/assets").hasAnyAuthority("Admin")
                .and().httpBasic();
        http.csrf().disable();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(this.employeeDetails).passwordEncoder(passwordEncoder());


    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    

}
