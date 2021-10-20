package com.hackerrank.weather.service;

import com.hackerrank.weather.entities.Weather;
import com.hackerrank.weather.mapper.WeatherMapper;
import com.hackerrank.weather.model.WeatherInput;
import com.hackerrank.weather.output.WeatherJSON;
import com.hackerrank.weather.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import java.security.GeneralSecurityException;


@Service
public class WeatherService {

    private final WeatherRepository weatherRepository;

    @Autowired
    public WeatherService(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    @Transactional
    public ResponseEntity<WeatherJSON> createWeather(final WeatherInput weatherInput) {
        final Weather weather = WeatherMapper.inputToWeather(weatherInput);
        weatherRepository.save(weather);
        return new ResponseEntity<WeatherJSON>(WeatherMapper.weatherToJSON(weather), HttpStatus.CREATED);
    }

    @Transactional
    public ResponseEntity<WeatherJSON> getWeatherById(int weatherId) {
        Weather weather = weatherRepository.findById(weatherId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Weather not found"));

        return new ResponseEntity<WeatherJSON>(WeatherMapper.weatherToJSON(weather), HttpStatus.OK);
    }
}
