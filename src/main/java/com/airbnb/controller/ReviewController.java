package com.airbnb.controller;

import com.airbnb.dto.ReviewRequest;
import com.airbnb.entity.Review;
import com.airbnb.service.ReviewService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping
    public Review addReview(@Valid @RequestBody ReviewRequest request) {
        return reviewService.addReview(request);
    }

    @GetMapping("/property/{propertyId}")
    public List<Review> getReviewsByProperty(@PathVariable Long propertyId) {
        return reviewService.getReviewsByProperty(propertyId);
    }
}
