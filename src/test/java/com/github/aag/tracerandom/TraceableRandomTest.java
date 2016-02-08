package com.github.aag.tracerandom;

import com.github.aag.traceablerandom.SeedValue;
import com.github.aag.traceablerandom.TraceableRandom;
import com.github.aag.traceablerandom.providers.SeedProvider;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TraceableRandomTest {
    @Test
    public void testGetSeedText() {
        SeedValue seedValue = new SeedValue("test seed", LocalDateTime.of(2016, 01, 02, 03, 04));

        SeedProvider mockProvider = mock(SeedProvider.class);
        when(mockProvider.getCurrentSeedValue()).thenReturn(seedValue);

        TraceableRandom traceableRandom = new TraceableRandom(mockProvider);
        assertEquals("test seed", traceableRandom.getSeedText());
    }

    @Test
    public void testGetSeedCreationTime() {
        SeedValue seedValue = new SeedValue("test seed", LocalDateTime.of(2016, 02, 03, 04, 05));

        SeedProvider mockProvider = mock(SeedProvider.class);
        when(mockProvider.getCurrentSeedValue()).thenReturn(seedValue);

        TraceableRandom traceableRandom = new TraceableRandom(mockProvider);
        assertEquals(LocalDateTime.of(2016, 02, 03, 04, 05), traceableRandom.getSeedCreationDateTime());
    }
}
