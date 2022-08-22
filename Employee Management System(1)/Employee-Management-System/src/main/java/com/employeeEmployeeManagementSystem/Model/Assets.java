package com.employeeEmployeeManagementSystem.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Assets {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    private String equipment;
    @Column(nullable = false)
    private String computer;
    @Column(nullable = false)
    private String productdesign;
    @JsonBackReference
    @ManyToOne
    @JoinColumn
    private Organisation organisation;





}
