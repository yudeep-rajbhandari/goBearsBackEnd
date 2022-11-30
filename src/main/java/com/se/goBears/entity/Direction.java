package com.se.goBears.entity;

import javax.persistence.*;


public class Direction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;


    @OneToOne
    private Room room;
}
