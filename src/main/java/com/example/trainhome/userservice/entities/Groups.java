package com.example.trainhome.userservice.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "groups")
public class Groups {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private Coach coachId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private SportSphere sportSphereId;

    @Column(name = "max_count", nullable = false)
    private Integer maxCount;

    @Column(name = "count", nullable = false)
    private Integer count;

    @Column(name = "trains_left", nullable = false)
    private Integer trainsLeft;
}
