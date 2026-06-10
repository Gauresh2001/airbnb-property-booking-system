package com.airbnb.repository;



import com.airbnb.entity.PropertyAvailability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PropertyAvailabilityRepository extends JpaRepository<PropertyAvailability, Long> {

    @Query("""
           SELECT COUNT(a) > 0
           FROM PropertyAvailability a
           WHERE a.property.id = :propertyId
           AND a.availableFrom <= :startDate
           AND a.availableTo >= :endDate
           """)
    boolean isPropertyAvailable(Long propertyId, java.time.LocalDate startDate, java.time.LocalDate endDate);
}
