package com.se.goBears.service;

import com.se.goBears.entity.Room;
import com.se.goBears.entity.Schedule;
import com.se.goBears.payload.request.ScheduleRequest;
import com.se.goBears.repository.RoomRepository;
import com.se.goBears.repository.ScheduleRepository;
import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.*;

@Service
public class ScheduleService {

    @Autowired
    private RoomService roomservice;

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private RoomRepository roomRepository;

    Map<String, Integer> map = new HashMap<String, Integer>();


    /**
     * This is the postconstruct for the days for the schedule.
     */
    @PostConstruct
    private void setDaysMap(){
        map.put("M",DateTimeConstants.MONDAY);
        map.put("T",DateTimeConstants.TUESDAY);
        map.put("W",DateTimeConstants.WEDNESDAY);
        map.put("TR",DateTimeConstants.THURSDAY);
        map.put("F",DateTimeConstants.FRIDAY);
    }

    /**
     * This method return a list of schedule given a date.
     * @param date is the date to be looked for.
     * @return a list of schedule for the given date.
     */
    public List<Schedule> getSchedulebyDate(String date){
        Date date1 = getDate(date);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Date d1 =  cal.getTime();
        cal.add(Calendar.DATE,1);
        Date d2 = cal.getTime();
        return scheduleRepository.findScheduleByFromDateGreaterThanAndToDateLessThan(d1,d2);
    }

    /**
     * This method adds a schedule given a schedule request.
     * @param request is the schedule to be added.
     */
    public void addSchedule(ScheduleRequest request) throws Exception {
        Room room = roomRepository.findById(request.getRoomId()).get();
        List<Schedule> scheduleList = scheduleRepository.findScheduleByRoom_IdAndFromDateGreaterThan(room.getId(),new DateTime(request.getSelectedFromDate()).toDate());
        List<DateTime> dateTimes = new ArrayList<>();
        if(request.getSelectedFrequency().equals(ScheduleRequest.Frequency.Custom)){
            for(ScheduleRequest.Custom s:request.getCustom()){
                List<DateTime> getDate = getAlldayDate(request.getSelectedFromDate(), request.getSelectedToDate(),map.get(s.toString()));
                dateTimes.addAll(getDate);
            }
            for (DateTime dateTime:dateTimes){
                Date fromDate = addTime(dateTime.toDate(),getDate(request.getSelectedFromTime()));
                Date toDate = addTime(dateTime.toDate(),getDate(request.getSelectedToTime()));
                saveSchedule(fromDate,toDate, request.getName(), room,scheduleList);
            }

        } else if (request.getSelectedFrequency().equals(ScheduleRequest.Frequency.Repeat)) {
            List<ScheduleRequest.Custom> aa  = Arrays.asList(new ScheduleRequest.Custom[]{ScheduleRequest.Custom.M,
                    ScheduleRequest.Custom.T,
                    ScheduleRequest.Custom.W,
                    ScheduleRequest.Custom.TR,
                    ScheduleRequest.Custom.F});
            for(ScheduleRequest.Custom s:aa){
                List<DateTime> getDate = getAlldayDate(request.getSelectedFromDate(), request.getSelectedToDate(),map.get(s.toString()));
                dateTimes.addAll(getDate);
            }
            for (DateTime dateTime:dateTimes){
                Date fromDate = addTime(dateTime.toDate(),getDate(request.getSelectedFromTime()));
                Date toDate = addTime(dateTime.toDate(),getDate(request.getSelectedToTime()));
                saveSchedule(fromDate,toDate, request.getName(), room,scheduleList);
            }
        }
        else{
            saveSchedule(addTime(getDate(request.getSelectedFromDate()),getDate(request.getSelectedFromTime())),addTime(getDate(request.getSelectedToDate()),getDate(request.getSelectedToTime())), request.getName(), room,scheduleList);
        }



    }

    private Date addTime(Date date, Date date1){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.add(Calendar.HOUR_OF_DAY, date1.getHours());
        return calendar.getTime();
    }

    private List<DateTime> getAlldayDate(String start,String end,Integer constants){
        DateTimeFormatter pattern = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        DateTime startDate = DateTime.parse(start);
        DateTime endDate = DateTime.parse(end);

        List<DateTime> days = new ArrayList<>();

        while (startDate.isBefore(endDate)){
            if ( startDate.getDayOfWeek() == constants ){
                days.add(startDate);
            }
            startDate = startDate.plusDays(1);
        }
        return days;
    }

    private Schedule saveSchedule(Date fromDate,Date toDate,String schedule,Room room,List<Schedule> scheduleList) throws Exception {

        for(Schedule schedule1: scheduleList){
            boolean cond1 = isDateInBetweenIncludingEndPoints(getDate(schedule1.getFromDate().toString()),getDate(schedule1.getToDate().toString()),fromDate);
            boolean cond2 = isDateInBetweenIncludingEndPoints(getDate(schedule1.getFromDate().toString()),getDate(schedule1.getToDate().toString()),toDate);
            if(cond1 || cond2){
                throw new Exception("Cannot reserve because reservation already found for given date/time");
            }

        }
        Schedule schedule1 = new Schedule();
        schedule1.setFromDate(fromDate);
        schedule1.setToDate(toDate);
        schedule1.setName(schedule);
        schedule1.setRoom(room);
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
