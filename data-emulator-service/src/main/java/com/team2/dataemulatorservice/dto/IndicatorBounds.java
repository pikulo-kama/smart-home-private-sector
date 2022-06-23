package com.team2.dataemulatorservice.dto;

import com.team2.dataemulatorservice.util.RandomWrapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Random;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class IndicatorBounds<T extends Number> {

    private T lowerBound;

    private T upperBound;

    public T getRandomPoint(Class<T> boundType) {
        Random random = RandomWrapper.getRandom();
        T bounds = null;

        if (Double.class.equals(boundType)) {
            bounds = (T) Double.valueOf(
                    lowerBound.doubleValue() +
                            (upperBound.doubleValue() - lowerBound.doubleValue()) *
                                    random.nextDouble());
        } else if (Long.class.equals(boundType)) {
            bounds = (T) Long.valueOf(
                    lowerBound.longValue() +
                            (upperBound.longValue() - lowerBound.longValue()) *
                                    random.nextLong());
        } else if (Integer.class.equals(boundType)) {
            bounds = (T) Integer.valueOf(
                    random.nextInt(upperBound.intValue() - lowerBound.intValue()) +
                            lowerBound.intValue()
            );
        }

        return bounds;
    }
}
