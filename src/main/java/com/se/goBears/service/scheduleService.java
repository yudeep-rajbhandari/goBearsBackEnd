package com.se.goBears.service;

import com.se.goBears.entity.Reservations;
import com.se.goBears.entity.Room;
import com.se.goBears.entity.Schedule;
import com.se.goBears.repository.RoomRepository;
import com.se.goBears.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;

public class scheduleService {

    @Autowired
    private Roomservice roomservice;

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private RoomRepository roomRepository;

    private Schedule addSchedule(long roomNumber, Date fromDate, Date toDate, String schedule) throws Exception {
        Room room = roomRepository.findById(roomNumber).get();
        List<Schedule> scheduleList = scheduleRepository.findScheduleByRoomid(roomNumber);

        for(Schedule schedule1: scheduleList){
            boolean cond1 = isDateInBetweenIncludingEndPoints(getDate(schedule1.getFromDate().toString()),getDate(schedule1.getToDate().toString()),getDate(schedule1.getFromDate().toString()));
            boolean cond2 = isDateInBetweenIncludingEndPoints(getDate(schedule1.getFromDate().toString()),getDate(schedule1.getToDate().toString()),getDate(schedule1.getToDate().toString()));
            if(cond1 || cond2){
                throw new Exception("Cannot reserve because reservation already found for given date/time");
            }

        }
        Schedule schedule1 = new Schedule();
        schedule1.setFromDate(fromDate);
        schedule1.setToDate(toDate);
        schedule1.setName(schedule);
        schedule1.setRoomid(roomNumber);
        scheduleRepository.save(schedule1);
        return schedule1;

    }
    public Date getDate(String a){
        try{
            SimpleDateFormat formatter6=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return formatter6.parse(a);
        }
        catch (Exception e){
            Instant inst2 = Instant.parse(a);
            return Date.from(inst2);
        }

    }
    public static boolean isDateInBetweenIncludingEndPoints(final Date min, final Date max, final Date date){
        return !(date.before(min) || date.after(max));
    }
}
