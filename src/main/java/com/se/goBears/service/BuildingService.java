package com.se.goBears.service;

import com.se.goBears.dao.BuildingDao;
import com.se.goBears.entity.Address;
import com.se.goBears.entity.Building;
import com.se.goBears.entity.Gate;
import com.se.goBears.entity.Room;
import com.se.goBears.repository.AddressRepository;
import com.se.goBears.repository.BuildingRepository;
import com.se.goBears.repository.GateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * This is the service class for Building entity.
 */
@Transactional
@Service
public class BuildingService {

    @Autowired
    private BuildingDao buildingDao;

    @Autowired
    public AddressRepository addressRepository;
    @Autowired
    public GateRepository gateRepository;

    @Autowired
    private BuildingRepository buildingRepository;

    /**
     * This method returns the building given a building name.
     *
     * @param name is the name of the building.
     * @return a building object associated with the building name.
     */
    public Building getBuildingByName(String name) {
        return buildingDao.findBuildingByName(name);
    }

    /**
     * This method returns the building object if the given room exists in the given building.
     *
     * @param roomName     is the name of the room.
     * @param buildingName is the name of the building.
     * @return the building object.
     */
    public Building ifRoomExistsInBuilding(String roomName, String buildingName) {
        Building building = buildingDao.findBuildingByName(buildingName);
        Set<Room> roomNameList = building.getRooms();
        for (Room room : roomNameList) {
            if (room.getName().equals(roomName)) {
                return null;
            }
        }
        return building;

    }


    /**
     * This method processes the add building request. It takes a building request body and sets the buildimg
     * address and add the building to the repository.
     *
     * @param building is a building object.
     * @return the saved building object.
     */
    public Building addBuilding(Building building) {
        building.setAddress(addressRepository.save(building.getAddress()));

        buildingRepository.save(building);
        return building;
    }

    /**
     * The method returns a list of all buildings.
     *
     * @return a list of all buildings.
     */
    public List<Building> getAllBuilding() {
        return (List<Building>) buildingRepository.findAll();
    }


    /**
     * This method on receiving an edit building updates the building address and the building object.
     *
     * @param building the edited building information.
     * @return the updated building object.
     */
    public Building editBuilding(Building building) {
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

    /**
     * This method returns a building object given a building id.
     *
     * @param buildingId is the id of the building.
     * @return a building object associated with the building id.
     */
    public Building findBuildingById(Long buildingId) {
        return buildingRepository.findBuildingById(buildingId);
    }


    /**
     * This method returns the total number of buildings.
     *
     * @return the number of buildings.
     */
    public Integer getBuildingCount() {
        return buildingRepository.findAll().size();
    }


    /**
     * This method on given a gate object and a building id, saves the gate and associates it with given building.
     *
     * @param gate       is the gate to be created and associated to a building.
     * @param buildingId is the id of the building.
     * @return the saved building object.
     */
    public Building addGate(Gate gate, Long buildingId) {
        Building building = findBuildingById(buildingId);
        gateRepository.save(gate);
        building.getGate().add(gate);
        return buildingRepository.save(building);
    }
}
