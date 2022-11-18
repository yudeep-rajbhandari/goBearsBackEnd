package com.se.goBears.controller;


import com.se.goBears.service.AllotmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;


public class AllotmentController {

    @Autowired
    private AllotmentService allotmentService;

    @PostMapping("/addAllotment")
    public void addAllotment() throws Exception {


    }
}
