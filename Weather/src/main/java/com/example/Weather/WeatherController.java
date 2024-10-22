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

    // Uncomment if you want to implement update and delete methods
    /*
    @PutMapping("/{id}")
    public ResponseEntity<WeatherRecord> updateWeather(@PathVariable Long id, @RequestBody WeatherRecord weatherRecord) {
        if (!weatherService.getAllWeather().stream().anyMatch(weather -> weather.getId().equals(id))) {
            return ResponseEntity.notFound().build();
        }
        weatherRecord.setId(id);
        return ResponseEntity.ok(weatherService.updateWeather(weatherRecord));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWeather(@PathVariable Long id) {
        if (!weatherService.getAllWeather().stream().anyMatch(weather -> weather.getId().equals(id))) {
            return ResponseEntity.notFound().build();
        }
        weatherService.deleteWeather(id);
        return ResponseEntity.noContent().build();
    }
    */
    @ExceptionHandler(WeatherValidationException.class)
public ResponseEntity<String> handleValidationException(WeatherValidationException ex) {
    return ResponseEntity.badRequest().body(ex.getMessage());
}

}
