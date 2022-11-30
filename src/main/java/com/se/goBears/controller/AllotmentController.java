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
 * <p>This controller handles all the API requests for Allotment</p>
 * @param
 * @return
 * @see
 * @throws
 * @version
 */
public class AllotmentController {

    @Autowired
    private AllotmentService allotmentService;

    @PostMapping("addAllotment")
    public Allotment addAllotment(@RequestBody Allotment allotment)  {
        return allotmentService.addAllotment(allotment);
    }

    @GetMapping("/getAllAllotment")
    public List<Allotment> getAllAllotment(){
        return allotmentService.getAllAllotment();
    }


    @GetMapping("/getMyAllotment/{userId}")
    public List<Allotment> getMyAllotment(@PathVariable Long userId){
        return allotmentService.getMyAllotment(userId);
    }

    @DeleteMapping("/deleteAllotment/{allotmentId}")
    public String deleteAllotment(@PathVariable Long allotmentId){
         allotmentService.deleteAllotment(allotmentId);
         return "deleted allotment with id "+allotmentId;
    }
}
