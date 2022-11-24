
        package com.se.goBears.controller;

import com.se.goBears.entity.Room;
import com.se.goBears.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.se.goBears.entity.Error;

import java.util.List;

@RestController
@RequestMapping("/api/room")
@CrossOrigin(origins = "http://localhost:3000")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @PostMapping("/addRoom")
    public ResponseEntity createRoom(@RequestBody Room room){
        try {
            Room room1 = roomService.createRoom(room);
            return new ResponseEntity<>(room1, HttpStatus.OK);
        }
        catch (Exception e){
            Error error = new Error(e.getMessage(), HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity createRoom(@PathVariable long id){
        try {
            Room room1 = roomService.getRoom(id);
            return new ResponseEntity<>(room1, HttpStatus.OK);
        }
        catch (Exception e){
            Error error = new Error(e.getMessage(), HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/all/bookable")
    public ResponseEntity getRoom(){
        try {
            List<Room> room1 = roomService.getAllBookableRoom();
            return new ResponseEntity<>(room1, HttpStatus.OK);
        }
        catch (Exception e){
            Error error = new Error(e.getMessage(), HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/addRoom2")
    public Room addRoom(@RequestBody Room room) throws Exception {
        return roomService.addRoom(room);
    }

    @GetMapping("/findAllRoom")
    public List<Room> findAllRoom(){
        return roomService.findAllRoom();
    }

    @PutMapping("/updateRoom")
    public Room updateRoom(@RequestBody Room room){
        return roomService.updateRoom(room);
    }

    @GetMapping("/findAllClassRoom")
    public List<Room> findAllClassRoomByBuilding(@RequestParam Long buildlingId){
        return roomService.getAllClassRoomByBuilding(buildlingId);
    }

    @GetMapping("/findAllByBuildingId/{buildingId}")
    public List<Room> findAllByBuildingId(@PathVariable Long buildingId){
        return roomService.findAllByBuildingId(buildingId);
    }
}