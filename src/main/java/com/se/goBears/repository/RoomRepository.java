
        package com.se.goBears.repository;

import com.se.goBears.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
    Room findRoomByName(String name);

    List<Room> findAll();

//    List<Room> findAllByBookable(boolean isBookable);


    Room findRoomById(Long id);

    List<Room> findRoomByRoomType(Room.RoomType roomType);

    List<Room> findRoomByBuildingIdAndRoomType(Long buildingID, Room.RoomType roomType);


    List<Room> findAllByBuildingId(Long buildingId);

    List<Room> findAllByIsBookableIsTrue();

List<Room> findAllByBuildingIdAndIsBookableIsTrue(Long buildingId);

}
