package com.example.Weather;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

// Service class for handling weather data logic
@Service
public class WeatherService {

    private final WeatherConfig weatherConfig; // Configuration object for default weather conditions
    private final Map<String, String> weatherData = new HashMap<>(); // In-memory storage for weather data

    // Constructor injection for WeatherConfig
    @Autowired
    public WeatherService(WeatherConfig weatherConfig) {
        this.weatherConfig = weatherConfig;
    }

    // Fetch weather for a specific city
    public String getWeather(String city) {
        
        return weatherData.getOrDefault(city, weatherConfig.getDefaultCondition()); // Return weather or default condition
    }

    // Fetch weather for a specific city and country
    public String getWeather(String city, String country) {
        
        String key = generateKey(city, country); // Generate key for city and country
        return weatherData.getOrDefault(key, weatherConfig.getDefaultCondition()); // Return weather or default condition
    }

    // Update the weather condition for a specific city (and optionally country)
    public String updateWeather(String city, String country, String condition) {
        // Use default condition if none is provided
        String finalCondition = (condition == null || condition.isEmpty()) 
                                ? weatherConfig.getDefaultCondition() // Set to default if condition is missing
                                : condition;

        String key = generateKey(city, country); // Generate key for city and country
        weatherData.put(key, finalCondition); // Update the weather data map

        return finalCondition; // Return the updated condition
    }

    // Helper method to generate a key for city and country
    private String generateKey(String city, String country) {
        return city + (country != null ? "," + country : ""); // Concatenate city and country for the key
    }
}

