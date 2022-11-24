package com.se.goBears.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Resource implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String resourceName;
    private ResourceType resourceType;
    private WorkingCondition workingCondition;


    public enum ResourceType {
        INDOOR,
        OUTDOOR
    };

    public enum WorkingCondition {
        EXCELLENT,
        GOOD,
        FAIR
    };

    @ManyToOne
    private Room room;


    @OneToMany
    private Set<Reservations> roomReservations;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Set<Reservations> getRoomReservations() {
        return roomReservations;
    }

    public void setRoomReservations(Set<Reservations> roomReservations) {
        this.roomReservations = roomReservations;
    }

    public ResourceType getResourceType() {
        return resourceType;
    }

    public void setResourceType(ResourceType resourceType) {
        this.resourceType = resourceType;
    }

    public WorkingCondition getWorkingCondition() {
        return workingCondition;
    }

    public void setWorkingCondition(WorkingCondition workingCondition) {
        this.workingCondition = workingCondition;
    }

    public Resource() {
    }


}