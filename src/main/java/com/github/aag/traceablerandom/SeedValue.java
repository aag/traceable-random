package com.github.aag.traceablerandom;


import java.time.LocalDateTime;

/**
 * This is a value object that represents the RNG seed and associated data for
 * a traceable random seed.
 */

public class SeedValue {
    private final String seedText;
    private final LocalDateTime retrievalDateTime;
    private final long seed;

    public SeedValue(String seedText, LocalDateTime retrievalDateTime) {
        this.seedText = seedText;
        this.retrievalDateTime = retrievalDateTime;

        this.seed = (long) seedText.hashCode();
    }

    public String getSeedText() {
        return seedText;
    }

    public LocalDateTime getSeedCreationDateTime() {
        return retrievalDateTime;
    }

    public long getSeed() {
        return seed;
    }

}
