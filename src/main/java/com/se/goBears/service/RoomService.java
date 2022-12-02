package com.se.goBears.service;

import com.se.goBears.entity.Building;
import com.se.goBears.entity.Room;
import com.se.goBears.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * This is the service class for Room entity.
 */
@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;


    @Autowired
    private BuildingService buildingService;


    /**
     * This method returns a room given a room name.
     *
     * @param name is the name of the room.
     * @return a room object associated with a room name.
     */
    public Room getRoomByName(String name) {
        return roomRepository.findRoomByName(name);
    }

    /**
     * This method creates a room is the room does not exists.
     *
     * @param room is the room object to be created.
     * @return the created room object.
     * @throws Exception if a room with the given room name already exists.
     */
    public Room createRoom(Room room) throws Exception {

        if (checkIfAlreadyExists(room.getName())) {
            throw new Exception("Same room name exists");

        }
        return roomRepository.save(room);
    }


    /**
     * This method checks if a room with given room name already exists.
     *
     * @param roomName is the name of the room to be checked.
     * @return True if the room does not exist else False.
     */
    public boolean checkIfAlreadyExists(String roomName) {
        Room room = roomRepository.findRoomByName(roomName);
        return room != null;
    }

    /**
     * This method, given a room id returns a room if it exists.
     *
     * @param id is the id of the room.
     * @return the room object associated with the room id.
     * @throws Exception if the room does not exist.
     */
    public Room getRoom(long id) throws Exception {
        Optional<Room> room = roomRepository.findById(id);
        if (room.isPresent()) {
            return room.get();
        } else {
            throw new Exception("Cannot find room");
        }
    }


    /**
     * This method adds the room if the room does not exist.
     *
     * @param room is the room object to be added.
     * @return an added room object.
     * @throws Exception if the room with given name already exists.
     */
    public Room addRoom(Room room) throws Exception {
        if (checkIfAlreadyExists(room.getName())) {
            throw new Exception("Same room name exists");
        }
        return roomRepository.save(room);

    }


    /**
     * This method returns a list of all rooms which have building assigned to them.
     *
     * @return a list of rooms.
     */
    public List<Room> findAllRoom() {
        return roomRepository.findAll().stream().filter(j -> j.getBuilding() != null).collect(Collectors.toList());
    }


    /**
     * This method updates the existing room given a new room information.
     *
     * @param room is the updated room object.
     * @return the updated room object.
     */
    public Room updateRoom(Room room) {
        Room updateRoom = roomRepository.findRoomById(room.getId());
        updateRoom.setName(room.getName());
        updateRoom.setRoomType(room.getRoomType());
        updateRoom.setIsBookable(room.isBookable());
        return roomRepository.save(updateRoom);
    }

    /**
     * This method returns a list of all bookable rooms.
     *
     * @return a list of bookable rooms.
     */
    public List<Room> getAllBookableRoom() {
        List<Room> roomList = roomRepository.findAll();
        return roomList.stream().filter(j -> !j.isBookable()).collect(Collectors.toList());
    }

    /**
     * This method returns all rooms in a given building which are classified as classroom.
     *
     * @param buildingId is the id of the building
     * @return a list of room associated to the building id and of type classroom.
     */
    public List<Room> getAllClassRoomByBuilding(Long buildingId) {
        List<Room> roomList = roomRepository.findRoomByBuilding_IdAndRoomType(buildingId, Room.RoomType.classroom);
        return roomList;
    }


    /**
     * This method returns a list of rooms given a building id.
     *
     * @param buildingId is the id of the building.
     * @return a list of rooms associated with the building.
     */
    public List<Room> findAllByBuildingId(Long buildingId) {
        return roomRepository.findAllByBuildingId(buildingId);
    }


    /**
     * This method returns a room given a room id.
     *
     * @param roomId is the id of the room.
     * @return a room object associated with the room id.
     */
    public Room findRoomById(Long roomId) {
        return roomRepository.findRoomById(roomId);
    }


    /**
     * This method, given a room sets its bookable status to False.
     *
     * @param room is the room object.
     * @return an update room object.
     * @throws Exception if the room is null.
     */
    public Room makeBookableFalse(Room room) throws Exception {
        if (room == null) {
            throw new Exception("Room is null");
        }
        room.setIsBookable(false);
        return roomRepository.save(room);
    }

    /**
     * This method returns a list of all bookable rooms.
     *
     * @return a list of bookable rooms.
     */
    public List<Room> findAllBookableRoom() {
        return roomRepository.findAllByIsBookableIsTrue();
    }


    /**
     * This method returns a count of all rooms.
     *
     * @return a count of all rooms.
     */
    public Integer getRoomCount() {
        return roomRepository.findAll().size();
    }

    /**
     * This method returns a list of room in a building given a building id.
     *
     * @param buildingId is the id of the building.
     * @return a list of rooms associated with the building.
     */
    public List<Room> getRoomByBuildingId(Long buildingId) {
        return roomRepository.findAllByBuildingId(buildingId);
    }

    /**
     * This method returns all the bookable rooms in the building given the building id.
     *
     * @param buildingId is the id of the building.
     * @return a list of all bookable rooms in the building.
     */
    public List<Room> getBookableRoomByBuilding(Long buildingId) {

        return roomRepository.findAllByBuildingIdAndIsBookableIsTrue(buildingId);
    }

}
