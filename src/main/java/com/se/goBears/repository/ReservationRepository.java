package com.se.goBears.repository;

import com.se.goBears.entity.Reservations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

/**
 * This is a repository interface for Reservation entity.
 */
public interface ReservationRepository extends JpaRepository<Reservations, Long> {
    /**
     * This method returns all reservation for a user id.
     *
     * @param id user id.
     * @return a list of reservations.
     */
    List<Reservations> findAllByBookedBy(Integer id);


    /**
     * This method returns a list of all reservations.
     *
     * @return a list of reservation.
     */
    List<Reservations> findAll();


    /**
     * This method a reservations by a reservation id.
     *
     * @param id is id of the reservation.
     * @return reservation.
     */
    Reservations findReservationsById(Long id);

    /**
     * This method returns all reservation for a user id.
     *
     * @param userId is the user id.
     * @return a list of reservations.
     */
    List<Reservations> findReservationsByBookedBy(Integer userId);

    @Query(
            value = "select * from Reservations r where r.from_date > ? and r.to_date < ? ",
            nativeQuery = true)
    List<Reservations> findReservationsByFromDateGreaterThanAndToDateLessThan(Date fromdate, Date toDate);
}
