package com.se.goBears.service;

import com.se.goBears.entity.Allotment;
import com.se.goBears.errors.CustomException;
import com.se.goBears.repository.AllotmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
/**
 * This is the service class for all the Allotment entity.
 */
public class AllotmentService {

    @Autowired
    private AllotmentRepository allotmentRepository;

    @Autowired
    UserService userService;

    @Autowired
    private RoomService roomService;

    /**
     * This method adds allotment for a room for a user.
     * @param allotment is an allotment to be added.
     * @return the saved allotment object.
     * @throws Exception if user does not exist.
     * @throws Exception if room does not exist.
     * @throws Exception if date for allotment is null.
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
     * This method returns a list of all allotment.
     * @return a list of allotments.
     */
    public List<Allotment> getAllAllotment(){
        return allotmentRepository.findAll();
    }


    /**
     * This method on given a user id returns a list of allotment associated with it.
     * @param userId is the user id of the user.
     * @return a list of allotment for the user.
     */
    public List<Allotment> getMyAllotment(Long userId){
        return allotmentRepository.findAllotmentsByUser(userService.findUserById(userId));
    }

    /**
     * This method deletes an allotment.
     * @param allotmentId is the allotment to be deleted.
     */
    public void deleteAllotment(Long allotmentId) {
        allotmentRepository.deleteById(allotmentId);
    }
}
