package com.se.goBears.service;

import com.se.goBears.entity.Reservations;
import com.se.goBears.entity.Room;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class ReservationServiceTest {

    @Autowired
    private RoomReservationService reservationService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private  ResourceReservationService resourceReservationService;

    @Test
    public void reserveRoomTest() throws Exception {
        Room room = new Room();
        room.setName("Test Room");
        room.setIsBookable(true);
        room.setRoomType(Room.RoomType.CLASSROOM);
        Room room1 = roomService.addRoom(room);
        Reservations reservations = new Reservations();
        reservations.setFromDate(new Date().toString());
        reservations.setToDate(new Date().toString());

        Reservations reservations1 = reservationService.saveRoomReservation(reservations, room1.getId());
        Assertions.assertEquals(reservations1.getReserveType(), Reservations.ReserveType.ROOM);
        reservationService.deleteReservationByid(reservations1.getId());
        roomService.deleteroomById(room1.getId());

    }

//    @Test
//    public void reserveResourceTest() throws Exception {
//        Room room = new Room();
//        room.setName("Test Room");
//        room.setIsBookable(true);
//        room.setRoomType(Room.RoomType.CLASSROOM);
//        Room room1 = roomService.addRoom(room);
//        Reservations reservations = new Reservations();
//        reservations.setFromDate(new Date().toString());
//        reservations.setToDate(new Date().toString());
//
//        Reservations reservations1 = resourceReservationService.saveRoomReservation(reservations,room1.getId());
//        Assertions.assertEquals(reservations1.getReserveType(), Reservations.ReserveType.RESOURCE);
//        reservationService.deleteReservationByid(reservations1.getId());
//        roomService.deleteroomById(room1.getId());
//
//    }

}
