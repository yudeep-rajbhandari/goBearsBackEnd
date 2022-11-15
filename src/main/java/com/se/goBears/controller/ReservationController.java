package com.se.goBears.controller;

import com.se.goBears.entity.Reservations;
import com.se.goBears.entity.Room;
import com.se.goBears.service.RoomReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/reservation")
@CrossOrigin(origins = "http://localhost:3000")
public class ReservationController {

    @Autowired
    private RoomReservationService roomReservationService;

    @PostMapping("/room/{id}")
    public Room reserveRoom(@PathVariable Long id, @RequestBody Reservations reservations ) throws Exception {
       return  roomReservationService.roomReservation(id,reservations);
    }

    @GetMapping("/room")
    public Set<Reservations> getRoomReservation(@RequestParam Long id){
        return roomReservationService.getRoomReservation(id);
    }

    @GetMapping("/byUserId")
    public List<Reservations> getRoomReservationById(@RequestParam Integer id){
        return roomReservationService.getRoomReservationById(id);
    }
}
