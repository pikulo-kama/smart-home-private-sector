package com.team2.dataemulatorservice.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class TemperatureIndicator<T extends Number> extends Indicator<T> {

    private TemperatureMeasurementUnit temperatureMeasurementUnit;

    public TemperatureIndicator(T indicatorValue,
                                Double electricityConsumption,
                                TemperatureMeasurementUnit temperatureMeasurementUnit) {
        super(indicatorValue, electricityConsumption);
        this.temperatureMeasurementUnit = temperatureMeasurementUnit;
    }
}
