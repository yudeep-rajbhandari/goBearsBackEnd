package com.se.goBears.entity;

import javax.persistence.*;

/**
 * This entity class defines the methods and variables for the entity Reservations. Reservation handles all
 * reservations.
 */
@Entity
public class Reservations {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;


    private Integer bookedBy;

    private String fromDate;

    private String toDate;

    private long entityId;

    private String entityName;
    private Status status = Status.PENDING;
    private ReserveType reserveType;

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public long getEntityId() {

        return entityId;
    }

    public void setEntityId(long roomId) {

        this.entityId = roomId;
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

    public enum Status {
        PENDING, DECLINED, APPROVED, ARCHIVED, CANCELED
    }

    public enum ReserveType {
        ROOM, RESOURCE
    }
}
