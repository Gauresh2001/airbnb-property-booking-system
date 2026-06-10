package com.airbnb.dto;



import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class PropertyRequest {

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Description is required")
    private String description;

    @NotBlank(message = "Location is required")
    private String location;

    @NotNull(message = "Price per night is required")
    @DecimalMin(value = "1.0", message = "Price must be greater than 0")
    private BigDecimal pricePerNight;

    @NotNull(message = "Host id is required")
    private Long hostId;
}
