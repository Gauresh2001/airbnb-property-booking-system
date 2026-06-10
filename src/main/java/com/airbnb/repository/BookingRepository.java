package com.airbnb.repository;



import com.airbnb.entity.Booking;
import com.airbnb.enums.BookingStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByGuestId(Long guestId);

    List<Booking> findByPropertyId(Long propertyId);

    @Query("""
           SELECT COUNT(b) > 0
           FROM Booking b
           WHERE b.property.id = :propertyId
           AND b.status = :status
           AND b.startDate < :endDate
           AND b.endDate > :startDate
           """)
    boolean existsOverlappingBooking(
            Long propertyId,
            LocalDate startDate,
            LocalDate endDate,
            BookingStatus status
    );
}
