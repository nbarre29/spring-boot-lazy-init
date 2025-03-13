package com.example.weather.service;

import com.example.weather.model.WeatherResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    private final RestTemplate restTemplate;
    private static final Logger logger = LoggerFactory.getLogger(WeatherService.class);

    @Value("${openweather.api.url}")
    private String apiUrl;

    @Value("${openweather.api.key}")
    private String apiKey;

    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Fetch weather details for a given city
     */
    public WeatherResponse getWeatherByCity(String city) {
        String url = String.format("%s?q=%s&appid=%s&units=metric", apiUrl, city, apiKey);
        try {
            logger.info("Fetching weather data for city: {}", city);
            return restTemplate.getForObject(url, WeatherResponse.class);
        } catch (RestClientException e) {
            logger.error("Error fetching weather data: {}", e.getMessage());
            return null;
        }
    }
}
