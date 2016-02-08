package com.github.aag.traceablerandom.providers;

import com.github.aag.traceablerandom.SeedValue;

public interface SeedProvider
{
    SeedValue getCurrentSeedValue();
}