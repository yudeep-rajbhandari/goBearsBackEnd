package com.se.goBears.service;


import com.se.goBears.config.jms.JmsOrderMessagingService;
import com.se.goBears.entity.Reservations;
import com.se.goBears.entity.Room;
import com.se.goBears.repository.ReservationRepository;
import com.se.goBears.repository.ResourceRepository;
import com.se.goBears.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * This service class handles the request for the room reservations.
 */
@Service
public class RoomReservationService {

    @Autowired
    private RoomRepository roomDao;

    @Autowired
    private ResourceRepository resourceRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private JmsOrderMessagingService messagingService;

    /**
     * This method returns a set of all reservation associated with a room.
     *
     * @param roomId is the id of the room.
     * @return a list of reservation associated with the room.
     */
    public Set<Reservations> getRoomReservation(Long roomId) {
        Room room = roomDao.findById(roomId).get();
        return room.getRoomReservation();
    }

    /**
     * This method returns a list of reservation associated with a user.
     *
     * @param userId is the id of the user.
     * @return a list of reservations associated with the user.
     */
    public List<Reservations> getRoomReservationById(Integer userId) {
        return reservationRepository.findAllByBookedBy(userId);
    }

    /**
     * This method given a room id and reservation check if the reservation date is valid and add a new reservation
     * for the room.
     *
     * @param roomId       is the id of the room to be reserved.
     * @param reservations is the reservation object.
     * @return room object with newly added reservation.
     * @throws Exception if the reservation dates are already occupied.
     */
    public Room roomReservation(Long roomId, Reservations reservations) throws Exception {
        Room room = roomDao.findById(roomId).get();
        for (Reservations roomReservation : room.getRoomReservation()) {
            boolean cond1 = isDateInBetweenIncludingEndPoints(getDate(roomReservation.getFromDate()), getDate(roomReservation.getToDate()), getDate(reservations.getFromDate()));
            boolean cond2 = isDateInBetweenIncludingEndPoints(getDate(roomReservation.getFromDate()), getDate(roomReservation.getToDate()), getDate(reservations.getToDate()));
            boolean cond3 = isDateInBetweenIncludingEndPoints(getDate(reservations.getFromDate()), getDate(reservations.getToDate()), getDate(roomReservation.getFromDate()));
            boolean cond4 = isDateInBetweenIncludingEndPoints(getDate(reservations.getFromDate()), getDate(reservations.getToDate()), getDate(roomReservation.getToDate()));


            if (cond1 || cond2 || cond3 || cond4) {
                throw new Exception("Cannot reserve because reservation already found for given date/time");
            }
        }

        Reservations roomReservation = saveRoomReservation(reservations, room.getId());
        room.getRoomReservation().add(roomReservation);
        room.setId(room.getId());


        return roomDao.save(room);
    }

    /**
     * This method returns true if the given date exists between two other given dates.
     *
     * @param min  is the start date.
     * @param max  is the end date.
     * @param date is the date to be checked if it is between two dates.
     * @return True if date exists between min and max dates else False.
     */
    public static boolean isDateInBetweenIncludingEndPoints(final Date min, final Date max, final Date date) {
        return !(date.before(min) || date.after(max));
    }

    /**
     * This method parses the string date and returns a date.
     *
     * @param a the string value for date to be parsed.
     * @return a parsed date value.
     */
    public Date getDate(String a) {
        try {
            SimpleDateFormat formatter6 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return formatter6.parse(a);
        } catch (Exception e) {
            Instant inst2 = Instant.parse(a);
            return Date.from(inst2);
        }

    }

    /**
     * This method saves a reservation for a room.
     * @param reservations is the reservation object.
     * @param roomId is the room associated with reservation.
     * @return a saved reservation.
     */
    public Reservations saveRoomReservation(Reservations reservations, Long roomId) {
        reservations.setReserveType(Reservations.ReserveType.ROOM);
        reservations.setEntityName(roomDao.findRoomById(roomId).getName());
        reservations.setEntityId(roomId);
        return reservationRepository.save(reservations);
    }

    /**
     * This method returns a list of all room reservations.
     *
     * @return a list of all reservations.
     */
    public List<Reservations> getAllRoomReservation() {
        return reservationRepository.findAll();
    }

    /**
     * This method handles the admin request to approve a reservation.
     *
     * @param id is the id of the reservation.
     * @return reservation object with approved status.
     */
    public Reservations acceptRoomReservation(Long id) {
        Reservations roomReservation = reservationRepository.findReservationsById(id);
        roomReservation.setStatus(Reservations.Status.APPROVED);
        sendEmail(roomReservation);
        return reservationRepository.save(roomReservation);
    }

    /**
     * This method send the reservation through messaging service.
     *
     * @param reservations is the reservation object to be sent.
     */
    public void sendEmail(Reservations reservations) {
        messagingService.sendOrder(reservations);
    }

    /**
     * This method handles the admin request to decline a reservation.
     *
     * @param id is the id of the reservation.
     * @return reservation object with declined status.
     */
    public Reservations declineRoomReservation(Long id) {
        Reservations roomReservation = reservationRepository.findReservationsById(id);
        roomReservation.setStatus(Reservations.Status.DECLINED);
        sendEmail(roomReservation);
        return reservationRepository.save(roomReservation);
    }

    /**
     * This method handles the admin request to arcjive a reservation.
     *
     * @param id is the id of the reservation.
     * @return reservation object with archived status.
     */
    public Reservations archiveRoomReservation(Long id) {
        Reservations roomReservation = reservationRepository.findReservationsById(id);
        roomReservation.setStatus(Reservations.Status.ARCHIVED);
        sendEmail(roomReservation);
        return reservationRepository.save(roomReservation);
    }

    /**
     * This method provides the list of room which does not have schedules between from and to date
     *
     * @param fromDate is the from date.
     * @param toDate   is the to date.
     * @return a list of room.
     */
    public List<Room> getRoomBySchedule(Date fromDate, Date toDate) {
        List<Room> roomList = roomDao.findAll().stream().filter(p -> p.isBookable()).collect(Collectors.toList());
        Set<Room> newRoomList = new HashSet<>();

        for (Room room : roomList) {
            if (room.getRoomReservation().isEmpty()) {
                newRoomList.add(room);
            }
            for (Reservations reservations1 : room.getRoomReservation()) {
                if (isDateInBetweenIncludingEndPoints(getDate(reservations1.getFromDate()), getDate(reservations1.getToDate()), fromDate)
                        || isDateInBetweenIncludingEndPoints(getDate(reservations1.getFromDate()), getDate(reservations1.getToDate()), toDate)
                ) {
                    break;
                }
                newRoomList.add(room);
            }

        }
        List<Room> roomList1 = new ArrayList<>();
        roomList1.addAll(newRoomList);
//       List<Room> newRoomList = roomList.stream().filter(room -> !roomIdList.contains(room.getId())).collect(Collectors.toList());
        return roomList1;
    }

    /**
     * This method runs every day at 1:10 and checks if any schedule is older than 30 days if yes then changes
     * the status to archived.
     */
    @Scheduled(cron = "0 1 1 * * ?")
    private void changeStatusCron() {
        List<Reservations> reservations = reservationRepository.findAll();
        Date currentDate = new Date();
        for (Reservations r : reservations) {
            ZonedDateTime now = ZonedDateTime.now();
            ZonedDateTime thirtyDaysAgo = now.plusDays(-30);

            if (getDate(r.getFromDate()).toInstant().isBefore(thirtyDaysAgo.toInstant())) {
                r.setStatus(Reservations.Status.ARCHIVED);
            }
        }
    }

    /**
     * This method deletes a reservation given a reservation id.
     * @param id is the id of the reservation to be deleted.
     */
    public void deleteReservationByid(Long id) {
        reservationRepository.deleteById(id);
    }
}
