package com.example.webservices.dto;



public record TemperatureResponse(
        String inputValue,
        String inputUnit,
        String outputValue,
        String outputUnit
) {}
