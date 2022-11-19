package com.example.trainhome.userservice.entities.compositeKeys;

import com.example.trainhome.userservice.entities.Coach;
import com.example.trainhome.userservice.entities.SportSphere;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class SportSphereCoachPriceId implements Serializable {
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private Coach coachId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private SportSphere sportSphereId;
}
