package com.se.goBears.service;

import com.se.goBears.dao.BuildingDao;
import com.se.goBears.dao.RoomDao;
import com.se.goBears.entity.Building;
import com.se.goBears.entity.Room;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BuildingService {


    @Autowired
    private BuildingDao buildingDao;

    public Building getBuildingByName(String name){
        return buildingDao.findBuildingByName(name);
    }

    public Building ifRoomExistsInBuilding(String roomName,String buildingName){
        Building building = buildingDao.findBuildingByName(buildingName);
        Set<Room> roomNameList = building.getRooms();
        for(Room room:roomNameList){
            if(room.getName().equals(roomName)){
                return null;
            }
        }
        return building;

    }
//    public List<Building> getSelectedBuilding(String buildingNames){
//        List<Building> buildingList = new ArrayList<>();
//        for (String name: buildingNames){
//            buildingList.add()
//        }
//    }

}
