package hh.backend.hotel_booking;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import hh.backend.hotel_booking.domain.Comer;
import hh.backend.hotel_booking.domain.ComerRepository;

@SpringBootTest
public class ComerRepositoryTest {

    ComerRepository comerRepository;

    @Autowired
    public ComerRepositoryTest(ComerRepository comerRepository) {
        this.comerRepository = comerRepository;
    }

    @Test
    void findComerById(){
        Comer comers = new Comer(5, true, false, 14);
        comers = comerRepository.save(comers);
        boolean itIs = comerRepository.existsById(comers.getComerId());
        assertThat(itIs).isTrue();
    }

    
}
