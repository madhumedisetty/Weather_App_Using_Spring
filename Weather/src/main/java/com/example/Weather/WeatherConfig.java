package com.example.Weather;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import java.util.Map;
import java.util.HashMap;

@Configuration
@ConfigurationProperties(prefix = "weather")
public class WeatherConfig {
    private String defaultCondition;
    private Map<String, TemperatureRange> cityTemperatures = new HashMap<>();

    // Getters and setters
    public String getDefaultCondition() { return defaultCondition; }
    public void setDefaultCondition(String defaultCondition) { this.defaultCondition = defaultCondition; }
    public Map<String, TemperatureRange> getCityTemperatures() { return cityTemperatures; }
    public void setCityTemperatures(Map<String, TemperatureRange> cityTemperatures) { this.cityTemperatures = cityTemperatures; }

    public static class TemperatureRange {
        private int min;
        private int max;

        // Getters and setters
        public int getMin() { return min; }
        public void setMin(int min) { this.min = min; }
        public int getMax() { return max; }
        public void setMax(int max) { this.max = max; }
    }
}


