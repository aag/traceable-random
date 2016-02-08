package com.github.aag.tracerandom;


import com.github.aag.traceablerandom.SeedValue;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class SeedValueTest {

    @Test
    public void testGetSeedText() {
        SeedValue val = new SeedValue("test data", LocalDateTime.now());

        assertEquals("test data", val.getSeedText());
    }

    @Test
    public void testGetRetrievalDateTime() {
        LocalDateTime dt = LocalDateTime.of(2016, 02, 06, 12, 00);
        SeedValue val = new SeedValue("test data", dt);

        assertEquals(dt, val.getSeedCreationDateTime());
    }

    @Test
    public void testGetSeed() {
        SeedValue val = new SeedValue("test data", LocalDateTime.now());

        assertEquals("test data".hashCode(), val.getSeed());
    }


}
