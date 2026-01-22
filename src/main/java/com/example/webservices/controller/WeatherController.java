package com.example.webservices.controller;

import com.example.webservices.dto.TemperatureRequest;
import com.example.webservices.dto.TemperatureResponse;
import com.example.webservices.client.WeatherClient;
import com.example.webservices.security.PermissionChecker;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import com.example.webservices.security.Permission;



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
        PermissionChecker.require(Permission.CONVERT);

        return weatherClient.convert(
                request.value(),
                request.from(),
                request.to()
        );
    }
}
