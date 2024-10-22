package com.example.Weather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Validated
public class WeatherService {
    private final WeatherRepository weatherRepository;
    private final WeatherValidator weatherValidator;

    @Autowired
    public WeatherService(WeatherRepository weatherRepository, WeatherValidator weatherValidator) {
        this.weatherRepository = weatherRepository;
        this.weatherValidator = weatherValidator;
    }

    public List<WeatherRecord> getAllWeather() {
        return weatherRepository.findAll();
    }

    public WeatherRecord getWeatherByCity(String city) {
        return weatherRepository.findByCity(city).orElseThrow(() -> new RuntimeException("City not found"));
    }

    private WeatherRecord convertToEntity(WeatherRequestDTO weatherRequestDTO) {
        WeatherRecord weatherRecord = new WeatherRecord();
        weatherRecord.setCity(weatherRequestDTO.getCity());
        weatherRecord.setTemperature(weatherRequestDTO.getTemperature());
        weatherRecord.setWeatherCondition(weatherRequestDTO.getWeatherCondition());
        return weatherRecord;
    }

    @Transactional
    public WeatherRecord addWeather(WeatherRequestDTO weatherRequestDTO) {
        weatherValidator.validateWeatherCondition(weatherRequestDTO);
        WeatherRecord weatherRecord = convertToEntity(weatherRequestDTO);
        return weatherRepository.save(weatherRecord);
    }
    /* 
     * public void deleteWeather(Long id) {
        weatherRepository.deleteById(id);
    }
    */

    

    public WeatherRecord updateWeather(WeatherRecord weatherRecord) {
        return weatherRepository.save(weatherRecord);
    }
}
