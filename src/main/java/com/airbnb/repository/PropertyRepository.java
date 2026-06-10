package com.airbnb.repository;



import com.airbnb.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface PropertyRepository extends JpaRepository<Property, Long> {

    List<Property> findByLocationContainingIgnoreCase(String location);

    List<Property> findByPricePerNightBetween(BigDecimal minPrice, BigDecimal maxPrice);
}
