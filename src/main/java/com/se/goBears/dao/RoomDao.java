package com.se.goBears.dao;

import com.se.goBears.entity.Room;
import com.se.goBears.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomDao extends JpaRepository<Room, Long> {
    Room findRoomByName(String name);
}
