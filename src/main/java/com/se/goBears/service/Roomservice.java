package com.se.goBears.service;

//import com.se.goBears.dao.ResourceDao;
import com.se.goBears.dao.RoomDao;
import com.se.goBears.entity.Building;
//import com.se.goBears.entity.Resource;
import com.se.goBears.entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Roomservice {

    @Autowired
    private RoomDao roomDao;


//    @Autowired
//    private ResourceDao resourceDao;

    public Room getRoomByName(String name){
        return roomDao.findRoomByName(name);
    }


    public boolean checkIfAlreadyExists(String roomName){
        Room room = roomDao.findRoomByName(roomName);
        return room !=null;
    }


}
