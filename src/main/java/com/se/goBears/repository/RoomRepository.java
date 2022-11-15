package com.se.goBears.repository;

import com.se.goBears.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
    Room findRoomByName(String name);
}
