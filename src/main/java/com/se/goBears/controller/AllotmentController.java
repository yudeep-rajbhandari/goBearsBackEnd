package com.se.goBears.controller;


import com.se.goBears.entity.Allotment;
import com.se.goBears.service.AllotmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/allotment/")
@CrossOrigin(origins = "http://localhost:3000")
public class AllotmentController {

    @Autowired
    private AllotmentService allotmentService;

    @PostMapping("addAllotment")
    public Allotment addAllotment(@RequestBody Allotment allotment) throws Exception {
        return allotmentService.addAllotment(allotment);
    }
}
