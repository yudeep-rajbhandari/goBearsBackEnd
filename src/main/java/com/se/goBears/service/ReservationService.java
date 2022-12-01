package com.se.goBears.service;

import com.se.goBears.entity.Reservations;
import com.se.goBears.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * This is the service class for Reservation entity.
 */
@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    /**
     * This method returns a list of reservations associated with a user id.
     * @param userId is the id of the user to be looked for.
     * @return a list of reservation associated with a user.
     */
    public List<Reservations> getMyReservation(Long userId){
        return reservationRepository.findReservationsByBookedBy(Math.toIntExact(userId));
    }

    /**
     * This method given the reservation id, cancels the reservation.
     * @param id is the id of the reservation to be cancelled.
     * @return the reservation object with cancelled status.
     */
    public Reservations cancelReservation(Long id){
        Reservations reservations = reservationRepository.findReservationsById(id);
        reservations.setStatus(Reservations.Status.CANCELED);

        return reservationRepository.save(reservations);
    }
}
