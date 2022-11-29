package com.se.goBears.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
public class Building implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @OneToOne
    private Address address;

    private Integer floors;

    private Double latitude;

    private Double longitude;

    @OneToMany
    private Set<Gate> gate;

    @OneToMany
    private Set<Room> rooms;

}
