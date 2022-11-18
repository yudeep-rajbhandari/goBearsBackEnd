package com.se.goBears.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Gate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private Long latitude;

    private long longitude;

    private CardinalDirection cardinalDirection;

    @OneToOne
    private Building building;



    private enum CardinalDirection{
        North,South,East,West
    }
}
