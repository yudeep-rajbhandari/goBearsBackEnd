package com.se.goBears.service;

//import com.se.goBears.dao.ResourceDao;
import com.se.goBears.entity.Building;
import com.se.goBears.repository.RoomRepository;
//import com.se.goBears.entity.Resource;
import com.se.goBears.entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;
import java.util.Optional;

@Service
public class Roomservice {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private BuildingService buildingService;

//    @Autowired
//    private ResourceDao resourceDao;

    public Room getRoomByName(String name){
        return roomRepository.findRoomByName(name);
    }

    public Room createRoom(Room room) throws Exception {

        if(checkIfAlreadyExists(room.getName())){
            throw new Exception("Same room name exists");

        }
        return roomRepository.save(room);
    }


    public boolean checkIfAlreadyExists(String roomName){
        Room room = roomRepository.findRoomByName(roomName);
        return room !=null;
    }
    public Room getRoom(long id) throws Exception {
        Optional<Room> room = roomRepository.findById(id);
        if(room.isPresent()){
            return room.get();
        }
        else {
            throw  new Exception("Cannot find room");
        }
    }


    public Room addRoom(Room room) throws Exception{
        if(checkIfAlreadyExists(room.getName())){
            throw new Exception("Same room name exists");
        }
        return roomRepository.save(room);

    }


   public List<Room> findAllRoom(){
        return roomRepository.findAll();
   }


   public Room updateRoom(Room room){
        Room updateRoom = roomRepository.findRoomById(room.getId());
       updateRoom.setName(room.getName());
       updateRoom.setRoomType(room.getRoomType());
       updateRoom.setIsBookable(room.isBookable());
       return roomRepository.save(updateRoom);
   }

}
