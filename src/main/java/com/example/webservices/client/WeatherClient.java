package com.example.webservices.client;

import com.example.webservices.wsdl.weather.FahrenheitToCelsius;
import com.example.webservices.wsdl.weather.FahrenheitToCelsiusResponse;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

@Component
public class WeatherClient {

    private final WebServiceTemplate webServiceTemplate;

    public WeatherClient(WebServiceTemplate webServiceTemplate) {
        this.webServiceTemplate = webServiceTemplate;
    }

    public FahrenheitToCelsiusResponse fahrenheitToCelsius(String fahrenheit) {

        FahrenheitToCelsius request = new FahrenheitToCelsius();
        request.setFahrenheit(fahrenheit);

        SoapActionCallback callback =
                new SoapActionCallback("https://www.w3schools.com/xml/FahrenheitToCelsius");

        return (FahrenheitToCelsiusResponse)
                webServiceTemplate.marshalSendAndReceive(request, callback);
    }
}


