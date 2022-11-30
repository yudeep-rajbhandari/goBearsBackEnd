package com.se.goBears.service;

import com.se.goBears.entity.Room;
import com.se.goBears.repository.RoomRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class RoomServiceTest {

    @Autowired
    private RoomService roomService;

    @Test
    public void createRoomTest() throws Exception {
        Room room = new Room();
        room.setName("Test Room");
        room.setIsBookable(true);
        room.setRoomType(Room.RoomType.CLASSROOM);
        Room room1 = roomService.addRoom(room);
        roomService.deleteroomById(room1.getId());

    }

    @Test
    public void sameRoomErrorTest() throws Exception {
        Room room = new Room();
        room.setName("Test Room");
        room.setIsBookable(true);
        room.setRoomType(Room.RoomType.CLASSROOM);
        Room room1 = roomService.addRoom(room);
        Exception exception = assertThrows(Exception.class, () -> {
            roomService.addRoom(room1);
        });
        roomService.deleteroomById(room1.getId());

    }
}
