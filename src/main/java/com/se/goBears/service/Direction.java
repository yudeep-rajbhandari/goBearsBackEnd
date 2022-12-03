package com.se.goBears.service;

import com.se.goBears.entity.Building;
import com.se.goBears.repository.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class Direction {
    @Autowired
    private BuildingRepository buildingRepository;
    public Building getBuildingByName(String name){
        return buildingRepository.findBuildingByName(name);
    }
}
