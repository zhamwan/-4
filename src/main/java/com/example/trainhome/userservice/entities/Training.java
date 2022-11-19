package com.example.trainhome.userservice.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "training")
public class Training {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "training_date", nullable = false, unique = true)
    private Date trainingDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private Coach coachId;

    @Column(name = "link", nullable = false)
    private String link;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Groups groupId;
}
