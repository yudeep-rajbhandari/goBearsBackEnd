package com.se.goBears.service;

import com.se.goBears.entity.Allotment;
import com.se.goBears.entity.Room;
import com.se.goBears.entity.User;
import com.se.goBears.errors.CustomException;
import com.se.goBears.repository.AllotmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
/**
 * This is the class for all the Allotment
 */
public class AllotmentService {

    @Autowired
    private AllotmentRepository allotmentRepository;

    @Autowired
    UserService userService;

    @Autowired
    private RoomService roomService;


    /**
     * This method adds allotment.
     * @param allotment
     * @return
     */
    public Allotment addAllotment(Allotment allotment) {
        if (allotment.getUser().getId()==null || allotment.getUser().getId()==0) {
            throw new CustomException("Select User");
        }
        if (allotment.getRoom().getId()==null || allotment.getRoom().getId()==0){
            throw new CustomException("Select room ");
        }
        if (allotment.getFromDate()==null){
            throw new CustomException("From Date can't be null");
        }

    allotment.setUser(userService.findUserById(allotment.getUser().getId()));
    allotment.setRoom(roomService.findRoomById(allotment.getRoom().getId()));
    allotment.setFromDate(allotment.getFromDate());
    allotment.setToDate(allotment.getToDate());
    return allotmentRepository.save(allotment);
}


    /**
     *
     * @return
     */
    public List<Allotment> getAllAllotment(){
        return allotmentRepository.findAll();
    }


    /**
     *
     * @param userId
     * @return
     */
    public List<Allotment> getMyAllotment(Long userId){
        return allotmentRepository.findAllotmentsByUser(userService.findUserById(userId));
    }
}
