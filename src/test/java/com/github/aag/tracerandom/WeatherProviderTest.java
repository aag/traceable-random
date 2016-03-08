package com.github.aag.tracerandom;

import com.github.aag.traceablerandom.SeedValue;
import com.github.aag.traceablerandom.datasources.WeatherDataSource;
import com.github.aag.traceablerandom.providers.WeatherProvider;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WeatherProviderTest {

    @Test
    public void testGetSeedTextCelsius() {
        WeatherDataSource mockProvider = mock(WeatherDataSource.class);
        when(mockProvider.getWeatherSummary()).thenReturn("rainy");
        when(mockProvider.getTemperature()).thenReturn(6);
        when(mockProvider.getTemperatureUnits()).thenReturn(WeatherDataSource.Units.CELSIUS);

        WeatherProvider provider = new WeatherProvider(mockProvider);
        SeedValue val = provider.getCurrentSeedValue();

        assertEquals("rainy, 6°C", val.getSeedText());
    }

    @Test
    public void testGetSeedTextFahrenheit() {
        WeatherDataSource mockProvider = mock(WeatherDataSource.class);
        when(mockProvider.getWeatherSummary()).thenReturn("partly cloudy");
        when(mockProvider.getTemperature()).thenReturn(65);
        when(mockProvider.getTemperatureUnits()).thenReturn(WeatherDataSource.Units.FAHRENHEIGHT);

        WeatherProvider provider = new WeatherProvider(mockProvider);
        SeedValue val = provider.getCurrentSeedValue();

        assertEquals("partly cloudy, 65°F", val.getSeedText());
    }

}