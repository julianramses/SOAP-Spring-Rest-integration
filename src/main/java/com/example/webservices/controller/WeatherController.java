package com.example.webservices.controller;

import com.example.webservices.dto.TemperatureResponse;
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
    public TemperatureResponse toCelsius(@RequestParam String fahrenheit) {
        return weatherClient.getCelsius(fahrenheit);
    }

    @GetMapping("/fahrenheit")
    public TemperatureResponse toFahrenheit(@RequestParam String celsius) {
        return weatherClient.getFahrenheit(celsius);
    }
}
