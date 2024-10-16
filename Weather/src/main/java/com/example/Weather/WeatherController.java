package com.example.Weather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {
    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/{city}")
    public String getWeather(@PathVariable String city) {
        return weatherService.getWeather(city);
    }

    @PostMapping("/{city}")
    public String updateWeather(@PathVariable String city, @RequestParam int temperature) {
        weatherService.updateWeather(city, temperature);
        return "Weather updated for " + city;
    }

    @GetMapping
    public Map<String, String> getAllWeather() {
        return weatherService.getAllWeatherData();
    }
}
