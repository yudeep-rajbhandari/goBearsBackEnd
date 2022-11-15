package com.se.goBears.repository;

import com.se.goBears.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
    Room findRoomByName(String name);

    List<Room> findAll();


    Room findRoomById(Long id);
}
