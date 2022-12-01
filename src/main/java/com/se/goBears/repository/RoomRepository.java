
package com.se.goBears.repository;

import com.se.goBears.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * This is a repository interface for Room entity.
 */
public interface RoomRepository extends JpaRepository<Room, Long> {
    /**
     * This method finds the room given the room name.
     *
     * @param name is the name of the room.
     * @return a room object associated with the name.
     */
    Room findRoomByName(String name);

    /**
     * This method returns a list of all rooms.
     *
     * @return a list of all rooms.
     */
    List<Room> findAll();


    /**
     * This method returns a room object given a room id.
     *
     * @param id is the id of the room.
     * @return a room associated with the id.
     */
    Room findRoomById(Long id);

    /**
     * This method returns all room associated with the given room type.
     *
     * @param roomType is the type of the room to be found.
     * @return a list of the room associated with the room type.
     */
    List<Room> findRoomByRoomType(Room.RoomType roomType);

    /**
     * The method returns a list of room given a building id and a room type.
     *
     * @param buildingID is the id of the building.
     * @param roomType   is the type of the room to be searched for.
     * @return a list of room associated with the given building and room type.
     */
    List<Room> findRoomByBuilding_IdAndRoomType(Long buildingID, Room.RoomType roomType);


    /**
     * This method returns all the rooms in a building.
     *
     * @param buildingId is the id of the building to be looked into.
     * @return a list of rooms associated with the building id.
     */
    List<Room> findAllByBuildingId(Long buildingId);

    /**
     * This method returns a list of all bookable room.
     *
     * @return a list of bookable rooms.
     */
    List<Room> findAllByIsBookableIsTrue();

    /**
     * This method returns all bookable room in a specific building.
     *
     * @param buildingId is the id of the building to be looked into.
     * @return a list of bookable room associated with the building.
     */
    List<Room> findAllByBuildingIdAndIsBookableIsTrue(Long buildingId);

}
