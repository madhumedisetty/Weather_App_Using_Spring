package com.example.Weather;

import org.springframework.stereotype.Component;

@Component
public class WeatherRecord {
    private String city;
    private int temperature;
    private String condition;

    public void initialize(String city, int temperature) {
        this.city = city;
        this.temperature = temperature;
    }

    // Getters and setters
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public int getTemperature() { return temperature; }
    public void setTemperature(int temperature) { this.temperature = temperature; }
    public String getCondition() { return condition; }
    public void setCondition(String condition) { this.condition = condition; }
}

