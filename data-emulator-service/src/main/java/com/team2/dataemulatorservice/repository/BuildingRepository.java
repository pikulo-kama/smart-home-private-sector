package com.team2.dataemulatorservice.repository;

import com.team2.dataemulatorservice.model.Building;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingRepository extends JpaRepository<Building, Long> {
}
