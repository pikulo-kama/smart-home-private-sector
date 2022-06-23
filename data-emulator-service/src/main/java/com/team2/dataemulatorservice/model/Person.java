package com.team2.dataemulatorservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "persons")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Person {

    @Id
    private Long personId;

    private String personName;
}
