package com.se.goBears.repository;


import com.se.goBears.entity.Building;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * This is a repository interface for Building entity.
 */
@Repository
@Transactional
public interface BuildingRepository extends CrudRepository<Building, Long> {
    /**
     * This method returns the building object.
     *
     * @param buildingId is the id of the building to be found
     * @return the building object.
     */
    Building findBuildingById(Long buildingId);
    /**
     * This method returns a list of all room associated with a building.
     * @param name is the name associated with a building.
     * @return a list of all the buildings associated with building name.
     */
    Building findBuildingByName(String name);
    /**
     * This method returns a list of all buildings.
     *
     * @return a list of all the buildings.
     */
    List<Building> findAll();

}
