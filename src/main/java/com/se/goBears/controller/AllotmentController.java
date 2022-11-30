package com.se.goBears.controller;


import com.se.goBears.entity.Allotment;
import com.se.goBears.service.AllotmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



/**
 * This controller class handles all the API requests for Allotment. It handles the request to add an allotment,
 * get a list of all allotments and get a list of allotment for a specific user.
 */
@RestController
@RequestMapping("/api/allotment/")
@CrossOrigin(origins = "http://localhost:3000")
public class AllotmentController {

    @Autowired
    private AllotmentService allotmentService;

    /**
     * <p>This method gets an allotment object, adds the allotment record and returns the
     * saved object.</p>
     * @param allotment a request body for an allotment.
     * @return the saved allotment through Allotment Service.
     * @see AllotmentService
     */
    @PostMapping("addAllotment")
    public Allotment addAllotment(@RequestBody Allotment allotment)  {
        return allotmentService.addAllotment(allotment);
    }

    /**
     * <p>This method returns a list of all allotments.</p>
     * @param
     * @return list of all allotments through Allotment Service.
     * @see AllotmentService
     */
    @GetMapping("/getAllAllotment")
    public List<Allotment> getAllAllotment(){
        return allotmentService.getAllAllotment();
    }

    /**
     * <p>This method gets a userid and returns a list of allotments associated with the user.</p>
     * @param userId the userid for the allotment.
     * @return a list of the allotment for a user through Allotment Service.
     * @see AllotmentService
     */
    @GetMapping("/getMyAllotment/{userId}")
    public List<Allotment> getMyAllotment(@PathVariable Long userId){
        return allotmentService.getMyAllotment(userId);
    }
}
