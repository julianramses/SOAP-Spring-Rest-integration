package com.example.webservices.client;

import com.example.webservices.dto.TemperatureResponse;
import com.example.webservices.mapper.TemperatureMapper;
import com.example.webservices.wsdl.weather.FahrenheitToCelsius;
import com.example.webservices.wsdl.weather.FahrenheitToCelsiusResponse;
import com.example.webservices.wsdl.weather.CelsiusToFahrenheit;
import com.example.webservices.wsdl.weather.CelsiusToFahrenheitResponse;

import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import org.springframework.stereotype.Component;

@Component
public class WeatherClient {

    private final WebServiceTemplate webServiceTemplate;

    public WeatherClient(WebServiceTemplate webServiceTemplate) {
        this.webServiceTemplate = webServiceTemplate;
    }

    public TemperatureResponse getCelsius(String fahrenheit) {

        FahrenheitToCelsius request = new FahrenheitToCelsius();
        request.setFahrenheit(fahrenheit);

        FahrenheitToCelsiusResponse response =
                (FahrenheitToCelsiusResponse)
                        webServiceTemplate.marshalSendAndReceive(
                                request,
                                new SoapActionCallback(
                                        "https://www.w3schools.com/xml/FahrenheitToCelsius"
                                )
                        );

        return TemperatureMapper.fromFahrenheitToCelsius(fahrenheit, response);
    }

    public TemperatureResponse getFahrenheit(String celsius) {

        CelsiusToFahrenheit request = new CelsiusToFahrenheit();
        request.setCelsius(celsius);

        CelsiusToFahrenheitResponse response =
                (CelsiusToFahrenheitResponse)
                        webServiceTemplate.marshalSendAndReceive(
                                request,
                                new SoapActionCallback(
                                        "https://www.w3schools.com/xml/CelsiusToFahrenheit"
                                )
                        );

        return TemperatureMapper.fromCelsiusToFahrenheit(celsius, response);
    }
}
