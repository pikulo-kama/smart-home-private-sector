package com.team2.dataemulatorservice.util;

import com.team2.dataemulatorservice.dto.Indicator;
import com.team2.dataemulatorservice.dto.IndicatorBounds;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

@NoArgsConstructor(access = AccessLevel.NONE)
public class IndicatorComposer {

    public static <T extends Number, I extends Indicator<T>> List<I> composeFrom(
            Integer datasetSize,
            IndicatorBounds<T> indicatorBounds,
            Class<T> tClass,
            BiFunction<T, Double, I> transformFunction) {

        double lower = indicatorBounds.getLowerBound().doubleValue();
        double upper = indicatorBounds.getUpperBound().doubleValue();

        return composeFrom(datasetSize, indicatorBounds, tClass, transformFunction, new IndicatorBounds<>(lower, upper));
    }

    public static <T extends Number, I extends Indicator<T>> List<I> composeFrom(
            Integer datasetSize,
            IndicatorBounds<T> indicatorBounds,
            Class<T> tClass,
            BiFunction<T, Double, I> transformFunction,
            IndicatorBounds<Double> electricityConsumptionIndicatorBounds) {

        List<I> indicators = new ArrayList<>();
        I indicator;

        for (int i = 0; i < datasetSize; i++) {
            indicator = transformFunction.apply(
                    indicatorBounds.getRandomPoint(tClass),
                    electricityConsumptionIndicatorBounds.getRandomPoint(Double.class));

            indicators.add(indicator);
        }

        return indicators;
    }
}
