package com.example.Weather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class WeatherService {
    private final WeatherConfig weatherConfig;
    private final ApplicationContext context;
    private final Map<String, WeatherRecord> weatherData = new HashMap<>();

    @Autowired
    public WeatherService(WeatherConfig weatherConfig, ApplicationContext context) {
        this.weatherConfig = weatherConfig;
        this.context = context;
    }

    public String getWeather(String city) {
        WeatherRecord record = weatherData.get(city);
        if (record == null) {
            return weatherConfig.getDefaultCondition();
        }
        return String.format("The temperature in %s is %d°C. Condition: %s", 
                             city, record.getTemperature(), record.getCondition());
    }

    public void updateWeather(String city, int temperature) {
        WeatherRecord record = weatherData.computeIfAbsent(city, k -> {
            WeatherRecord newRecord = context.getBean(WeatherRecord.class);
            newRecord.initialize(city, temperature);
            return newRecord;
        });
        record.setTemperature(temperature);
        record.setCondition(determineCondition(city, temperature));
    }

    private String determineCondition(String city, int temperature) {
        WeatherConfig.TemperatureRange range = weatherConfig.getCityTemperatures().get(city);
        if (range == null) {
            return weatherConfig.getDefaultCondition();
        }
        if (temperature < range.getMin()) {
            return "Cold";
        } else if (temperature > range.getMax()) {
            return "Hot";
        } else {
            return "Pleasant";
        }
    }

    public Map<String, String> getAllWeatherData() {
        Map<String, String> result = new HashMap<>();
        weatherData.forEach((city, record) -> 
            result.put(city, String.format("%d°C, %s", record.getTemperature(), record.getCondition()))
        );
        return result;
    }
}

