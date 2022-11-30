package com.se.goBears.service;

import com.se.goBears.entity.Reservations;
import com.se.goBears.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservations> getMyReservation(Long userId){
        return reservationRepository.findReservationsByBookedBy(Math.toIntExact(userId));
    }

    public Reservations cancelReservation(Long id){
        Reservations reservations = reservationRepository.findReservationsById(id);
        reservations.setStatus(Reservations.Status.CANCELED);

        return reservationRepository.save(reservations);
    }
}
