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
        return weatherRepository.findByCity(city)
                .orElseThrow(() -> new RuntimeException("City not found"));
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

    @Transactional
    public WeatherRecord updateWeather(String city, WeatherRequestDTO weatherRequestDTO) {
        WeatherRecord existingRecord = weatherRepository.findByCity(city)
                .orElseThrow(() -> new RuntimeException("City not found"));

        weatherValidator.validateWeatherCondition(weatherRequestDTO);

        existingRecord.setTemperature(weatherRequestDTO.getTemperature());
        existingRecord.setWeatherCondition(weatherRequestDTO.getWeatherCondition());

        return weatherRepository.save(existingRecord);
    }

    @Transactional
    public void deleteWeather(String city) {
        WeatherRecord weatherRecord = weatherRepository.findByCity(city)
                .orElseThrow(() -> new RuntimeException("City not found"));

        weatherRepository.delete(weatherRecord);
    }
}
