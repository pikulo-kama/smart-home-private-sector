package com.team2.dataemulatorservice.service;

import com.team2.dataemulatorservice.dto.IndicatorGroup;

import java.util.List;

public interface IndicatorPublisherService {

    /**
     * Used to send metrics to Kafka topics
     *
     * @param measurementDataList Indicator data
     * @param publishInterval interval with which data would be sent to Kafka topics
     */
    void publishGeneratedData(List<IndicatorGroup> measurementDataList, Long publishInterval);
}
