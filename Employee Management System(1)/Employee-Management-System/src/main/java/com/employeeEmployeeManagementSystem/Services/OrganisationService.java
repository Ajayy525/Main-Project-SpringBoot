package com.employeeEmployeeManagementSystem.Services;

import com.employeeEmployeeManagementSystem.Model.Organisation;

import java.util.List;

public interface OrganisationService {
    Organisation saveOrganisation(Organisation organisation);

    List<Organisation> getAllOrganisation();

    Organisation updateOrganisation(Organisation organisation, int id);

    Organisation getOrganisationById(int id);

    void deleteOrganisation(int id);
}
