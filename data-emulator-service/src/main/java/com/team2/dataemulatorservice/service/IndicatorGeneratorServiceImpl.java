package com.team2.dataemulatorservice.service;

import com.team2.dataemulatorservice.dto.Indicator;
import com.team2.dataemulatorservice.dto.IndicatorBounds;
import com.team2.dataemulatorservice.dto.IndicatorGroup;
import com.team2.dataemulatorservice.dto.IndicatorCollectionLocation;
import com.team2.dataemulatorservice.dto.TemperatureIndicator;
import com.team2.dataemulatorservice.repository.BuildingRepository;
import com.team2.dataemulatorservice.util.IndicatorComposer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.team2.dataemulatorservice.dto.TemperatureMeasurementUnit.CELSIUS;

@Service
public class IndicatorGeneratorServiceImpl implements IndicatorGeneratorService {

    private final BuildingRepository buildingRepository;

    @Value("${indicator.bounds.temperature.lower}")
    private Integer temperatureLower;

    @Value("${indicator.bounds.temperature.upper}")
    private Integer temperatureUpper;

    @Value("${indicator.bounds.carbon.dioxide.lower}")
    private Long carbonDioxideLower;

    @Value("${indicator.bounds.carbon.dioxide.upper}")
    private Long carbonDioxideUpper;

    @Value("${indicator.bounds.humidity.lower}")
    private Double humidityLower;

    @Value("${indicator.bounds.humidity.upper}")
    private Double humidityUpper;

    public IndicatorGeneratorServiceImpl(BuildingRepository buildingRepository) {
        this.buildingRepository = buildingRepository;
    }

    @Override
    public List<IndicatorGroup> generateMeasurements(Integer datasetSize) {
        List<IndicatorCollectionLocation> indicatorCollectionLocationList = IndicatorCollectionLocation.randomOf(buildingRepository.findAll(), datasetSize);

        List<TemperatureIndicator<Integer>> temperatureIndicators = IndicatorComposer.composeFrom(
                datasetSize,
                new IndicatorBounds<>(temperatureLower, temperatureUpper),
                Integer.class,
                (temperatureValue, electricityConsumption) -> new TemperatureIndicator<>(
                        temperatureValue, electricityConsumption, CELSIUS)
        );

        List<Indicator<Long>> co2Indicators = IndicatorComposer.composeFrom(
                datasetSize,
                new IndicatorBounds<>(carbonDioxideLower, carbonDioxideUpper),
                Long.class,
                Indicator::new
        );

        List<Indicator<Double>> humidityIndicators = IndicatorComposer.composeFrom(
                datasetSize,
                new IndicatorBounds<>(humidityLower, humidityUpper),
                Double.class,
                Indicator::new
        );

        return IntStream.range(0, datasetSize).boxed()
                .map(i -> IndicatorGroup.builder()
                                .temperature(temperatureIndicators.get(i))
                                .carbonDioxide(co2Indicators.get(i))
                                .humidity(humidityIndicators.get(i))
                                .location(indicatorCollectionLocationList.get(i))
                                .build())
                .collect(Collectors.toList());
    }
}
