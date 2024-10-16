package com.example.Weather;

public class WeatherRecord {
    private String city;
    private String condition;

    // Constructor to initialize fields
    public WeatherRecord(String city, String condition) {
        this.city = city;
        this.condition = condition;
    }

    // Getters and setters
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}
