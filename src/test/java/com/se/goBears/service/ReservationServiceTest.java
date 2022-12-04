package com.se.goBears.service;

import com.se.goBears.entity.Reservations;
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
    private  ResourceReservationService resourceReservationService;

    @Test
    public void reserveRoomTest(){
        Reservations reservations = new Reservations();
        reservations.setFromDate(new Date().toString());
        reservations.setToDate(new Date().toString());

        Reservations reservations1 = reservationService.saveRoomReservation(reservations,Long.valueOf(23));
        Assertions.assertEquals(reservations1.getReserveType(), Reservations.ReserveType.ROOM);
        reservationService.deleteReservationByid(reservations1.getId());

    }

    @Test
    public void reserveResourceTest(){
        Reservations reservations = new Reservations();
        reservations.setFromDate(new Date().toString());
        reservations.setToDate(new Date().toString());

        Reservations reservations1 = resourceReservationService.saveRoomReservation(reservations,Long.valueOf(23));
        Assertions.assertEquals(reservations1.getReserveType(), Reservations.ReserveType.RESOURCE);
        reservationService.deleteReservationByid(reservations1.getId());

    }

}
