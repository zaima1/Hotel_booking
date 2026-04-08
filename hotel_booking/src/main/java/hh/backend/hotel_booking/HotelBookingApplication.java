package hh.backend.hotel_booking;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.backend.hotel_booking.domain.Booker;
import hh.backend.hotel_booking.domain.BookerRepository;
import hh.backend.hotel_booking.domain.Booking;
import hh.backend.hotel_booking.domain.BookingRepository;
import hh.backend.hotel_booking.domain.Comer;
import hh.backend.hotel_booking.domain.ComerRepository;
import hh.backend.hotel_booking.domain.Hotel;
import hh.backend.hotel_booking.domain.HotelRepository;
import hh.backend.hotel_booking.domain.Room;
import hh.backend.hotel_booking.domain.RoomRepository;

@SpringBootApplication
public class HotelBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelBookingApplication.class, args);
	}

	@Bean
	public CommandLineRunner createDemoRows(BookerRepository bookerRepository, RoomRepository roomRepository, 
	ComerRepository comerRepository, HotelRepository hotelRepository, BookingRepository bookingRepository){
		return (args) ->{
		
			Room room1 = roomRepository.save(new Room((long ) 12,4,12000, LocalDate.of(2026,12,4), LocalDate.of(2027, 3, 10)));
			Booker booker1 =bookerRepository.save(new Booker("Aleksi", "Kallio"));
			Hotel hotel1 =hotelRepository.save(new Hotel(4,"martantie 4", "vantaa", "01700",5));
			Comer comer1 = comerRepository.save(new Comer(4,true, false, 12));
			Booking booking1 = bookingRepository.save(new Booking(LocalDate.of(2026, 7, 17), LocalDate.of(2027, 12, 20), 12000,4));
		};
	}
}
