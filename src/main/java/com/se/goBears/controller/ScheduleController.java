package com.se.goBears.controller;


import com.se.goBears.entity.Schedule;
import com.se.goBears.payload.request.ScheduleRequest;
import com.se.goBears.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This controller class handles the API requests adding and returning schedule information for a date.
 */
@RestController
@RequestMapping("/api/schedule")
@CrossOrigin(origins = "*")
public class ScheduleController {


    @Autowired
    private ScheduleService scheduleService;

    /**
     * This method takes a number of schedule objects and associates a schedule to a specified room.
     * @param scheduleRequest is the schedule abject to be associated to a room.
     * @throws Exception creates a new schedule if schedule already exists.
     * @see ScheduleService
     */
    @PostMapping("/addSchedule")
    public void addBulkSchedule(@RequestBody ScheduleRequest scheduleRequest) throws Exception {
        scheduleService.addSchedule(scheduleRequest);
        System.out.println(scheduleRequest);

    }

    /**
     * This method returns all the schedule for a current date. The method takes user input as a calendar date
     * generates all the schedule for the specified date or date range.
     * @param date is the specific date specified the user using the provided calendar.
     * @return a list of schedule available for the selected date.
     */
    @PostMapping(("/getSchedule"))
    public List<Schedule> getSchedule(@RequestBody ScheduleRequest date){
        return scheduleService.getSchedulebyDate(date.getSelectedFromTime());
    }
}
