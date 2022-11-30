package com.se.goBears.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class Gate implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private Double latitude;
    private Double longitude;
    private String picture;
    private String elevator;
    private String elevatorPicture;

}
