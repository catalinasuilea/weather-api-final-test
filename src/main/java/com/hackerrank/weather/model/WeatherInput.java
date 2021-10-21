package com.hackerrank.weather.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WeatherInput{
    private Integer id;

    @Schema(name = "date", description = "The date for weather", example = "2021-09-27")
    @Pattern(regexp = "^(19|20)\\d\\d[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$",
            message = "The date must match the pattern: yyyy-MM-dd")
    @Valid
    private String date;

    private Float lat;
    private Float lon;
    private String city;
    private String state;

    @Schema(description = "List of temperatures", required = true, example = "[24.0, 21.5, 24.0, 19.5, 25.5, 25.5, 24.0, 25.0, 23.0, 22.0, 18.0, 18.0, 23.5, 23.0, 23.0, 25.5, 21.0, 20.5, 20.0, 18.5, 20.5, 21.0, 25.0, 20.5]")
    private List<Double> temperatures;


    public WeatherInput(String date, Float lat, Float lon, String city, String state, List<Double> temperatures) {
        this.date = date;
        this.lat = lat;
        this.lon = lon;
        this.city = city;
        this.state = state;
        this.temperatures = temperatures;
    }
}
