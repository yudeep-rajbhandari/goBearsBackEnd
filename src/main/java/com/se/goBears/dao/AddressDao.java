package com.se.goBears.dao;

import com.se.goBears.entity.Building;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressDao extends JpaRepository<Building, Long> {
    Building findBuildingByName(String name);
    Building findBuildingById(Long id);
}