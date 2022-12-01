package com.se.goBears.dao;

import com.se.goBears.entity.Building;
import com.se.goBears.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * This DAO interface handles the storage of data for Room entity.
 */
public interface RoomDao extends JpaRepository<Room, Long> {
    /**
     * This method on given name for a room returns room associated with it.
     *
     * @param name is the name of the room.
     * @return the room object associated with the name.
     */
    Room findRoomByName(String name);

    /**
     * This method on given id for a room returns room associated with it.
     *
     * @param id is the id of the room.
     * @return the room object associated with the id.
     */
    Room findRoomById(Long id);

}
