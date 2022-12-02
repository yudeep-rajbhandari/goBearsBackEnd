package com.se.goBears.service;

import com.se.goBears.entity.Reservations;
import com.se.goBears.entity.Resource;
import com.se.goBears.entity.Room;
import com.se.goBears.repository.ReservationRepository;
import com.se.goBears.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class ResourceReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ResourceRepository resourceRepository;

    public Resource resourceReservation(Long resourceId, Reservations reservations) throws Exception {
        Resource resource = resourceRepository.findById(resourceId).get();
        for(Reservations roomReservation: resource.getResourceReservations()){
            boolean cond1 = isDateInBetweenIncludingEndPoints(getDate(roomReservation.getFromDate()),getDate(roomReservation.getToDate()),getDate(reservations.getFromDate()));
            boolean cond2 = isDateInBetweenIncludingEndPoints(getDate(roomReservation.getFromDate()),getDate(roomReservation.getToDate()),getDate(reservations.getToDate()));
            boolean cond3 = isDateInBetweenIncludingEndPoints(getDate(reservations.getFromDate()),getDate(reservations.getToDate()),getDate(roomReservation.getFromDate()));
            boolean cond4 = isDateInBetweenIncludingEndPoints(getDate(reservations.getFromDate()),getDate(reservations.getToDate()),getDate(roomReservation.getToDate()));


            if(cond1 || cond2 || cond3 || cond4){
                throw new Exception("Cannot reserve because reservation already found for given date/time");
            }
        }
        reservations.setReserveType(Reservations.ReserveType.RESOURCE);
        reservations.setRoomId(resource.getId());
        Reservations roomReservation = reservationRepository.save(reservations);
        resource.getResourceReservations().add(roomReservation);
        resource.setId(resource.getId());
        return resourceRepository.save(resource);
    }
    public Date getDate(String a){
        try{
            SimpleDateFormat formatter6=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return formatter6.parse(a);
        }
        catch (Exception e){
            Instant inst2 = Instant.parse(a);
            return Date.from(inst2);
        }

    }
    public static boolean isDateInBetweenIncludingEndPoints(final Date min, final Date max, final Date date){
        return !(date.before(min) || date.after(max));
    }
}
