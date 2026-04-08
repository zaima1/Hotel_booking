package hh.backend.hotel_booking;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import hh.backend.hotel_booking.domain.Room;
import hh.backend.hotel_booking.domain.RoomRepository;

@SpringBootTest
public class RoomRepositoryTest {

    RoomRepository roomRepository;

    
    @Autowired
    public RoomRepositoryTest(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Test
    void findRoomByid(){
        Room rooms = new Room((long)14 , 4, 1200, LocalDate.of(2026, 1, 25), LocalDate.of(2027, 12, 31));
        rooms = roomRepository.save(rooms);
        boolean itIs = roomRepository.existsById(rooms.getRoomId());
        assertThat(itIs).isTrue();
    }

    
}
