package com.se.goBears.controller;


import com.se.goBears.entity.Schedule;
import com.se.goBears.payload.request.ScheduleRequest;
import com.se.goBears.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedule")
@CrossOrigin(origins = "*")
public class ScheduleController {


    @Autowired
    private ScheduleService scheduleService;

    @PostMapping("/addSchedule")
    public void addBulkSchedule(@RequestBody ScheduleRequest scheduleRequest) throws Exception {
        scheduleService.addSchedule(scheduleRequest);


    }

    @PostMapping(("/getSchedule"))
    public List<Schedule> getSchedule(@RequestBody ScheduleRequest date){
        return scheduleService.getSchedulebyDate(date.getSelectedFromTime());
    }
}
