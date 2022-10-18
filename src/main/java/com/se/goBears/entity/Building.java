package com.se.goBears.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Data
public class Building implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    @OneToOne
    private Address address;

    private Integer floors;

    private Long latitude;
    private Long longitude;

    @OneToMany
    private Set<Gate> gates;


    @OneToMany
    private Set<Room> rooms;
}
