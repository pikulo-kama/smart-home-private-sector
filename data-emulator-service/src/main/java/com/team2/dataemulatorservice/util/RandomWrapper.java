package com.team2.dataemulatorservice.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Random;

@NoArgsConstructor(access = AccessLevel.NONE)
public class RandomWrapper {

    private static final Random random = new Random();

    public static Random getRandom() {
        return random;
    }
}
