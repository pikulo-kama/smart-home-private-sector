package com.team2.dataemulatorservice.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class IndicatorGroup {

    private TemperatureIndicator<Integer> temperature;

    private Indicator<Long> carbonDioxide;

    private Indicator<Double> humidity;

    private IndicatorCollectionLocation location;
}
