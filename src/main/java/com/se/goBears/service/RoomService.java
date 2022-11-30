package com.se.goBears.service;

import com.se.goBears.entity.Room;
import com.se.goBears.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;



    @Autowired
    private BuildingService buildingService;


    public Room getRoomByName(String name){
        return roomRepository.findRoomByName(name);
    }

    public Room createRoom(Room room) throws Exception {

        if(checkIfAlreadyExists(room.getName())){
            throw new Exception("Same room name exists");

        }
        return roomRepository.save(room);
    }


    public boolean checkIfAlreadyExists(String roomName){
        Room room = roomRepository.findRoomByName(roomName);
        return room !=null;
    }
    public Room getRoom(long id) throws Exception {
        Optional<Room> room = roomRepository.findById(id);
        if(room.isPresent()){
            return room.get();
        }
        else {
            throw  new Exception("Cannot find room");
        }
    }


    public Room addRoom(Room room) throws Exception{
        if(checkIfAlreadyExists(room.getName())){
            throw new Exception("Same room name exists");
        }
        return roomRepository.save(room);

    }


    public List<Room> findAllRoom(){
        return roomRepository.findAll().stream().filter(j->j.getBuilding()!= null).collect(Collectors.toList());
    }


    public Room updateRoom(Room room){
        Room updateRoom = roomRepository.findRoomById(room.getId());
        updateRoom.setName(room.getName());
        updateRoom.setRoomType(room.getRoomType());
        updateRoom.setIsBookable(room.isBookable());
        return roomRepository.save(updateRoom);
    }

    public List<Room> getAllBookableRoom(){
        List<Room> roomList = roomRepository.findAll();
        return roomList.stream().filter(j->!j.isBookable()).collect(Collectors.toList());
    }

    public List<Room> getAllClassRoomByBuilding(Long buildingId){
        List<Room> roomList = roomRepository.findRoomByBuildingIdAndRoomType(buildingId,Room.RoomType.CLASSROOM);
        return roomList;
    }


    public List<Room> findAllByBuildingId(Long buildingId){
        return roomRepository.findAllByBuildingId(buildingId);
    }



    public Room findRoomById(Long roomId){
        return roomRepository.findRoomById(roomId);
    }


    public Room makeBookableFalse(Room room) throws Exception {
        if (room==null){
            throw new Exception("Room is null");
        }
        room.setIsBookable(false);
        return roomRepository.save(room);
    }

    public List<Room> findAllBookableRoom(){
        return roomRepository.findAllByIsBookableIsTrue();
    }


    public Integer getRoomCount(){
        return roomRepository.findAll().size();
    }

    public List<Room> getRoomByBuildingId(Long buildingId){
        return roomRepository.findAllByBuildingId(buildingId);
    }

    public List<Room> getBookableRoomByBuilding(Long buildingId){

        return roomRepository.findAllByBuildingIdAndIsBookableIsTrue(buildingId);
    }

}
