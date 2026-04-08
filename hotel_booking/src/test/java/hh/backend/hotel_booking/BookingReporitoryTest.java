package hh.backend.hotel_booking;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import hh.backend.hotel_booking.domain.Booking;
import hh.backend.hotel_booking.domain.BookingRepository;

@SpringBootTest
public class BookingReporitoryTest {

    BookingRepository bookingRepository;

     @Autowired
    public BookingReporitoryTest(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Test
    void findByIdBooking(){
        Booking bookings = new Booking(LocalDate.of(2026, 12, 12), LocalDate.of(2027, 1, 10), 12000, 5);
        bookings = bookingRepository.save(bookings);
        boolean itIs = bookingRepository.existsById(bookings.getBookingId());
        assertThat(itIs).isTrue();
    }
   
    
}
