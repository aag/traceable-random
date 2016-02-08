package com.github.aag.traceablerandom;

import com.github.aag.traceablerandom.providers.SeedProvider;

import java.time.LocalDateTime;
import java.util.Random;

public class TraceableRandom {
    private final SeedValue seedValue;
    private final Random random;

    public TraceableRandom(SeedProvider seedProvider) {
        this.seedValue = seedProvider.getCurrentSeedValue();
        this.random = new Random(this.seedValue.getSeed());
    }

    public Random getRandom() {
        return random;
    }

    public String getSeedText() {
        return seedValue.getSeedText();
    }

    public LocalDateTime getSeedCreationDateTime() {
        return seedValue.getSeedCreationDateTime();
    }
}
