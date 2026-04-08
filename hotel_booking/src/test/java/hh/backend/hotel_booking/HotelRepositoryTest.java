package hh.backend.hotel_booking;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import hh.backend.hotel_booking.domain.Hotel;
import hh.backend.hotel_booking.domain.HotelRepository;

@SpringBootTest
public class HotelRepositoryTest {

    HotelRepository hotelRepository;

	@Autowired
     public HotelRepositoryTest(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }


	@Test
	void findById() {
		 Hotel hotels = new Hotel(4,"ratapihankuja 4", "helsinki", "0100", 3);
		hotels = hotelRepository.save(hotels);
		boolean itIs = hotelRepository.existsById(hotels.getHotelId());
		 assertThat(itIs).isTrue();
	}

   
}   
