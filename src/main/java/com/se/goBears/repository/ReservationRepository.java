package com.se.goBears.repository;

import com.se.goBears.entity.Reservations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservations, Long> {
    List<Reservations> findAllByBookedBy(Integer id);


    List<Reservations> findAll();


    Reservations findReservationsById(Long id);

    List<Reservations> findReservationsByBookedBy(Integer userId);

    @Query(
            value = "select * from Reservations r where r.from_date > ? and r.to_date < ? ",
            nativeQuery = true)
    List<Reservations> findReservationsByFromDateGreaterThanAndToDateLessThan(Date fromdate, Date toDate);
}
