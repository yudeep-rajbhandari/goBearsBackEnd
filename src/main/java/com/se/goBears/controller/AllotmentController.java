package com.se.goBears.controller;


import com.se.goBears.entity.Allotment;
import com.se.goBears.service.AllotmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * This controller class handles the API requests for allotment.
 */
@RestController
@RequestMapping("/api/allotment/")
@CrossOrigin(origins = "http://localhost:3000")


public class AllotmentController {

    @Autowired
    private AllotmentService allotmentService;

    /**
     * This method handles the request to add an allotment.
     * @param allotment is a request body for allotment.
     * @return the saved request body for allotment.
     */
    @PostMapping("addAllotment")
    @PreAuthorize("hasRole('ADMIN')")
    public Allotment addAllotment(@RequestBody Allotment allotment) {
        return allotmentService.addAllotment(allotment);
    }

    /**
     * This method handles the request for all allotment.
     * @return A list of all allotment.
     */
    @GetMapping("/getAllAllotment")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Allotment> getAllAllotment() {
        return allotmentService.getAllAllotment();
    }


    /**
     * This method handles the request to get allotment for an id.
     * @param userId is the id of the user.
     * @return a list of allotment associated with a user.
     */
    @GetMapping("/getMyAllotment/{userId}")
    public List<Allotment> getMyAllotment(@PathVariable Long userId) {
        return allotmentService.getMyAllotment(userId);
    }

    /**
     * This method handles the request for deletion of allotment.
     * @param allotmentId is the id of the allotment to be deleted.
     * @return message stating successful deletion.
     */
    @DeleteMapping("/deleteAllotment/{allotmentId}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteAllotment(@PathVariable Long allotmentId) {
        allotmentService.deleteAllotment(allotmentId);
        return "deleted allotment with id " + allotmentId;
    }
}
