package com.se.goBears.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * This entity class defines the methods and variables for the entity Gate. Gate defines all the description
 * for the Gate.
 */
@Data
@Entity
public class Gate implements Serializable {

    /**
     * This variable annotated with @ID and @GeneratedValue defines an autogenerated id for entity objects.
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * This variable defines the name of the Gate.
     */
    private String name;
    /**
     * This variable defines the latitude of the Gate.
     */
    private Double latitude;
    /**
     * This variable defines the longitude of the Gate.
     */
    private Double longitude;
    /**
     * This variable represents the picture for the Gate.
     */
    private String picture;
    /**
     * The variable is to define the elevator related to the Gate.
     */
    private String elevator;
    /**
     * This variable defines the picture of the elevator related to the Gate.
     */
    private String elevatorPicture;

}
