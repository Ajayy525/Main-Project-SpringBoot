package com.employeeEmployeeManagementSystem.Services;


import com.employeeEmployeeManagementSystem.Model.Organisation;
import com.employeeEmployeeManagementSystem.Repository.OrganisationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganisationServiceImpl implements OrganisationService {

    @Autowired

    private OrganisationRepo organisationRepo;
    public OrganisationServiceImpl(OrganisationRepo organisationRepo)
    {
        this.organisationRepo=organisationRepo;
    }
    @Override
    public Organisation saveOrganisation(Organisation organisation)
    {
        return organisationRepo.save(organisation);
    }
    @Override
    public List<Organisation> getAllOrganisation()
    {
        return organisationRepo.findAll();
    }

    @Override
    public Organisation getOrganisationById(int id) {
        return organisationRepo.findById(id).orElseThrow();
    }

    @Override
    public void deleteOrganisation(int id) {
        organisationRepo.findById(id).orElseThrow();
        organisationRepo.deleteById(id);

    }

    @Override
    public Organisation updateOrganisation(Organisation organisation,int id)
    {
        Organisation existingOrganisation =organisationRepo.findById(id).orElseThrow();
        existingOrganisation.setOrgName(organisation.getOrgName());
        existingOrganisation.setOrgnCategories(organisation.getOrgnCategories());
        existingOrganisation.setEmail(organisation.getEmail());
        organisationRepo.save(existingOrganisation);
        return existingOrganisation;
    }


}
