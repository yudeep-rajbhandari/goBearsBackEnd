package com.se.goBears.repository;

import com.se.goBears.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    List<Schedule> findScheduleByRoomid(Long roomid);
}
