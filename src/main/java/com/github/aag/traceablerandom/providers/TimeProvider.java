package com.github.aag.traceablerandom.providers;

import com.github.aag.traceablerandom.SeedValue;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeProvider implements SeedProvider {

    private final Clock clock;

    public TimeProvider(Clock clock) {
        this.clock = clock;
    }

    @Override
    public SeedValue getCurrentSeed() {
        LocalDateTime dt = LocalDateTime.now(clock);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        return new SeedValue(dt.format(formatter), dt);
    }
}
