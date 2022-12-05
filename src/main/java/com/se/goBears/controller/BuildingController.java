package com.se.goBears.controller;


import com.se.goBears.entity.Building;
import com.se.goBears.entity.Gate;
import com.se.goBears.repository.BuildingRepository;
import com.se.goBears.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This controller class handles the API requests related to Building class. It handles request to add new building,
 * get all buildings, edit building information, find a building by an id, get number of buildings and addition of
 * a building gate.
 */
@RestController
@RequestMapping("/api/building")
@CrossOrigin(origins = "*")
public class BuildingController {

    @Autowired
    private BuildingService buildingService;

    @Autowired
    private BuildingRepository buildingRepository;

    /**
     * This method handles the add building request. It takes a building request body, authenticates the user
     * role to be admin and returns the added building object.
     * @param building is a building request body.
     * @return the saved building object through Building Service.
     * @see BuildingService
     */
    @PostMapping("/addBuilding")
    @PreAuthorize("hasRole('ADMIN')")
    public Building addBuilding(@RequestBody Building building) {

        return buildingService.addBuilding(building);
    }

    /**
     * This method handles the get all buildings request. It returns a list of all buildings.
     * @param
     * @return a list of all buildings.
     * @see BuildingService
     */
    @GetMapping("/getAllBuilding")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Building> getAllBuilding() {
        return buildingService.getAllBuilding();
    }

    /**
     * This method handles the edit request for a building. It takes a new building request body, authenticates
     * the user role as ADMIN and returns the edited building object.
     * @param building is building object with all the details required to be edited.
     * @return a object body of edited building.
     * @see BuildingService
     */
    @PutMapping("/updateBuilding")
    @PreAuthorize("hasRole('ADMIN')")
    public Building editBuilding(@RequestBody Building building) {
        return buildingService.editBuilding(building);
    }

    /**
     * This method takes a building Id as a parameter and returns the building object identified by the Id.
     * @param buildingId  is the id of the building to be searched.
     * @return an object of the building.
     */
    @GetMapping("/findBuildingById/{buildingId}")
    @PreAuthorize("hasRole('ADMIN')")
    public Building findBuildingById(@PathVariable Long buildingId) {
        return buildingService.findBuildingById(buildingId);
    }


    /**
     * This method returns the total number of buildings created.
     * @return an integer number for the number of buildings.
     */
    @GetMapping("/getBuildingCount")
    public Integer getBuildingCount() {
        return buildingService.getBuildingCount();
    }

    /**
     * This method takes a request body Gate and a building Id as an input and assigns the
     * provided gate to the building.
     * @param gate is a gate object.
     * @param buildingId is the id of the building to be associated with the gate.
     * @return details of the building with associated gate information.
     * @see Gate
     * @see Building
     */
    @PutMapping("/addGate/{buildingId}")
    @PreAuthorize("hasRole('ADMIN')")
    public Building addGate(@RequestBody Gate gate, @PathVariable Long buildingId) {
        return buildingService.addGate(gate, buildingId);
    }

}
