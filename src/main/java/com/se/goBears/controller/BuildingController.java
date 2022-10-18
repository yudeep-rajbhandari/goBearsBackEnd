package com.se.goBears.controller;


import com.se.goBears.entity.Building;
import com.se.goBears.repository.BuildingRepository;
import com.se.goBears.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/building")
@CrossOrigin(origins = "http://localhost:3000")
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
}
