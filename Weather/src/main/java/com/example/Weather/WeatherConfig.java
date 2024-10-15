package com.example.Weather;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "weather")
public class WeatherConfig {
    private String defaultCondition;

    public String getDefaultCondition() {
        return defaultCondition;
    }

    public void setDefaultCondition(String defaultCondition) {
        this.defaultCondition = defaultCondition;
    }
}

