package com.se.goBears.dao;

import com.se.goBears.entity.Building;
import com.se.goBears.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * This repository stores all records for building entity.
 */
public interface BuildingDao extends JpaRepository<Building, Long> {
    /**
     * This method takes a building name as input and returns the building associated with it.
     * @param name is the name of the building.
     * @return the associated building.
     */
    Building findBuildingByName(String name);

    /**
     * This method takes a building id as an input and returns the associated building.
     * @param id is the id of the building.
     * @return the building associated with the id.
     */
    Building findBuildingById(Long id);

}
