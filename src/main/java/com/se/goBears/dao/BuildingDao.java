package com.se.goBears.dao;

import com.se.goBears.entity.Building;
import com.se.goBears.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingDao extends JpaRepository<Building, Long> {
    Building findBuildingByName(String name);
    Building findBuildingById(Long id);

}
