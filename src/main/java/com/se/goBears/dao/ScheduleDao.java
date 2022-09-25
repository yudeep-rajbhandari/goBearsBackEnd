package com.se.goBears.dao;

import com.se.goBears.entity.Room;
import com.se.goBears.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleDao extends JpaRepository<Schedule, Long> {

}
