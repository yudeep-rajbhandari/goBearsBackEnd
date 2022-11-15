package com.se.goBears.controller;

import com.se.goBears.entity.Room;
import com.se.goBears.service.Roomservice;
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
    private Roomservice roomservice;

    @PostMapping("/addRoom")
    public ResponseEntity createRoom(@RequestBody Room room){
        try {
            Room room1 = roomservice.createRoom(room);
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
            Room room1 = roomservice.getRoom(id);
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
            List<Room> room1 = roomservice.getAllBookableRoom();
            return new ResponseEntity<>(room1, HttpStatus.OK);
        }
        catch (Exception e){
            Error error = new Error(e.getMessage(), HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
    }
}
