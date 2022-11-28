package com.se.goBears.service;

import com.se.goBears.entity.Allotment;
import com.se.goBears.entity.Room;
import com.se.goBears.entity.User;
import com.se.goBears.repository.AllotmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AllotmentService {

    @Autowired
    private AllotmentRepository allotmentRepository;

    @Autowired
    UserService userService;

    @Autowired
    private RoomService roomService;


    public Allotment addAllotment(Allotment allotment) throws Exception {
        if (allotment.getUser()==null){
            throw new Exception("User can't be null");
        }
        if (allotment.getRoom()==null){
            throw new Exception("Room can't be null");
        }
        allotment.setUser(userService.findUserById(allotment.getUser().getId()));
        allotment.setRoom(roomService.findRoomById(allotment.getRoom().getId()));
        allotment.setFromDate(allotment.getFromDate());
        allotment.setToDate(allotment.getToDate());
        return allotmentRepository.save(allotment);
    }


    public List<Allotment> getAllAllotment(){
        return allotmentRepository.findAll();
    }
}
