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
    private Long latitude;
    private Long longitude;
    @OneToMany
    private Set<Gate> gates;
    @OneToMany
    private Set<Room> rooms;

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Address getAddress() {
//        return address;
//    }
//
//    public void setAddress(Address address) {
//        this.address = address;
//    }
//
//    public Integer getFloors() {
//        return floors;
//    }
//
//    public void setFloors(Integer floors) {
//        this.floors = floors;
//    }
//
//    public Long getLatitude() {
//        return latitude;
//    }
//
//    public void setLatitude(Long latitude) {
//        this.latitude = latitude;
//    }
//
//    public Long getLongitude() {
//        return longitude;
//    }
//
//    public void setLongitude(Long longitude) {
//        this.longitude = longitude;
//    }
//
//    public Set<Gate> getGates() {
//        return gates;
//    }
//
//    public void setGates(Set<Gate> gates) {
//        this.gates = gates;
//    }
//
//    public Set<Room> getRooms() {
//        return rooms;
//    }
//
//    public void setRooms(Set<Room> rooms) {
//        this.rooms = rooms;
//    }
}
