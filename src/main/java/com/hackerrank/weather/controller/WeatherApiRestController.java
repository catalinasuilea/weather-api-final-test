package com.hackerrank.weather.controller;

import com.hackerrank.weather.model.WeatherInput;
import com.hackerrank.weather.output.WeatherJSON;
import com.hackerrank.weather.service.WeatherService;
import com.hackerrank.weather.utils.Patterns;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;


@RestController
public class WeatherApiRestController {

    private final WeatherService weatherService;

    @Autowired
    public WeatherApiRestController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/weather")
    public List<WeatherJSON> getWeatherInfo(@Valid @Pattern(regexp = Patterns.YYYY_MM_DD_REGEXP) @RequestParam(required = false) String date, @RequestParam(required = false) String city, @RequestParam(required = false) String sort){
       return null;
    }

    @GetMapping("/weather/{id}")
    public ResponseEntity<WeatherJSON> getWeatherById(@Valid @NotNull @PathVariable Integer id) {
       return weatherService.getWeatherById(id);
    }


    /**
     * Submit weather.
     *
     */
    @PostMapping(path = "/weather")
    @Operation(summary = "Create a new weather data record", tags = {"Weather",},
            responses = {
                    @ApiResponse(responseCode = "201", description = "Adds a weather to the DB and returns a JSON of it.",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = WeatherJSON.class))),
                    @ApiResponse(responseCode = "401", description = "Unauthorized."),
                    @ApiResponse(responseCode = "422", description = "Business error."),
                    @ApiResponse(responseCode = "500", description = "Internal server error.")
            })
    public ResponseEntity<WeatherJSON> submitWeather(@RequestBody @Valid final WeatherInput weatherInput) {
        return weatherService.createWeather(weatherInput);
    }
}
