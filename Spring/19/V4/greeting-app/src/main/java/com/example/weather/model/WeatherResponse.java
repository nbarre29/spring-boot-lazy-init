package com.example.weather.model;

import lombok.Data;
import java.util.Map;

@Data
public class WeatherResponse {
    private String name; // City name
    private Map<String, Object> main; // Temperature, Pressure, Humidity
    private Map<String, Object>[] weather; // Weather description
}
