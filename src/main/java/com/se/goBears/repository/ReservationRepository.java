package com.se.goBears.repository;

import com.se.goBears.entity.Reservations;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservations, Long> {
    List<Reservations> findAllByBookedBy(Integer id);


    List<Reservations> findAll();


    Reservations findReservationsById(Long id);

    List<Reservations> findReservationsByBookedBy(Integer userId);
}
