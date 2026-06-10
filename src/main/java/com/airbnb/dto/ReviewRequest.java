package com.airbnb.dto;


import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ReviewRequest {

    @NotNull(message = "Property id is required")
    private Long propertyId;

    @NotNull(message = "Guest id is required")
    private Long guestId;

    @Min(value = 1, message = "Rating minimum 1")
    @Max(value = 5, message = "Rating maximum 5")
    private Integer rating;

    @NotBlank(message = "Comment is required")
    private String comment;
}
