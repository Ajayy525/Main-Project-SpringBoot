package com.employeeEmployeeManagementSystem.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Assets {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @Column(nullable = false)
    String equipment;
    @Column(nullable = false)
    String computer;
    @Column(nullable = false)
    String productdesign;

}
