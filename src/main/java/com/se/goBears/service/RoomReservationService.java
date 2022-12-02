package com.se.goBears.service;


import com.se.goBears.config.jms.JmsOrderMessagingService;
import com.se.goBears.entity.Reservations;
import com.se.goBears.entity.Room;
import com.se.goBears.payload.request.ScheduleRequest;
import com.se.goBears.repository.ReservationRepository;
import com.se.goBears.repository.RoomRepository;
import com.se.goBears.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class RoomReservationService {

    @Autowired
    private RoomRepository roomDao;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private JmsOrderMessagingService messagingService;

    public Set<Reservations> getRoomReservation(Long roomId){
        Room room = roomDao.findById(roomId).get();
        return room.getRoomReservation();
    }

    public List<Reservations> getRoomReservationById(Integer userId){
        return  reservationRepository.findAllByBookedBy(userId);
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
        reservations.setReserveType(Reservations.ReserveType.ROOM);
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
        roomReservation.setStatus(Reservations.Status.APPROVED);
        sendEmail(roomReservation);
        return reservationRepository.save(roomReservation);
    }
    public Reservations declineRoomReservation(Long id){
        Reservations roomReservation = reservationRepository.findReservationsById(id);
        roomReservation.setStatus(Reservations.Status.DECLINED);
        sendEmail(roomReservation);
        return reservationRepository.save(roomReservation);
    }
    public Reservations archiveRoomReservation(Long id){
        Reservations roomReservation = reservationRepository.findReservationsById(id);
        roomReservation.setStatus(Reservations.Status.ARCHIVED);
        sendEmail(roomReservation);
        return reservationRepository.save(roomReservation);
    }
    public void sendEmail(Reservations reservations){
        messagingService.sendOrder(reservations);
    }

    public List<Room> getRoomBySchedule(Date fromDate,Date toDate){
            List<Room> roomList = roomDao.findAll().stream().filter(p->p.isBookable()).collect(Collectors.toList());
            Set<Room> newRoomList = new HashSet<>();

        for(Room room:roomList){
            if(room.getRoomReservation().isEmpty()){
                newRoomList.add(room);
            }
            for(Reservations reservations1:room.getRoomReservation()){
                if(isDateInBetweenIncludingEndPoints(getDate(reservations1.getFromDate()),getDate(reservations1.getToDate()),fromDate)
                || isDateInBetweenIncludingEndPoints(getDate(reservations1.getFromDate()),getDate(reservations1.getToDate()),toDate)
                ){
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
    @Scheduled(cron = "0 1 1 * * ?")
    private void changeStatusCron(){
        List<Reservations> reservations = reservationRepository.findAll();
        Date currentDate = new Date();
        for(Reservations r: reservations){
            ZonedDateTime now = ZonedDateTime.now();
            ZonedDateTime thirtyDaysAgo = now.plusDays(-30);

            if (getDate(r.getFromDate()).toInstant().isBefore(thirtyDaysAgo.toInstant())) {
                        r.setStatus(Reservations.Status.ARCHIVED);
            }
        }
    }
}
