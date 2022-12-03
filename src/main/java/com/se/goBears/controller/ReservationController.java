package com.se.goBears.controller;

import com.se.goBears.entity.Reservations;
import com.se.goBears.entity.Room;
import com.se.goBears.service.ReservationService;
import com.se.goBears.service.ResourceReservationService;
import com.se.goBears.service.RoomReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Set;

/**
 * This controller class handles the API requests for room reservations. It handles request to reserve a room, get all
 * reservation for a room, get all reservation by a user, get all reservations information and cancel a reservation.
 * Admin request for reservation acceptance, decline and archive are also handled by the controller.
 */
@RestController
@RequestMapping("/api/reservation")
@CrossOrigin(origins = "*")
public class ReservationController {

    @Autowired
    private RoomReservationService roomReservationService;

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private ResourceReservationService resourceReservationService;

    /**
     * This method accepts a room id and a reservation body and creates the requested reservation if all the dates
     * criteria are matched.
     *
     * @param id           is the id of the room to be associated to the reservation.
     * @param reservations is the request reservation to be created for the room.
     * @return room object with associated reservation details.
     * @throws Exception if a reservation conflict occurs.
     * @see RoomReservationService
     */
    @PostMapping("/room/{id}")
    public ResponseEntity reserveRoom(@PathVariable Long id, @RequestBody Reservations reservations) throws Exception {
        try {
            Room room = roomReservationService.roomReservation(id, reservations);
            return new ResponseEntity<>(room, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new Error(e.getMessage()), HttpStatus.BAD_REQUEST);
        }

    }

    /**
     * This method takes a room id and returns a set of reservations associated with the room.
     *
     * @param id is the room id.
     * @return a set of reservations associated with the room.
     * @see RoomReservationService
     */
    @GetMapping("/room")
    public Set<Reservations> getRoomReservation(@RequestParam Long id) {
        return roomReservationService.getRoomReservation(id);
    }

    /**
     * This method takes a user id as an input and generates all reservations associated with the user.
     *
     * @param id is the id of the user to generate associated reservations.
     * @return a list of reservation associated to the user.
     */
    @GetMapping("/byUserId")
    public List<Reservations> getRoomReservationById(@RequestParam Integer id) {
        return roomReservationService.getRoomReservationById(id);
    }


    /**
     * This method returns all the reservations.
     *
     * @return a list of all reservations.
     */
    @GetMapping("/getAllRoomReservation")
    public List<Reservations> getAllRoomReservation() {
        return roomReservationService.getAllRoomReservation();
    }

    /**
     * This method takes a reservation id as input and alters the reservation status to APPROVED.
     *
     * @param id is the id of the reservation.
     * @return the updated reservation object.
     */
    @PutMapping("/acceptRoomReservation/{id}")
    public Reservations acceptRoomReservation(@PathVariable Long id) {
        return roomReservationService.acceptRoomReservation(id);
    }

    /**
     * This method takes a reservation id as input and alters the reservation status to DECLINED.
     *
     * @param id is the id of the reservation.
     * @return the updated reservation object.
     */
    @PutMapping("/declineRoomReservation/{id}")
    public Reservations declineRoomReservation(@PathVariable Long id) {
        return roomReservationService.declineRoomReservation(id);
    }

    /**
     * This method takes a reservation id as input and alters the reservation status to ARCHIVED.
     *
     * @param id is the id of the reservation.
     * @return the updated reservation object.
     */
    @PutMapping("/archiveRoomReservation/{id}")
    public Reservations archiveRoomReservation(@PathVariable Long id) {
        return roomReservationService.archiveRoomReservation(id);
    }

    /**
     * This method returns all the reservations associated with a user.
     *
     * @param userId is the id of the user.
     * @return a list of reservations associated with the user.
     * @see ReservationService
     */
    @GetMapping("/getMyReservation/{userId}")
    public List<Reservations> getMyReservation(@PathVariable Long userId) {
        return reservationService.getMyReservation(userId);
    }

    /**
     * This method takes a reservation id as input and alters the reservation status to CANCELED.
     *
     * @param id is the id of the reservation.
     * @return the updated reservation object.
     */
    @PutMapping("/cancelReservation/{id}")
    public Reservations cancelReservation(@PathVariable Long id) {
        return reservationService.cancelReservation(id);
    }


    @PostMapping("/resource/{id}")
    public Reservations reserveResource(@PathVariable Long id, @RequestBody Reservations reservations) throws Exception {
        return resourceReservationService.resourceReservation(id,reservations);
    }

}
