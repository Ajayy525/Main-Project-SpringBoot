package com.employeeEmployeeManagementSystem.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Organisation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orgid;
    @Column(nullable = false)
    private String orgName;
    @Column(nullable = false)
    private String orgnCategories;
    @Column(nullable = false)
    private String email;

}
