package com.hackerrank.weather.repository;

import com.hackerrank.weather.entities.Weather;
import com.hackerrank.weather.output.WeatherJSON;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface WeatherRepository extends JpaRepository<Weather, Integer> {
//    @Query("SELECT distinct new com.hackerrank.weather.output.WeatherJSON(w.id, w.date, w.lat, w.lon, w.city, w.state) " +
//            "FROM Weather w WHERE w.date = :date")
//    List<WeatherJSON> findAllByDate(@Param("date") String date);
      List<WeatherJSON> findAllByDate(LocalDate date);

      List<WeatherJSON> findAllByCity(String city);
}
