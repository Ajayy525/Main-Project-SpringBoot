package com.employeeEmployeeManagementSystem.Model;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_name",nullable = false)
    private String name;

}
