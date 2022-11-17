package com.se.goBears.service;


import com.se.goBears.entity.Reservations;
import com.se.goBears.entity.Room;
import com.se.goBears.repository.ReservationRepository;
import com.se.goBears.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class RoomReservationService {

    @Autowired
    private RoomRepository roomDao;

    @Autowired
    private ReservationRepository reservationRepository;

    public Set<Reservations> getRoomReservation(Long roomId){
        Room room = roomDao.findById(roomId).get();
        return room.getRoomReservation();
    }

    public List<Reservations> getRoomReservationById(Integer userId){
        List<Reservations> reservationsList = reservationRepository.findAllByBookedBy(userId);
        return reservationsList;
    }

    public Room roomReservation(Long roomId, Reservations reservations) throws Exception {
        Room room = roomDao.findById(roomId).get();
        for(Reservations roomReservation: room.getRoomReservation()){
            boolean cond1 = isDateInBetweenIncludingEndPoints(getDate(roomReservation.getFromDate()),getDate(roomReservation.getToDate()),getDate(reservations.getFromDate()));
            boolean cond2 = isDateInBetweenIncludingEndPoints(getDate(roomReservation.getFromDate()),getDate(roomReservation.getToDate()),getDate(reservations.getToDate()));
            boolean cond3 = isDateInBetweenIncludingEndPoints(getDate(reservations.getFromDate()),getDate(reservations.getToDate()),getDate(roomReservation.getFromDate()));
            boolean cond4 = isDateInBetweenIncludingEndPoints(getDate(reservations.getFromDate()),getDate(reservations.getToDate()),getDate(roomReservation.getToDate()));


            if(cond1 || cond2 || cond3 || cond4){
                throw new Exception("Cannot reserve because reservation already found for given date/time");
            }

        }
        reservations.setReserveType(Reservations.ReserveType.Room);
        reservations.setRoomId(room.getId());
        Reservations roomReservation = reservationRepository.save(reservations);
        room.getRoomReservation().add(roomReservation);
        room.setId(room.getId());
        return roomDao.save(room);

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


    public List<Reservations> getAllRoomReservation(){
        return reservationRepository.findAll();
    }

    public Reservations acceptRoomReservation(Long id){
        Reservations roomReservation = reservationRepository.findReservationsById(id);
        roomReservation.setStatus(Reservations.Status.Approved);
        return reservationRepository.save(roomReservation);

    }
}
