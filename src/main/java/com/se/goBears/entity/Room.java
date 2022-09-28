package com.se.goBears.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private RoomType roomType;
    private boolean isBookable;



    @ManyToOne
    private RoomReservation roomReservation;

    @ManyToOne
    private Building building;

    @OneToMany
    private Set<Schedule> schedule;

//    @OneToMany
//    private Set<Resource> resources;


    @OneToMany
    private Set<User> users;
//
//   @OneToOne
//    private Direction direction;

    private Long latitude;
    private Long Longitude;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public enum RoomType{
        classroom,staffroom,lab,washroom
    }
}
