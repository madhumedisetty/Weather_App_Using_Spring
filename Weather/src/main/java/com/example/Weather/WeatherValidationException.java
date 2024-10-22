package com.example.Weather;

import java.util.*;

public class WeatherValidationException extends WeatherException {
    private final List<String> violations;

    public WeatherValidationException(String message, List<String> violations) {
        super(message);
        this.violations = violations;
    }

    public List<String> getViolations() {
        return violations;
    }
}

