package com.example.trainhome.userservice.entities;

import com.example.trainhome.userservice.entities.compositeKeys.GroupPersonId;
import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "group_person")
public class GroupPerson {
    @EmbeddedId
    private GroupPersonId id;
}
