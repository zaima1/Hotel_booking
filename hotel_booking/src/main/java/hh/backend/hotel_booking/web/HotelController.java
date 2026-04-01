package hh.backend.hotel_booking.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hh.backend.hotel_booking.domain.Hotel;
import hh.backend.hotel_booking.domain.HotelRepository;
import hh.backend.hotel_booking.domain.RoomRepository;

@Controller
public class HotelController {
    private final HotelRepository hotelRepository;
    private final RoomRepository roomRepository;

    public HotelController(HotelRepository hotelRepository, RoomRepository roomRepository) {
        this.hotelRepository = hotelRepository;
        this.roomRepository = roomRepository;
    }

    @GetMapping("/listhotel")
    public String listhotel
    (Model model){
        model.addAttribute("hotel", hotelRepository.findAll());
        return"listhotel";
    }

    @GetMapping("/addhotel")
    public String addHotel(Model model){
        model.addAttribute("hotel", new Hotel());
        model.addAttribute("rooms", roomRepository.findAll());
        return"addhotel";
    }

    @PostMapping("/savehotel")
    public String saveHotel(@ModelAttribute Hotel hotel, Model model){
        hotelRepository.save(hotel);
        model.addAttribute("hotel",hotel);
        return"redirect:/listhotel";
    }
    

    @GetMapping("/delete/{id}")
    public String deleteHotel(@PathVariable("id") Long hotel_id, Model model){
        hotelRepository.deleteById(hotel_id);
        return "redirect:../listhotel";
    }


    @GetMapping("/updete/{id}")
    public String updatehotel(@PathVariable("id") Long hotel_id, Model model){
        Hotel hotel = hotelRepository.findById(hotel_id).orElseThrow(()->
        new IllegalArgumentException("Wrong hotel id"));
        model.addAttribute("hotel", hotel);
        return"edithotel";
    }

    @PostMapping("/hotelupdate")
    public String hotelUpdate(@ModelAttribute Hotel hotel){
        hotelRepository.save(hotel);
        return"redirect:/listhotel";
    }

}
