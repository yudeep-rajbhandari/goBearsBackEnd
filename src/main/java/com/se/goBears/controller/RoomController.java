
package com.se.goBears.controller;

import com.se.goBears.entity.Building;
import com.se.goBears.entity.Room;
import com.se.goBears.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.se.goBears.entity.Error;

import java.util.List;

/**
 * This controller class handles API requests for room creation, assignment of a room to a building, update room
 * status and provide all related room information.
 */
@RestController
@RequestMapping("/api/room")
@CrossOrigin(origins = "*")
public class RoomController {
    @Autowired
    private RoomService roomService;

    /**
     * This method handles the creation of a room object. Given room body as an input and if no other room with
     * the same name exists the room is created.
     * @param room is the request body sent to be created.
     * @return the created object room.
     * @throws Exception if a room with the given room name already exists.
     */
    @PostMapping("/addRoom")
    public ResponseEntity createRoom(@RequestBody Room room) {
        try {
            Room room1 = roomService.createRoom(room);
            return new ResponseEntity<>(room1, HttpStatus.OK);
        } catch (Exception e) {
            Error error = new Error(e.getMessage(), HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * The method takes a room id as an input and returns the room record if it exists.
     * @param id is the id of the room.
     * @return a room object if it exists.
     * @throws Exception if no value is present.
     */
    @GetMapping("/{id}")
    public ResponseEntity createRoom(@PathVariable long id) {
        try {
            Room room1 = roomService.getRoom(id);
            return new ResponseEntity<>(room1, HttpStatus.OK);
        } catch (Exception e) {
            Error error = new Error(e.getMessage(), HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * This methods returns a list of all bookable rooms.
     * @return list of all bookable rooms.
     * @see RoomService
     */
    @GetMapping("/all/bookable")
    public ResponseEntity getRoom() {
        try {
            List<Room> room1 = roomService.getAllBookableRoom();
            return new ResponseEntity<>(room1, HttpStatus.OK);
        } catch (Exception e) {
            Error error = new Error(e.getMessage(), HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * This method takes a room as input and save it to repository if it does not exist.
     * @param room is the room object body.
     * @return saved room object body.
     * @throws Exception if a room with the given name already exists.
     */
    @PostMapping("/addRoom2")
    public Room addRoom(@RequestBody Room room) throws Exception {
        return roomService.addRoom(room);
    }

    /**
     * This method returns a list of room that has a building assigned to it.
     * @return a list of room.
     */
    @GetMapping("/findAllRoom")
    public List<Room> findAllRoom() {
        return roomService.findAllRoom();
    }

    /**
     * This method takes a room object as input and updates the existing room record.
     * @param room is the room object with the updated information.
     * @return the updated room object.
     */
    @PutMapping("/updateRoom")
    public Room updateRoom(@RequestBody Room room) {
        return roomService.updateRoom(room);
    }

    /**
     * The method takes a building id as an input and returns back a list of room whose room type has been
     * designated as a classroom.
     * @param buildlingId is the id of the building.
     * @return a list of room designated as classroom.
     */
    @GetMapping("/findAllClassRoom")
    public List<Room> findAllClassRoomByBuilding(@RequestParam Long buildlingId) {
        return roomService.getAllClassRoomByBuilding(buildlingId);
    }

    /**
     * This method takes a building Id as an input and returns a list of room associated with it.
     * @param buildingId is the id of the building.
     * @return a list of rooms in the building.
     */
    @GetMapping("/findAllByBuildingId/{buildingId}")
    public List<Room> findAllByBuildingId(@PathVariable Long buildingId) {
        return roomService.findAllByBuildingId(buildingId);
    }


    /**
     * This method returns a list of room where the bookable status for a room is true.
     * @return a list of all bookable rooms.
     */
    @GetMapping("/allBookableRoom")
    public List<Room> findAllBookableRoom() {
        return roomService.findAllBookableRoom();
    }


    /**
     * The method returns a count of total number of rooms.
     * @return an integer with a count of total number of rooms.
     */
    @GetMapping("/getRoomCount")
    public Integer getRoomCount() {
        return roomService.getRoomCount();
    }

    /**
     * This method takes a building Id as an input and returns a list of room associated with it.
     * @param buildingId is the id of the building.
     * @return a list of rooms in the building.
     */
    @GetMapping("/getRoomByBuildingId/{buildingId}")
    public List<Room> getRoomByBuildingId(@PathVariable Long buildingId) {
        return roomService.getRoomByBuildingId(buildingId);
    }


    /**
     * This method takes a building id as input and returns a list of room in the building where the bookable
     * status for the room is true.
     * @param buildingId is the id of the building.
     * @return a list of bookable room in the building.
     */
    @GetMapping("/getBookableRoomByBuilding/{buildingId}")
    public List<Room> getBookableRoomByBuilding(@PathVariable Long buildingId) {
        return roomService.getBookableRoomByBuilding(buildingId);
    }

    /**
     * This method takes a room id as input and return the room object associated with it.
     * @param roomId is the id of the room.
     * @return a room object associated with the room id.
     */
    @GetMapping("/getRoomById/{roomId}")
    public Room getRoomById(@PathVariable Long roomId) {
        return roomService.findRoomById(roomId);
    }
}
