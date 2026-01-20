package com.example.webservices.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record TemperatureRequest(

        @NotBlank(message = "value is required")
        @Pattern(
                regexp = "^-?\\d+(\\.\\d+)?$",
                message = "value must be a valid number"
        )
        String value,

        @NotBlank(message = "from is required")
        @Pattern(
                regexp = "F|C",
                message = "from must be F or C"
        )
        String from,

        @NotBlank(message = "to is required")
        @Pattern(
                regexp = "F|C",
                message = "to must be F or C"
        )
        String to
) {}
