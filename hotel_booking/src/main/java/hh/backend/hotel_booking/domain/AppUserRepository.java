package hh.backend.hotel_booking.domain;

import org.springframework.data.repository.CrudRepository;



public interface AppUserRepository  extends CrudRepository <Appuser, Long>{
    Appuser  findByUsername(String username);

}
