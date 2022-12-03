package com.se.goBears.controller;


import com.se.goBears.entity.Allotment;
import com.se.goBears.service.AllotmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/allotment/")
@CrossOrigin(origins = "http://localhost:3000")

/**
 * This controller handles all the API requests for Allotment.
 * @param
 * @return
 * @throws
 * @version
 */
public class AllotmentController {

    /**
     * <p>This is a autowire to allotment service.</p>
     */
    @Autowired
    private AllotmentService allotmentService;

    /**
     * <p>This method handles the request to add an allotment.</p>
     * @param allotment Request body for allotment.
     * @return The saved request body for allotment.
     */
    @PostMapping("addAllotment")
    @PreAuthorize("hasRole('ADMIN')")
    public Allotment addAllotment(@RequestBody Allotment allotment) {
        return allotmentService.addAllotment(allotment);
    }

    /**
     * <p>This method handles the request for all allotment.</p>
     * @param
     * @return A list of all allotment.
     */
    @GetMapping("/getAllAllotment")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Allotment> getAllAllotment() {
        return allotmentService.getAllAllotment();
    }


    /**
     * <p>This method handles the request to get allotment for an id.</p>
     * @param userId
     * @return
     */
    @GetMapping("/getMyAllotment/{userId}")
    public List<Allotment> getMyAllotment(@PathVariable Long userId) {
        return allotmentService.getMyAllotment(userId);
    }

    @DeleteMapping("/deleteAllotment/{allotmentId}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteAllotment(@PathVariable Long allotmentId) {
        allotmentService.deleteAllotment(allotmentId);
        return "deleted allotment with id " + allotmentId;
    }
}
