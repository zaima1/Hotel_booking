package hh.backend.hotel_booking;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.backend.hotel_booking.domain.BookerRepository;
import hh.backend.hotel_booking.domain.ComerRepository;
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
	ComerRepository comerRepository, HotelRepository hotelRepository){
		return (args) ->{
		
			Room room1 = roomRepository.save(new Room((long ) 12,4,12000, LocalDate.of(2026,12,04), LocalDate.of(2027, 03, 10)));
			
		};
	}
}
