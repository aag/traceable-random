package com.github.aag.traceablerandom.datasources;


import java.time.LocalDateTime;

public interface WeatherDataSource {
    /**
     * Updates the weather data from the external source.
     */
    void update();

    /**
     * Returns the DateTime of the weather reading.
     */
    LocalDateTime getWeatherDateTime();

    /**
     * Returns the temperature. Must be combined with the value returned by
     * getUnits() to know the actual temperature.
     */
    int getTemperature();

    /**
     * Returns the units of the temperature reading.
     */
    Units getTemperatureUnits();

    /**
     * Returns a short string summary of the weather conditions.
     * Examples: "scattered clouds" or "light rain".
     */
    String getWeatherSummary();


    enum Units {
        CELSIUS,
        FAHRENHEIGHT,
    }
}
