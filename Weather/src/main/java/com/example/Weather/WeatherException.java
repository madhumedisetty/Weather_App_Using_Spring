package com.example.Weather;

public class WeatherException extends RuntimeException {
    public WeatherException(String message) {
        super(message);
    }

    public WeatherException(String message, Throwable cause) {
        super(message, cause);
    }
}
