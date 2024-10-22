package com.example.Weather;
public class WeatherValidationConstants {
    public static final int MIN_TEMPERATURE = -50;
    public static final int MAX_TEMPERATURE = 50;

    public static final String WEATHER_CONDITION_PATTERN = "^(sunny|cloudy|rainy|snowy)$";
    public static final int CITY_MIN_LENGTH = 3;
    public static final int CITY_MAX_LENGTH = 20;

    public static final String CITY_BLANK_MESSAGE = "City is required and cannot be empty";         
    public static final String CITY_SIZE_MESSAGE = "City must be between 3 and 20 characters";
    public static final String WEATHER_CONDITION_BLANK_MESSAGE = "Weather condition is required and cannot be empty";
    public static final String WEATHER_CONDITION_SIZE_MESSAGE = "Weather condition must be between 3 and 20 characters";
}
