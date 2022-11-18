package com.se.goBears.entity;

import javax.persistence.*;

@Entity
public class Reservations {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;


    private Integer bookedBy;

    private String fromDate;

    private String toDate;

    private long roomId;

    public long getRoomId() {

        return roomId;
    }

    public void setRoomId(long roomId) {

        this.roomId = roomId;
    }

    private Status status = Status.PENDING;
    public enum Status{
        PENDING, DECLINED, APPROVED, ARCHIVED
    }

    private ReserveType reserveType;
    public enum ReserveType{
        Room, Resource
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBookedBy() {
        return bookedBy;
    }

    public void setBookedBy(Integer bookedBy) {
        this.bookedBy = bookedBy;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public ReserveType getReserveType() {
        return reserveType;
    }

    public void setReserveType(ReserveType reserveType) {
        this.reserveType = reserveType;
    }
}
