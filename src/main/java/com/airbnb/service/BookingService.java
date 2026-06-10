package com.airbnb.service;



import com.airbnb.dto.BookingRequest;
import com.airbnb.entity.Booking;
import com.airbnb.entity.Property;
import com.airbnb.entity.User;
import com.airbnb.enums.BookingStatus;
import com.airbnb.enums.Role;
import com.airbnb.exception.ResourceNotFoundException;
import com.airbnb.repository.BookingRepository;
import com.airbnb.repository.PropertyAvailabilityRepository;
import com.airbnb.repository.PropertyRepository;
import com.airbnb.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final PropertyRepository propertyRepository;
    private final UserRepository userRepository;
    private final PropertyAvailabilityRepository availabilityRepository;

    @Transactional
    public Booking createBooking(BookingRequest request) {
        Property property = propertyRepository.findById(request.getPropertyId())
                .orElseThrow(() -> new ResourceNotFoundException("Property not found"));

        User guest = userRepository.findById(request.getGuestId())
                .orElseThrow(() -> new ResourceNotFoundException("Guest not found"));

        if (guest.getRole() != Role.GUEST) {
            throw new RuntimeException("Only GUEST can book property");
        }

        if (!request.getStartDate().isBefore(request.getEndDate())) {
            throw new RuntimeException("Start date must be before end date");
        }

        boolean available = availabilityRepository.isPropertyAvailable(
                property.getId(),
                request.getStartDate(),
                request.getEndDate()
        );

        if (!available) {
            throw new RuntimeException("Property is not available for selected dates");
        }

        boolean overlapping = bookingRepository.existsOverlappingBooking(
                property.getId(),
                request.getStartDate(),
                request.getEndDate(),
                BookingStatus.CONFIRMED
        );

        if (overlapping) {
            throw new RuntimeException("Property already booked for selected dates");
        }

        long nights = ChronoUnit.DAYS.between(request.getStartDate(), request.getEndDate());

        BigDecimal totalPrice = property.getPricePerNight()
                .multiply(BigDecimal.valueOf(nights));

        Booking booking = Booking.builder()
                .property(property)
                .guest(guest)
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .totalPrice(totalPrice)
                .status(BookingStatus.CONFIRMED)
                .createdAt(LocalDateTime.now())
                .build();

        return bookingRepository.save(booking);
    }

    public List<Booking> getUserBookings(Long userId) {
        return bookingRepository.findByGuestId(userId);
    }

    public List<Booking> getPropertyBookings(Long propertyId) {
        return bookingRepository.findByPropertyId(propertyId);
    }
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking cancelBooking(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found"));

        booking.setStatus(BookingStatus.CANCELLED);

        return bookingRepository.save(booking);
    }

    public Booking completeBooking(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found"));

        booking.setStatus(BookingStatus.COMPLETED);

        return bookingRepository.save(booking);
    }
}
