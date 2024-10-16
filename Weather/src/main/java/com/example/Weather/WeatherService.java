package com.example.Weather;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class WeatherService {
    private final WeatherConfig weatherConfig;
    private final Map<String, WeatherRecord> weatherData = new HashMap<>();

    @Autowired
    public WeatherService(WeatherConfig weatherConfig) {
        this.weatherConfig = weatherConfig;
    }

    // Get weather for a city, with default handling
    public String getWeather(String city) {
        WeatherRecord record = weatherData.get(city);
        if (record == null) {
            return "Weather data not found for " + city;
        }
        return record.getCondition();
    }

    // Update weather data for a city
    public void updateWeatherData(String city, String condition) {
        String finalCondition = (condition == null || condition.isEmpty()) 
            ? weatherConfig.getDefaultCondition() 
            : condition;
        
        // Create a new WeatherRecord for each update
        WeatherRecord newRecord = new WeatherRecord(city, finalCondition);
        weatherData.put(city, newRecord);
    }
}
