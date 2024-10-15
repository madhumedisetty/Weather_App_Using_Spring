package com.example.Weather;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

// REST controller for handling weather-related requests
@RestController
@RequestMapping("/api")
@Validated // Enables validation for method parameters
public class WeatherController {

    private final WeatherService weatherService;

    // Constructor injection for WeatherService
    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    // GET endpoint to fetch weather information based on city (and optionally country)
    @GetMapping("/weather")
    public String getWeather(@RequestParam @NotBlank String city,
                             @RequestParam(required = false) String country) {
        // Check if country is provided, and return appropriate weather info
        if (country == null || country.isEmpty()) {
            return weatherService.getWeather(city);
        } else {
            return weatherService.getWeather(city, country);
        }
        
    }

    // POST endpoint to update weather condition for a city (and optionally country)
    @PostMapping("/weather")
    public String updateWeather(@RequestParam @NotBlank String city,
                                @RequestParam(required = false) String country,
                                @RequestParam(required = false) String condition) {
            // Call the service to update the weather condition and generate a response message
        String updatedCondition = weatherService.updateWeather(city, country, condition);
        return "Madhu updated the weather condition for " + city 
           + (country != null ? ", " + country : "") + " to: " + updatedCondition;
        
    }
}
