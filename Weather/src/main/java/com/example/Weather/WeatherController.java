package com.example.Weather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@RequestMapping("/api/weather")
@Validated
public class WeatherController {
    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/all")
    public List<WeatherRecord> getAllWeather() {
        return weatherService.getAllWeather();
    }

    @GetMapping("/{city}")
    public ResponseEntity<WeatherRecord> getWeatherByCity(@PathVariable @NotBlank String city) {
        WeatherRecord weather = weatherService.getWeatherByCity(city);
        return weather != null ? ResponseEntity.ok(weather) : ResponseEntity.notFound().build();
    }

    @PostMapping("/create")
    public WeatherRecord addWeather(@Valid @RequestBody WeatherRequestDTO weatherRequestDTO) {
        return weatherService.addWeather(weatherRequestDTO);
    }

    @PutMapping("/{city}")
    public ResponseEntity<WeatherRecord> updateWeather(
            @PathVariable @NotBlank String city,
            @Valid @RequestBody WeatherRequestDTO weatherRequestDTO) {
        WeatherRecord updatedRecord = weatherService.updateWeather(city, weatherRequestDTO);
        return ResponseEntity.ok(updatedRecord);
    }

    @DeleteMapping("/{city}")
    public ResponseEntity<Void> deleteWeather(@PathVariable @NotBlank String city) {
        weatherService.deleteWeather(city);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(WeatherValidationException.class)
    public ResponseEntity<String> handleValidationException(WeatherValidationException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
