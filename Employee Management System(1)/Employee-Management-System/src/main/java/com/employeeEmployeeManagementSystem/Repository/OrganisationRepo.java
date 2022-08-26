package com.employeeEmployeeManagementSystem.Repository;

import com.employeeEmployeeManagementSystem.Model.Organisation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganisationRepo extends JpaRepository<Organisation,Integer > {
}
