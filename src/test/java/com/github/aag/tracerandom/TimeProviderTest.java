package com.github.aag.tracerandom;

import com.github.aag.traceablerandom.SeedValue;
import com.github.aag.traceablerandom.providers.TimeProvider;
import org.junit.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

import static org.junit.Assert.assertEquals;

public class TimeProviderTest {
    @Test
    public void testGetCurrentSeedText() {
        Clock clock = Clock.fixed(Instant.ofEpochSecond(1454760000, 0), ZoneId.systemDefault());

        TimeProvider provider = new TimeProvider(clock);
        SeedValue val = provider.getCurrentSeedValue();

        assertEquals("2016-02-06 13:00:00", val.getSeedText());
    }

    @Test
    public void testGetCurrentSeed() {
        Clock clock = Clock.fixed(Instant.ofEpochSecond(1454760000, 0), ZoneId.systemDefault());

        TimeProvider provider = new TimeProvider(clock);
        SeedValue val = provider.getCurrentSeedValue();

        assertEquals(-310677989, val.getSeed());
    }
}
