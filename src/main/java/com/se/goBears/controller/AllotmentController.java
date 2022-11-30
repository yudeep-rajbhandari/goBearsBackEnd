package com.se.goBears.controller;


import com.se.goBears.entity.Allotment;
import com.se.goBears.service.AllotmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api/allotment/")
@CrossOrigin(origins = "http://localhost:3000")

/**
 * <p>This controller class handles all the API requests for Allotment. It handles the request to add an allotment,
 * get a list of all allotments and get a list of allotment for a specific user.</p>
 * @param
 * @return
 * @see
 * @throws
 * @version
 */
public class AllotmentController {

    @Autowired
    private AllotmentService allotmentService;

    /**
     * <p>his method adds an allotment record.</p>T
     * @param allotment A request-body for an allotment.
     * @return The saved allotment.
     */
    @PostMapping("addAllotment")
    public Allotment addAllotment(@RequestBody Allotment allotment)  {
        return allotmentService.addAllotment(allotment);
    }

    /**
     * <p>This method gets all allotment.</p>
     * @param
     * @return List of all allotments.
     */
    @GetMapping("/getAllAllotment")
    public List<Allotment> getAllAllotment(){
        return allotmentService.getAllAllotment();
    }

    /**
     * <p>This method gets a userid and returns a list of allotments associated with the user.</p>
     * @param userId the userid for the allotment.
     * @return a list of the allotment for a user.
     */
    @GetMapping("/getMyAllotment/{userId}")
    public List<Allotment> getMyAllotment(@PathVariable Long userId){
        return allotmentService.getMyAllotment(userId);
    }
}
