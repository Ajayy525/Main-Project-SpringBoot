package com.employeeEmployeeManagementSystem.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

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

    @JsonManagedReference
    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(mappedBy = "organisation", cascade = CascadeType.ALL)
    private List<Employee> employees;

    @JsonManagedReference
    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(mappedBy = "organisation", cascade = CascadeType.ALL)
    private List<Assets> assets;



}
