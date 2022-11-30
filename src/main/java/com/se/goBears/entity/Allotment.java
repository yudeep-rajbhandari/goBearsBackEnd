package com.se.goBears.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
public class Allotment implements Serializable {
    @Id
   @GeneratedValue
    private Long id;

    @ManyToOne
    private Room room;

    private Date fromDate;
    private Date toDate;

    @OneToOne
    private User user;


}
