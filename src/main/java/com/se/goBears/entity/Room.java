package com.se.goBears.entity;



import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


/**
 * This entity class defines the methods and variables for the Room Role.
 */
@Entity
public class Room implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private RoomType roomType;
    private boolean isBookable;

    private Integer floor;

    @OneToMany(targetEntity = Reservations.class, cascade = CascadeType.ALL)
    private Set<Reservations> roomReservation = new HashSet<>();

    @ManyToOne
    private Building building;
    @OneToMany
    private Set<User> users = new HashSet<>();

    private Long latitude;
    private Long longitude;


    public enum RoomType{
        CLASSROOM, STAFFROOM, LAB, WASHROOM
    }

    public void setBookable(boolean bookable) {
        isBookable = bookable;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public boolean isBookable() {
        return isBookable;
    }

    public void setIsBookable(boolean isBookable) {
        this.isBookable = isBookable;
    }

    public Set<Reservations> getRoomReservation() {
        return roomReservation;
    }

    public void setRoomReservation(Set<Reservations> roomReservation) {
        this.roomReservation = roomReservation;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Long getLatitude() {
        return latitude;
    }

    public void setLatitude(Long latitude) {
        this.latitude = latitude;
    }

    public Long getLongitude() {
        return longitude;
    }

    public void setLongitude(Long longitude) {
        this.longitude = longitude;
    }
}
