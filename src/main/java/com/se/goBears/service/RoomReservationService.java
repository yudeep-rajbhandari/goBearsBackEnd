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


/**
 * This service class handles the request for the room reservations.
 */
@Service
public class RoomReservationService {

    @Autowired
    private RoomRepository roomDao;

    @Autowired
    private ReservationRepository reservationRepository;

    /**
     * This method returns a set of all reservation associated with a room.
     * @param roomId is the id of the room.
     * @return a list of reservation associated with the room.
     */
    public Set<Reservations> getRoomReservation(Long roomId){
        Room room = roomDao.findById(roomId).get();
        return room.getRoomReservation();
    }

    /**
     * This method returns a list of reservation associated with a user.
     * @param userId is the id of the user.
     * @return a list of reservations associated with the user.
     */
    public List<Reservations> getRoomReservationById(Integer userId){
        List<Reservations> reservationsList = reservationRepository.findAllByBookedBy(userId);
        return reservationsList;
    }

    /**
     * This method given a room id and reservation check if the reservation date is valid and add a new reservation
     * for the room.
     * @param roomId is the id of the room to be reserved.
     * @param reservations is the reservation object.
     * @return room object with newly added reservation.
     * @throws Exception if the reservation dates are already occupied.
     */
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

    /**
     * This method parses the string date and returns a date.
     * @param a the string value for date to be parsed.
     * @return a parsed date value.
     */
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

    /**
     * This method returns true if the given date exists between two other given dates.
     * @param min is the start date.
     * @param max is the end date.
     * @param date is the date to be checked if it is between two dates.
     * @return True if date exists between min and max dates else False.
     */
    public static boolean isDateInBetweenIncludingEndPoints(final Date min, final Date max, final Date date){
        return !(date.before(min) || date.after(max));
    }


    /**
     * This method returns a list of all room reservations.
     * @return a list of all reservations.
     */
    public List<Reservations> getAllRoomReservation(){
        return reservationRepository.findAll();
    }

    /**
     * This method handles the admin request to approve a reservation.
     * @param id is the id of the reservation.
     * @return reservation object with approved status.
     */
    public Reservations acceptRoomReservation(Long id){
        Reservations roomReservation = reservationRepository.findReservationsById(id);
        roomReservation.setStatus(Reservations.Status.APPROVED);
        return reservationRepository.save(roomReservation);
    }

    /**
     * This method handles the admin request to decline a reservation.
     * @param id is the id of the reservation.
     * @return reservation object with declined status.
     */
    public Reservations declineRoomReservation(Long id){
        Reservations roomReservation = reservationRepository.findReservationsById(id);
        roomReservation.setStatus(Reservations.Status.DECLINED);
        return reservationRepository.save(roomReservation);
    }

    /**
     * This method handles the admin request to arcjive a reservation.
     * @param id is the id of the reservation.
     * @return reservation object with archived status.
     */
    public Reservations archiveRoomReservation(Long id){
        Reservations roomReservation = reservationRepository.findReservationsById(id);
        roomReservation.setStatus(Reservations.Status.ARCHIVED);
        return reservationRepository.save(roomReservation);
    }
}
