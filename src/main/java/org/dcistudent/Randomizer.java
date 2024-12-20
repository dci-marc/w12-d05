package org.dcistudent;

import java.util.Random;

public final class Randomizer {
    private static final Random RANDOM = new Random();

    static {
        RANDOM.setSeed(System.currentTimeMillis());
    }

    private Randomizer() {}

    public static Random getInstance() {
        return RANDOM;
    }
}
