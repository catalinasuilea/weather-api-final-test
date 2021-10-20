package com.hackerrank.weather.mapper;

import com.hackerrank.weather.entities.Weather;
import com.hackerrank.weather.model.WeatherInput;
import com.hackerrank.weather.output.WeatherJSON;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

public class WeatherMapper {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static Weather inputToWeather(WeatherInput weatherInput) {
        return Weather.builder()
                .id(weatherInput.getId())
                .date(LocalDate.parse(weatherInput.getDate(),formatter))
                .lat(weatherInput.getLat())
                .lon(weatherInput.getLon())
                .city(weatherInput.getCity())
                .state(weatherInput.getState())
                .temperatures(weatherInput.getTemperatures().stream().map(BigDecimal::new).collect(Collectors.toList()))
                .build();
    }

    public static WeatherJSON weatherToJSON(Weather weather) {
        return WeatherJSON.builder()
                .id(weather.getId())
                .date(weather.getDate().format(formatter))
                .lat(weather.getLat())
                .lon(weather.getLon())
                .city(weather.getCity())
                .state(weather.getState())
                .temperatures(weather.getTemperatures().stream().map(BigDecimal::doubleValue).collect(Collectors.toList()))
                .build();
    }
}