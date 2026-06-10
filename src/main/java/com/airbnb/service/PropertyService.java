package com.airbnb.service;



import com.airbnb.dto.AvailabilityRequest;
import com.airbnb.dto.PropertyRequest;
import com.airbnb.entity.Property;
import com.airbnb.entity.PropertyAvailability;
import com.airbnb.entity.User;
import com.airbnb.enums.Role;
import com.airbnb.exception.ResourceNotFoundException;
import com.airbnb.repository.PropertyAvailabilityRepository;
import com.airbnb.repository.PropertyRepository;
import com.airbnb.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PropertyService {

    private final PropertyRepository propertyRepository;
    private final UserRepository userRepository;
    private final PropertyAvailabilityRepository availabilityRepository;

    public Property createProperty(PropertyRequest request) {
        User host = userRepository.findById(request.getHostId())
                .orElseThrow(() -> new ResourceNotFoundException("Host not found"));

        if (host.getRole() != Role.HOST) {
            throw new RuntimeException("Only HOST can create property");
        }

        Property property = Property.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .location(request.getLocation())
                .pricePerNight(request.getPricePerNight())
                .rating(0.0)
                .host(host)
                .build();

        return propertyRepository.save(property);
    }

    public Property updateProperty(Long id, PropertyRequest request) {
        Property property = propertyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Property not found"));

        property.setTitle(request.getTitle());
        property.setDescription(request.getDescription());
        property.setLocation(request.getLocation());
        property.setPricePerNight(request.getPricePerNight());

        return propertyRepository.save(property);
    }

    public PropertyAvailability addAvailability(AvailabilityRequest request) {
        Property property = propertyRepository.findById(request.getPropertyId())
                .orElseThrow(() -> new ResourceNotFoundException("Property not found"));

        if (!request.getAvailableFrom().isBefore(request.getAvailableTo())) {
            throw new RuntimeException("Available from date must be before available to date");
        }

        PropertyAvailability availability = PropertyAvailability.builder()
                .property(property)
                .availableFrom(request.getAvailableFrom())
                .availableTo(request.getAvailableTo())
                .build();

        return availabilityRepository.save(availability);
    }

    public List<Property> searchProperties(String location) {
        if (location == null || location.isBlank()) {
            return propertyRepository.findAll();
        }
        return propertyRepository.findByLocationContainingIgnoreCase(location);
    }

    public List<Property> filterByPrice(BigDecimal minPrice, BigDecimal maxPrice) {
        return propertyRepository.findByPricePerNightBetween(minPrice, maxPrice);
    }

    public Property getPropertyById(Long id) {
        return propertyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Property not found"));
    }
}
