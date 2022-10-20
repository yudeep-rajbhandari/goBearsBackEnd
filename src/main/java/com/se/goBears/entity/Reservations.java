package com.se.goBears.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
@Data
@Entity
public class Reservations {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    private User bookedBy;

    private String fromDate;
    private String toDate;

    private Status status;
    public enum Status{
        Pending, Cancelled, Approved
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

    public User getBookedBy() {
        return bookedBy;
    }

    public void setBookedBy(User bookedBy) {
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
