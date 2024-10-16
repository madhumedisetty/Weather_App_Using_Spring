package com.example.Weather;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("/api")
public class WeatherController {

    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    // GET endpoint to fetch weather for a specific city
    @GetMapping("/weather/{city}")
    public String getWeather(@PathVariable @NotBlank String city) {
        return weatherService.getWeather(city);
    }

    // POST endpoint to update weather for a city
    @PostMapping("/weather/{city}")
    public String updateWeather(@PathVariable @NotBlank String city,
                                @RequestParam(required = false) String condition) {
        weatherService.updateWeatherData(city, condition);
        return "Weather updated for " + city;
    }
}
