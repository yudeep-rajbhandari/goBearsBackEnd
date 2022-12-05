package com.se.goBears.repository;

import com.se.goBears.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

/**
 * This is a repository interface for Schedule entity.
 */
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {


    /**
     * This method returns all schedule given a room id and a from date.
     * @param roomId is the id of the room.
     * @param fromdate is the from date for the schedule.
     * @return a list of schedule for a room after the given from date.
     */
    List<Schedule> findScheduleByRoomIdAndFromDateGreaterThan(Long roomId, Date fromdate);

    /**
     * This method returns a schedule list given a from and a to date.
     * @param fromdate is the date for the search to begin.
     * @param toDate is the date for which search is to end.
     * @return a list of schedule between the fron and to dates.
     */
    List<Schedule> findScheduleByFromDateGreaterThanAndToDateLessThan(Date fromdate,Date toDate);
}
