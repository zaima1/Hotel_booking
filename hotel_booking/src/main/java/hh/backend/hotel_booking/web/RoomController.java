package hh.backend.hotel_booking.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hh.backend.hotel_booking.domain.HotelRepository;
import hh.backend.hotel_booking.domain.Room;
import hh.backend.hotel_booking.domain.RoomRepository;

@Controller
public class RoomController {
    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;


    public RoomController(RoomRepository roomRepository, HotelRepository hotelRepository) {
        this.roomRepository = roomRepository;
        this.hotelRepository = hotelRepository;
    }

    @GetMapping("/rooms")
    public String rooms(Model model){
        model.addAttribute("rooms",roomRepository.findAll());
        return "roomlist";
    }

    @GetMapping("/addroom")
    public String adroom(Model model){
        model.addAttribute("rooms", new Room());
        model.addAttribute("hotel", hotelRepository.findAll());
        return"addroom";
    }

    @PostMapping("/saveroom")
    public String saveroom(@ModelAttribute Room room, Model model){
        roomRepository.save(room);
        model.addAttribute("room", room);
        return"redirect:/roomlist";
    }

    @GetMapping("/deleteroom/{id}")
    public String deleteRoom(@PathVariable("id") long  roomNumber, Model model){
        roomRepository.deleteById(roomNumber);
        return"redirect:../roomlist";
    }

    @GetMapping("/updateroom/{id}")
    public String updateRoom(@PathVariable("id") long roomNumber, Model model ){
        Room room = roomRepository.findById(roomNumber).orElseThrow(()->
         new IllegalArgumentException("wrong room number"));
        return"editroom";
    }

    @PostMapping("/roomupdate")
    public String roomUpdate(@ModelAttribute Room room){
        roomRepository.save(room);
        return "redirect:/roomlist";
    }

    
}
