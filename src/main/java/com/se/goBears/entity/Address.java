package com.se.goBears.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * This entity class defines all the variable and method declaration for the entity Address. This defines the
 * address for the buildings in the system.
 */
@Data
@Entity
public class Address implements Serializable {
    @Id
    @GeneratedValue
    /**
     * This is the auto generated id for the class objects.
     */
    private Long id;
    /**
     * This variable define the street name for the address.
     */
    private String street;
    /**
     * This variable define the city name for the address.
     */
    private String city;
    /**
     * This variable define the state name for the address.
     */
    private String state;
    /**
     * This variable define the zip code for the address.
     */
    private String zip;


}
