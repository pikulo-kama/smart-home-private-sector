package com.team2.dataemulatorservice.service;

import com.team2.dataemulatorservice.dto.IndicatorGroup;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndicatorPublisherServiceImpl implements IndicatorPublisherService {

    @Override
    public void publishGeneratedData(List<IndicatorGroup> measurementDataList, Long publishInterval) {
        // todo
    }
}
