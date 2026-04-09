package hh.backend.hotel_booking;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.backend.hotel_booking.domain.AppUserRepository;
import hh.backend.hotel_booking.domain.Appuser;
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
			ComerRepository comerRepository, HotelRepository hotelRepository, BookingRepository bookingRepository,
			AppUserRepository appUserRepository) {
		return (args) -> {

			Room room1 = roomRepository
					.save(new Room((long) 12, 4, 12000, LocalDate.of(2026, 12, 4), LocalDate.of(2027, 3, 10)));
			Room room2 = roomRepository
					.save(new Room((long) 190, 6, 16000, LocalDate.of(2026, 10, 30), LocalDate.of(2027, 10, 20)));
			Booker booker1 = bookerRepository.save(new Booker("Aleksi", "Kallio"));
			Booker booker2 = bookerRepository.save(new Booker("Alisa", "Lohja"));
			Hotel hotel1 = hotelRepository.save(new Hotel(4, "Martantie 4", "Vantaa", "01700", 5));
			Hotel hotel2 = hotelRepository.save(new Hotel(10, "Isotie 7", "Tampere", "0200", 7));
			Comer comer1 = comerRepository.save(new Comer(4, true, false, 12));
			Booking booking1 = bookingRepository
					.save(new Booking(LocalDate.of(2026, 7, 17), LocalDate.of(2027, 12, 20), 12000, 4));

		};
	}
}
