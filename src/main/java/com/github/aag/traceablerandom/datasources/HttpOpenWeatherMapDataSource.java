package com.github.aag.traceablerandom.datasources;


import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * This class implements an interface to the OpenWeatherMap API.
 * Using it requires first signing up at http://openweathermap.org/
 * and getting an API key.
 */

public class HttpOpenWeatherMapDataSource implements WeatherDataSource {
    private final String apiKey;
    private final Units units;
    private final String location;

    private int temperature;
    private LocalDateTime weatherDateTime;
    private String summary;

    /**
     * @param apiKey   An API key from the OpenWeatherMap website.
     * @param units    The units of measure for the temperature.
     * @param location A location string for the API. Examples: "London,uk" or "Berlin,de".
     */
    public HttpOpenWeatherMapDataSource(
            String apiKey,
            Units units,
            String location
    ) {
        this.apiKey = apiKey;
        this.units = units;
        this.location = location;
    }

    /**
     * Do an HTTP request to the API server and store the parts of the
     * response as local variables.
     */
    public void update() {
        try {
            HttpResponse<JsonNode> response = Unirest.get("http://api.openweathermap.org/data/2.5/weather")
                    .queryString("appid", apiKey)
                    .queryString("units", getUnitsQueryString())
                    .queryString("q", location)
                    .asJson();

            JSONObject responseJson = response.getBody().getObject();

            double temp = responseJson.getJSONObject("main")
                    .getDouble("temp");
            this.temperature = (int) Math.round(temp);

            Instant weatherDT = Instant.ofEpochSecond(responseJson.getLong("dt"));
            weatherDateTime = LocalDateTime.ofInstant(weatherDT, ZoneId.systemDefault());

            summary = responseJson.getJSONArray("weather")
                    .getJSONObject(0)
                    .getString("description");

        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }

    @Override
    public LocalDateTime getWeatherDateTime() {
        return weatherDateTime;
    }

    @Override
    public int getTemperature() {
        return temperature;
    }

    @Override
    public Units getTemperatureUnits() {
        return units;
    }

    @Override
    public String getWeatherSummary() {
        return summary;
    }

    /**
     * Gets the string value of the object's temperature units for use in the
     * API's query string.
     *
     * @return String
     */
    private String getUnitsQueryString() {
        String queryString;

        switch (units) {
            case FAHRENHEIGHT:
                queryString = "imperial";
                break;
            default:
                queryString = "metric";
                break;
        }

        return queryString;
    }
}
