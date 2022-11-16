package com.se.goBears.repository;

import com.se.goBears.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    List<Schedule> findScheduleByRoom_IdAndFromDateGreaterThan(Long roomId, Date fromdate);

    List<Schedule> findScheduleByFromDateGreaterThanAndToDateLessThan(Date fromdate,Date toDate);
}
