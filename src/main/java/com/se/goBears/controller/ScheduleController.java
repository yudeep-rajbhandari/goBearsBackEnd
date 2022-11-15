package com.se.goBears.controller;


import com.se.goBears.entity.Schedule;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/schedule")
@CrossOrigin(origins = "http://localhost:3000")
public class ScheduleController {

    public void addBulkSchedule(){

    }
}
