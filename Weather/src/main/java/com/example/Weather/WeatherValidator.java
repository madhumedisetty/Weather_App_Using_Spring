package com.example.Weather;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WeatherValidator {
    public void validateWeatherCondition(WeatherRequestDTO weatherRequestDTO) {
        List<String> violations = new ArrayList<>();
    
        if (weatherRequestDTO.getTemperature() > 30 && "snowy".equalsIgnoreCase(weatherRequestDTO.getWeatherCondition())) {
            violations.add("Snowy weather is not allowed when temperature is above 30 degrees");
        }
    
        if (weatherRequestDTO.getTemperature() < 0 && "sunny".equalsIgnoreCase(weatherRequestDTO.getWeatherCondition())) {
            violations.add("Sunny weather is not allowed when temperature is below 0 degrees");
        }
    
        if (!violations.isEmpty()) {
            throw new WeatherValidationException(String.join(" ", violations), violations);
        }
    }
    
}
