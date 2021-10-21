package com.hackerrank.weather.repository;

import com.hackerrank.weather.entities.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface WeatherRepository extends JpaRepository<Weather, Integer> {

      List<Weather> findAllByDate(LocalDate date);

      List<Weather> findAllByCityInIgnoreCase(List<String> city);

      List<Weather> findAllByOrderByDateAsc();

      List<Weather> findAllByOrderByDateDesc();
}
