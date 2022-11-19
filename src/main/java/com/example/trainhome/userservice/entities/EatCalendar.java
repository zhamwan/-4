package com.example.trainhome.userservice.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "eat_calendar")
public class EatCalendar {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "info")
    private String info;

    @Column(name = "date", nullable = false)
    private Date date;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Person personId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private Coach coachId;
}
