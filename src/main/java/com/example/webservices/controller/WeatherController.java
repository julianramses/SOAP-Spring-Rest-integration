package com.example.webservices.controller;

import com.example.webservices.dto.TemperatureRequest;
import com.example.webservices.dto.TemperatureResponse;
import com.example.webservices.client.WeatherClient;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherClient weatherClient;

    public WeatherController(WeatherClient weatherClient) {
        this.weatherClient = weatherClient;
    }

    @PostMapping("/convert")
    public TemperatureResponse convert(
            @Valid @RequestBody TemperatureRequest request
    ) {

        return weatherClient.convert(
                request.value(),
                request.from(),
                request.to()
        );
    }
}
