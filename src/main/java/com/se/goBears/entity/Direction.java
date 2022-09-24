package com.se.goBears.entity;

import lombok.Data;

import javax.persistence.*;


public class Direction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String description;


    private Room room;
}
