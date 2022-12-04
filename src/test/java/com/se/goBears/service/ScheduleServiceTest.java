package com.se.goBears.service;


import com.se.goBears.entity.Room;
import com.se.goBears.entity.Schedule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class ScheduleServiceTest {

    @Autowired
    private ScheduleService scheduleService;


    @Test
    @Transactional
    public void saveScheduleTest() throws Exception {
        List<Schedule> scheduleList = new ArrayList<>();
        Schedule schedule = scheduleService.saveSchedule(new Date(),new Date(),"mySchedule",new Room(),scheduleList);
        scheduleService.deleteSchedule(schedule.getId());
    }

    @Test
    @Transactional
    public void saveScheduleFail1() throws Exception {
        Date fromDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fromDate);
        calendar.add(Calendar.HOUR_OF_DAY, 1);
        Date toDate =  calendar.getTime();
        Schedule schedule = new Schedule();
        schedule.setFromDate(fromDate);
        schedule.setToDate(toDate);
        List<Schedule> scheduleList = new ArrayList<>();
        scheduleList.add(schedule);
        Exception exception = assertThrows(Exception.class, () -> {
            scheduleService.saveSchedule(fromDate,toDate,"mySchedule",new Room(),scheduleList);

        });

    }

}

