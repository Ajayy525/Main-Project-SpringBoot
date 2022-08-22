package com.employeeEmployeeManagementSystem.Controler;

import com.employeeEmployeeManagementSystem.Model.Organisation;
import com.employeeEmployeeManagementSystem.Services.OrganisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/orgn")
public class OrganisationControler {
    @Autowired
    private OrganisationService organisationService;
    public OrganisationControler(OrganisationService organisationService)
    {
        this.organisationService=organisationService;
    }
    @PostMapping
    public ResponseEntity<String> saveOrganisation(@RequestBody Organisation organisation)
    {
        if(organisation.getOrgName().length()>0&&organisation.getOrgName().length()>0&&organisation.getOrgnCategories().length()>0&&organisation.getEmail().length()>0) {
            Organisation org = organisationService.saveOrganisation(organisation);
            if (org == null) {
                return new ResponseEntity<>("Organisation Already Exist", HttpStatus.BAD_REQUEST);
            } else {
                return new ResponseEntity<String>("Organisation added Successfully", HttpStatus.CREATED);
            }
        }else {
            return new ResponseEntity<>("Invalid Data",HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public List<Organisation> getAllOrganisation()
    {
        return organisationService.getAllOrganisation();
    }
    @GetMapping("/getBYID/{id}")
    public ResponseEntity<Organisation>getOrganisationById(@PathVariable("id")int id)
    {
        return new ResponseEntity<Organisation>(organisationService.getOrganisationById(id),HttpStatus.OK);
    }
    @PutMapping("/updateBYID/{id}")
    public ResponseEntity<String> updateOrganisation(@PathVariable("id") int id, @RequestBody Organisation organisation) {
        try {

            organisationService.updateOrganisation(organisation, id);
            return new ResponseEntity<String>("Organisation's details updated Successfully", HttpStatus.OK);
        } catch (NoSuchElementException e) {

            return new ResponseEntity<String>("Organisation's details not found", HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteOrganisation(@PathVariable("id") int id)
    {
        organisationService.deleteOrganisation(id);
        return new ResponseEntity<String>("**** Organisation deleted successfully ****",HttpStatus.OK);
    }



}