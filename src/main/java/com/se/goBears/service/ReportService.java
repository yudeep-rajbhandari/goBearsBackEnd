package com.se.goBears.service;

import com.se.goBears.entity.Building;
import com.se.goBears.entity.Resource;
import com.se.goBears.entity.Room;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReportService {
    @Autowired
    private BuildingService buildingService;

    @Autowired
    private Roomservice roomservice;

    @Autowired
    private ResourceService resourceService;

    private void getReport(String buildingName){
        Building building = buildingService.getBuildingByName(buildingName);
        List<Room> roomList = building.getRooms().stream().collect(Collectors.toList());
        List<Resource> resources = new ArrayList<>();
//        for(Room room: roomList){
//            resources.addAll(room.getRoomReservation().)
//        }

    }
}
