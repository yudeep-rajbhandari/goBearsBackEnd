package com.se.goBears.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
@Entity
public class RoomReservation extends Reservations{
    @OneToMany
    private Set<Room> room;
}
