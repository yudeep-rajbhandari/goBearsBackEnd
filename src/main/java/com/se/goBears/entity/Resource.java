package com.se.goBears.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * This entity class defines the methods and variables for the entity Resource. Resource defines all the
 * description for the resource.
 */
@Entity
public class Resource implements Serializable {

    /**
     * This variable annotated with @ID and @GeneratedValue defines an autogenerated id for entity objects.
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * This variable defines the name of the resource.
     */
    private String resourceName;
    /**
     * The variable defines the type of resource.
     */
    private ResourceType resourceType;
    /**
     * This variable defines the working condition of the resource.
     */
    private WorkingCondition workingCondition;


    /**
     * This enum class defines the possible type for a resource.
     */
    public enum ResourceType {
        INDOOR,
        OUTDOOR
    }

    ;

    /**
     * This enum class defines the possible values for working condition of a resource.
     */
    public enum WorkingCondition {
        EXCELLENT,
        GOOD,
        FAIR
    }

    ;

    /**
     * This variable annotated with @ManyToOne defines a ManyToOne relationship with Room entity.
     */
    @ManyToOne
    private Room room;

    /**
     * This variable annotated with @OneToMany defines a OneToMany relationship with Reservation entity.
     */
    @OneToMany
    private Set<Reservations> resourceReservations;

    /**
     * This method returns the id associated with a resource.
     *
     * @return the id of the resource.
     */
    public Long getId() {
        return id;
    }

    /**
     * This method sets the id associated with a resource.
     *
     * @param id is the id of the resource.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method returns the name of the resource.
     *
     * @return the name of the resource.
     */
    public String getResourceName() {
        return resourceName;
    }

    /**
     * This method sets the name of the resource.
     *
     * @param resourceName is the name of the resource.
     */
    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    /**
     * This method gets the room associated with the resource.
     *
     * @return the room associated.
     */
    public Room getRoom() {
        return room;
    }

    /**
     * This method sets the room associated with the resource.
     *
     * @param room is the room to be associated.
     */
    public void setRoom(Room room) {
        this.room = room;
    }

    /**
     * This method returns a set of resource reservations associated with the resource.
     *
     * @return a set of reservation.
     */
    public Set<Reservations> getResourceReservations() {
        return resourceReservations;
    }

    /**
     * This method sets the reservations for a resource.
     *
     * @param resourceReservations is the reservation to be set.
     */
    public void setResourceReservations(Set<Reservations> resourceReservations) {
        this.resourceReservations = resourceReservations;
    }

    /**
     * This method returns the resource type.
     *
     * @return the type of resource.
     */
    public ResourceType getResourceType() {
        return resourceType;
    }

    /**
     * This method sets the resource type.
     *
     * @param resourceType is the type of resource.
     */
    public void setResourceType(ResourceType resourceType) {
        this.resourceType = resourceType;
    }


    /**
     * This method returns the working condition of a resource.
     *
     * @return the working condition of a resource.
     */
    public WorkingCondition getWorkingCondition() {
        return workingCondition;
    }

    /**
     * This method sets the working condition of a resource.
     *
     * @param workingCondition is the working condition to be set.
     */
    public void setWorkingCondition(WorkingCondition workingCondition) {
        this.workingCondition = workingCondition;
    }

    public Resource() {
    }


}