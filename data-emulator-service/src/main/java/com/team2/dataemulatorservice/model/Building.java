package com.team2.dataemulatorservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "buildings")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Building {

    @Id
    private Long buildingId;

    private String buildingVerboseAddress;

    @ManyToOne
    @JoinColumn(name = "building_owner_id")
    private Person buildingOwner;

    @OneToMany(mappedBy = "buildingId")
    private List<Room> rooms;
}
