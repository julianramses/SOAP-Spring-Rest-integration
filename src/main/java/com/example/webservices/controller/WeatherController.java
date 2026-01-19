package com.example.webservices.controller;

import com.example.webservices.client.WeatherClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherClient weatherClient;

    public WeatherController(WeatherClient weatherClient) {
        this.weatherClient = weatherClient;
    }

    @GetMapping("/celsius")
    public String getCelsius(@RequestParam String fahrenheit) {
        return weatherClient
                .fahrenheitToCelsius(fahrenheit)
                .getFahrenheitToCelsiusResult();
    }
}

