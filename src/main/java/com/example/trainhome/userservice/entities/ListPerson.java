package com.example.trainhome.userservice.entities;

import com.example.trainhome.userservice.entities.compositeKeys.ListPersonId;
import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "list_person")
public class ListPerson {
    @EmbeddedId
    private ListPersonId id;
}
