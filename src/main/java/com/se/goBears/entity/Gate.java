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
    private String latitude;
    private String longitude;
    private String picture;
    private String elevator;
    private String elevatorPicture;

}
