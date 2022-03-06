package com.example.springboot.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@Table(name = "pet")
@Entity
public class PetPO {

    @Id
    @GeneratedValue
    private int id;

    private String name;
    private String tag;

}
