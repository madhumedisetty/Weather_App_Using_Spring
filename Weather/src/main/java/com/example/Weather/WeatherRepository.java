package com.example.Weather;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WeatherRepository extends JpaRepository<WeatherRecord, String> {
    Optional<WeatherRecord> findByCity(String city);
}
