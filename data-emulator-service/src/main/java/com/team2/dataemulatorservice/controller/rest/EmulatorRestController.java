package com.team2.dataemulatorservice.controller.rest;

import com.team2.dataemulatorservice.dto.IndicatorGroup;
import com.team2.dataemulatorservice.service.IndicatorPublisherService;
import com.team2.dataemulatorservice.service.IndicatorGeneratorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmulatorRestController {

    private final IndicatorGeneratorService indicatorGeneratorService;
    private final IndicatorPublisherService indicatorPublisherService;

    public EmulatorRestController(IndicatorGeneratorService indicatorGeneratorService,
                                  IndicatorPublisherService indicatorPublisherService) {
        this.indicatorGeneratorService = indicatorGeneratorService;
        this.indicatorPublisherService = indicatorPublisherService;
    }

    @GetMapping("/sendEmulated")
    public void emulateAndSendData(
            @RequestParam(name = "size", required = false, defaultValue = "1") Integer size,
            @RequestParam(name = "interval", required = false, defaultValue = "3000") Long interval) {
        List<IndicatorGroup> generatedData = indicatorGeneratorService.generateMeasurements(size);
        indicatorPublisherService.publishGeneratedData(generatedData, interval);
    }

    @GetMapping("/emulate")
    public List<IndicatorGroup> emulateAndGetData(
            @RequestParam(name = "size", required = false, defaultValue = "1") Integer size) {
        return indicatorGeneratorService.generateMeasurements(size);
    }
}
