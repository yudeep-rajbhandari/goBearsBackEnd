package com.se.goBears.service;

import com.se.goBears.dao.ScheduleDao;
import com.se.goBears.entity.Room;
import com.se.goBears.entity.Schedule;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class scheduleService {

    @Autowired
    private Roomservice roomservice;

    @Autowired
    private ScheduleDao scheduleDao;

    private Schedule addSchedule(String roomNumber, Date fromDate, Date toDate, String schedule){
        Room room = roomservice.getRoomByName(roomNumber);
        Schedule schedule1 = new Schedule();
        schedule1.setFromDate(fromDate);
        schedule1.setToDate(toDate);
        schedule1.setName(schedule);
        schedule1.setRoom(room);
        scheduleDao.save(schedule1);
        return schedule1;

    }
}
