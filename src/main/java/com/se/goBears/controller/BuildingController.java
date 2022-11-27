package com.se.goBears.controller;


import com.se.goBears.entity.Building;
import com.se.goBears.repository.BuildingRepository;
import com.se.goBears.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/building")
@CrossOrigin(origins = "*")
public class BuildingController {

    @Autowired
    private BuildingService buildingService;

    @Autowired
    private BuildingRepository buildingRepository;

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

}
