package com.team2.dataemulatorservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Indicator<T extends Number> {

    private T indicatorValue;

    private Double electricityConsumption;
}
