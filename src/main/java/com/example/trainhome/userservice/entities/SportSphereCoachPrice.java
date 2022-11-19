package com.example.trainhome.userservice.entities;

import com.example.trainhome.userservice.entities.compositeKeys.SportSphereCoachPriceId;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "person")
public class SportSphereCoachPrice {
    @EmbeddedId
    private SportSphereCoachPriceId id;

    @Column(name = "price", nullable = false)
    private Integer price;
}
