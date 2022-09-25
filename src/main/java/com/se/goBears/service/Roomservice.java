package com.se.goBears.service;

import com.se.goBears.dao.ResourceDao;
import com.se.goBears.dao.RoomDao;
import com.se.goBears.entity.Building;
import com.se.goBears.entity.Resource;
import com.se.goBears.entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Roomservice {

    @Autowired
    private RoomDao roomDao;

    @Autowired
    private BuildingService buildingService;

    @Autowired
    private ResourceDao resourceDao;

    public Room getRoomByName(String name){
        return roomDao.findRoomByName(name);
    }
    public Room addRoom(String roomName, boolean bookable, String buildingName, Room.RoomType roomType, Long latitude,Long longitude){
        Building building = buildingService.ifRoomExistsInBuilding(roomName,buildingName);

        if(building ==null){
            return null;
        }
        Room room = new Room();
        room.setName(roomName);
        room.setBookable(bookable);
        room.setBuilding(building);
        room.setLatitude(latitude);
        room.setLongitude(longitude);
        room.setRoomType(roomType);
        roomDao.save(room);
        return room;

    }

    public boolean checkIfAlreadyExists(String roomName){
        Room room = roomDao.findRoomByName(roomName);
        return room !=null;
    }
    public List<Resource>  getRoomResource(String RoomName){
        Room room = roomDao.findRoomByName(RoomName);
        List<Resource> resourceList = resourceDao.findResourceByRoom(room);
        return resourceList;
    }

}
