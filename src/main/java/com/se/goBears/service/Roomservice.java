package com.se.goBears.service;

//import com.se.goBears.dao.ResourceDao;
import com.se.goBears.dao.RoomDao;
import com.se.goBears.entity.Building;
import com.se.goBears.entity.Building;
import com.se.goBears.repository.RoomRepository;
//import com.se.goBears.entity.Resource;
import com.se.goBears.entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.awt.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class Roomservice {

    @Autowired
    private RoomDao roomDao;

    @Autowired
    private BuildingService buildingService;

//    @Autowired
//    private ResourceDao resourceDao;

    public Room getRoomByName(String name){
        return roomDao.findRoomByName(name);
    }

    public Room createRoom(Room room) throws Exception {

        if(checkIfAlreadyExists(room.getName())){
            throw new Exception("Same room name exists");

        }
        return roomDao.save(room);
    }


    public boolean checkIfAlreadyExists(String roomName){
        Room room = roomDao.findRoomByName(roomName);
        return room !=null;
    }
    public Room getRoom(long id) throws Exception {
        Optional<Room> room = roomDao.findById(id);
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
    public List<Room> getAllBookableRoom(){
        List<Room> roomList = roomDao.findAll();
        return roomList.stream().filter(j->!j.isBookable()).collect(Collectors.toList());
    }

}
