package hh.backend.hotel_booking;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import hh.backend.hotel_booking.domain.Booker;
import hh.backend.hotel_booking.domain.BookerRepository;

@SpringBootTest
public class BookerRepositoryTest {

    BookerRepository bookerRepository;

    @Autowired
    public BookerRepositoryTest(BookerRepository bookerRepository) {
        this.bookerRepository = bookerRepository;
    }

    void findBookerById(){
        Booker bookers = new Booker("Alisa", "Peltola");
        bookers = bookerRepository.save(bookers);
        boolean itIs = bookerRepository.existsById(bookers.getBookerId());
        assertThat(itIs).isTrue();
    }

    
}
