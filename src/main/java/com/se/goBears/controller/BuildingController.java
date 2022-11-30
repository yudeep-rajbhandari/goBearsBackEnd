package com.se.goBears.controller;


import com.se.goBears.entity.Building;
import com.se.goBears.entity.Gate;
import com.se.goBears.entity.Room;
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

    /**
     * This is an autowire to Building Service.
     * @see BuildingService
     */
    @Autowired
    private BuildingService buildingService;

    /**
     * This is an autowire to Building Service.
     * @see BuildingRepository
     */
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
    public Building addBuilding( @RequestBody Building building){

        return buildingService.addBuilding(building);
    }
    @GetMapping("/getAllBuilding")
//    @PreAuthorize("hasRole('ADMIN')")
    public List<Building> getAllBuilding(){
        return buildingService.getAllBuilding();
    }


    @PutMapping("/updateBuilding")
    @PreAuthorize("hasRole('ADMIN')")
    public Building editBuilding(@RequestBody Building building){
        return buildingService.editBuilding(building);
    }


    @GetMapping("/findBuildingById/{buildingId}")
    @PreAuthorize("hasRole('ADMIN')")
    public Building findBuildingById(@PathVariable Long buildingId){
        return buildingService.findBuildingById(buildingId);
    }


    @GetMapping("/getBuildingCount")
    public Integer getBuildingCount(){
        return buildingService.getBuildingCount();
    }


    @PutMapping("/addGate/{buildingId}")
    public Building addGate(@RequestBody Gate gate, @PathVariable Long buildingId){
        return buildingService.addGate(gate,buildingId);
    }

}
