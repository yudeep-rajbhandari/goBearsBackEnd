package com.se.goBears.service;

import com.se.goBears.dao.BuildingDao;
import com.se.goBears.entity.Address;
import com.se.goBears.entity.Building;
import com.se.goBears.entity.Room;
import com.se.goBears.repository.AddressRepository;
import com.se.goBears.repository.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Transactional
@Service
public class BuildingService {


    @Autowired
    private BuildingDao buildingDao;

    @Autowired
    public AddressRepository addressRepository;

    @Autowired
    private BuildingRepository buildingRepository;
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


    public Building addBuilding(Building building){
        Address address = addressRepository.save(building.getAddress());
        building.setAddress(address);
        buildingRepository.save(building);
        return building;
    }
public List<Building> getAllBuilding(){
    return (List<Building>) buildingRepository.findAll();
}


public Building editBuilding(Building building){
        Building updateBuilding = buildingRepository.findBuildingById(building.getId());
        Address updateAddress = addressRepository.findAddressById(updateBuilding.getAddress().getId());

        updateAddress.setStreet(building.getAddress().getStreet());
        updateAddress.setCity(building.getAddress().getCity());
        updateAddress.setState(building.getAddress().getState());
        updateAddress.setZip(building.getAddress().getZip());

    updateBuilding.setName(building.getName());
    updateBuilding.setFloors(building.getFloors());
    updateBuilding.setAddress(addressRepository.save(updateAddress));

        return buildingRepository.save(updateBuilding);
}

public Building findBuildingById(Long buildingId){
        return buildingRepository.findBuildingById(buildingId);
}


}
