package com.example.webservices.mapper;

import com.example.webservices.dto.TemperatureResponse;
import com.example.webservices.wsdl.weather.CelsiusToFahrenheitResponse;
import com.example.webservices.wsdl.weather.FahrenheitToCelsiusResponse;

public class TemperatureMapper {
    private TemperatureMapper() {
        // utility class
    }

    public static TemperatureResponse fromFahrenheitToCelsius(
            String inputValue,
            FahrenheitToCelsiusResponse soapResponse
    ) {
        return new TemperatureResponse(
                inputValue,
                "F",
                soapResponse.getFahrenheitToCelsiusResult(),
                "C"
        );
    }

    public static TemperatureResponse fromCelsiusToFahrenheit(
            String inputValue,
            CelsiusToFahrenheitResponse soapResponse
    ) {
        return new TemperatureResponse(
                inputValue,
                "C",
                soapResponse.getCelsiusToFahrenheitResult(),
                "F"
        );
    }
}
