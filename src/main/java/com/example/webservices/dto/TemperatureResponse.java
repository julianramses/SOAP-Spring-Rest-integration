package com.example.webservices.dto;



public record TemperatureResponse(
        String input,
        String inputUnit,
        String output,
        String outputUnit
) {}
