package com.se.goBears.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private boolean availability;
    private WorkingCondition workingCondition;
    private ResourceType resourceType;
    @ManyToOne
    private ResourceReservation resourceReservation;

    @ManyToOne
    private Room room;

    @OneToOne
    private User user;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private enum WorkingCondition{
        Good,Excellent,Old
    }

    private enum ResourceType{
        Indoor,Outdoor
    }
}

