package com.github.aag.traceablerandom.providers;

import com.github.aag.traceablerandom.SeedValue;
import com.github.aag.traceablerandom.datasources.WeatherDataSource;

import java.time.Clock;
import java.time.LocalDateTime;

public class WeatherProvider implements SeedProvider {

    private WeatherDataSource dataSource;

    public WeatherProvider(WeatherDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public SeedValue getCurrentSeedValue() {
        dataSource.update();

        WeatherDataSource.Units units = dataSource.getTemperatureUnits();

        String seedText = dataSource.getWeatherSummary() + ", "
                + dataSource.getTemperature()
                + getTemperatureUnitsString(units);

        return new SeedValue(seedText, dataSource.getWeatherDateTime());
    }

    private String getTemperatureUnitsString(WeatherDataSource.Units units) {
        String unitsString;

        switch (units) {
            case FAHRENHEIGHT:
                unitsString = "°F";
                break;
            default:
                unitsString = "°C";
                break;
        }

        return unitsString;
    }

    private String formatTemperature(double temp, WeatherDataSource.Units units) {
        String tempString;

        switch (units) {
            case FAHRENHEIGHT:
                tempString = String.valueOf(Math.round(temp));
                break;
            default:
                tempString = String.format("%.1f", temp);
                break;
        }

        return tempString;
    }
}
