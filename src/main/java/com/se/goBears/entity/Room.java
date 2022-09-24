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
    private String roomNumber;
    private boolean isBookable;

    @ManyToOne
    private RoomReservation roomReservation;

    @ManyToOne
    private Building building;

    @OneToMany
    private Set<Schedule> schedule;

   @OneToOne
    private Direction direction;

    private Long latitude;
    private Long Longitude;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private enum RoomType{
        classroom,staffroom,lab,washroom
    }
}
