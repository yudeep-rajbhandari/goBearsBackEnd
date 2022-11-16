package com.se.goBears.dao;

import com.se.goBears.entity.Building;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllotmentDao extends JpaRepository<Building, Long> {

}
