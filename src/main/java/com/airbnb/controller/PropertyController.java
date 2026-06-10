package com.airbnb.controller;



import com.airbnb.dto.AvailabilityRequest;
import com.airbnb.dto.PropertyRequest;
import com.airbnb.entity.Property;
import com.airbnb.entity.PropertyAvailability;
import com.airbnb.service.PropertyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/properties")
@RequiredArgsConstructor
@CrossOrigin("*")
public class PropertyController {

    private final PropertyService propertyService;

    @PostMapping
    public Property createProperty(@Valid @RequestBody PropertyRequest request) {
        return propertyService.createProperty(request);
    }

    @PutMapping("/{id}")
    public Property updateProperty(
            @PathVariable Long id,
            @Valid @RequestBody PropertyRequest request
    ) {
        return propertyService.updateProperty(id, request);
    }

    @PostMapping("/availability")
    public PropertyAvailability addAvailability(@Valid @RequestBody AvailabilityRequest request) {
        return propertyService.addAvailability(request);
    }

    @GetMapping
    public List<Property> searchProperties(@RequestParam(required = false) String location) {
        return propertyService.searchProperties(location);
    }

    @GetMapping("/{id}")
    public Property getPropertyById(@PathVariable Long id) {
        return propertyService.getPropertyById(id);
    }

    @GetMapping("/filter/price")
    public List<Property> filterByPrice(
            @RequestParam BigDecimal minPrice,
            @RequestParam BigDecimal maxPrice
    ) {
        return propertyService.filterByPrice(minPrice, maxPrice);
    }
}
