package com.hackerrank.weather.repository;

import com.hackerrank.weather.entities.Weather;
import com.hackerrank.weather.output.WeatherJSON;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface WeatherRepository extends JpaRepository<Weather, Integer> {

      List<Weather> findAllByDate(LocalDate date);

      List<Weather> findAllByCityInIgnoreCase(List<String> city);

//      List<Weather> findAllByDateOrderByDateAsc(LocalDate date);
//
//      List<Weather> findAllByDateOrderByDateDesc(LocalDate date);

      List<Weather> findAllByOrderByDateAsc();

      List<Weather> findAllByOrderByDateDesc();
}
