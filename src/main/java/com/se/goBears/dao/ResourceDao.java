package com.se.goBears.dao;

import com.se.goBears.entity.Building;
import com.se.goBears.entity.Resource;
import com.se.goBears.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface ResourceDao extends JpaRepository<Resource, Long> {
    List<Resource> findResourceByRoom(Room room);
}
