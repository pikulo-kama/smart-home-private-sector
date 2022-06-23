package com.team2.dataemulatorservice.service;

import com.team2.dataemulatorservice.dto.IndicatorGroup;

import java.util.List;

public interface IndicatorGeneratorService {

    List<IndicatorGroup> generateMeasurements(Integer datasetSize);
}
