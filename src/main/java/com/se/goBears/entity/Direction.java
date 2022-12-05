package com.se.goBears.entity;

import javax.persistence.*;


/**
 * This entity class defines the methods and variables for the entity Direction.
 */
public class Direction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;


    @OneToOne
    private Room room;
}
