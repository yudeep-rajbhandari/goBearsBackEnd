package com.se.goBears.controller;

import com.se.goBears.entity.Reservations;
import com.se.goBears.entity.Room;
import com.se.goBears.service.ReservationService;
import com.se.goBears.service.RoomReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/reservation")
@CrossOrigin(origins = "*")
public class ReservationController {

    @Autowired
    private RoomReservationService roomReservationService;

    @Autowired
    private ReservationService reservationService;

    @PostMapping("/room/{id}")
    public ResponseEntity reserveRoom(@PathVariable Long id, @RequestBody Reservations reservations ) throws Exception {
        try{
            Room room = roomReservationService.roomReservation(id,reservations);
            return new ResponseEntity<>(room, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(new Error(e.getMessage()), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/room")
    public Set<Reservations> getRoomReservation(@RequestParam Long id){
        return roomReservationService.getRoomReservation(id);
    }

    @GetMapping("/byUserId")
    public List<Reservations> getRoomReservationById(@RequestParam Integer id){
        return roomReservationService.getRoomReservationById(id);
    }



    @GetMapping("/getAllRoomReservation")
    public List<Reservations> getAllRoomReservation(){
        return roomReservationService.getAllRoomReservation();
    }

    @PutMapping("/acceptRoomReservation/{id}")
    public Reservations acceptRoomReservation(@PathVariable Long id){
        return roomReservationService.acceptRoomReservation(id);
    }
    @PutMapping("/declineRoomReservation/{id}")
    public Reservations declineRoomReservation(@PathVariable Long id){
        return roomReservationService.declineRoomReservation(id);
    }
    @PutMapping("/archiveRoomReservation/{id}")
    public Reservations archiveRoomReservation(@PathVariable Long id){
        return roomReservationService.archiveRoomReservation(id);
    }

    @GetMapping("/getMyReservation/{userId}")
    public List<Reservations> getMyReservation(@PathVariable Long userId){
        return reservationService.getMyReservation(userId);
    }

    @PutMapping("/cancelReservation/{id}")
    public Reservations cancelReservation(@PathVariable Long id){
        return reservationService.cancelReservation(id);
    }

}
