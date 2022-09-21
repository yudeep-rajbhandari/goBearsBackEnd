package com.se.goBears.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Direction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String description;

    @OneToOne
    private Room room;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
