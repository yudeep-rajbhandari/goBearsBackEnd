package com.se.goBears.repository;


import com.se.goBears.entity.Building;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface BuildingRepository extends CrudRepository<Building, Long> {
}