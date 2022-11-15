package com.se.goBears.dao;

import com.se.goBears.entity.Reservations;
import com.se.goBears.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationDao extends JpaRepository<Reservations, Long> {
    List<Reservations> findAllByBookedBy(Integer id);
}
